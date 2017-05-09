package uacm.modelo;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="empleado")
public class Empleado extends Persona  implements Serializable{
	@Id
	@javax.persistence.TableGenerator(
		    name="EMP_GEN",
		    table="GENERATOR_TABLE",
		    pkColumnName = "key",
		    valueColumnName = "hi",
		    pkColumnValue="EMP",
		    		initialValue = 1,
		    	      allocationSize = 10000
		    
		)
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long numeroEmpleado;
	private Date fechaContrato;
	private Date fechaDespido;
	private String status;//10
	//@Null
	//private Propetario arregloPropetario[];
	
	
	public Long getNumeroEmpleado() {
		return numeroEmpleado;
	}
	public void setNumeroEmpleado(Long numeroEmpleado) {
		this.numeroEmpleado = numeroEmpleado;
	}	
	public Date getFechaContrato() {
		return fechaContrato;
	}
	public void setFechaContrato(Date fechaContrato) {
		this.fechaContrato = fechaContrato;
	}
	public Date getFechaDespido() {
		return fechaDespido;
	}
	public void setFechaDespido(Date fechaDespido) {
		this.fechaDespido = fechaDespido;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}


		

}
