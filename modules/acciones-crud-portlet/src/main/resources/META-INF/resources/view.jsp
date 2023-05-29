<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@ include file="/init.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="aui" uri="http://liferay.com/tld/aui"%>
<%@ taglib prefix="liferay-ui" uri="http://liferay.com/tld/ui"%>
<%@ page import="licencias.build.service.model.Licencias"%>
<%@ page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.liferay.portal.kernel.util.WebKeys"%>

<h1>Listado de licencias</h1>
<table class="table">
	<thead>
		<tr>
			<th scope="col">#</th>
			<th scope="col">Nombre</th>
			<th scope="col">Descripción</th>
			<th scope="col">Versión</th>
			<th scope="col">userId</th>
			<th></th>
		</tr>
	</thead>
	<tbody class="table-group-divider">
		<c:forEach var="li" items="${licencias}">
			<tr>
				<td>${li.licenciasId}</td>
				<td>${li.nombreLicencia}</td>
				<td>${li.descripcionLicencia}</td>
				<td>${li.versionLicencia}</td>
				<td>${li.userId}</td>
				<portlet:renderURL var="modificarLicencia">
					<portlet:param name="mvcRenderCommandName"
						value='/modificarLicencia' />
					<portlet:param name="entryId" value="${li.licenciasId}" />
				</portlet:renderURL>
				<td><a href="${modificarLicencia}"
					class="btn btn-outline-success">Modificar</a></td>
				<portlet:renderURL var="eliminarLicencia">
					<portlet:param name="mvcRenderCommandName"
						value='/eliminarLicencia' />
					<portlet:param name="entryId" value="${li.licenciasId}" />
				</portlet:renderURL>
				<td><a href="${eliminarLicencia}"
					class="btn btn-outline-danger">Eliminar</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
