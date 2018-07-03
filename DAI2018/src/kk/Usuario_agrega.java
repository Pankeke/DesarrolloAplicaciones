package kk;

import java.awt.Image;
import java.awt.List;
import java.awt.Toolkit;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Usuario_agrega extends JFrame implements ActionListener
{
	private JLabel img_enfermera, lbl_matricula, lbl_nombre, lbl_direccion, lbl_telefono, lbl_contacto, lbl_sexo, lbl_tiposangre, lbl_imagen_usuario;
	private JTextField tf_matricula,tf_nombre,tf_direccion,tf_telefono,tf_contacto;
	private String[] sexo={"Masculino","Femenino"};
	private JRadioButton a,b,o;
	private JComboBox cb_sexo;
	private JButton btn_aceptar, btn_cancelar, btn_regresar, btn_seleccionarimagen;
	private Usuario usuario=new Usuario();
	private JFileChooser fc_imagen;
	private ImageIcon ic;
	boolean bs;
	File foto_usuario;
	private ButtonGroup sangreGroup;
	private UsuariosDAO usuarios_dao=new UsuariosDAO();
	public Usuario_agrega()
	{
		super("Agregar usuario");
		setSize(830,380);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		Image im=Toolkit.getDefaultToolkit().getImage("botiquin.png");
		setIconImage(im);
		
		img_enfermera=new JLabel(new ImageIcon("enfermera.jpg"));
		img_enfermera.setBounds(20, 20,237,300);
		add(img_enfermera);
		
		lbl_matricula=new JLabel("Matricula");
		lbl_matricula.setBounds(277,15,100,30);
		add(lbl_matricula);
		
		lbl_nombre=new JLabel("Nombre");
		lbl_nombre.setBounds(277,45,100,30);
		add(lbl_nombre);
		
		lbl_direccion=new JLabel("Direccion");
		lbl_direccion.setBounds(277,75,100,30);
		add(lbl_direccion);
		
		lbl_telefono=new JLabel("Telefono");
		lbl_telefono.setBounds(277,105,100,30);
		add(lbl_telefono);
		
		lbl_contacto=new JLabel("Telefono de contacto");
		lbl_contacto.setBounds(277,135,100,30);
		add(lbl_contacto);
		
		lbl_sexo=new JLabel("Sexo");
		lbl_sexo.setBounds(277,165,100,30);
		add(lbl_sexo);
		
		lbl_tiposangre=new JLabel("Tipo sangre");
		lbl_tiposangre.setBounds(277,195,100,30);
		add(lbl_tiposangre);
		
		lbl_imagen_usuario=new JLabel(new ImageIcon(""));
		lbl_imagen_usuario.setBounds(600,0,200,250);
		add(lbl_imagen_usuario);
		
		btn_seleccionarimagen=new JButton("Seleccionar");
		btn_seleccionarimagen.setBounds(640,240,120,20);
		btn_seleccionarimagen.addActionListener(this);
		add(btn_seleccionarimagen);
		fc_imagen=new JFileChooser();
		FileNameExtensionFilter filtro=new FileNameExtensionFilter("JPG, PNG & GIF images","jpg","jpeg","png","gif");
		fc_imagen.setFileFilter(filtro);
		
		tf_matricula=new JTextField();
		tf_matricula.setBounds(342,22,150,20);
		add(tf_matricula);
		
		tf_nombre=new JTextField();
		tf_nombre.setBounds(342,52,230,20);
		add(tf_nombre);
		
		tf_direccion=new JTextField();
		tf_direccion.setBounds(342,82,230,20);
		add(tf_direccion);
		
		tf_telefono=new JTextField();
		tf_telefono.setBounds(342,112,150,20);
		add(tf_telefono);
		
		tf_contacto=new JTextField();
		tf_contacto.setBounds(382,142,150,20);
		add(tf_contacto);
		
		cb_sexo=new JComboBox(sexo);
		cb_sexo.setBounds(337,170,100,20);
		add(cb_sexo);
		
		a=new JRadioButton("A+");
		a.setBounds(357,200,40,20);
		add(a);
		
		b=new JRadioButton("A-");
		b.setBounds(417,200,40,20);
		add(b);
		
		o=new JRadioButton("O+");
		o.setBounds(467,200,50,20);
		add(o);
		
		sangreGroup=new ButtonGroup();
		sangreGroup.add(a);
		sangreGroup.add(b);
		sangreGroup.add(o);
		
		btn_aceptar=new JButton("Aceptar");
		btn_aceptar.setBounds(277,300,100,30);
		btn_aceptar.addActionListener(this);
		add(btn_aceptar);
		
		btn_cancelar=new JButton("Cancelar");
		btn_cancelar.setBounds(387,300,100,30);
		add(btn_cancelar);
		
		btn_regresar=new JButton("Regresar");
		btn_regresar.setBounds(497,300,100,30);
		add(btn_regresar);
		
		
		
		setVisible(true);
	}
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Usuario_agrega usuario=new Usuario_agrega();
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==btn_aceptar)
		{
			usuario.setMatricula(tf_matricula.getText());
			usuario.setNombre(tf_nombre.getText());
			usuario.setDireccion(tf_direccion.getText());
			usuario.setTelefono(tf_telefono.getText());
			usuario.setTelefono_contacto(tf_contacto.getText());
			usuario.setFoto(foto_usuario);
			//boolean bs; //= (cb_sexo.getSelectedIndex() == 1) ? true : false;
			if (cb_sexo.getSelectedIndex()==1)
			{
				bs=true;
			}
			else
			{
				bs=false;
			}
			usuario.setSexo(bs);
			
			char ts=(a.isSelected()) ? 'a' : 'b';
			usuario.setTipo_sangre(ts);
			
			if(usuarios_dao.agregarUsuario(usuario))
			{
				JOptionPane.showMessageDialog(null, "Usuario agregado");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Usuario no agregado");
			}
			
			
			System.out.println(usuario);
		}
		if(e.getSource()==btn_seleccionarimagen)
		{
			int valor =fc_imagen.showOpenDialog(this);
			if(valor==JFileChooser.APPROVE_OPTION)
			{
				//ImageIcon imagen=new ImageIcon(fc_imagen.getSelectedFile().getAbsolutePath()).setImage(imagen);
				ImageIcon imagen=new ImageIcon(fc_imagen.getSelectedFile().getAbsolutePath());
				lbl_imagen_usuario.setIcon(imagen);
				ic=new ImageIcon(imagen.getImage().getScaledInstance(200, 150, Image.SCALE_DEFAULT));
				lbl_imagen_usuario.setIcon(ic);
				foto_usuario=new File(fc_imagen.getSelectedFile().getPath());
			}
		}
		
	}

}
