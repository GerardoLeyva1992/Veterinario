package uacm.modelo;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
@Table(name="Registro")
@Entity 
public class Registro implements Serializable {
	@Id
	@javax.persistence.TableGenerator(
		    name="REG_GEN",
		    table="GENERATOR_TABLE",
		    pkColumnName = "key",
		    valueColumnName = "hi",
		    pkColumnValue="REG",
		    		initialValue = 1,
		    	      allocationSize = 10000
		    
		)
	@NotNull
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long consecutivo;
	@NotNull
	private Date fechaIngreso;
	private Date fechaAlta;
	@Id
	private Long idEspecie;
	@NotNull
	private String sintomas;
	@NotNull
	private String diagnostico;
	@NotNull
	private String Status;
	@Id
	@NotNull
	private Long numeroEmpleado;
	
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public Long getConsecutivo() {
		return consecutivo;
	}
	public void setConsecutivo(Long consecutivo) {
		this.consecutivo = consecutivo;
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public Date getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public Long getIdEspecie() {
		return idEspecie;
	}
	public void setIdEspecie(Long idEspecie) {
		this.idEspecie = idEspecie;
	}
	public String getSintomas() {
		return sintomas;
	}
	public void setSintomas(String sintomas) {
		this.sintomas = sintomas;
	}
	public String getDiagnostico() {
		return diagnostico;
	}
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}
	public Long getNumeroEmpleado() {
		return numeroEmpleado;
	}
	public void setNumeroEmpleado(Long numeroEmpleado) {
		this.numeroEmpleado = numeroEmpleado;
	}

}
