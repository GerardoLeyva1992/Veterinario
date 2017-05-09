package uacm.vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import com.toedter.calendar.JDateChooser;

import uacm.init.HibernateUtil;

import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class fecha extends JFrame {

	private JPanel contentPane;
	private Radar radar;
	private JTable table;
	private JScrollPane scrollPane;
	private JDateChooser dateChooser;
	private JButton btnNewButton;
	private JComboBox comboBox ;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fecha frame = new fecha();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public fecha() {
		radar=new Radar();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1244, 621);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("yyyy-MM-dd");
		dateChooser.setBounds(1095, 26, 123, 20);
		contentPane.add(dateChooser);
		
		btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(radar);
		btnNewButton.setBounds(1129, 548, 89, 23);
		contentPane.add(btnNewButton);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 24, 1075, 447);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Fecha de Alta", "Fecha de Ingreso"}));
		comboBox.setBounds(1095, 57, 123, 20);
		contentPane.add(comboBox);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(22, 548, 89, 23);
		contentPane.add(btnCancelar);
		btnCancelar.addActionListener(radar);
	}
	private class Radar implements ActionListener{

	public void actionPerformed(ActionEvent evento){
		
		if( (evento.getActionCommand()).equals("Buscar")){
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = null;
			try {
				transaction = session.beginTransaction();
				Iterator query =null;
				if(comboBox.getActionCommand().equals("Fecha de alta"))
					query =session.createQuery("select r.idEspecie,r.Status,r.diagnostico,r.fechaAlta,r.fechaIngreso,r.numeroEmpleado,r.sintomas,e.nombre from Registro r,Especie e where r.idEspecie=e.idEspecie and  r.fechaAlta="+"'"+new java.sql.Date( dateChooser.getDate().getTime())+"'").list().iterator();
				else
					query =session.createQuery("select r.idEspecie,r.Status,r.diagnostico,r.fechaAlta,r.fechaIngreso,r.numeroEmpleado,r.sintomas,e.nombre from Registro r,Especie e where r.idEspecie=e.idEspecie and  r.fechaIngreso="+"'"+new java.sql.Date( dateChooser.getDate().getTime())+"'").list().iterator();

				Object[][] datosFila=new Object[30][10];
				String nombreColumnas[] = {"Matricula Mascota","Status","Diagnostico","Fecha de Alta","Fecha de Ingreso","Numero de empleado que atendio","Sintomas","Nombre de Mascota"};
				int i=0;
		        while(query.hasNext()){
		        	
		            Object[] tuple = (Object[]) query.next();
					datosFila[i][0]=tuple[0];
					datosFila[i][1]=tuple[1];
					datosFila[i][2]=tuple[2];
					datosFila[i][3]=tuple[3];
					datosFila[i][4]=tuple[4];
					datosFila[i][5]=tuple[5];
					datosFila[i][6]=tuple[6];
					datosFila[i][7]=tuple[7];
		        	i=i+1;
					  }
				DefaultTableModel modelo1;
                modelo1 = new DefaultTableModel(datosFila,nombreColumnas);
                table.setModel(modelo1);		        
				transaction.commit();
			} catch (HibernateException e) {
				transaction.rollback();
				e.printStackTrace();
			} finally {
				session.close();
			}

		}
		if( (evento.getActionCommand()).equals("Cancelar")){
			Principal m1 = new Principal();
			m1.setVisible(true);
			dispose();
		}
	
			}	
		}
}
