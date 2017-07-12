package edunote.pojos;

import java.util.List;
import javax.persistence.*;
@Entity
@Table(schema="colegio")
public class Bimestre {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_bim")
	private Integer id;
	@Column(nullable=false,unique=true)
	private String nombre;
	@OneToMany(fetch=FetchType.EAGER, mappedBy="bimestre")
	private List<Nota> notas;
	
	public Bimestre(){}
	public Bimestre(Integer id){this.id=id;}
	public Bimestre(String nombre){ this.nombre = nombre;}
	public Bimestre(Integer id,String nombre){ this.nombre = nombre; this.id=id;}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Nota> getNotas() {
		return notas;
	}
	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}
	public boolean addNota(Nota nota){
		return notas.add(nota);
	}
	public boolean equals(Object a){ return ((Bimestre)a).getNombre().equalsIgnoreCase(getNombre());}
	public String toString(){return this.getNombre();}
}
