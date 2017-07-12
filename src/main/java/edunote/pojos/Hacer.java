package edunote.pojos;

import javax.persistence.*;

@Entity
@Table(schema="colegio")
public class Hacer extends Nota{
	@Column(name="n_tpractico",nullable=false)
	private Integer pratico;
	@Column(name="n_disertacion",nullable=false)
	private Integer disertacion;
	@Column(name="n_cuadernos",nullable=false)
	private Integer cuadernos;
	@Column(name="n_album",nullable=false)
	private Integer album;
	@Column(name="n_resumenes",nullable=false)
	private Integer resumenes;
	@Column(name="n_participacion",nullable=false)
	private Integer participacion;
	@Column
	private Double promedio;
	public Integer getPratico() {
		return pratico;
	}
	public void setPratico(Integer pratico) {
		this.pratico = pratico;
	}
	public Integer getDisertacion() {
		return disertacion;
	}
	public void setDisertacion(Integer disertacion) {
		this.disertacion = disertacion;
	}
	public Integer getCuadernos() {
		return cuadernos;
	}
	public void setCuadernos(Integer cuadernos) {
		this.cuadernos = cuadernos;
	}
	public Integer getAlbum() {
		return album;
	}
	public void setAlbum(Integer album) {
		this.album = album;
	}
	public Integer getResumenes() {
		return resumenes;
	}
	public void setResumenes(Integer resumenes) {
		this.resumenes = resumenes;
	}
	public Integer getParticipacion() {
		return participacion;
	}
	public void setParticipacion(Integer participacion) {
		this.participacion = participacion;
	}
	public Double getPromedio() {
		return promedio;
	}
	public void setPromedio(Double promedio) {
		this.promedio = promedio;
	}
}
