<%@ taglib uri="http://struts.apache.org/tags-html-el" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean-el" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://common.web.sbn.iccu.it/sbn" prefix="sbn"%>

<div style="text-align: center;">
	<div>
		<c:choose>
			<c:when test="${navForm.conferma}">
				<jsp:include
					page="/WEB-INF/jsp/subpages/servizi/utility/confermaOperazione.jsp"></jsp:include>
			</c:when>
			<c:otherwise>
				<sbn:checkAttivita idControllo="GESTIONE">
					<html:submit property="methodConfigurazione"
						titleKey="servizi.configurazione.servizio.inserisce"
						bundle="serviziLabels">
						<bean:message key="servizi.bottone.nuovo" bundle="serviziLabels" />
					</html:submit> &nbsp;
					<html:submit property="methodConfigurazione"
						titleKey="servizi.configurazione.servizio.cancella"
						bundle="serviziLabels">
						<bean:message key="servizi.bottone.cancella"
							bundle="serviziLabels" />
					</html:submit> &nbsp;
				</sbn:checkAttivita>
				<html:submit property="methodConfigurazione"
					titleKey="servizi.configurazione.servizio.esamina"
					bundle="serviziLabels">
					<bean:message key="servizi.bottone.esamina" bundle="serviziLabels" />
				</html:submit>
			</c:otherwise>
		</c:choose>
	</div>
</div>
