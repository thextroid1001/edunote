package edunote.servicios.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edunote.servicios.*;
@Service
public class API {

//	public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

	@Autowired
	public UsuarioService $usuario; //Service which will do all data retrieval/manipulation work
	
	@Autowired
	public AccountService $cuenta;
	
	@Autowired
	public MaestroService $maestro;
	
	@Autowired
	public EstudianteService $estudiante;
	
	@Autowired
	public ColegioService $colegio;
	
	protected final String PATH_ESTUDIANTE = "/estudiante/";
	protected final String PATH_MAESTRO = "/maestro/";
	protected final String PATH_USUARIO = "/usuario/";
	protected final String PATH_COLEGIO = "/colegio/";
}