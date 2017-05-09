package uacm.vista;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.EventQueue;

import com.toedter.calendar.JDateChooser;

import uacm.init.HibernateUtil;
import uacm.modelo.Empleado;




public class vistaEmpleado extends JFrame {

	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textAPaterno;
	private JLabel lblApellidoPaterno;
	private JTextField textAMaterno;
	private JLabel lblApellidoMaterno;
	private JLabel lblImganeVet;
	private JTextField textCorreo;
	private JTextField textTelefono;
    private Radar radar;
    private JLabel lblNombre;
    private JDateChooser dateChooser;
    private JLabel lblFechaContrato;
    private JLabel lblNewCorreo;
    private JLabel lblNewLabel_3;
    private JButton btnAlta;
    private JDateChooser dateChooserFechaNacimiento;
    private JLabel lblNewLabel;
    private JButton btnNewButton;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vistaEmpleado frame = new vistaEmpleado();
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
	public vistaEmpleado() {
		
		radar = new Radar();

		setTitle("Alta Empleado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 466, 535);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textNombre = new JTextField();
		textNombre.setBounds(10, 45, 175, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(20, 76, 76, 14);
		contentPane.add(lblNombre);

		textAPaterno = new JTextField();
		textAPaterno.setBounds(10, 101, 175, 20);
		contentPane.add(textAPaterno);
		textAPaterno.setColumns(10);
		
		lblApellidoPaterno = new JLabel("Apellido Paterno");
		lblApellidoPaterno.setBounds(20, 132, 148, 14);
		contentPane.add(lblApellidoPaterno);
		
		textAMaterno = new JTextField();
		textAMaterno.setBounds(10, 157, 175, 20);
		contentPane.add(textAMaterno);
		textAMaterno.setColumns(10);
		
		lblApellidoMaterno = new JLabel("Apellido Materno");
		lblApellidoMaterno.setBounds(20, 188, 88, 14);
		contentPane.add(lblApellidoMaterno);
		
		lblImganeVet = new JLabel("");
		lblImganeVet.setIcon(new ImageIcon(vistaEmpleado.class.getResource("/imagenes/man-vet.png")));
		lblImganeVet.setBounds(290, 34, 118, 246);
		contentPane.add(lblImganeVet);
		
		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("yyyy-MM-dd");
		dateChooser.setBounds(10, 213, 175, 20);
		contentPane.add(dateChooser);
		
		lblFechaContrato = new JLabel("Fecha de Contrato");
		lblFechaContrato.setBounds(20, 246, 118, 14);
		contentPane.add(lblFechaContrato);
		
		textCorreo = new JTextField();
		textCorreo.setBounds(10, 271, 175, 20);
		contentPane.add(textCorreo);
		textCorreo.setColumns(10);
		
		lblNewCorreo = new JLabel("Correo");
		lblNewCorreo.setBounds(20, 302, 46, 14);
		contentPane.add(lblNewCorreo);
		
		textTelefono = new JTextField();
		textTelefono.setBounds(10, 327, 175, 20);
		contentPane.add(textTelefono);
		textTelefono.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Telefono");
		lblNewLabel_3.setBounds(20, 358, 76, 14);
		contentPane.add(lblNewLabel_3);
		
		btnAlta = new JButton("Dar de alta");
		btnAlta.setBounds(290, 444, 148, 23);
		btnAlta.addActionListener(radar);
		contentPane.add(btnAlta);

	   
		dateChooserFechaNacimiento = new JDateChooser();
		dateChooserFechaNacimiento.setDateFormatString("yyyy-MM-dd");
		dateChooserFechaNacimiento.setBounds(10, 383, 175, 20);
		contentPane.add(dateChooserFechaNacimiento);
		
		lblNewLabel = new JLabel("Fecha Nacimiento");
		lblNewLabel.setBounds(20, 414, 158, 20);
		contentPane.add(lblNewLabel);
		
		btnNewButton = new JButton("Cancelar");
		btnNewButton.setBounds(91, 444, 139, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(radar);
	}
	private class Radar implements ActionListener{

	public void actionPerformed(ActionEvent evento){
		
		
		if( (evento.getActionCommand()).equals("Dar de alta")){
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = null;
			try {
				transaction = session.beginTransaction();
	
				Empleado e = new Empleado();
				e.setNombre(textNombre.getText());
				e.setApellidoMaterno(textAMaterno.getText());
				e.setApellidoPaterno(textAPaterno.getText());
				e.setFechaNacimiento(new java.sql.Date( dateChooserFechaNacimiento.getDate().getTime()));
				e.setFechaContrato(new java.sql.Date(dateChooser.getDate().getTime()));
				e.setStatus("Activo");
				e.setCorreo(textCorreo.getText());
				e.setTelefono(textTelefono.getText());
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
