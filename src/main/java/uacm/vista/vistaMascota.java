package uacm.vista;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import uacm.init.HibernateUtil;
import uacm.modelo.Especie;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;

public class vistaMascota extends JFrame {

	private JPanel contentPane;
	private JTextField textNombreMascota;
	private JTextField textMeses;
	private JTextField textidPropetario;
	private JLabel lblIdPropetario;
	private JComboBox comboBox;
    private Radar radar;
    private JButton btnResgistrar;
    private JLabel lblMesesDeVida;
    private JLabel lblNombre;
    private JLabel lblNewLabel;
    private JButton btnCancelar;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vistaMascota frame = new vistaMascota();
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
	public vistaMascota() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/imagenes/archivo-de-gato-icono-4547-128.png")));

		setTitle("Alta Mascota");
		setResizable(false);
		radar = new Radar();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textNombreMascota = new JTextField();
		textNombreMascota.setBounds(10, 11, 167, 20);
		contentPane.add(textNombreMascota);
		textNombreMascota.setColumns(10);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(20, 42, 46, 14);
		contentPane.add(lblNombre);
		
		textMeses = new JTextField();
		textMeses.setBounds(10, 67, 167, 20);
		contentPane.add(textMeses);
		textMeses.setColumns(10);
		
		lblMesesDeVida = new JLabel("Meses de vida");
		lblMesesDeVida.setBounds(20, 98, 88, 14);
		contentPane.add(lblMesesDeVida);
		
		textidPropetario = new JTextField();
		textidPropetario.setBounds(10, 123, 167, 20);
		contentPane.add(textidPropetario);
		textidPropetario.setColumns(10);
		
		lblIdPropetario = new JLabel("id Propetario");
		lblIdPropetario.setBounds(20, 158, 117, 14);
		contentPane.add(lblIdPropetario);
		
		btnResgistrar = new JButton("Registrar");
		btnResgistrar.setBounds(324, 211, 89, 23);
		btnResgistrar.addActionListener(radar);
		contentPane.add(btnResgistrar);
		
		comboBox = new JComboBox();
		comboBox.setBounds(267, 11, 146, 20);
		comboBox.addItem("Gato");
		comboBox.addItem("Perro");
		comboBox.addItem("Conejo");
		comboBox.addItem("Tortuga");
		contentPane.add(comboBox);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(vistaMascota.class.getResource("/imagenes/cat.png")));
		lblNewLabel.setBounds(256, 42, 168, 158);
		contentPane.add(lblNewLabel);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(19, 211, 89, 23);
		contentPane.add(btnCancelar);
		btnCancelar.addActionListener(radar);
		

	}
	private class Radar implements ActionListener{

	public void actionPerformed(ActionEvent evento){
		
		
		if( (evento.getActionCommand()).equals("Registrar")){
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = null;
			try {
				transaction = session.beginTransaction();
	
				Especie e = new Especie();
				e.setIdPropetario(Long.parseLong(textidPropetario.getText()));
				e.setMesesVida(Integer.parseInt(textMeses.getText()));
				e.setNombre(textNombreMascota.getText());
				e.setTipoEspecie(comboBox.getSelectedItem().toString());
			
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
