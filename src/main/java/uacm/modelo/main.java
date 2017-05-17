package uacm.modelo;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import uacm.init.HibernateUtil;

public class main {
	
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();

			Propetario e = new Propetario();
			e.setNombre("Gerardo");
			e.setApellidoMaterno("Leyva");
			e.setApellidoPaterno("Teutli");
			e.setFechaNacimiento(null);
			e.setCorreo("gerardoLeyvahotmail.com");
			e.setTelefono("55-66-77-88");
			e.setNumeroEmpleado(1L);
			session.save(e);
			
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
			} 
			finally {
			session.close(); 
			}

	}

}
