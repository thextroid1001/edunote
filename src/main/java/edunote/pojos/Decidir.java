package edunote.pojos;

import javax.persistence.*;

@Entity
@Table(schema="colegio")
public class Decidir extends Nota{
	@Column(name="n_creatividad",nullable=false)
	private Integer creatividad; 
	@Column(name="n_desarrollo_psp",nullable=false)
	private Integer psp;
	@Column(name="n_autodeterminacion",nullable=false)
	private Integer autodeterminacion;
	@Column(name="n_desarrollo_critico",nullable=false)
	private Integer critico;
	@Column
	private Double promedio;
	public Integer getCreatividad() {
		return creatividad;
	}
	public void setCreatividad(Integer creatividad) {
		this.creatividad = creatividad;
	}
	public Integer getPsp() {
		return psp;
	}
	public void setPsp(Integer psp) {
		this.psp = psp;
	}
	public Integer getAutodeterminacion() {
		return autodeterminacion;
	}
	public void setAutodeterminacion(Integer autodeterminacion) {
		this.autodeterminacion = autodeterminacion;
	}
	public Integer getCritico() {
		return critico;
	}
	public void setCritico(Integer critico) {
		this.critico = critico;
	}
	public Double getPromedio() {
		return promedio;
	}
	public void setPromedio(Double promedio) {
		this.promedio = promedio;
	}
	
	
}
