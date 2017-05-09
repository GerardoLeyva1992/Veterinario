package uacm.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Delete extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
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
		radar=new Radar();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Paciente (Mascota)", "Veterinario(Empleado)"}));
		comboBox.setBounds(145, 49, 199, 20);
		contentPane.add(comboBox);
		
		lblEliminar = new JLabel("Eliminar ");
		lblEliminar.setForeground(new Color(255, 0, 0));
		lblEliminar.setBounds(30, 52, 46, 14);
		contentPane.add(lblEliminar);
		
		textField = new JTextField();
		textField.setBounds(131, 130, 254, 20);
		contentPane.add(textField);
		textField.setColumns(10);
	
		lblNumeroDeEmpleado = new JLabel("Numero de Empleado para Veterianrio");
		lblNumeroDeEmpleado.setBounds(10, 186, 284, 14);
		contentPane.add(lblNumeroDeEmpleado);
		
		lblIdespecieParaPaciente = new JLabel("IdEspecie para Paciente (Mascota)");
		lblIdespecieParaPaciente.setBounds(10, 218, 190, 14);
		contentPane.add(lblIdespecieParaPaciente);
		
		lblIdentificador = new JLabel("Identificador");
		lblIdentificador.setBounds(30, 133, 91, 14);
		contentPane.add(lblIdentificador);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(335, 218, 89, 23);
		contentPane.add(btnEliminar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(199, 218, 89, 23);
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
		}
	}
		}

