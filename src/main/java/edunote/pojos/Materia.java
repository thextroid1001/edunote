package edunote.pojos;

import java.util.List;
import javax.persistence.*;
@Entity
@Table(schema="colegio")
public class Materia {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_materia")
	private Integer id;
	@Column(nullable=false,unique=true)
	private String nombre;
	@Column
	private Integer horas;
	@OneToMany(fetch=FetchType.EAGER,mappedBy="materia")
	private List<Nota> notas;
	public Materia() {	}
	public Materia(String nombre, Integer horas) {
		this.nombre = nombre;
		this.horas = horas;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getHoras() {
		return horas;
	}
	public void setHoras(Integer horas) {
		this.horas = horas;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public List<Nota> getNotas() {
		return notas;
	}
	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}
	public boolean addNota(Nota n){return this.notas.add(n);}
	public boolean equals(Object obj) {
		return this.getNombre().equalsIgnoreCase(((Materia)obj).getNombre());
	}
}
