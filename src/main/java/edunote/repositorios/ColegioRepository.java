package edunote.repositorios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import edunote.pojos.Colegio;
import java.lang.String;
@Repository
public interface ColegioRepository extends JpaRepository<Colegio, Integer>{
	Colegio findByNombre(String nombre);
}
