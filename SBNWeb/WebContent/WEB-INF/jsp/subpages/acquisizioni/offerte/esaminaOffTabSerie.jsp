<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-html-el" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean-el" prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean-struts"%>
<%@ taglib uri="http://common.web.sbn.iccu.it/sbn" prefix="sbn"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="layout"%>


		  <!-- TABELLA DI TAG: da eliminare integralmente se non presenti -->
		<table  width="100%"  border="0" cellpadding="0" cellspacing="0">
              <tr>
  				 <!-- prima COLONNA TAG OFF-->

				 <!-- SECONDA COLONNA TAG ON-->
				    <td>
					<table width="100%" border="0"  cellpadding="0" cellspacing="0" >
            		  <tr>
             		   <td style="width: 8px;">
              		    <table  border="0" cellpadding="0" cellspacing="0" style="width: 8px;">
               		     <tr>
                  		    	<td style="width: 8px; height: 8px;" class="tagSxTopOff" >&nbsp;</td>

                  		  </tr>
                  		  <tr>

                		      <td class="tagBottomOffA" style="width: 8px; height: 8px;" >&nbsp;</td>
                 		  </tr>
             		   </table>
             		   </td>
              		  <td colspan="3" class="tagBottomOff2" style="width: auto;">
						<bean-struts:define id="varLink" value="AUT" />
			            <html:link  action="/acquisizioni/offerte/esaminaOfferte.do" paramId="paramLink" paramName="varLink" >
			               		<bean:message  key="ricerca.label.autore" bundle="acquisizioniLabels" />
			            </html:link>
              		  </td>
              		  <td style="width: 8px;">
               		   <table  border="0" cellpadding="0" cellspacing="0" style="width: 8px;">
                 		   <tr>

                     		 <td style="width: 8px; height: 8px;" class="tagDxTopOff" >&nbsp;</td>
                  		  </tr>
                  		  <tr>

                 		  <td style="width: 8px; height: 8px;" class="tagBottomOffB">&nbsp;</td>
                  		  </tr>
                	</table>
             		   </td>


            		  </tr>

           		 </table>


				</td> <td>
					<table width="100%" border="0"  cellpadding="0" cellspacing="0" >
            		  <tr>
             		   <td style="width: 8px;">
              		    <table  border="0" cellpadding="0" cellspacing="0" style="width: 8px;">
               		     <tr>
                  		    	<td style="width: 8px; height: 8px;" class="tagSxTopOn" >&nbsp;</td>

                  		  </tr>
                  		  <tr>

                		      <td class="tagBottomOnA" style="width: 8px; height: 8px;" >&nbsp;</td>
                 		  </tr>
             		   </table>
             		   </td>
              		  <td colspan="3" class="tagBottomOn2" style="width: auto;">
		               		<bean:message  key="ricerca.label.serie" bundle="acquisizioniLabels" />
              		  </td>
              		  <td style="width: 8px;">
               		   <table  border="0" cellpadding="0" cellspacing="0" style="width: 8px;">
                 		   <tr>

                     		 <td style="width: 8px; height: 8px;" class="tagDxTopOn" >&nbsp;</td>
                  		  </tr>
                  		  <tr>

                 		  <td style="width: 8px; height: 8px;" class="tagBottomOnB">&nbsp;</td>
                  		  </tr>
                	</table>
             		   </td>


            		  </tr>

           		 </table>


				</td> <td>
					<table width="100%" border="0"  cellpadding="0" cellspacing="0" >
            		  <tr>
             		   <td style="width: 8px;">
              		    <table  border="0" cellpadding="0" cellspacing="0" style="width: 8px;">
               		     <tr>
                  		    	<td style="width: 8px; height: 8px;" class="tagSxTopOff" >&nbsp;</td>

                  		  </tr>
                  		  <tr>

                		      <td class="tagBottomOffA" style="width: 8px; height: 8px;" >&nbsp;</td>
                 		  </tr>
             		   </table>
             		   </td>
              		  <td colspan="3" class="tagBottomOff2" style="width: auto;">
	          		  	<bean-struts:define id="varLink" value="SOG" />
			            <html:link  action="/acquisizioni/offerte/esaminaOfferte.do" paramId="paramLink" paramName="varLink" >
			               		<bean:message  key="ricerca.label.soggetto" bundle="acquisizioniLabels" />
			            </html:link>
              		  </td>
              		  <td style="width: 8px;">
               		   <table  border="0" cellpadding="0" cellspacing="0" style="width: 8px;">
                 		   <tr>

                     		 <td style="width: 8px; height: 8px;" class="tagDxTopOff" >&nbsp;</td>
                  		  </tr>
                  		  <tr>

                 		  <td style="width: 8px; height: 8px;" class="tagBottomOffB">&nbsp;</td>
                  		  </tr>
                	</table>
             		   </td>


            		  </tr>

           		 </table>


				</td> <td>
					<table width="100%" border="0"  cellpadding="0" cellspacing="0" >
            		  <tr>
             		   <td style="width: 8px;">
              		    <table  border="0" cellpadding="0" cellspacing="0" style="width: 8px;">
               		     <tr>
                  		    	<td style="width: 8px; height: 8px;" class="tagSxTopOff" >&nbsp;</td>

                  		  </tr>
                  		  <tr>

                		      <td class="tagBottomOffA" style="width: 8px; height: 8px;" >&nbsp;</td>
                 		  </tr>
             		   </table>
             		   </td>
              		  <td colspan="3" class="tagBottomOff2" style="width: auto;">
	          		  	<bean-struts:define id="varLink" value="CLA" />
			            <html:link  action="/acquisizioni/offerte/esaminaOfferte.do" paramId="paramLink" paramName="varLink" >
			               		<bean:message  key="ricerca.label.classificaz" bundle="acquisizioniLabels" />
			            </html:link>
              		  </td>
              		  <td style="width: 8px;">
               		   <table  border="0" cellpadding="0" cellspacing="0" style="width: 8px;">
                 		   <tr>

                     		 <td style="width: 8px; height: 8px;" class="tagDxTopOff" >&nbsp;</td>
                  		  </tr>
                  		  <tr>

                 		  <td style="width: 8px; height: 8px;" class="tagBottomOffB">&nbsp;</td>
                  		  </tr>
                	</table>
             		   </td>


            		  </tr>

           		 </table>


				</td> <td>
					<table width="100%" border="0"  cellpadding="0" cellspacing="0" >
            		  <tr>
             		   <td style="width: 8px;">
              		    <table  border="0" cellpadding="0" cellspacing="0" style="width: 8px;">
               		     <tr>
                  		    	<td style="width: 8px; height: 8px;" class="tagSxTopOff" >&nbsp;</td>

                  		  </tr>
                  		  <tr>

                		      <td class="tagBottomOffA" style="width: 8px; height: 8px;" >&nbsp;</td>
                 		  </tr>
             		   </table>
             		   </td>
              		  <td colspan="3" class="tagBottomOff2" style="width: auto;">
		          		  	<bean-struts:define id="varLink" value="NOT" />
				            <html:link  action="/acquisizioni/offerte/esaminaOfferte.do" paramId="paramLink" paramName="varLink" >
				               		<bean:message  key="ricerca.label.noteEdi" bundle="acquisizioniLabels" />
				            </html:link>
                        </td>
              		  <td style="width: 8px;">
               		   <table  border="0" cellpadding="0" cellspacing="0" style="width: 8px;">
                 		   <tr>

                     		 <td style="width: 8px; height: 8px;" class="tagDxTopOff" >&nbsp;</td>
                  		  </tr>
                  		  <tr>

                 		  <td style="width: 8px; height: 8px;" class="tagBottomOffB">&nbsp;</td>
                  		  </tr>
                	</table>
             		   </td>


            		  </tr>

           		 </table>


				</td> <td>
					<table width="100%" border="0"  cellpadding="0" cellspacing="0" >
            		  <tr>
             		   <td style="width: 8px;">
              		    <table  border="0" cellpadding="0" cellspacing="0" style="width: 8px;">
               		     <tr>
                  		    	<td style="width: 8px; height: 8px;" class="tagSxTopOff" >&nbsp;</td>

                  		  </tr>
                  		  <tr>

                		      <td class="tagBottomOffA" style="width: 8px; height: 8px;" >&nbsp;</td>
                 		  </tr>
             		   </table>
             		   </td>
              		  <td colspan="3" class="tagBottomOff2" style="width: auto;">
	          		  	<bean-struts:define id="varLink" value="ISB" />
			            <html:link  action="/acquisizioni/offerte/esaminaOfferte.do" paramId="paramLink" paramName="varLink" >
			               		<bean:message  key="ricerca.label.isbd" bundle="acquisizioniLabels" />
			            </html:link>
              		  </td>
              		  <td style="width: 8px;">
               		   <table  border="0" cellpadding="0" cellspacing="0" style="width: 8px;">
                 		   <tr>

                     		 <td style="width: 8px; height: 8px;" class="tagDxTopOff" >&nbsp;</td>
                  		  </tr>
                  		  <tr>

                 		  <td style="width: 8px; height: 8px;" class="tagBottomOffB">&nbsp;</td>
                  		  </tr>
                	</table>
             		   </td>


            		  </tr>

           		 </table>


				</td>
               <!-- ULTIMA COLONNA TAG SPECIFICARE LA % DEL WIDTH PER LE PAGINE CON POCHI TAG -->
			   <td style="width: 20%;" class="tagDxBottomFinale">&nbsp;</td>

               <!-- FINE TAG -->
            	 </tr>

           		 </table>
           		 <br>

		  	<table  align="center" width="100%"   style="border-color: #5A96DF;	border-style: dotted; border-width: 1px;" >
                    <tr class="etichetta" bgcolor="#dde8f0">
                      <td scope="col" align="center">
							<bean:message key="ricerca.label.codCollana" bundle="acquisizioniLabels" />
                      </td>
                      <td scope="col" align="center">
							<bean:message key="ricerca.label.serie" bundle="acquisizioniLabels" />
                      </td>
                      <td scope="col" align="center">
							<bean:message key="ricerca.label.codSerie" bundle="acquisizioniLabels" />
                      </td>
                    </tr>

				<logic:greaterThan name="esaminaOfferteForm" property="numRigheSer" value="0">
					<logic:iterate id="elencaRigheSer" property="listaSerie" name="esaminaOfferteForm" indexId="indice">
					   <c:set var="color" >
							<c:choose>
						        <c:when test='${color == "#FFCC99"}'>
						            #FEF1E2
						        </c:when>
						        <c:otherwise>
									#FFCC99
						        </c:otherwise>
						    </c:choose>
					    </c:set>
					  	<tr class="testoNormale" bgcolor="${color}">
	                      <td  scope="col" align="center">
							<html:text styleId="testoNormale" name="elencaRigheSer" property="numCollana" size="6" readonly="true" ></html:text>
	                      </td>
	                      <td  scope="col" align="center">
							<html:text styleId="testoNormale" name="elencaRigheSer"   maxlength="80" property="collana" size="30" readonly="true" ></html:text>
	                      </td>
	                      <td  scope="col" align="center">
							<html:text styleId="testoNormale" name="elencaRigheSer" property="chiaveCollana" size="10" readonly="true" ></html:text>
	                      </td>
						</tr>
					</logic:iterate>
				</logic:greaterThan>
	     </table>
