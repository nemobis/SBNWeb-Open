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
package it.iccu.sbn.ejb.domain.stampe;


import it.iccu.sbn.ejb.DomainEJBFactory;
import it.iccu.sbn.ejb.domain.acquisizioni.Acquisizioni;
import it.iccu.sbn.ejb.exception.ApplicationException;
import it.iccu.sbn.ejb.exception.DataException;
import it.iccu.sbn.ejb.exception.ResourceNotFoundException;
import it.iccu.sbn.ejb.exception.ValidationException;
import it.iccu.sbn.ejb.utils.DateUtil;
import it.iccu.sbn.ejb.vo.OutputStampaVo;
import it.iccu.sbn.ejb.vo.acquisizioni.ListaSuppSpeseVO;
import it.iccu.sbn.ejb.vo.elaborazioniDifferite.DownloadVO;
import it.iccu.sbn.ejb.vo.elaborazioniDifferite.ElaborazioniDifferiteOutputVo;
import it.iccu.sbn.ejb.vo.elaborazioniDifferite.StampaStatisticheDiffVO;
import it.iccu.sbn.ejb.vo.stampe.StampaDiffVO;
import it.iccu.sbn.ejb.vo.stampe.StampaOnLineVO;
import it.iccu.sbn.ejb.vo.stampe.StampaVo;
import it.iccu.sbn.servizi.batch.BatchLogWriter;
import it.iccu.sbn.util.jms.ConstantsJMS;

import java.io.InputStream;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.MessageDrivenBean;
import javax.ejb.MessageDrivenContext;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.naming.NamingException;

import org.apache.log4j.Logger;


/**
 * <!-- begin-xdoclet-definition -->
 *
 * @ejb.bean name="SBNSpese"
 * 			 acknowledge-mode="Auto-acknowledge"
 *           destination-type="javax.jms.Queue"
 *           transaction-type="Container"
 *           destination-jndi-name="SBNSpese"
 *           message-selector="STATO='HELD'"
 *
 * @ejb.resource-ref
 *   res-ref-name="jms/QCF"
 *   res-type="javax.jms.QueueConnectionFactory"
 *   res-auth="Container"
 *
 * @ejb.transaction="Supports"
 * @jboss.destination-jndi-name name="queue/A"
 * @jboss.resource-ref
 * 		res-ref-name="jms/QCF"
 * 		jndi-name="ConnectionFactory"
 * <!-- end-xdoclet-definition -->
 * @generated
 *
 */
public class SBNStampaStatisticheBean extends SBNStampeBase implements MessageDrivenBean, MessageListener {
	/**
	 *
	 */
	private static final long serialVersionUID = 5381991885729447552L;
	/**
	 *
	 */

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc --> The context for the
	 * message-driven bean, set by the EJB container.
	 *
	 * @generated
	 */
	private MessageDrivenContext ctx = null;
	private Acquisizioni acquisizioni;
	private static Logger log = Logger.getLogger(SBNStampaStatisticheBean.class);

	Acquisizioni getEjbAcq() throws Exception {
		return DomainEJBFactory.getInstance().getAcquisizioni();
	}


	/**
	 * Required method for container to set context.
	 *
	 * @generated
	 */
	public void setMessageDrivenContext(MessageDrivenContext mdc) throws EJBException {
		// TODO Auto-generated method stub
		this.ctx = mdc;
	}

	/**
	 * Required removal method for message-driven beans. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void ejbRemove() throws EJBException {
		System.out.println("TextMDB.ejbRemove, this=" + hashCode());
		closeJMS();
	}

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
			this.acquisizioni = DomainEJBFactory.getInstance().getAcquisizioni();
			this.setupJMS();
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

/*	public Object elabora(StampaVo stampaVO, String idMessaggio)
	throws ResourceNotFoundException, ApplicationException, ValidationException, DataException	{
		String nomeFileErr ="Elaborazione fallita, per maggiori dettagli aprire il link";
		int indiceChar= idMessaggio.indexOf(":");
		String idMess= idMessaggio.substring(indiceChar+1, idMessaggio.length());
		String nameFile = "";

		//qui metterò i dati da stampare
		List datiDaStampare = new ArrayList();

		String pathDownload = null;
		String downloadLinkPath = stampaVO.getDownloadLinkPath();
		String utente = null;
		byte[] streamRichiestaStampa;
		byte[] streamLogStampa;
		List<DownloadVO> listaDownload = new ArrayList();
		ElaborazioniDifferiteOutputVo elaborazioniDifferiteOutputVo = new ElaborazioniDifferiteOutputVo(stampaVO);
		try {

			pathDownload = stampaVO.getDownload();
			String ticket = stampaVO.getTicket();
			if (stampaVO instanceof StampaOnLineVO) {
				OutputStampaVo output = new OutputStampaVo();
				output.setStato(ConstantsJMS.STATO_OK);
				datiDaStampare = ((StampaOnLineVO)stampaVO).getDatiStampa();
				//vado a stampare
				streamRichiestaStampa = effettuaStampa(
						stampaVO.getTemplate(),
						stampaVO.getTipoStampa(),
						datiDaStampare);
				if (streamRichiestaStampa != null) {
					output.setOutput(streamRichiestaStampa);
				} else {
					output.setStato(ConstantsJMS.STATO_ERROR);
				}
				return output;
			} else {
				// Stampa differita
				elaborazioniDifferiteOutputVo.setStato(ConstantsJMS.STATO_OK);

				log.info("path fileJrxml per la stampa comuncazione: "+stampaVO.getTemplate());
				System.out.print(""+stampaVO.getTemplate());
				elaborazioniDifferiteOutputVo.setDataDiElaborazione(DateUtil.getDate()+DateUtil.getTime());

				String modalita = ((StampaDiffVO)stampaVO).getModalita();
				utente = ((StampaDiffVO)stampaVO).getUser();
				List parametri = (List)((StampaDiffVO)stampaVO).getParametri();
				ListaSuppSpeseVO lpVO=(ListaSuppSpeseVO)parametri.get(0);
				try{
					//TODO cance: implementare la chiamata al bean che restituisce i dati da stampare
					//attualmente passiamo un arraylist nuovo e vuoto
					List listaOutput = new ArrayList();
					listaOutput = (List<RigheVO>)this.acquisizioni.ripartoSpese(lpVO);
					datiDaStampare=listaOutput;
				} catch(Exception exep) {
					elaborazioniDifferiteOutputVo.setStato(ConstantsJMS.STATO_ERROR);
					blw.logWriteException(exep);
					return elaborazioniDifferiteOutputVo;
				}


				try {
					//mi serve poi per sapere se ho creato almeno un file
					boolean listaEsistente = false;

					if(datiDaStampare.size()>0){
						//genero la stampa
						streamRichiestaStampa = effettuaStampa(
								stampaVO.getTemplate(),
								stampaVO.getTipoStampa(),
								datiDaStampare);
						//metto la stampa generata nella lista dei file da scaricare
						if(streamRichiestaStampa !=null){
							try {
								nameFile = utente +"_spese_"+idMess+ "." + stampaVO.getTipoStampa().toLowerCase();
								this.scriviFile(utente, stampaVO.getTipoStampa(), streamRichiestaStampa, pathDownload, nameFile);
							}catch (Exception ef) {
								throw new Exception("Creazione del file"+ nameFile+"fallita");
							}
							String filename = "";
							for(int index = 0; index < getDownloadFileName().size(); index++){
								listaEsistente = true;
								filename = (String)(getDownloadFileName().get(index));
								listaDownload.add(new DownloadVO(filename, downloadLinkPath+filename));
							}
						}
					}

					if(!listaEsistente){
						throw new Exception("elaborazione fallita a causa di un errore nella creazione della lista dei file di cui fare il download");
					}
					elaborazioniDifferiteOutputVo.setDownloadList(listaDownload);
					elaborazioniDifferiteOutputVo.setDataDiFineElaborazione(DateUtil.getDate()+DateUtil.getTime());

				}catch (Exception ef) {
					elaborazioniDifferiteOutputVo.setStato(ConstantsJMS.STATO_ERROR);
					blw.logWriteException(ef);
					return elaborazioniDifferiteOutputVo;
				}
				return elaborazioniDifferiteOutputVo;
			}

		} catch (Exception ex) {
			log.error(ex.getMessage());
			elaborazioniDifferiteOutputVo.setStato(ConstantsJMS.STATO_ERROR);
			nameFile = utente +"_log_spese_"+idMess+ "." + "txt";
			listaDownload.add(new DownloadVO(nomeFileErr, downloadLinkPath+nameFile));
			elaborazioniDifferiteOutputVo.setDownloadList(listaDownload);
			return elaborazioniDifferiteOutputVo;
		}
	}
*/

	public Object elabora(StampaVo input, BatchLogWriter blw)
	throws ResourceNotFoundException, ApplicationException, ValidationException, DataException	{
		StampaStatisticheDiffVO stampaVO = (StampaStatisticheDiffVO) input;
		getDownloadFileName().clear();  // da aggiungere per eliminare n nomi di file in output nella sintetica dello stato delle richieste
		String nomeFileErr ="Elaborazione fallita, per maggiori dettagli aprire il link";
		String idMess= stampaVO.getIdBatch();
		String nameFile = "";
		StampaVo stampavo=stampaVO.getStampavo();

		//qui metterò i dati da stampare
		List datiDaStampare = new ArrayList();

		String pathDownload = null;
		String downloadLinkPath = stampavo.getDownloadLinkPath();
		String utente = null;
		InputStream streamRichiestaStampa;
		byte[] streamLogStampa;
		List<DownloadVO> listaDownload = new ArrayList();
		ElaborazioniDifferiteOutputVo elaborazioniDifferiteOutputVo = new ElaborazioniDifferiteOutputVo(stampaVO);
		try {

			pathDownload = stampavo.getDownload();
			String ticket = stampavo.getTicket();
			if (stampavo instanceof StampaOnLineVO) {
				OutputStampaVo output = new OutputStampaVo();
				output.setStato(ConstantsJMS.STATO_OK);
				datiDaStampare = ((StampaOnLineVO)stampavo).getDatiStampa();
				//vado a stampare
				streamRichiestaStampa = effettuaStampa(
						stampavo.getTemplate(),
						stampavo.getTipoStampa(),
						datiDaStampare);
				if (streamRichiestaStampa != null) {
					output.setOutput(streamRichiestaStampa);
				} else {
					output.setStato(ConstantsJMS.STATO_ERROR);
				}
				return output;
			} else {
				// Stampa differita
				elaborazioniDifferiteOutputVo.setStato(ConstantsJMS.STATO_OK);

				log.info("path fileJrxml per la stampa statistiche: "+stampavo.getTemplate());
				System.out.print(""+stampavo.getTemplate());
				elaborazioniDifferiteOutputVo.setDataDiElaborazione(DateUtil.getDate()+DateUtil.getTime());

				String modalita = ((StampaDiffVO)stampavo).getModalita();
				utente = ((StampaDiffVO)stampavo).getUser();
				List parametri = (List)((StampaDiffVO)stampavo).getParametri();
				ListaSuppSpeseVO lpVO=(ListaSuppSpeseVO)parametri.get(0);
				try{
					//TODO cance: implementare la chiamata al bean che restituisce i dati da stampare
					//attualmente passiamo un arraylist nuovo e vuoto
					List listaOutput = new ArrayList();
/*					//07.09.09
					if (stampavo.getTipoOperazione().equals("STAMPA_SPESE"))
					{
						listaOutput = (List<RigheVO>) getEjbAcq().ripartoSpese(lpVO);
					}
					else
					{
*/						listaOutput = getEjbAcq().statisticheTempi(lpVO);
					//}

					datiDaStampare=listaOutput;
				} catch(Exception exep) {
					elaborazioniDifferiteOutputVo.setStato(ConstantsJMS.STATO_ERROR);
					blw.logWriteException(exep);
					return elaborazioniDifferiteOutputVo;
				}


				try {
					//mi serve poi per sapere se ho creato almeno un file
					boolean listaEsistente = false;

					if(datiDaStampare.size()>0){
						//genero la stampa
						streamRichiestaStampa = effettuaStampa(
								stampavo.getTemplate(),
								stampavo.getTipoStampa(),
								datiDaStampare);
						//metto la stampa generata nella lista dei file da scaricare
						if(streamRichiestaStampa !=null){
							try {
								//nameFile = utente +"_spese_"+idMess+ "." + stampavo.getTipoStampa().toLowerCase();
								nameFile = stampaVO.getFirmaBatch()+ "." + stampavo.getTipoStampa().toLowerCase();
								this.scriviFile(utente, stampavo.getTipoStampa(), streamRichiestaStampa, pathDownload, nameFile);
							}catch (Exception ef) {
								throw new Exception("Creazione del file"+ nameFile+"fallita");
							}
							String filename = "";
							for(int index = 0; index < getDownloadFileName().size(); index++){
								listaEsistente = true;
								filename = (getDownloadFileName().get(index));
								listaDownload.add(new DownloadVO(filename, downloadLinkPath+filename));
							}
						}
					}

					if(!listaEsistente){
						//throw new Exception("elaborazione fallita a causa di un errore nella creazione della lista dei file di cui fare il download");
						elaborazioniDifferiteOutputVo.setStato(ConstantsJMS.STATO_OK);
						nameFile = utente +"_log_statistiche_"+idMess+ "." + "txt";
						streamLogStampa = ("La richiesta non ha prodotto risultati.").getBytes("UTF8");
						this.scriviFile(utente, "txt", streamLogStampa, pathDownload, nameFile);
						listaDownload.add(new DownloadVO(nameFile, downloadLinkPath+nameFile));

					}
					elaborazioniDifferiteOutputVo.setDownloadList(listaDownload);
					elaborazioniDifferiteOutputVo.setDataDiFineElaborazione(DateUtil.getDate()+DateUtil.getTime());

				}catch (Exception ef) {
					elaborazioniDifferiteOutputVo.setStato(ConstantsJMS.STATO_ERROR);
					blw.logWriteException(ef);
					return elaborazioniDifferiteOutputVo;
				}
				return elaborazioniDifferiteOutputVo;
			}

		} catch (Exception ex) {
			elaborazioniDifferiteOutputVo.setStato(ConstantsJMS.STATO_ERROR);
			blw.logWriteException(ex);
			return elaborazioniDifferiteOutputVo;
		}
	}

	/**
	 * This method implements the business logic for the EJB.
	 *
	 */
	public void onMessage(Message message)  {
//		// Prelevo la coda dove effettuare la reply
//		String propertyName = "";
//		getDownloadFileName().clear();
//		try {
//			message.acknowledge();
//			Queue dest = (Queue) message.getJMSReplyTo();
//			ElaborazioniDifferiteOutputVo elaborazioniDifferiteOutputVo = null;
//			StampaVo stampaVO=null;
//			try {
//				// Effettuo la elaborazione
//				if (message instanceof ObjectMessage) {
//					stampaVO = (StampaVo)((ObjectMessage) message).getObject();
//					elaborazioniDifferiteOutputVo = (ElaborazioniDifferiteOutputVo)this.elabora(stampaVO, message.getJMSMessageID());
//					log.info("Terminata l'elaborazione del messaggio in SBNStampeSpeseBean");
//					// Notifico la fine dell'elaborazione
//					propertyName = "L'elaborazione é andata a buon fine";
//					this.replyExec(message, dest, elaborazioniDifferiteOutputVo);
//					log.info("Inoltrato il messaggio alla coda, con stato di elaborazione OK e contenuto del messaggio: "+propertyName);
//				} else {
//					throw new Exception("Failed to complete remote elaboration");
//				}
//
//			} catch (Exception ex) {
//				// Notifico la fine dell'elaborazione
//				propertyName = "L'elaborazione non é andata a buon fine";
//				if (elaborazioniDifferiteOutputVo == null) {
//					elaborazioniDifferiteOutputVo = new ElaborazioniDifferiteOutputVo(stampaVO);
//				}
//				elaborazioniDifferiteOutputVo.setStato(ConstantsJMS.STATO_ERROR);
//				this.reply(message, dest, elaborazioniDifferiteOutputVo); // "ERROR"
//				log.info("Inoltrato il messaggio alla coda, con stato di elaborazione ERROR e contenuto del messaggio: "+propertyName);
//				log.error(ex.getMessage());
//			}
//		} catch (Exception ex2) {
//			log.error(ex2.getMessage());
//			new Exception("Non é stato possibile effettuare la reply", ex2);
		}
//	}

	public void setSessionContext(javax.ejb.SessionContext ctx) throws javax.ejb.EJBException, java.rmi.RemoteException{
	}

}
