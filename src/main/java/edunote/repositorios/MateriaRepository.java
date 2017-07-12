package edunote.repositorios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import edunote.pojos.Materia;

@Repository
public interface MateriaRepository extends JpaRepository<Materia, String>{

}
