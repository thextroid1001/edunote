package edunote.controller.rest;
import java.util.List;
import org.slf4j.*;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import edunote.pojos.Colegio;
import edunote.servicios.impl.API;
import edunote.util.CustomErrorType;

@RestController
@Controller
@RequestMapping("/api/**")
public class APIColegios extends API {
	// -------------------Recuperar Todos Colegios---------------------------------------------
	public static final Logger logger = LoggerFactory.getLogger(APIColegios.class);

	@RequestMapping(value = PATH_COLEGIO, method = RequestMethod.GET)
	public ResponseEntity<List<?>> listAllColegios() {
		List<Colegio> personas = $colegio.listar();
		if( personas.isEmpty() ) {
			return new ResponseEntity<List<?>>(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<?>>(personas, HttpStatus.OK);
	}
	/** -------------------Retrieve Single Colegio------------------------------------------*/

	@RequestMapping(value = PATH_COLEGIO + "{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getColegio(@PathVariable("id") Integer id) {
		logger.info("Recuperando Colegio con id {}", id);
		Colegio colegio = $colegio.findById(id);
		if( colegio == null ) {
			logger.error("Colegio con id {} no encontrado.", id);
			return new ResponseEntity<>(new CustomErrorType(String.format("Colegio con id %d no encontrado.", id)),
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Colegio>(colegio, HttpStatus.OK);
	}

	// -------------------Create a Colegio-------------------------------------------

	@RequestMapping(value = PATH_COLEGIO, method = RequestMethod.POST)
	public ResponseEntity<?> createColegio(@RequestBody Colegio data, UriComponentsBuilder ucBuilder) {
		logger.info("Creando Colegio : {}", data);

		if( $colegio.siExiste(data) ) {
			logger.error("Imposible para crear. Un Colegio con nombre {} ya existe", data.getNombre());
			return new ResponseEntity<>(
					new CustomErrorType(String.format("Imposible para crear. Un Colegio con Nombre %s ya existe", data.getNombre())) ,HttpStatus.CONFLICT);
		}
		$colegio.guardar(data);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/colegio/{id}").buildAndExpand(data.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	// ------------------- Update a Colegio ------------------------------------------------

	@RequestMapping(value = PATH_COLEGIO + "{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateColegio(@PathVariable("id") Integer id, @RequestBody Colegio data,@RequestParam String nombre_old) {
		logger.info("Actualizando Colegio con id {}", id);
		if( nombre_old != null && data.getNombre() != nombre_old && $colegio.siExiste(data) ) {
			logger.error("Impsobile actualizar. El Colegio con nombre {} ya existe", data.getNombre());
			return new ResponseEntity<>(new CustomErrorType(
					String.format("Imposible actualizar. El Colegio con nombre %s ya existe", data.getNombre())),
					HttpStatus.CONFLICT);
		}
		Colegio currentColegio = $colegio.findById(id);
		if( currentColegio == null ) {
			logger.error("Imposible actualizar. Colegio con id {} no encontrado.", id);
			return new ResponseEntity<>(
					new CustomErrorType(String.format("Imposible actualizar. Colegio con id {} no encontrado.", id)),
					HttpStatus.NOT_FOUND);
		}
		currentColegio.setNombre(data.getNombre());
		currentColegio.setId(data.getId());
		currentColegio.setNombre(data.getNombre());
		$colegio.guardar(currentColegio);
		return new ResponseEntity<Colegio>(currentColegio, HttpStatus.OK);
	}

	// ------------------- Delete a Colegio-----------------------------------------

	@RequestMapping(value = PATH_COLEGIO + "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteColegio(@PathVariable("id") Integer idcolegio) {
		logger.info("Procesando & Eliminando Colegio con rda {}", idcolegio);

		Colegio colegio = $colegio.findById(idcolegio);
		if( colegio == null ) {
			logger.error("Imposible de Eliminar. Colegio con rda {} no encontrado.", idcolegio);
			return new ResponseEntity<>(
					new CustomErrorType(
							String.format("Imposible de Eliminar. Colegio con rda %s not encontrado.", idcolegio)),
					HttpStatus.NOT_FOUND);
		}
		$colegio.eliminar(colegio);
		return new ResponseEntity<Colegio>(HttpStatus.NO_CONTENT);
	}

}
