package uacm.vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Toolkit;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JButton btnNewEmpleado;
	private JButton btnNewMascota;
	private JButton btnNewDuenio;
	private JButton btnNewConsulta;
	private JButton btnNewRegistros;
	private JLabel lblAltaDeEmplado;
	private JLabel lblAltaDeDueo;
	private JLabel lblAltaDeMascota;
	private JLabel lblConsultaVeterinaria;
	private JLabel lblRegistrosaltasetc;
	private Radar radar;
	private JButton btnNewBorrar;
	private JLabel lblBorrarPacienteO;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/imagenes/archivo-de-gato-icono-4547-128.png")));
		setTitle("Menu Principal");
		setResizable(false);
		radar = new Radar();
		setTitle("Sistema de Veterinarios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 763, 573);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNewEmpleado = new JButton("   ");
		btnNewEmpleado.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/man-vet.png")));
		btnNewEmpleado.setBounds(10, 11, 224, 128);
		contentPane.add(btnNewEmpleado);
		btnNewEmpleado.addActionListener(radar);
		
		btnNewMascota = new JButton("     ");
		btnNewMascota.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/cat.png")));
		btnNewMascota.setBounds(27, 365, 207, 128);
		contentPane.add(btnNewMascota);
		btnNewMascota.addActionListener(radar);
		
		btnNewDuenio = new JButton("    ");
		btnNewDuenio.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/man.png")));
		btnNewDuenio.setBounds(475, 11, 214, 128);
		contentPane.add(btnNewDuenio);
		btnNewDuenio.addActionListener(radar);
		
		btnNewConsulta = new JButton("  ");
		btnNewConsulta.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/a.jpg")));
		btnNewConsulta.setBounds(475, 365, 214, 128);
		contentPane.add(btnNewConsulta);
		btnNewConsulta.addActionListener(radar);
		
		
		btnNewRegistros = new JButton(" ");
		btnNewRegistros.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/buscar.png")));
		btnNewRegistros.setBounds(187, 152, 346, 202);
		contentPane.add(btnNewRegistros);
		btnNewRegistros.addActionListener(radar);
		
		
		btnNewBorrar = new JButton("");
		btnNewBorrar.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/close_delete-128.png")));
		btnNewBorrar.setBounds(10, 219, 128, 86);
		contentPane.add(btnNewBorrar);
		btnNewBorrar.addActionListener(radar);

		lblAltaDeEmplado = new JLabel("Alta de Emplado");
		lblAltaDeEmplado.setBounds(10, 150, 99, 14);
		contentPane.add(lblAltaDeEmplado);
		
		lblAltaDeDueo = new JLabel("Alta de Due\u00F1o");
		lblAltaDeDueo.setBounds(580, 150, 109, 14);
		contentPane.add(lblAltaDeDueo);
		
		lblAltaDeMascota = new JLabel("Alta de mascota");
		lblAltaDeMascota.setBounds(56, 509, 99, 14);
		contentPane.add(lblAltaDeMascota);
		
		lblConsultaVeterinaria = new JLabel("Consulta veterinaria");
		lblConsultaVeterinaria.setBounds(526, 509, 119, 14);
		contentPane.add(lblConsultaVeterinaria);
		
		lblRegistrosaltasetc = new JLabel("Registros,altas,etc");
		lblRegistrosaltasetc.setBounds(314, 375, 151, 14);
		contentPane.add(lblRegistrosaltasetc);
		
		lblBorrarPacienteO = new JLabel("Borrar Paciente o Empleado.");
		lblBorrarPacienteO.setBounds(20, 321, 157, 14);
		contentPane.add(lblBorrarPacienteO);
	}
	private class Radar implements ActionListener{

		public void actionPerformed(ActionEvent evento){
			if( (evento.getActionCommand()).equals("")){
				Delete m1 = new Delete();
				m1.setVisible(true);
				dispose();
			}
			if( (evento.getActionCommand()).equals(" ")){
				fecha m1 = new fecha();
				m1.setVisible(true);
				dispose();
			}
			if( (evento.getActionCommand()).equals("  ")){
				vistaConsulta m1 = new vistaConsulta();
				m1.setVisible(true);
				dispose();
			}
			if( (evento.getActionCommand()).equals("   ")){
				vistaEmpleado m1 = new vistaEmpleado();
				m1.setVisible(true);
				dispose();
			}	
			if( (evento.getActionCommand()).equals("    ")){
				vistaPaciente m1 = new vistaPaciente();
				m1.setVisible(true);
				dispose();
			}
			if( (evento.getActionCommand()).equals("     ")){
				vistaMascota m1 = new vistaMascota();
				m1.setVisible(true);
				dispose();
			}			
		}//fin actionPerformed
	}//fin Radar
}
