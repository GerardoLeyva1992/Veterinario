package uacm.modelo;

import java.sql.Date;

public interface PersonaIn {
	String getNombre();
	String getTelefono();
	String getCorreo();
	String getApellidoMaterno();
	String getApellidoPaterno();
	Date getFechaNacimiento();
	void setApellidoMaterno(String setApellidoMaterno);
	void setApellidoPaterno(String setApellidoPaterno);
	void setNombre(String nombre);
	void setFechaNacimiento(Date fechaNacimiento);
	void setCorreo(String correo);
	void setTelefono(String telefono);
}
