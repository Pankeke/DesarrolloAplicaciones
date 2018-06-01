package unidad1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelloWorld3 extends JFrame implements ActionListener
{
	private JLabel lbl_mensaje;
	private JButton btn_aceptar;
	private JTextField tf_mensaje;
	
	
	public HelloWorld3()
	{
		super("Hello World 3 !!!!");
		setSize(400,200);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon ic=new ImageIcon("youtube.png");
		
		lbl_mensaje=new JLabel(ic);
		add(lbl_mensaje);
		
		tf_mensaje=new JTextField(20);
		add(tf_mensaje);
		
		btn_aceptar=new JButton("Aceptar");
		btn_aceptar.addActionListener(this);
		add(btn_aceptar);
		Image im = Toolkit.getDefaultToolkit().getImage("youtube.png");
		setIconImage(im);
		setVisible(true);
	}
	
	public static void main(String[] args)
	{
		HelloWorld3 ventana = new HelloWorld3();
		
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource()==btn_aceptar)
		{
			String nombre;
			nombre=tf_mensaje.getText();
			lbl_mensaje.setText("Hello "+nombre);
			//tf_mensaje.setVisible(false);
			//tf_mensaje.setEnabled(false);
			tf_mensaje.setText("");
		}
		
	}

}
