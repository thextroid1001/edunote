package edunote.pojos;
import javax.persistence.*;
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(schema="colegio")
public class Nota {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_nota")
	private Long id;
	@Column(name="puntaje",nullable=true)
	private Double puntaje;
	@ManyToOne
	@JoinColumn(name="nt_materia",nullable=false)
	private Materia materia;
	@ManyToOne
	@JoinColumn(name="nt_maestro",nullable=false)
	private Maestro maestro;
	@ManyToOne
	@JoinColumn(name="nt_bimestre",nullable=false)
	private Bimestre bimestre;
	@ManyToOne
	@JoinColumn(name="nt_registro",nullable=false)
	private Registro registro;
	@Column(nullable=false,columnDefinition="boolean default true")
	private boolean incorporado=true;
	
	public Long getId() {		return id;	}
	public void setId(Long id) {	this.id = id;	}
	public Double getPuntaje() {		return puntaje;	}
	public void setPuntaje(Double puntaje) {		this.puntaje = puntaje;	}
	public Materia getMateria() {		return materia;	}
	public void setMateria(Materia materia) {		this.materia = materia;	}
	public Maestro getMaestro() {		return maestro;	}
	public void setMaestro(Maestro maestro) {		this.maestro = maestro;	}
	public Bimestre getBimestre() {		return bimestre;	}
	public void setBimestre(Bimestre bimestre) {		this.bimestre = bimestre;	}
	public boolean isIncorporado() {		return incorporado;	}
	public void setIncorporado(boolean incorporado) {		this.incorporado = incorporado;	}
	
}
