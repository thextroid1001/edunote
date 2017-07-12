package edunote.repositorios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import edunote.pojos.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, String>{

}
