package edunote.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class AppController {

	@RequestMapping("/")
	String home(ModelMap modal) {
		modal.addAttribute("title","CRUD Example");
		return "app/index";
	}
	@RequestMapping("/app/modules/login/index.html")
	String login(ModelMap modal) {
		modal.addAttribute("title","login");
		return "app/modules/login/index";
	}
	@RequestMapping("/app/common/app.html")
	String commonApp(ModelMap modal) {
		modal.addAttribute("title","login");
		return "app/common/app";
	}
	@RequestMapping("/app/modules/dashboard/views/home.html")
	String dashboardHandler() {
		return "app/modules/dashboard/views/home";
	}
	@RequestMapping("/app/modules/dashboard/estudiante/index.html")
	String usuariosHandler(Model scope) {
		scope.addAttribute("datos", new String[]{"israel","marino","jerez"});
		return "app/modules/dashboard/estudiante/index";
	}
	@RequestMapping("/app/modules/dashboard/maestro/index.html")
	String maestrosHandler() {
		return "app/modules/dashboard/maestro/index";
	}
	
	@RequestMapping("/app/modules/dashboard/registro/dialog.html")
	String inscribirHandler() {
		return "app/modules/dashboard/registro/dialog";
	}
	@RequestMapping("/app/modules/dashboard/registro/colegio/dialog.html")
	String inscribirHandlerColegio() {
		return "app/modules/dashboard/registro/colegio/dialog";
	}

	@RequestMapping("/partials/{page}")
	String partialHandler(@PathVariable("page") final String page) {
		return page;
	}
}
