<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@ page import="java.util.List"%>
<%@ include file="/init.jsp"%>
<%@ taglib prefix="aui" uri="http://liferay.com/tld/aui"%>

<portlet:actionURL name="agregarLicencia" var="agregarLicencia" />
<aui:form action="<%=agregarLicencia%>" method="post">
	<aui:fieldset label="Agrega una Licencia">
		<aui:input label="Nombre Licencia" name="nombreLicencia" type="text"
			required="true" />
		<aui:input label="Descripción de Licencia" name="descripcionLicencia"
			type="text" required="true" />
		<aui:input label="Versión de Licencia" name="versionLicencia"
			type="text" required="true" />
		<aui:select label="Agregar al usuario" name="userId" type="long"
			required="true">
			<aui:option selected="true" value="Ver">Ver</aui:option>
			<%
				List<User> users = UserLocalServiceUtil.getUsers(-1, -1);
							for (User user2 : users) {
								long usuario_id = user2.getUserId();
								String screenName = user2.getScreenName();
			%>
			<aui:option value="<%=usuario_id%>"><%=screenName%></aui:option>
			<%
				}
			%>
		</aui:select>
	</aui:fieldset>
	<aui:button-row>
		<aui:button name="botonAgregar" type="submit" value="Aceptar" />
	</aui:button-row>
</aui:form>
