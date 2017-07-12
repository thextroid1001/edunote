package edunote.pojos;
import java.util.List;

import javax.persistence.*;
@Entity
@Table(schema="colegio")
public class Colegio {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_colegio")
	private Integer id;
	@Column(nullable=false,unique=true)
	private String nombre;
	@Column
	private String direccion;
	@Column
	private byte[] escudo;
	@OneToMany(fetch=FetchType.EAGER,mappedBy="colegio")
	private List<Registro> registros;
	
	public Colegio() {	}
	public Colegio(Integer id,String nombre,String direccion){this.id=id;this.nombre=nombre;this.direccion=direccion;}
	public Colegio(String nombre, String direccion, byte[] escudo) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.escudo = escudo;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public byte[] getEscudo() {
		return escudo;
	}
	public void setEscudo(byte[] escudo) {
		this.escudo = escudo;
	}
	public List<Registro> getRegistros() {
		return registros;
	}
	public void setRegistros(List<Registro> registros) {
		this.registros = registros;
	}
	public boolean addRegistro(Registro r){return this.registros.add(r);}
}
