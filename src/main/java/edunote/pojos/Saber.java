package edunote.pojos;

import javax.persistence.*;

@Entity
@Table(schema="colegio")
public class Saber extends Nota{
	@Column(nullable=false,name="n_examen1")
	private Integer examen1;
	@Column(nullable=false,name="n_examen2")
	private Integer examen2;
	@Column(nullable=false,name="n_examen3")
	private Integer examen3;
	@Column(nullable=false,name="n_examen4")
	private Integer examen4;
	@Column(nullable=false,name="n_examen5")
	private Integer examen5;
	@Column
	private Double promedio;
	public Integer getExamen1() {
		return examen1;
	}
	public void setExamen1(Integer examen1) {
		this.examen1 = examen1;
	}
	public Integer getExamen2() {
		return examen2;
	}
	public void setExamen2(Integer examen2) {
		this.examen2 = examen2;
	}
	public Integer getExamen3() {
		return examen3;
	}
	public void setExamen3(Integer examen3) {
		this.examen3 = examen3;
	}
	public Integer getExamen4() {
		return examen4;
	}
	public void setExamen4(Integer examen4) {
		this.examen4 = examen4;
	}
	public Integer getExamen5() {
		return examen5;
	}
	public void setExamen5(Integer examen5) {
		this.examen5 = examen5;
	}
	public Double getPromedio() {
		return promedio;
	}
	public void setPromedio(Double promedio) {
		this.promedio = promedio;
	}
	
}
