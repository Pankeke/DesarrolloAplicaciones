package unidad2;

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
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class UsuarioModificar extends JFrame implements ActionListener {
	
	private JLabel lbl_imagen_usuario;
	private JTextField tf_matricula;
	private JComboBox cb_nombre;
	private JTextField tf_direccion;
	private JTextField tf_telefono;
	private JTextField tf_telefono_contacto;
	private JButton btn_aceptar, btn_cancelar, btn_regresar, btn_seleccionar_imagen;
	private JRadioButton rb_ap, rb_an;
	private JComboBox cb_sexo;
	private JFileChooser fc_imagen;
	private Usuario usuario=new Usuario();
	private ImageIcon ic;
	File foto_usuario;
	private ButtonGroup sangreGroup;
	private UsuariosDAO usuarios_dao = new UsuariosDAO();
	ArrayList<Usuario> usuarios;
	
	public UsuarioModificar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setTitle("Modificar usuario");
		setSize(900, 400);
		
		setLayout(null);
		
		Image im = Toolkit.getDefaultToolkit().getImage("botiquin.png");
		setIconImage(im);
		
		
		ImageIcon imagen=new ImageIcon("enfermera.jpg");
		ImageIcon ic = new ImageIcon(imagen.getImage().getScaledInstance(237, 300, Image.SCALE_DEFAULT));
		
		JLabel lbl_imagen = new JLabel(ic);
		lbl_imagen.setBounds(20, 10, 237, 300);
		add(lbl_imagen);
		
		JLabel lbl_matricula = new JLabel("Matricula");
		lbl_matricula.setBounds(277, 50, 100, 20);
		add(lbl_matricula);
		
		JLabel lbl_nombre = new JLabel("Nombre");
		lbl_nombre.setBounds(277, 20, 100, 20);
		add(lbl_nombre);
		
		JLabel lbl_direccion = new JLabel("Direcci\u00F3n");
		lbl_direccion.setBounds(277, 80, 100, 20);
		add(lbl_direccion);
		
		JLabel lbl_telefono = new JLabel("Telefono");
		lbl_telefono.setBounds(277, 110, 100, 20);
		add(lbl_telefono);
		
		JLabel lbl_telefono_contacto = new JLabel("Telefono de contacto");
		lbl_telefono_contacto.setBounds(277, 140, 110, 20);
		add(lbl_telefono_contacto);
		
		JLabel lbl_sexo = new JLabel("Sexo");
		lbl_sexo.setBounds(277, 170, 100, 20);
		add(lbl_sexo);
		
		JLabel lbl_tipo_sangre = new JLabel("Tipo de sangre");
		lbl_tipo_sangre.setBounds(277, 200, 100, 20);
		add(lbl_tipo_sangre);
		
		lbl_imagen_usuario=new JLabel();
		lbl_imagen_usuario.setBounds(690, 50, 200, 200);
		add(lbl_imagen_usuario);
		
		btn_seleccionar_imagen=new JButton("Seleccionar");
		btn_seleccionar_imagen.setBounds(690, 230, 120, 20);
		btn_seleccionar_imagen.addActionListener(this);
		add(btn_seleccionar_imagen);
		
		tf_matricula = new JTextField();
		tf_matricula.setBounds(360,50 ,200, 20);
		tf_matricula.setEnabled(false);
		add(tf_matricula);
		tf_matricula.setColumns(10);
		
		
		
		usuarios = new ArrayList<Usuario>();
		usuarios = usuarios_dao.traerUsuarios();
		/*
		String[] nombres = new String[usuarios.size()];
		
		for(int i=0; i<usuarios.size();i++) {
			System.err.println("aqui estamos");
			nombres[i] = usuarios.get(i).getNombre();
		}
		
		//System.out.println(usuarios.toString());
		*/
		
		DefaultComboBoxModel nombres = new DefaultComboBoxModel(usuarios_dao.traerNombres());
				
		cb_nombre = new JComboBox(nombres);
		cb_nombre.setBounds(360,20 ,200, 20);
		cb_nombre.addActionListener(this);
		add(cb_nombre);
		
				
		tf_direccion = new JTextField();
		tf_direccion.setBounds(360,80 ,200, 20);
		add(tf_direccion);
		tf_direccion.setColumns(10);
		
		tf_telefono = new JTextField();
		tf_telefono.setBounds(360,110 ,200, 20);
		add(tf_telefono);
		tf_telefono.setColumns(10);
		
		tf_telefono_contacto = new JTextField();
		tf_telefono_contacto.setBounds(390,140 ,200, 20);
		add(tf_telefono_contacto);
		tf_telefono_contacto.setColumns(10);
		
		String[] s={"Femenino", "Masculino"};
		
		cb_sexo = new JComboBox(s);
		cb_sexo.setBounds(390,170,100,20);
		add(cb_sexo);
		
		rb_ap = new JRadioButton("A+");
		rb_ap.setBounds(367,200,40,30);
		add(rb_ap);
		
		rb_an = new JRadioButton("A-");
		rb_an.setBounds(420,200,40,30);
		add(rb_an);
		
		sangreGroup = new ButtonGroup( );
		sangreGroup.add(rb_an);
		sangreGroup.add(rb_ap);
		
		
		btn_aceptar = new JButton("Modificar");
		btn_aceptar.setBounds(277, 290, 100, 20);
		btn_aceptar.addActionListener(this);
		btn_aceptar.setEnabled(false);
		add(btn_aceptar);
		
		btn_cancelar = new JButton("Cancelar");
		btn_cancelar.setBounds(397, 290, 100, 20);
		add(btn_cancelar);
		
		btn_regresar = new JButton("Regresar");
		btn_regresar.setBounds(517, 290, 100, 20);
		add(btn_regresar);
		
		fc_imagen=new JFileChooser();
		FileNameExtensionFilter filtro=
		new FileNameExtensionFilter("JPG, PNG & GIF images", "jpg", "jpeg","png", "gif");
		fc_imagen.setFileFilter(filtro);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				UsuarioModificar correr = new UsuarioModificar();
				correr.setVisible(true);
			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent a) {
		// TODO Auto-generated method stub
		if(a.getSource()==cb_nombre) {
			usuario= usuarios.get(cb_nombre.getSelectedIndex());
			tf_matricula.setText(usuario.getMatricula());
			tf_direccion.setText(usuario.getDireccion());
			tf_telefono.setText(usuario.getTelefono());
			tf_telefono_contacto.setText(usuario.getTelefono_contacto());
			foto_usuario = usuario.getFoto();
			
			if(usuario.isSexo()) {
				cb_sexo.setSelectedIndex(0);
			}else {
				cb_sexo.setSelectedIndex(1);
			}
			if(usuario.getTipo_sangre()=='a') {
				rb_ap.setSelected(true);
			}else {
				rb_an.setSelected(true);
			}
			
			
			
			ImageIcon ic = new ImageIcon(usuario.getImagen().getScaledInstance(120, 150, Image.SCALE_DEFAULT));
			lbl_imagen_usuario.setIcon(ic);
			
			btn_aceptar.setEnabled(true);
			
			
			System.out.println(usuario.toString());
			
		}
		if(a.getSource()==btn_aceptar) {
			//(usuario.setMatricula(tf_matricula.getText());
			//usuario.setNombre(tf_nombre.getText());
			usuario.setDireccion(tf_direccion.getText());
			usuario.setTelefono(tf_telefono.getText());
			usuario.setTelefono_contacto(tf_telefono_contacto.getText());
			usuario.setFoto(foto_usuario);
			
		
			
			boolean bs = (cb_sexo.getSelectedIndex() == 0) ? true : false;
			usuario.setSexo(bs);
			
			char ts=(rb_ap.isSelected()) ? 'a' : 'b';
			usuario.setTipo_sangre(ts);
			if(usuarios_dao.modificarUsuario(usuario)) {
				JOptionPane.showMessageDialog(null, "Completado!");
			}else {
				JOptionPane.showMessageDialog(null, "Error!");
			}
		}
		if(a.getSource()==btn_seleccionar_imagen) {
			int valor=fc_imagen.showOpenDialog(this);
			if(valor==JFileChooser.APPROVE_OPTION) {
				ImageIcon imagen = new ImageIcon(fc_imagen.getSelectedFile().getAbsolutePath());
				ic=new ImageIcon(imagen.getImage().getScaledInstance(120, 150, Image.SCALE_DEFAULT));
				lbl_imagen_usuario.setIcon(ic);
				foto_usuario=new File(fc_imagen.getSelectedFile().getPath());
				System.out.println(fc_imagen.getSelectedFile().getAbsolutePath());
			}
		}
		
		
	}

}
