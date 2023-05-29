package acciones.crud.portlet.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import acciones.crud.portlet.constants.AccionesCrudPortletKeys;
import licencias.build.service.model.Licencias;
import licencias.build.service.service.LicenciasLocalServiceUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + AccionesCrudPortletKeys.ACCIONESCRUD,
		"mvc.command.name=/modificarLicencia" })

public class ModificarLicenciaMVCRender implements MVCRenderCommand {

	@SuppressWarnings("deprecation")
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		// Relacionar el nombre, en este caso el ID.
		try {
			Licencias li = LicenciasLocalServiceUtil
					.getLicencias(Long.parseLong(renderRequest.getParameter("entryId")));
			renderRequest.setAttribute("licencia", li);
			System.out.println("Hola, desde ModificarLicenciaMVCRender " + li.getLicenciasId());
		} catch (NumberFormatException | PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/modificarLicencia.jsp";
	}

}
