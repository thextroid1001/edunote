package edunote.pojos;

import javax.persistence.*;

import org.hibernate.annotations.NaturalId;

@Entity
@Table(schema="colegio")
public class Registro {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_registro")
	private Long id;
	@ManyToOne
	@JoinColumn(name="reg_estudiante",nullable=false)
	private Estudiante estudiante;
	@ManyToOne
	@NaturalId
	@JoinColumn(name="reg_colegio",nullable=false)
	private Colegio colegio;
	@ManyToOne
	@NaturalId
	@JoinColumn(name="reg_ciclo",nullable=false)
	private Ciclo ciclo;
	@ManyToOne
	@NaturalId
	@JoinColumn(name="reg_curso",nullable=false)
	private Curso curso;
	@Column(nullable=false)
	@NaturalId
	private Integer gestion;
	@Column(nullable=false,columnDefinition="boolean default false")
	private boolean retirado=false;
	
	public Estudiante getEstudiante() {
		return estudiante;
	}
	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}
	public Colegio getColegio() {
		return colegio;
	}
	public void setColegio(Colegio colegio) {
		this.colegio = colegio;
	}
	public Ciclo getCiclo() {
		return ciclo;
	}
	public void setCiclo(Ciclo ciclo) {
		this.ciclo = ciclo;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getGestion() {
		return gestion;
	}
	public void setGestion(Integer gestion) {
		this.gestion = gestion;
	}
	public boolean isRetirado() {
		return retirado;
	}
	public void setRetirado(boolean retirado) {
		this.retirado = retirado;
	}
}
