package edunote.pojos;

import java.util.List;
import javax.persistence.*;
@Entity
@Table(schema="colegio")
public class Ciclo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_ciclo")
	private Integer id;
	@Column(nullable=false,unique=true)
	private String nombre;
	@OneToMany(fetch=FetchType.EAGER,mappedBy="ciclo")
	private List<Registro> registros;
	
	public Ciclo() {}
	public Ciclo(Integer id){this.id=id;}
	public Ciclo(String nombre) {this.nombre = nombre;}
	public Ciclo(Integer id,String nombre){this.id=id;this.nombre=nombre;}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean equals(Object arg) {
		return ((Ciclo)arg).getNombre().equalsIgnoreCase(this.getNombre());
	}
	public List<Registro> getRegistros() {
		return registros;
	}
	public void setRegistros(List<Registro> registros) {
		this.registros = registros;
	}
	public boolean addRegistro(Registro r){return this.registros.add(r);}
	public String toString(){return String.format("Colegio: %s",this.nombre);}
}
