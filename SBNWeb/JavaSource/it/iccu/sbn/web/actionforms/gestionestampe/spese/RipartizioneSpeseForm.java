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
package it.iccu.sbn.web.actionforms.gestionestampe.spese;

import it.iccu.sbn.ejb.vo.gestionestampe.ComboCodDescVO;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class RipartizioneSpeseForm extends ActionForm{//  DynaValidatorForm

	private static final long serialVersionUID = -6649104312604964571L;
	private String tipoFormato;
	private String tipoModello;
	private String elemBlocco;
	private String nomForn;
	private String tipoOrdine;
	private List listaTipoOrdine;
	private String tpForn;
	private List listaProv;
	private String prov;
	private List listaPaese;
	private String paese;
	private List listaProfAcq;
	private String profAcq;
	private String codForn;
	private boolean sessione;
	private boolean ricercaLocale = false;
	private String codBib;
	private String codPolo;
	private String descrBib;
	private String tipoOrdinamSelez;
	private List<ComboCodDescVO> elencoModelli = new ArrayList<ComboCodDescVO>();
	private List listaTipiOrdinamento;
	private String dataOrdineDa;
	private String dataOrdineA;
	private String annoOrdine;
	private String codFornitore;
	private String fornitore;
	private String sezione;
	private String natura;
	private List listaNatura;
	private String esercizio;
	private String capitolo;
	private List listaTipoImpegno;
	private String tipoImpegno;
	private List listaRangeDewey;
	private String rangeDewey;

	private List listaLingue;
	private String lingue;
	private String lingueDescr;
	private List listaPaesi;
	private String paesiDescr;
	private String paesi;



	private List listaTipoMaterialeInv;
	private String tipoMaterialeInv;
	private String tipoMaterialeInvDescr;


	private List listaSupporto;
	private String supporto;
	private String supportoDescr;

	private List listaTipoRecord;
	private String tipoRecord;
	private String tipoRecordDescr;

	private String testoListaSezioni;
	private String idListaSezioni;

	private List listaBiblioteche;

	private String ordiniNOinv="";



	public String getDescrBib() {
		return descrBib;
	}
	public void setDescrBib(String descrBib) {
		this.descrBib = descrBib;
	}

	public String getTipoFormato() {
		return tipoFormato;
	}
	public void setTipoFormato(String tipoFormato) {
		this.tipoFormato = tipoFormato;
	}
	public String getElemBlocco() {
		return elemBlocco;
	}
	public void setElemBlocco(String elemBlocco) {
		this.elemBlocco = elemBlocco;
	}
	public String getNomForn() {
		return nomForn;
	}
	public void setNomForn(String nomForn) {
		this.nomForn = nomForn;
	}
	public String getTpForn() {
		return tpForn;
	}
	public void setTpForn(String tpForn) {
		this.tpForn = tpForn;
	}
	public List getListaProv() {
		return listaProv;
	}
	public void setListaProv(List listaProv) {
		this.listaProv = listaProv;
	}
	public String getProv() {
		return prov;
	}
	public void setProv(String prov) {
		this.prov = prov;
	}
	public List getListaPaese() {
		return listaPaese;
	}
	public void setListaPaese(List listaPaese) {
		this.listaPaese = listaPaese;
	}
	public String getPaese() {
		return paese;
	}
	public void setPaese(String paese) {
		this.paese = paese;
	}
	public List getListaProfAcq() {
		return listaProfAcq;
	}
	public void setListaProfAcq(List listaProfAcq) {
		this.listaProfAcq = listaProfAcq;
	}
	public String getProfAcq() {
		return profAcq;
	}
	public void setProfAcq(String profAcq) {
		this.profAcq = profAcq;
	}
	public String getCodForn() {
		return codForn;
	}
	public void setCodForn(String codForn) {
		this.codForn = codForn;
	}
	public boolean isSessione() {
		return sessione;
	}
	public void setSessione(boolean sessione) {
		this.sessione = sessione;
	}
	public List getElencoModelli() {
		return elencoModelli;
	}
	public void setElencoModelli(List tipiModelli) {
		elencoModelli = tipiModelli;
	}
	public String getTipoModello() {
		return tipoModello;
	}
	public void setTipoModello(String tipoModello) {
		this.tipoModello = tipoModello;
	}
	public boolean isRicercaLocale() {
		return ricercaLocale;
	}

	public void setRicercaLocale(boolean ricercaLocale) {
		this.ricercaLocale = ricercaLocale;
	}
	public List getListaTipiOrdinamento() {
		return listaTipiOrdinamento;
	}
	public void setListaTipiOrdinamento(List listaTipiOrdinamento) {
		this.listaTipiOrdinamento = listaTipiOrdinamento;
	}
	public String getCodBib() {
		return codBib;
	}
	public void setCodBib(String codBib) {
		this.codBib = codBib;
	}

	public List getListaBiblioteche() {
		return listaBiblioteche;
	}
	public void setListaBiblioteche(List listaBiblioteche) {
		this.listaBiblioteche = listaBiblioteche;
	}
	public String getTipoOrdinamSelez() {
		return tipoOrdinamSelez;
	}
	public void setTipoOrdinamSelez(String tipoOrdinamSelez) {
		this.tipoOrdinamSelez = tipoOrdinamSelez;
	}
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.ricercaLocale= false;
	}
	public String getAnnoOrdine() {
		return annoOrdine;
	}
	public void setAnnoOrdine(String annoOrdine) {
		this.annoOrdine = annoOrdine;
	}
	public String getDataOrdineA() {
		return dataOrdineA;
	}
	public void setDataOrdineA(String dataOrdineA) {
		this.dataOrdineA = dataOrdineA;
	}
	public String getDataOrdineDa() {
		return dataOrdineDa;
	}
	public void setDataOrdineDa(String dataOrdineDa) {
		this.dataOrdineDa = dataOrdineDa;
	}
	public List getListaTipoOrdine() {
		return listaTipoOrdine;
	}
	public void setListaTipoOrdine(List listaTipoOrdine) {
		this.listaTipoOrdine = listaTipoOrdine;
	}
	public String getTipoOrdine() {
		return tipoOrdine;
	}
	public void setTipoOrdine(String tipoOrdine) {
		this.tipoOrdine = tipoOrdine;
	}
	public String getCodPolo() {
		return codPolo;
	}
	public void setCodPolo(String codPolo) {
		this.codPolo = codPolo;
	}
	public String getCodFornitore() {
		return codFornitore;
	}
	public void setCodFornitore(String codFornitore) {
		this.codFornitore = codFornitore;
	}
	public String getFornitore() {
		return fornitore;
	}
	public void setFornitore(String fornitore) {
		this.fornitore = fornitore;
	}
	public String getCapitolo() {
		return capitolo;
	}
	public void setCapitolo(String capitolo) {
		this.capitolo = capitolo;
	}
	public String getEsercizio() {
		return esercizio;
	}
	public void setEsercizio(String esercizio) {
		this.esercizio = esercizio;
	}
	public List getListaNatura() {
		return listaNatura;
	}
	public void setListaNatura(List listaNatura) {
		this.listaNatura = listaNatura;
	}
	public List getListaTipoImpegno() {
		return listaTipoImpegno;
	}
	public void setListaTipoImpegno(List listaTipoImpegno) {
		this.listaTipoImpegno = listaTipoImpegno;
	}
	public String getNatura() {
		return natura;
	}
	public void setNatura(String natura) {
		this.natura = natura;
	}
	public String getSezione() {
		return sezione;
	}
	public void setSezione(String sezione) {
		this.sezione = sezione;
	}
	public String getTipoImpegno() {
		return tipoImpegno;
	}
	public void setTipoImpegno(String tipoImpegno) {
		this.tipoImpegno = tipoImpegno;
	}
	public List getListaSupporto() {
		return listaSupporto;
	}
	public void setListaSupporto(List listaSupporto) {
		this.listaSupporto = listaSupporto;
	}
	public List getListaTipoMaterialeInv() {
		return listaTipoMaterialeInv;
	}
	public void setListaTipoMaterialeInv(List listaTipoMaterialeInv) {
		this.listaTipoMaterialeInv = listaTipoMaterialeInv;
	}
	public String getSupporto() {
		return supporto;
	}
	public void setSupporto(String supporto) {
		this.supporto = supporto;
	}
	public String getSupportoDescr() {
		return supportoDescr;
	}
	public void setSupportoDescr(String supportoDescr) {
		this.supportoDescr = supportoDescr;
	}
	public String getTipoMaterialeInv() {
		return tipoMaterialeInv;
	}
	public void setTipoMaterialeInv(String tipoMaterialeInv) {
		this.tipoMaterialeInv = tipoMaterialeInv;
	}
	public String getTipoMaterialeInvDescr() {
		return tipoMaterialeInvDescr;
	}
	public void setTipoMaterialeInvDescr(String tipoMaterialeInvDescr) {
		this.tipoMaterialeInvDescr = tipoMaterialeInvDescr;
	}
	public List getListaTipoRecord() {
		return listaTipoRecord;
	}
	public void setListaTipoRecord(List listaTipoRecord) {
		this.listaTipoRecord = listaTipoRecord;
	}
	public String getTipoRecord() {
		return tipoRecord;
	}
	public void setTipoRecord(String tipoRecord) {
		this.tipoRecord = tipoRecord;
	}
	public String getTipoRecordDescr() {
		return tipoRecordDescr;
	}
	public void setTipoRecordDescr(String tipoRecordDescr) {
		this.tipoRecordDescr = tipoRecordDescr;
	}
	public String getIdListaSezioni() {
		return idListaSezioni;
	}
	public void setIdListaSezioni(String idListaSezioni) {
		this.idListaSezioni = idListaSezioni;
	}
	public String getTestoListaSezioni() {
		return testoListaSezioni;
	}
	public void setTestoListaSezioni(String testoListaSezioni) {
		this.testoListaSezioni = testoListaSezioni;
	}
	public String getOrdiniNOinv() {
		return ordiniNOinv;
	}
	public void setOrdiniNOinv(String ordiniNOinv) {
		this.ordiniNOinv = ordiniNOinv;
	}
	public List getListaRangeDewey() {
		return listaRangeDewey;
	}
	public void setListaRangeDewey(List listaRangeDewey) {
		this.listaRangeDewey = listaRangeDewey;
	}
	public String getRangeDewey() {
		return rangeDewey;
	}
	public void setRangeDewey(String rangeDewey) {
		this.rangeDewey = rangeDewey;
	}
	public String getLingue() {
		return lingue;
	}
	public void setLingue(String lingue) {
		this.lingue = lingue;
	}
	public List getListaLingue() {
		return listaLingue;
	}
	public void setListaLingue(List listaLingue) {
		this.listaLingue = listaLingue;
	}
	public List getListaPaesi() {
		return listaPaesi;
	}
	public void setListaPaesi(List listaPaesi) {
		this.listaPaesi = listaPaesi;
	}
	public String getPaesi() {
		return paesi;
	}
	public void setPaesi(String paesi) {
		this.paesi = paesi;
	}
	public String getLingueDescr() {
		return lingueDescr;
	}
	public void setLingueDescr(String lingueDescr) {
		this.lingueDescr = lingueDescr;
	}
	public String getPaesiDescr() {
		return paesiDescr;
	}
	public void setPaesiDescr(String paesiDescr) {
		this.paesiDescr = paesiDescr;
	}
}
