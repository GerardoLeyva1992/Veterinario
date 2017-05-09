package uacm.vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.swing.JTextField;
import javax.swing.JLabel;
import com.toedter.calendar.JDateChooser;

import uacm.init.HibernateUtil;
import uacm.modelo.Registro;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class vistaConsulta extends JFrame {

	private JPanel contentPane;
	private JTextField textidMascota;
	private JTextField textNumeroEmpleado;
	private JTextField textSintomas;
	private JTextField textDiagnostico;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JDateChooser dateFechaIngreso;
	private JLabel lblFechaIngreso;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_4;
	private JButton btnGuardar;
	private JComboBox comboBox;
	private Radar radar;
	private JButton btnCancelar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vistaConsulta frame = new vistaConsulta();
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
	public vistaConsulta() {
		setTitle("Consulta Veterinaria");
		radar=new Radar();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 717, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textidMascota = new JTextField();
		textidMascota.setBounds(10, 11, 122, 20);
		contentPane.add(textidMascota);
		textidMascota.setColumns(10);
		
		lblNewLabel = new JLabel("id Mascota");
		lblNewLabel.setBounds(20, 42, 122, 14);
		contentPane.add(lblNewLabel);
		
		textNumeroEmpleado = new JTextField();
		textNumeroEmpleado.setBounds(163, 11, 86, 20);
		contentPane.add(textNumeroEmpleado);
		textNumeroEmpleado.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Numero Empleado");
		lblNewLabel_1.setBounds(173, 42, 143, 14);
		contentPane.add(lblNewLabel_1);
		
		dateFechaIngreso = new JDateChooser();
		dateFechaIngreso.setDateFormatString("yyyy-MM-dd");
		dateFechaIngreso.setBounds(536, 11, 143, 20);
		contentPane.add(dateFechaIngreso);
		
		lblFechaIngreso = new JLabel("Fecha de Ingreso");
		lblFechaIngreso.setBounds(546, 42, 122, 14);
		contentPane.add(lblFechaIngreso);
		
		textSintomas = new JTextField();
		textSintomas.setBounds(10, 90, 357, 148);
		contentPane.add(textSintomas);
		textSintomas.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Sintomas");
		lblNewLabel_2.setBounds(20, 249, 95, 14);
		contentPane.add(lblNewLabel_2);
		
		textDiagnostico = new JTextField();
		textDiagnostico.setBounds(410, 90, 269, 148);
		contentPane.add(textDiagnostico);
		textDiagnostico.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Diagnostico");
		lblNewLabel_3.setBounds(420, 249, 150, 14);
		contentPane.add(lblNewLabel_3);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(radar);
		btnGuardar.setBounds(590, 324, 89, 23);
		contentPane.add(btnGuardar);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Dar Alta", "Internar"}));
		comboBox.setBounds(10, 288, 143, 20);
		contentPane.add(comboBox);
		
		lblNewLabel_4 = new JLabel("Estatus");
		lblNewLabel_4.setBounds(10, 328, 143, 14);
		contentPane.add(lblNewLabel_4);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(419, 324, 89, 23);
		contentPane.add(btnCancelar);
		btnCancelar.addActionListener(radar);
	}
	private class Radar implements ActionListener{

	public void actionPerformed(ActionEvent evento){
		
		
		if( (evento.getActionCommand()).equals("Guardar")){
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = null;
			try {
				transaction = session.beginTransaction();
	
				Registro e = new Registro();
				e.setIdEspecie(Long.parseLong(textidMascota.getText()));
				e.setDiagnostico(textDiagnostico.getText());
				e.setNumeroEmpleado(Long.parseLong(textNumeroEmpleado.getText()));
				e.setSintomas(textSintomas.getText());
				e.setStatus(comboBox.getSelectedItem().toString());
				e.setFechaIngreso(new java.sql.Date( dateFechaIngreso.getDate().getTime()));
				if(comboBox.getSelectedItem().toString()=="Dar Alta")
					e.setFechaAlta(new java.sql.Date( dateFechaIngreso.getDate().getTime()));
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
		if( (evento.getActionCommand()).equals("Cancelar")){
			Principal m1 = new Principal();
			m1.setVisible(true);
			dispose();
		}
	
		}
		
	}
}
