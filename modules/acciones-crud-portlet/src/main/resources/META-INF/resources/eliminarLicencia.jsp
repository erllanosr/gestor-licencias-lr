<%@ include file="/init.jsp"%>
<%@ page import="java.util.List"%>
<%@ page import="licencias.build.service.model.Licencias"%>
<%@ taglib prefix="aui" uri="http://liferay.com/tld/aui"%>

<%
	Licencias licencia = (Licencias) request.getAttribute("licencia");
%>
<portlet:actionURL name="eliminarLicencia" var="eliminarLicencia" />
<aui:form action="<%=eliminarLicencia%>" method="post">
	<aui:fieldset label="Eliminar Licencia">
		<aui:input label="ID Licencia" type="disabled" name="licenciasId"
			value="<%=licencia.getLicenciasId()%>" />
		<aui:input label="Nombre Licencia" name="nombreLicencia"
			value="<%=licencia.getNombreLicencia()%>" required="true" />
		<aui:input label="Descripción de Licencia" name="descripcionLicencia"
			value="<%=licencia.getDescripcionLicencia()%>" required="true" />
		<aui:input label="Versión de Licencia" name="versionLicencia"
			value="<%=licencia.getVersionLicencia()%>" required="true" />
	</aui:fieldset>
	<aui:button-row>
		<aui:button name="botonEliminar" type="submit" value="Aceptar" />
	</aui:button-row>
</aui:form>