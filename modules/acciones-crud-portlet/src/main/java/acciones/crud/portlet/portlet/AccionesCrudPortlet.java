package acciones.crud.portlet.portlet;

import acciones.crud.portlet.constants.AccionesCrudPortletKeys;

import licencias.build.service.model.Licencias;
import licencias.build.service.service.LicenciasLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author erick.llanos.ext
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=AccionesCrud", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + AccionesCrudPortletKeys.ACCIONESCRUD, "javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class AccionesCrudPortlet extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		List<Licencias> licencias = LicenciasLocalServiceUtil.getLicenciases(-1, -1);

		renderRequest.setAttribute("licencias", licencias);
		super.doView(renderRequest, renderResponse);
	}

	// Método para modificar licencias

	@ProcessAction(name = "modificarLicencia")
	// MVC ACTION COMMAND
	public void modificarLicencia(ActionRequest actionRequest, ActionResponse actionResponse)
			throws NumberFormatException, PortalException {
		Licencias li = LicenciasLocalServiceUtil
				.getLicencias(Long.parseLong(ParamUtil.getString(actionRequest, "licenciasId")));
		li.setNombreLicencia(ParamUtil.getString(actionRequest, "nombreLicencia"));
		li.setDescripcionLicencia(ParamUtil.getString(actionRequest, "descripcionLicencia"));
		li.setVersionLicencia(ParamUtil.getString(actionRequest, "versionLicencia"));

		LicenciasLocalServiceUtil.updateLicencias(li);
	}

	// Método para eliminar licencias

	@ProcessAction(name = "eliminarLicencia")
	public void eliminarLicencia(ActionRequest actionRequest, ActionResponse actionResponse)
			throws NumberFormatException, PortalException {
		Licencias li = LicenciasLocalServiceUtil
				.getLicencias(Long.parseLong(ParamUtil.getString(actionRequest, "licenciasId")));
		LicenciasLocalServiceUtil.deleteLicencias(li);
	}
}