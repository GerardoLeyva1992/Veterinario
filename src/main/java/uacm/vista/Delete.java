package uacm.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import uacm.init.HibernateUtil;
import uacm.modelo.Empleado;
import uacm.modelo.Especie;
import uacm.modelo.Registro;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.persistence.Query;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Delete extends JFrame {

	private JPanel contentPane;
	private JTextField textIdentificador;
	private Radar radar;
	private JComboBox comboBox ;
	private JLabel lblEliminar;
	private JLabel lblNumeroDeEmpleado;
	private JLabel lblIdespecieParaPaciente;
	private JLabel lblIdentificador;
	private JButton btnEliminar;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delete frame = new Delete();
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
	public Delete() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/imagenes/archivo-de-gato-icono-4547-128.png")));

		setTitle("Eliminar");
		setResizable(false);
		radar=new Radar();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 578, 300);
		contentPane = new JPanel();
		contentPane.setForeground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Paciente (Mascota)", "Veterinario(Empleado)"}));
		comboBox.setBounds(186, 49, 199, 20);
		contentPane.add(comboBox);
		
		lblEliminar = new JLabel("Eliminar ");
		lblEliminar.setForeground(new Color(255, 0, 0));
		lblEliminar.setBounds(30, 52, 72, 14);
		contentPane.add(lblEliminar);
		
		textIdentificador = new JTextField();
		textIdentificador.setBounds(131, 130, 254, 20);
		contentPane.add(textIdentificador);
		textIdentificador.setColumns(10);
	
		lblNumeroDeEmpleado = new JLabel("Numero de Empleado para Veterianrio");
		lblNumeroDeEmpleado.setBounds(10, 186, 284, 14);
		contentPane.add(lblNumeroDeEmpleado);
		
		lblIdespecieParaPaciente = new JLabel("IdEspecie para Paciente (Mascota)");
		lblIdespecieParaPaciente.setBounds(10, 218, 230, 14);
		contentPane.add(lblIdespecieParaPaciente);
		
		lblIdentificador = new JLabel("Identificador");
		lblIdentificador.setBounds(30, 133, 91, 14);
		contentPane.add(lblIdentificador);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(445, 227, 89, 23);
		contentPane.add(btnEliminar);
		btnEliminar.addActionListener(radar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(296, 227, 89, 23);
		contentPane.add(btnCancelar);
		btnCancelar.addActionListener(radar);
	}
	private class Radar implements ActionListener{

		public void actionPerformed(ActionEvent evento){
			
			if( (evento.getActionCommand()).equals("Cancelar")){
				Principal m1 = new Principal();
				m1.setVisible(true);
				dispose();
			}
			if( (evento.getActionCommand()).equals("Eliminar")){
				Session session = HibernateUtil.getSessionFactory().openSession();
				Transaction transaction = null;
				try {
					transaction = session.beginTransaction();
					if(comboBox.getSelectedItem().toString()=="Veterinario(Empleado)"){
					Empleado e=new Empleado();
					e.setNumeroEmpleado(Long.parseLong(textIdentificador.getText()));
					session.delete(e);
					}
					if(comboBox.getSelectedItem().toString()=="Paciente (Mascota)"){
						Especie s=new Especie();
						s.setIdEspecie(Long.parseLong(textIdentificador.getText()));
						
						session.delete(s);
						
					}
					
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
	}

		
		}

