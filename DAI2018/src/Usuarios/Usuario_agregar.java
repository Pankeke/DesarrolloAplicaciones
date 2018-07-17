package Usuarios;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Usuario_agregar extends JFrame {

	private JPanel contentPane;
	private JTextField tf_matricula;
	private JTextField tf_nombre;
	private JTextField tf_direccion;
	private JTextField tf_telefono;
	private JTextField tf_telefono_contacto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Usuario_agregar frame = new Usuario_agregar();
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
	public Usuario_agregar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		setTitle("Agragar usuario");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Image im = Toolkit.getDefaultToolkit().getImage("icono_enfermera.png");
		setIconImage(im);
		
		
		
		JLabel lbl_imagen = new JLabel(new ImageIcon("enfermera.jpg"));
		lbl_imagen.setBounds(10, 20, 113, 239);
		contentPane.add(lbl_imagen);
		
		JLabel lbl_matricula = new JLabel("Matricula");
		lbl_matricula.setBounds(140, 20, 79, 14);
		contentPane.add(lbl_matricula);
		
		JLabel lbl_nombre = new JLabel("Nombre");
		lbl_nombre.setBounds(140, 54, 79, 14);
		contentPane.add(lbl_nombre);
		
		JLabel lbl_direccion = new JLabel("Direcci\u00F3n");
		lbl_direccion.setBounds(140, 88, 79, 14);
		contentPane.add(lbl_direccion);
		
		JLabel lbl_telefono = new JLabel("Telefono");
		lbl_telefono.setBounds(140, 122, 79, 14);
		contentPane.add(lbl_telefono);
		
		JLabel lbl_telefono_contacto = new JLabel("Telefono de contacto");
		lbl_telefono_contacto.setBounds(140, 156, 113, 14);
		contentPane.add(lbl_telefono_contacto);
		
		JLabel lbl_sexo = new JLabel("Sexo");
		lbl_sexo.setBounds(140, 190, 79, 14);
		contentPane.add(lbl_sexo);
		
		JLabel lbl_tipo_sangre = new JLabel("Tipo de sangre");
		lbl_tipo_sangre.setBounds(140, 224, 103, 14);
		contentPane.add(lbl_tipo_sangre);
		
		tf_matricula = new JTextField();
		tf_matricula.setBounds(195, 17, 86, 20);
		contentPane.add(tf_matricula);
		tf_matricula.setColumns(10);
		
		tf_nombre = new JTextField();
		tf_nombre.setBounds(195, 51, 86, 20);
		contentPane.add(tf_nombre);
		tf_nombre.setColumns(10);
		
		tf_direccion = new JTextField();
		tf_direccion.setBounds(195, 85, 130, 20);
		contentPane.add(tf_direccion);
		tf_direccion.setColumns(10);
		
		tf_telefono = new JTextField();
		tf_telefono.setBounds(195, 120, 86, 20);
		contentPane.add(tf_telefono);
		tf_telefono.setColumns(10);
		
		tf_telefono_contacto = new JTextField();
		tf_telefono_contacto.setBounds(263, 153, 86, 20);
		contentPane.add(tf_telefono_contacto);
		tf_telefono_contacto.setColumns(10);
		
		JComboBox cb_sexo = new JComboBox();
		cb_sexo.setBounds(181, 187, 141, 20);
		contentPane.add(cb_sexo);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("A+");
		rdbtnNewRadioButton.setBounds(242, 222, 41, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("A-");
		rdbtnNewRadioButton_1.setBounds(296, 222, 47, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JButton btn_aceptar = new JButton("Aceptar");
		btn_aceptar.setBounds(140, 292, 89, 23);
		contentPane.add(btn_aceptar);
		
		JButton btn_cancelar = new JButton("Cancelar");
		btn_cancelar.setBounds(263, 292, 89, 23);
		contentPane.add(btn_cancelar);
		
		JButton btn_regresar = new JButton("Regresar");
		btn_regresar.setBounds(374, 292, 89, 23);
		contentPane.add(btn_regresar);
	}
}
