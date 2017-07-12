package edunote.pojos;

import java.util.List;
import javax.persistence.*;
@Entity
@Table(schema="colegio")
public class Curso {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_curso")
	private Integer id;
	@Column(nullable=false,unique=true)
	private String nombre;
	@OneToMany(fetch=FetchType.EAGER,mappedBy="curso")
	private List<Registro> registros;
	
	public Curso(){}
	public Curso(String nombre){this.nombre = nombre;}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean equals(Object arg){
		return ((Curso)arg).getNombre().equalsIgnoreCase(this.getNombre());
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<Registro> getRegistros() {
		return registros;
	}
	public void setRegistros(List<Registro> registros) {
		this.registros = registros;
	}
	public boolean addRegistro(Registro r){return this.registros.add(r);}
	public String toString(){return String.format("Curso: ", this.getNombre());}
	
}
