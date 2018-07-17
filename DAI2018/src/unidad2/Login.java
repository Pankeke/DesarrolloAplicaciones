package unidad2;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener {
	private JLabel lbl_img_usuario, lbl_img_candado, lbl_img_ok, lbl_usuario, lbl_contra;
	private JButton btn_aceptar, btn_borrar;
	private JTextField tf_usuario;
	private JPasswordField pf_contra;
	
	public Login() {
		super("Inicio de sesión");
		setSize(450, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		Image im = Toolkit.getDefaultToolkit().getImage("icono.png");
		setIconImage(im);
		
		lbl_img_usuario=new JLabel(new ImageIcon("usuario01.png"));
		lbl_img_usuario.setBounds(20, 10, 70, 70);
		add(lbl_img_usuario);
		
		lbl_img_candado=new JLabel(new ImageIcon("candado.png"));
		lbl_img_candado.setBounds(20, 90, 70, 70);
		add(lbl_img_candado);
		
		lbl_usuario=new JLabel("Usuario:");
		lbl_usuario.setBounds(95, 50, 100, 30);
		add(lbl_usuario);
		
		lbl_contra=new JLabel("Contraseña:");
		lbl_contra.setBounds(95, 125, 100, 30);
		add(lbl_contra);
		
		tf_usuario=new JTextField();
		tf_usuario.setBounds(150, 55, 150, 20);
		add(tf_usuario);
		
		pf_contra=new JPasswordField();
		pf_contra.setBounds(172, 130, 150, 20);
		add(pf_contra);
		
		lbl_img_ok=new JLabel();
		lbl_img_ok.setBounds(340, 50, 70, 70);
		add(lbl_img_ok);
		
		btn_aceptar=new JButton("Aceptar");
		btn_aceptar.setBounds(100, 175, 100,20);
		btn_aceptar.addActionListener(this);
		add(btn_aceptar);
		
		btn_borrar=new JButton("Borrar");
		btn_borrar.setBounds(230, 175, 100,20);
		btn_borrar.addActionListener(this);
		add(btn_borrar);
		
		
		
		
		
		setVisible(true);
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Login ventana=new Login();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btn_aceptar) {
			String u=tf_usuario.getText();
			Pattern pattern = Pattern.compile("^[\\d]{6}?$");
			Matcher m = pattern.matcher(u);
			boolean b = m.matches();
			//System.err.println(b);
			
			String p=String.copyValueOf(pf_contra.getPassword());
			Pattern pattern1 = Pattern.compile("^[[a-zA-Z0-9\\W]]++$");
			Matcher m1 = pattern1.matcher(p);
			boolean b1 = m1.matches();
			System.err.println(b1);
			
			
			/*
			if(u.equals("abrete") && p.equals("sesamo")) {
				lbl_img_ok.setIcon(new ImageIcon("palomita1.png"));
			}else {
				lbl_img_ok.setIcon(new ImageIcon("tachita1.png"));
			}
			*/
		}
		if(e.getSource()==btn_borrar) {
			tf_usuario.setText("");
			pf_contra.setText("");
			lbl_img_ok.setIcon(null);
		}
		
	}

}
