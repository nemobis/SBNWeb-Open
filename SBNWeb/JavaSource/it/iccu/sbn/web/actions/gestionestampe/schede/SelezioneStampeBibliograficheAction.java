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
package it.iccu.sbn.web.actions.gestionestampe.schede;

import it.iccu.sbn.ejb.remote.Utente;
import it.iccu.sbn.ejb.utils.ValidazioneDati;
import it.iccu.sbn.ejb.vo.elaborazioniDifferite.config.ActionPathVO;
import it.iccu.sbn.ejb.vo.elaborazioniDifferite.config.TipoAttivita;
import it.iccu.sbn.ejb.vo.gestionesemantica.stampe.ParametriStampaSoggettarioVO;
import it.iccu.sbn.ejb.vo.gestionesemantica.stampe.ParametriStampaTerminiThesauroVO;
import it.iccu.sbn.ejb.vo.gestionesemantica.stampe.ParametriStampaVO;
import it.iccu.sbn.vo.domain.CodiciAttivita;
import it.iccu.sbn.web.actionforms.gestionestampe.schede.SelezioneStampeBibliograficheForm;
import it.iccu.sbn.web.constant.NavigazioneSemantica;
import it.iccu.sbn.web2.navigation.Navigation;
import it.iccu.sbn.web2.navigation.NavigationForward;
import it.iccu.sbn.web2.util.Constants;
import it.iccu.sbn.web2.util.LinkableTagUtils;
import it.iccu.sbn.web2.util.SbnAttivitaChecker;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.LookupDispatchAction;

public class SelezioneStampeBibliograficheAction extends LookupDispatchAction implements SbnAttivitaChecker {

	private static Logger log = Logger.getLogger(SelezioneStampeBibliograficheAction.class);

	protected Map<String, String> getKeyMethodMap() {
		Map<String, String> map = new HashMap<String, String>();
		return map;
	}

    protected ActionForward unspecified(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
		SelezioneStampeBibliograficheForm currentForm = (SelezioneStampeBibliograficheForm) form;
		if (!currentForm.isInitialized())
			init(request, form);

    	return mapping.getInputForward();
    }

    private void init(HttpServletRequest request, ActionForm form) {
    	log.debug("init()");
    	SelezioneStampeBibliograficheForm currentForm = (SelezioneStampeBibliograficheForm) form;

    	//lista statica delle stampe attivabili
    	List<ActionPathVO> listaStampe = currentForm.getListaStampe();
		listaStampe.add(new ActionPathVO(CodiciAttivita.getIstance().GDF_STAMPA_SCHEDE_CATALOGRAFICHE, "Stampa Schede", "/gestionestampe/schede/stampaSchede.do", TipoAttivita.STAMPA));
    	listaStampe.add(new ActionPathVO(CodiciAttivita.getIstance().GDF_STAMPA_CATALOGHI, "Stampa Cataloghi", "/elaborazioniDifferite/esporta/esporta.do", TipoAttivita.STAMPA));

    	currentForm.setInitialized(true);
	}

	public ActionForward prenotaStampa(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
		SelezioneStampeBibliograficheForm currentForm = (SelezioneStampeBibliograficheForm) form;

		if (ValidazioneDati.strIsNull(currentForm.getSelezione()))
		  	return mapping.getInputForward();

		List<ActionPathVO> listaStampe = currentForm.getListaStampe();
		Integer idx = Integer.valueOf(currentForm.getSelezione());
		ActionPathVO actionVO = listaStampe.get(idx);

		ParametriStampaVO parametri = null;
		String codAttivita = actionVO.getCodAttivita();
		if (ValidazioneDati.equals(CodiciAttivita.getIstance().GDF_STAMPA_SCHEDE_CATALOGRAFICHE, codAttivita) )
			parametri = new ParametriStampaSoggettarioVO();
		if (ValidazioneDati.equals(CodiciAttivita.getIstance().GDF_STAMPA_CATALOGHI, codAttivita) ) {
			parametri = new ParametriStampaTerminiThesauroVO();
			parametri.setCodAttivita(codAttivita);
			request.setAttribute(NavigazioneSemantica.PARAMETRI_STAMPA, parametri);

			NavigationForward forward2 = Navigation.getInstance(request).goForward(new ActionForward(actionVO.getActionPath()) );
			forward2.addParameter(Constants.CODICE_ATTIVITA, actionVO.getCodAttivita());
			return forward2;

		}


		parametri.setCodAttivita(codAttivita);
		request.setAttribute(NavigazioneSemantica.PARAMETRI_STAMPA, parametri);

		return Navigation.getInstance(request).goForward(new ActionForward(actionVO.getActionPath()) );
    }

	@Override
	protected String getMethodName(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response, String parameter)
			throws Exception {

		SelezioneStampeBibliograficheForm currentForm = (SelezioneStampeBibliograficheForm) form;

		Enumeration<?> params = request.getParameterNames();
		while (params.hasMoreElements()) {
			String param = (String) params.nextElement();
			if (param.startsWith(SelezioneStampeBibliograficheForm.SUBMIT_TESTO_PULSANTE) ) {
				String tokens[] = param.split(LinkableTagUtils.SEPARATORE);
				currentForm.setSelezione(tokens[2]);
				return "prenotaStampa";
			}

		}
		return super.getMethodName(mapping, form, request, response, parameter);

	}

	public boolean checkAttivita(HttpServletRequest request, ActionForm form, String idCheck) {
		try {
			//mostro sulla jsp solo le stampe abilitate
			Utente utenteEjb = (Utente) request.getSession().getAttribute(Constants.UTENTE_BEAN);
			utenteEjb.checkAttivita(idCheck);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

}
