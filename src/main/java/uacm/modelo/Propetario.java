package uacm.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table(name="propetario")
@Entity
public class Propetario extends Persona implements Serializable  {
	@Id
	@javax.persistence.TableGenerator(
		    name="PRO_GEN",
		    table="GENERATOR_TABLE",
		    pkColumnName = "key",
		    valueColumnName = "hi",
		    pkColumnValue="PRO",
		    		initialValue = 1,
		    	      allocationSize = 10000
		    
		)
	@NotNull
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long idPropetario;
	@NotNull
	@Id
	private Long numeroEmpleado;
	
	//private Especie arregloEspecie[];
	
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
	/*
	public Especie[] getArregloEspecie() {
		return arregloEspecie;
	}
	public void setArregloEspecie(Especie[] arregloEspecie) {
		this.arregloEspecie = arregloEspecie;
	}
	*/

	

}
