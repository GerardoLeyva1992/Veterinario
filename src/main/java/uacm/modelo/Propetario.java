package uacm.modelo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name="propetario")
@Entity
public class Propetario extends Persona   {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idPropetario;
	
	private Long numeroEmpleado;

	
	public Long getIdPropetario() {
		return idPropetario;
	}
	public void setIdPropetario(Long idPropetario) {
		this.idPropetario = idPropetario;
	}
	public Long getNumeroEmpleado() {
		return numeroEmpleado;
	}
	public void setNumeroEmpleado(Long numeroEmpleado) {
		this.numeroEmpleado = numeroEmpleado;
	}



	

}
