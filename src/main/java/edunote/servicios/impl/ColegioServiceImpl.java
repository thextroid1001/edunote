package edunote.servicios.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edunote.pojos.Colegio;
import edunote.repositorios.ColegioRepository;
import edunote.servicios.ColegioService;

@Service
public class ColegioServiceImpl implements ColegioService{
	@Autowired
	private ColegioRepository $$colegio;
	@Override
	public List<Colegio> listar() {
		return $$colegio.findAll();
	}

	@Override
	public Colegio findById(Integer id) {
		return $$colegio.findOne(id);
	}

	@Override
	public Colegio findByNombre(String nombre) {
		return $$colegio.findByNombre(nombre);
	}

	@Override
	public void guardar(Colegio colegio) {
		$$colegio.save(colegio);
	}

	@Override
	public void eliminar(Colegio colegio) {
		$$colegio.delete(colegio.getId());
	}
	@Override
	public boolean siExiste(Colegio colegio) {
		return $$colegio.findByNombre(colegio.getNombre())!=null;
	}
	
}
