package form.agregar.portlet.portlet;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import licencias.build.service.model.Licencias;
import licencias.build.service.service.LicenciasLocalServiceUtil;

import form.agregar.portlet.constants.FormAgregarPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.ProcessAction;

import org.osgi.service.component.annotations.Component;

/**
 * @author erick.llanos.ext
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=FormAgregar", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp", "javax.portlet.name=" + FormAgregarPortletKeys.FORMAGREGAR,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class FormAgregarPortlet extends MVCPortlet {
	// Crear el ProcessAction
	@ProcessAction(name = "agregarLicencia")

	// MVC ACTION COMMAND
	public void agregarLicencia(ActionRequest actionRequest, ActionResponse actionResponse) {
		Licencias li = LicenciasLocalServiceUtil
				.createLicencias(CounterLocalServiceUtil.increment(Licencias.class.getName()));
		li.setNombreLicencia(ParamUtil.getString(actionRequest, "nombreLicencia"));
		li.setDescripcionLicencia(ParamUtil.getString(actionRequest, "descripcionLicencia"));
		li.setVersionLicencia(ParamUtil.getString(actionRequest, "versionLicencia"));
		li.setUserId(ParamUtil.getLong(actionRequest, "userId"));

		LicenciasLocalServiceUtil.addLicencias(li);
		ParamUtil.print(actionRequest);

	}
}