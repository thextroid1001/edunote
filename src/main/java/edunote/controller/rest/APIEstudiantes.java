package edunote.controller.rest;
import java.util.List;
import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import edunote.pojos.*;
import edunote.repositorios.ColegioRepository;
import edunote.servicios.impl.*;
import edunote.util.CustomErrorType;
@RestController
@Controller
@RequestMapping("/api/**")
public class APIEstudiantes extends API{
	ColegioRepository colegioRepository;
	// -------------------Recuperar Todos Users---------------------------------------------
	public static final Logger logger = LoggerFactory.getLogger(APIEstudiantes.class);
		@RequestMapping(value = PATH_ESTUDIANTE,method = RequestMethod.GET)
		public ResponseEntity<List<Estudiante>> listAllUsers() {
			List<Estudiante> personas = $estudiante.findAllEstudiantes();
			if (personas.isEmpty()) {
				return new ResponseEntity<List<Estudiante>>(HttpStatus.NO_CONTENT);
				// You many decide to return HttpStatus.NOT_FOUND
			}
			return new ResponseEntity<List<Estudiante>>(personas, HttpStatus.OK);
		}

		// -------------------Retrieve Single User------------------------------------------

		@RequestMapping(value = PATH_ESTUDIANTE+"{id}", method = RequestMethod.GET)
		public ResponseEntity<?> getUser(@PathVariable("id") long id) {
			logger.info("Fetching User with id {}", id);
			Persona persona = $usuario.findById(id);
			if (persona == null) {
				logger.error("User with id {} not found.", id);
				return new ResponseEntity<>(new CustomErrorType("User with id " + id 
						+ " not found"), HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Persona>(persona, HttpStatus.OK);
		}

		// -------------------Create a User-------------------------------------------

		@RequestMapping(value=PATH_ESTUDIANTE, method = RequestMethod.POST)
		public ResponseEntity<?> createUser(@RequestBody Estudiante persona, UriComponentsBuilder ucBuilder) {
			logger.info("Creating User : {}", persona);

			if ($estudiante.isEstudianteExist(persona)) {
				logger.error("Incapaz para crear. Un usuario con rude {} ya existe", persona.getRude());
				return new ResponseEntity<>(new CustomErrorType(String.format("Incapaz para crear. Un usuario con rude %s ya existe", persona.getRude())),HttpStatus.CONFLICT);
			}
			$estudiante.saveEstudiante(persona);

			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/api/user/{id}").buildAndExpand(persona.getId()).toUri());
			return new ResponseEntity<String>(headers, HttpStatus.CREATED);
		}

		// ------------------- Update a User ------------------------------------------------

		@RequestMapping(value = PATH_ESTUDIANTE+"{id}", method = RequestMethod.PUT)
		public ResponseEntity<?> updateUser(@PathVariable("id") long id, @RequestBody Estudiante persona) {
			logger.info("Updating User with id {}", id);
			if(persona.rude_old!=null && (int)persona.rude_old!=Integer.parseInt(persona.getRude()) && $estudiante.isEstudianteExist(persona)){
				logger.error("Impsobile actualizar. El Maestro con rda {} ya existe",persona.getRude());
				return new ResponseEntity<>(new CustomErrorType(String.format("Imposible actualizar. El Maestro con rude %s con rda ya existe",persona.getRude())),HttpStatus.CONFLICT);
			}
			Estudiante currentUser = $estudiante.findById(id);

			if (currentUser == null) {
				logger.error("Unable to update. User with id {} not found.", id);
				return new ResponseEntity<>(new CustomErrorType("Unable to upate. User with id " + id + " not found."),
						HttpStatus.NOT_FOUND);
			}
			currentUser.setCi		(persona.getCi());
			currentUser.setAm		(persona.getAm());
			currentUser.setNombre	(persona.getNombre());
			currentUser.setAp		(persona.getAp());
			currentUser.setRude		(persona.getRude());
			currentUser.setTelefono	(persona.getTelefono());
			$estudiante.updateEstudiante(currentUser);
			return new ResponseEntity<Estudiante>(currentUser, HttpStatus.OK);
		}

		// ------------------- Delete a User-----------------------------------------

		@RequestMapping(value = PATH_ESTUDIANTE+"{id}", method = RequestMethod.DELETE)
		public ResponseEntity<?> deleteUser(@PathVariable("id") long id) {
			logger.info("Fetching & Deleting User with id {}", id);

			Persona persona = $usuario.findById(id);
			if (persona == null) {
				logger.error("Unable to delete. User with id {} not found.", id);
				return new ResponseEntity<>(new CustomErrorType("Unable to delete. User with id " + id + " not found."),
						HttpStatus.NOT_FOUND);
			}
			$usuario.deleteUserById(id);
			return new ResponseEntity<Persona>(HttpStatus.NO_CONTENT);
		}

		// ------------------- Delete All Users-----------------------------

		@RequestMapping(value=PATH_ESTUDIANTE, method = RequestMethod.DELETE)
		public ResponseEntity<Persona> deleteAllUsers() {
			logger.info("Deleting All Users");

			return new ResponseEntity<Persona>(HttpStatus.NO_CONTENT);
		}
	
}
