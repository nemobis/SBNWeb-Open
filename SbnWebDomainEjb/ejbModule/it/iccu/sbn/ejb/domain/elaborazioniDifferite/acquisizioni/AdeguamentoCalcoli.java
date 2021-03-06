/*******************************************************************************
 * Copyright (C) 2019 ICCU - Istituto Centrale per il Catalogo Unico
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package it.iccu.sbn.ejb.domain.elaborazioniDifferite.acquisizioni;

import it.iccu.sbn.ejb.DomainEJBFactory;
import it.iccu.sbn.ejb.domain.acquisizioni.Acquisizioni;
import it.iccu.sbn.ejb.domain.acquisizioni.AcquisizioniBMT;
import it.iccu.sbn.ejb.utils.DateUtil;
import it.iccu.sbn.ejb.vo.acquisizioni.AdeguamentoCalcoliVO;
import it.iccu.sbn.ejb.vo.elaborazioniDifferite.DownloadVO;
import it.iccu.sbn.ejb.vo.elaborazioniDifferite.ElaborazioniDifferiteOutputVo;
import it.iccu.sbn.servizi.batch.BatchLogWriter;
import it.iccu.sbn.util.jms.ConstantsJMS;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.naming.NamingException;

public class AdeguamentoCalcoli {


	private  Acquisizioni acquisizioni;
	private AcquisizioniBMT acquisizioniBMT;

	/**
	 * Required creation method for message-driven beans.
	 *
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * <!-- begin-xdoclet-definition -->
	 *
	 * @ejb.create-method <!-- end-xdoclet-definition -->
	 * @generated
	 */
	public void ejbCreate() {
		try {
			DomainEJBFactory factory = DomainEJBFactory.getInstance();
			this.acquisizioni = factory.getAcquisizioni();
			this.acquisizioniBMT = factory.getAcquisizioniBMT();

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new EJBException("Failed to init TextMDB", e);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new EJBException("Failed to init TextMDB", e);
		} catch (CreateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new EJBException("Failed to init TextMDB", e);
		} catch (Exception e) {
			throw new EJBException("Failed to init TextMDB", e);
		}
	}
	public AdeguamentoCalcoli() {
		this.ejbCreate();
	}

	private AdeguamentoCalcoliVO adeguamentoCalcoliVO;

	public AdeguamentoCalcoli(AdeguamentoCalcoliVO adeguamentoCalcoliVO){
		this.adeguamentoCalcoliVO = adeguamentoCalcoliVO;
		this.ejbCreate();
	}

	public ElaborazioniDifferiteOutputVo adeguamentoCalcoli(String codPolo, String codBib, BatchLogWriter log)	{
		System.out.println("++============================================================================++");
		System.out.println("AdeguamentoCalcoli Elaborazioni differite - Inizio di AdeguamentoCalcoli.java metodo adeguamentoCalcoli");
		System.out.println("Sone le " + DateUtil.getDate()+DateUtil.getTime());
		System.out.println("++============================================================================++");
		ElaborazioniDifferiteOutputVo elaborazioniDifferiteOutputVo=null;


		String nomeFileLogIntero="";
		String suffisso="adeguamentoCalcoli_";

		if (log!=null && log.getFilename()!=null && log.getFilename().getNomeFileVisualizzato()!=null && log.getFilename().getNomeFileVisualizzato().trim().length()>0)
		{
			nomeFileLogIntero=log.getFilename().getNomeFileVisualizzato();
			int pos=nomeFileLogIntero.lastIndexOf(".");
			String nomeFileLogParziale="";
			if (pos>0)
			{
				nomeFileLogParziale=nomeFileLogIntero.substring(0,pos);
			}
			if (!nomeFileLogParziale.equals(""))
			{
				suffisso=nomeFileLogParziale;
			}
		}



		// Crea lista dei file da scaricare
		List listaDownload= new ArrayList();
    	//String filename =  "adeguamentoCalcoli_"+String.valueOf(System.currentTimeMillis())+".htm";
    	String filename =  suffisso+".htm";

    	try {

			AdeguamentoCalcoliVO outputAllineamentoVO;
			outputAllineamentoVO = this.acquisizioniBMT.adeguaCalcoli(adeguamentoCalcoliVO);
			elaborazioniDifferiteOutputVo = new ElaborazioniDifferiteOutputVo(outputAllineamentoVO);
    		FileOutputStream streamOut = new FileOutputStream(adeguamentoCalcoliVO.getDownloadPath()+ File.separator + filename);
			//AdeguamentoCalcoliVO outputAllineamentoVO;
			//outputAllineamentoVO = this.acquisizioniBMT.adeguaCalcoli(adeguamentoCalcoliVO);
			if (outputAllineamentoVO != null){
				for (int i = 0; i < outputAllineamentoVO.getErrori().size(); i++) {
					String stringaMsg = outputAllineamentoVO.getErrori().get(i);
					stringaMsg = stringaMsg + "<br>";
					streamOut.write(stringaMsg.getBytes());
				}
			}

			streamOut.write("FINE Adeguamento Calcoli".getBytes());
			streamOut.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//listaDownload.add(new DownloadVO(filename, allineaVo.getDownloadPath()+filename));
		listaDownload.add(new DownloadVO(filename, adeguamentoCalcoliVO.getDownloadLinkPath()+filename));
		elaborazioniDifferiteOutputVo.setDownloadList(listaDownload);

		// Setta i parametri di ricerca in base a EsportaVO
		Map hm = new HashMap();
		hm.put("campo", "valore");
		elaborazioniDifferiteOutputVo.setParametriDiRicercaMap(hm);

		elaborazioniDifferiteOutputVo.setStato(ConstantsJMS.STATO_OK);
		elaborazioniDifferiteOutputVo.setDataDiElaborazione(DateUtil.getDate()+DateUtil.getTime());

		System.out.println("++============================================================================++");
		System.out.println("AdeguamentoCalcoli Elaborazioni differite - Fine di AdeguamentoCalcoli.java metodo adeguamentoCalcoli");
		System.out.println("Sone le " + DateUtil.getDate()+DateUtil.getTime());
		System.out.println("++============================================================================++");
		return elaborazioniDifferiteOutputVo;
	}

}
