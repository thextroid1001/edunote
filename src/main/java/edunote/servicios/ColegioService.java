package edunote.servicios;
import edunote.pojos.*;
import java.util.*;
public interface ColegioService {
	public List<Colegio> listar();
	public Colegio findById(Integer id);
	public Colegio findByNombre(String nombre);
	public void guardar(Colegio colegio);
	public void eliminar(Colegio colegio);
	public boolean siExiste(Colegio colegio);
}
