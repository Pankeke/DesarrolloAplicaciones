package Unidad2;

import java.awt.Image;
import java.awt.List;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Usuario_agregar extends JFrame implements ActionListener
{

	private JLabel lbl_imagen;
	private JLabel lbl_img_enfermera, lbl_matricula, lbl_nombre, lbl_dir, lbl_tel, lbl_telcon, lbl_sexo, lbl_tipo;
	private JButton btn_aceptar, btn_cancelar, btn_regresar, btn_seleccionar_imagen;
	private JTextField tf_matricula, tf_nombre, tf_dir, tf_tel, tf_telcon, tf_sexo, tf_tipo;
	private String[] sexo= {"Hombre","Mujer"};
	private JRadioButton tipo_a,tipo_A,tipo_b,tipo_B,tipo_o,tipo_O;
	private JFileChooser fc_imagen;
	private ImageIcon ic;
	private JComboBox sexolist;
	File foto_usuario;
	private ButtonGroup sangreGroup;
	private UsuariosDAO usuarios_dao=new UsuariosDAO();
	
	private Usuario usuario=new Usuario();
	
	public Usuario_agregar () 
	{
		super("Agregar usuario");
		setSize(900,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		Image im = Toolkit.getDefaultToolkit().getImage("botiquin.png");
		setIconImage(im);
		
		lbl_img_enfermera=new JLabel(new ImageIcon("enfermera.jpg"));
		lbl_img_enfermera.setBounds(20, 10, 237, 300);
		add(lbl_img_enfermera);
		
		lbl_matricula= new JLabel("Matrcula");
		lbl_matricula.setBounds(277, 20, 100, 20);
		add(lbl_matricula);
		
		tf_matricula=new JTextField();
		tf_matricula.setBounds(360,20 ,200, 20);
		add(tf_matricula);
		
		lbl_nombre= new JLabel("Nombre");
		lbl_nombre.setBounds(277, 50, 100, 20);
		add(lbl_nombre);
		
		tf_nombre=new JTextField();
		tf_nombre.setBounds(360,50 ,200, 20);
		add(tf_nombre);
		
		lbl_dir= new JLabel("Direccion");
		lbl_dir.setBounds(277, 80, 100, 20);
		add(lbl_dir);
		
		tf_dir=new JTextField();
		tf_dir.setBounds(360,80 ,200, 20);
		add(tf_dir);
		
		lbl_tel= new JLabel("Telefono");
		lbl_tel.setBounds(277, 110, 100, 20);
		add(lbl_tel);
		
		tf_tel=new JTextField();
		tf_tel.setBounds(360,110 ,200, 20);
		add(tf_tel);
		
		lbl_telcon= new JLabel("Telefono de conta...");
		lbl_telcon.setBounds(277, 140, 110, 20);
		add(lbl_telcon);
		
		tf_telcon=new JTextField();
		tf_telcon.setBounds(390,140 ,200, 20);
		add(tf_telcon);
		
		lbl_sexo= new JLabel("Sexo");
		lbl_sexo.setBounds(277, 170, 100, 20);
		add(lbl_sexo);
		
		/*JList lista=new JList(sexo);
		lista.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		Object[] seleccion = lista.getSelectedValues(); 
		int[] indices = lista.getSelectedIndices(); 
		JScrollPane barraDesplazamiento = new JScrollPane(lista); 
		barraDesplazamiento.setBounds(250,170,100,20); 
		add(barraDesplazamiento);*/
		
		/*String[] s= {"Femenino","Masculino"};
		cd_sexo = new JCombobox (s); 
		cd_sexo.setBounds(187, 187, 141, 20);
		add(cd_sexo);*/
		
		sexolist=new JComboBox(sexo);
		sexolist.setBounds(390,170,100,20);
		add(sexolist);
		
		
		lbl_tipo= new JLabel("Tipo de sangre");
		lbl_tipo.setBounds(277, 200, 100, 20);
		add(lbl_tipo);
		
		tipo_a=new JRadioButton("A+");
		tipo_a.setBounds(367,200,40,30);
        add(tipo_a);
		
        tipo_A=new JRadioButton("A-");
		tipo_A.setBounds(420,200,40,30);
        add(tipo_A);
        
        tipo_b=new JRadioButton("B+");
		tipo_b.setBounds(470,200,40,30);
        add(tipo_b);
        
        tipo_B=new JRadioButton("B-");
		tipo_B.setBounds(520,200,40,30);
        add(tipo_B);
        
        tipo_o=new JRadioButton("O+");
		tipo_o.setBounds(367,230,45,30);
        add(tipo_o);
        
        
        tipo_O=new JRadioButton("O-");
		tipo_O.setBounds(420,230,40,30);
        add(tipo_O);
        
        
        sangreGroup = new ButtonGroup();
        sangreGroup.add(tipo_A);
        sangreGroup.add(tipo_a);
        sangreGroup.add(tipo_b);
        sangreGroup.add(tipo_B);
        sangreGroup.add(tipo_O);
        sangreGroup.add(tipo_o);
		
        btn_aceptar=new JButton("Aceptar");
		btn_aceptar.setBounds(277, 290, 100, 20);
		btn_aceptar.addActionListener(this);
		btn_aceptar.setEnabled(false);
		add(btn_aceptar);
        
		btn_cancelar=new JButton("Cancelar");
		btn_cancelar.setBounds(397, 290, 100, 20);
		btn_cancelar.addActionListener(this);
		add(btn_cancelar);
		
		btn_regresar=new JButton("Regresar");
		btn_regresar.setBounds(517, 290, 100, 20);
		btn_regresar.addActionListener(this);
		add(btn_regresar);
		
		lbl_imagen=new JLabel(new ImageIcon ("esc.png"));
		lbl_imagen.setBounds(650,50 , 200, 200);
		add(lbl_imagen);
		
		btn_seleccionar_imagen=new JButton("Seleccionar");
		btn_seleccionar_imagen.setBounds(690, 230, 120, 20);
		btn_seleccionar_imagen.addActionListener(this);
		add(btn_seleccionar_imagen);
		
		fc_imagen=new JFileChooser();
		FileNameExtensionFilter filtro=new FileNameExtensionFilter("JPG, PNG & GIF images","jpg", "jpeg", "png", "gif");
		fc_imagen.setFileFilter(filtro);
		
		
		/*usuario.setMatricula(tf_matricula.getText());
		usuario.setNombre(tf_nombre.getText());
		usuario.setDireccion(tf_dir.getText());
		usuario.setTelefono(tf_tel.getText());
		usuario.setTelefono_contacto(tf_telcon.getText());
		usuario.setFoto(foto_usuario);*/
		
		setVisible(true);
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args)
	{
		Usuario_agregar ventana=new Usuario_agregar();
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
	
		if (e.getSource()==btn_aceptar)
		{
			String tel=String.valueOf(tf_tel.getText());
			if (!tel.matches("[10]*"))
			{
				System.out.println("Noooo");
			}
			else
			{
				
			}
			//&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
			try
			{
				int num=Integer.valueOf(tf_tel.getText());
				
			}
			catch (Exception a)
			{
				
			}
			
			usuario.setMatricula(tf_matricula.getText());
			usuario.setNombre(tf_nombre.getText());
			usuario.setDireccion(tf_dir.getText());
			usuario.setTelefono(tf_tel.getText());
			usuario.setTelefono_contacto(tf_telcon.getText());
			usuario.setFoto(foto_usuario);
			
			
			boolean bs= (sexolist.getSelectedIndex()== 1) ? true : false ;
			usuario.setSexo(bs);
			
			char ts=(tipo_a.isSelected()) ? 'a' : 'b';
			usuario.setTipo_sangre(ts);
			
			if (usuarios_dao.agregarUsuario(usuario))
			{
				JOptionPane.showMessageDialog(null, "usuario agregado");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "usuario no agregado");
			}
			
			
			System.out.println(usuario);
		}
		if (e.getSource()==btn_seleccionar_imagen) 
		{
			int valor=fc_imagen.showOpenDialog(this);
			if(valor==JFileChooser.APPROVE_OPTION)
			{
				/*System.out.println(JFileChooser.APPROVE_OPTION);
				ImageIcon imagen= new ImageIcon(fc_imagen.getSelectedFile().getAbsolutePath().getScaleInstance(200,250,Image.SCALE_DEFAULT));
				lbl_imagen.setIcon(imagen);*/
				ImageIcon imagen = new ImageIcon(fc_imagen.getSelectedFile().getAbsolutePath());
				ic= new ImageIcon(imagen.getImage().getScaledInstance(200, 150, Image.SCALE_DEFAULT));
				lbl_imagen.setIcon(ic);
				foto_usuario=new File(fc_imagen.getSelectedFile().getPath());
				System.out.println(fc_imagen.getSelectedFile().getAbsolutePath());
				
				btn_aceptar.setEnabled(true);
				
			}
		}
		
	}

}
