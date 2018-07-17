package falla;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class UsuarioEliminar extends JFrame implements ActionListener
{
	private JLabel img_enfermera, lbl_matricula, lbl_nombre, lbl_direccion, lbl_telefono, lbl_contacto, lbl_sexo, lbl_tiposangre, lbl_imagen_usuario;
	private JTextField tf_matricula, tf_direccion, tf_telefono, tf_contacto;
	private JComboBox cb_nombre;
	private String[] sexo={"Masculino","Femenino"};
	private JComboBox sexolist;
	private JRadioButton rb_ap, rb_an;
	private ButtonGroup sangreGroup;
	private JButton btn_aceptar, btn_cancelar, btn_regresar, btn_seleccionar_imagen;
	private JFileChooser fc_imagen;
	private ImageIcon ic;
	private File foto_usuario;
	
	private ArrayList<Usuario> usuarios;
	
	private Usuario usuario=new Usuario();
	private UsuariosDAO usuario_dao=new UsuariosDAO();
	
	public UsuarioEliminar() {
		super("Eliminar usuario");
		setSize(800, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		Image im=Toolkit.getDefaultToolkit().getImage("icon.png");
		setIconImage(im);
		
		img_enfermera= new JLabel(new ImageIcon("enfermera.jpg"));
		img_enfermera.setBounds(10, 10, 237, 300);
		add(img_enfermera);
		
		lbl_matricula= new JLabel("Matrú€ula:");
		lbl_matricula.setBounds(260, 50, 120, 30);
		add(lbl_matricula);
		
		tf_matricula= new JTextField();
		tf_matricula.setBounds(320, 50, 190, 25);
		tf_matricula.setEditable(false);
		add(tf_matricula);
		
		lbl_nombre= new JLabel("Nombre:");
		lbl_nombre.setBounds(260, 10, 100, 30);
		add(lbl_nombre);
		
		usuarios=new ArrayList<Usuario>();
		usuarios= usuario_dao.traerUsuarios();
		
		/*
		String [] nombres = new String[usuarios.size()];
		
		for (int i=0; i<=usuarios.size()-1; i++) {
			nombres[i]= usuarios.get(i).getNombre();
		} */
		
		DefaultComboBoxModel nombres = new DefaultComboBoxModel(usuario_dao.traerNombres());
		
		cb_nombre= new JComboBox(nombres);
		cb_nombre.setBounds(320, 10, 190, 25);
		cb_nombre.addActionListener(this);
		add(cb_nombre);
		
		lbl_direccion= new JLabel("Dirección:");
		lbl_direccion.setBounds(260, 90, 120, 30);
		add(lbl_direccion);
		
		tf_direccion= new JTextField();
		tf_direccion.setBounds(320, 90, 190, 25);
		tf_direccion.setEditable(false);
		add(tf_direccion);
		
		lbl_telefono= new JLabel("Teléfono:");
		lbl_telefono.setBounds(260, 130, 120, 30);
		add(lbl_telefono);
		
		tf_telefono= new JTextField();
		tf_telefono.setBounds(320, 130, 190, 25);
		tf_telefono.setEditable(false);
		add(tf_telefono);
		
		lbl_contacto= new JLabel("Teléfono de contacto:");
		lbl_contacto.setBounds(260, 170, 130, 30);
		add(lbl_contacto);
		
		tf_contacto= new JTextField();
		tf_contacto.setBounds(390, 170, 120, 25);
		tf_contacto.setEditable(false);
		add(tf_contacto);
		
		lbl_sexo= new JLabel("Sexo:");
		lbl_sexo.setBounds(260, 210, 120, 30);
		add(lbl_sexo);
		
		sexolist=new JComboBox(sexo);
		sexolist.setBounds(320, 210, 120, 25);
		add(sexolist);
		
		lbl_tiposangre= new JLabel("Tipo de sangre:");
		lbl_tiposangre.setBounds(260, 250, 130, 30);
		add(lbl_tiposangre);
		
		rb_ap= new JRadioButton("A+");
		rb_ap.setBounds(350, 250, 40, 30);
		add(rb_ap);
		
		rb_an= new JRadioButton("A-");
		rb_an.setBounds(390, 250, 40, 30);
		add(rb_an);
		
		sangreGroup= new ButtonGroup();
		sangreGroup.add(rb_ap);
		sangreGroup.add(rb_an);
		
		lbl_imagen_usuario= new JLabel();
		lbl_imagen_usuario.setBounds(550,20, 180, 150);
		add(lbl_imagen_usuario);
		
		btn_seleccionar_imagen= new JButton("Seleccionar imagen");
		btn_seleccionar_imagen.setBounds(550, 200, 180, 25);
		btn_seleccionar_imagen.addActionListener(this);
		add(btn_seleccionar_imagen);
		
		btn_aceptar= new JButton("Eliminar");
		btn_aceptar.setBounds(260, 290, 100, 25);
		btn_aceptar.addActionListener(this);
		btn_aceptar.setEnabled(true);
		add(btn_aceptar);
		
		btn_cancelar= new JButton("Cancelar");
		btn_cancelar.setBounds(380, 290, 100, 25);
		add(btn_cancelar);
		
		btn_regresar= new JButton("Regresar");
		btn_regresar.setBounds(500, 290, 100, 25);
		add(btn_regresar);
		
		fc_imagen= new JFileChooser();
		FileNameExtensionFilter filtro= new FileNameExtensionFilter("JPG, PNG & GIF", "jpg", "jpeg", "png", "gif");
		fc_imagen.setFileFilter(filtro);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UsuarioEliminar ventana=new UsuarioEliminar();
		ventana.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent a) {
		// TODO Auto-generated method stub
		
		if(a.getSource()==cb_nombre) {
			//System.out.println("Aqui estamosv2");
			usuario= usuarios.get(cb_nombre.getSelectedIndex());
			
			cb_nombre.getSelectedIndex();
			tf_matricula.setText(usuario.getMatricula());
			tf_direccion.setText(usuario.getDireccion());
			tf_telefono.setText(usuario.getTelefono());
			tf_contacto.setText(usuario.getTelefono_contacto());
			System.out.println(usuario);
			
			if(usuario.isSexo()==false) {
				sexolist.setSelectedIndex(0);
			} else {
				sexolist.setSelectedIndex(1);
			}
			
			if(usuario.getTipo_sangre()=='a') {
				rb_ap.setSelected(true);
			}else {
				rb_an.setSelected(true);
			}
			
			//ImageIcon ic= new ImageIcon(usuario.getImagen().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
			
			lbl_imagen_usuario.setIcon(ic);
			btn_aceptar.setEnabled(true);
		}
		
		if(a.getSource()==btn_aceptar) {
			usuario.setMatricula(tf_matricula.getText());
			//usuario.setNombre(tf_nombre.getText());
			//usuario.setDireccion(tf_direccion.getText());
			//usuario.setTelefono(tf_telefono.getText());
			//usuario.setTelefono_contacto(tf_contacto.getText());
			//usuario.setFoto(foto_usuario);
			
			if(usuario_dao.eliminarUsuario(usuario)) {
				System.out.println("Usuario eliminado");
			} else {
				System.out.println("Usuario NO eliminado");
			}
		}
	}
}
