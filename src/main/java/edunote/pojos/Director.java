package edunote.pojos;

import java.util.Calendar;
import javax.persistence.*;
@Entity
@Table(schema="edunote")
public class Director extends Maestro{
	private static final long serialVersionUID = 1L;
	@Temporal(TemporalType.DATE)
	Calendar fecha_ini;

	public Calendar getFecha_ini() {
		return fecha_ini;
	}
	public void setFecha_ini(Calendar fecha_ini) {
		this.fecha_ini = fecha_ini;
	}
	public String toString(){return String.format("Director: %s %s %s con rda: [%s]",getNombre(),getAp(),getAm(),getRda());}
	
}
