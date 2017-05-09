package uacm.vista;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.toedter.calendar.JDateChooser;

import uacm.init.HibernateUtil;
import uacm.modelo.Propetario;
import javax.swing.JButton;

public class vistaPaciente extends JFrame {

	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textAPaterno;
	private JLabel lblApellidoPaterno;
	private JTextField textAMaterno;
	private JLabel lblApellidoMaterno;
	private JTextField textidVeterinario;
	private JLabel lblIdveterianrio;
	private JLabel lblNewLabel;
	private JTextField textCorreo;
	private JLabel lblNewLabel_1;
	private JTextField textTelefono;
	private JLabel lblNewLabel_2;
	private JDateChooser dataFechaNacimineto;
    private Radar radar;
    private JButton btnGuardarClinete;
    private JLabel lblNewLabel_3;
    private JButton btnCancelar;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vistaPaciente frame = new vistaPaciente();
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
	public vistaPaciente() {
		
		radar = new Radar();

		setTitle("Alta Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 466, 525);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textNombre = new JTextField();
		textNombre.setBounds(10, 45, 175, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
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
		
		textidVeterinario = new JTextField();
		textidVeterinario.setBounds(10, 213, 175, 20);
		contentPane.add(textidVeterinario);
		textidVeterinario.setColumns(10);
		
		lblIdveterianrio = new JLabel("id Veterianrio");
		lblIdveterianrio.setBounds(27, 246, 158, 14);
		contentPane.add(lblIdveterianrio);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(vistaPaciente.class.getResource("/imagenes/man.png")));
		lblNewLabel.setBounds(269, 34, 139, 246);
		contentPane.add(lblNewLabel);
		
		textCorreo = new JTextField();
		textCorreo.setBounds(10, 271, 175, 20);
		contentPane.add(textCorreo);
		textCorreo.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Correo");
		lblNewLabel_1.setBounds(20, 302, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		textTelefono = new JTextField();
		textTelefono.setBounds(10, 327, 175, 20);
		contentPane.add(textTelefono);
		textTelefono.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Telefono");
		lblNewLabel_2.setBounds(20, 358, 102, 14);
		contentPane.add(lblNewLabel_2);
		
		dataFechaNacimineto = new JDateChooser();
		dataFechaNacimineto.setBounds(10, 383, 175, 20);
		dataFechaNacimineto.setDateFormatString("yyyy-MM-dd");
		contentPane.add(dataFechaNacimineto);
		
		lblNewLabel_3 = new JLabel("Fecha Nacimiento");
		lblNewLabel_3.setBounds(20, 424, 148, 14);
		contentPane.add(lblNewLabel_3);
		
		btnGuardarClinete = new JButton("Guardar");
		btnGuardarClinete.setBounds(319, 438, 89, 23);
		btnGuardarClinete.addActionListener(radar);
		contentPane.add(btnGuardarClinete);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(202, 438, 89, 23);
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
	
				Propetario e = new Propetario();
				e.setNombre(textNombre.getText());
				e.setApellidoMaterno(textAMaterno.getText());
				e.setApellidoPaterno(textAPaterno.getText());
				e.setFechaNacimiento(new java.sql.Date( dataFechaNacimineto.getDate().getTime()));
				e.setCorreo(textCorreo.getText());
				e.setTelefono(textTelefono.getText());
				e.setNumeroEmpleado(Long.parseLong(textidVeterinario.getText()));
				//262144
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
