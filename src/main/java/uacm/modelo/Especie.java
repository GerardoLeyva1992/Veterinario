package uacm.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Table(name="especie")
@Entity 
public class Especie implements Serializable {
	@Id
	@javax.persistence.TableGenerator(
		    name="ESP_GEN",
		    table="GENERATOR_TABLE",
		    pkColumnName = "key",
		    valueColumnName = "hi",
		    pkColumnValue="ESP",
		    		initialValue = 1,
		    	      allocationSize = 10000
		    
		)
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long idEspecie;
	
	
	private Long idPropetario;

	private String nombre;
	
	private int mesesVida;
	
	private String tipoEspecie;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Long getIdPropetario() {
		return idPropetario;
	}
	public void setIdPropetario(Long idPropetario) {
		this.idPropetario = idPropetario;
	}
	public Long getIdEspecie() {
		return idEspecie;
	}
	public void setIdEspecie(Long idEspecie) {
		this.idEspecie = idEspecie;
	}
	public int getMesesVida() {
		return mesesVida;
	}
	public void setMesesVida(int mesesVida) {
		this.mesesVida = mesesVida;
	}
	public String getTipoEspecie() {
		return tipoEspecie;
	}
	public void setTipoEspecie(String tipoEspecie) {
		this.tipoEspecie = tipoEspecie;
	}
	
	

}
