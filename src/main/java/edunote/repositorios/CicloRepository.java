package edunote.repositorios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import edunote.pojos.Ciclo;

@Repository
public interface CicloRepository extends JpaRepository<Ciclo, String>{

}
