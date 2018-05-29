package unidad1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelloWorld4 extends JFrame implements ActionListener
{
	private JLabel lbl_mensaje;
	private JButton btn_aceptar;
	private JTextField tf_mensaje;
	
	
	public HelloWorld4()
	{
		super("Hello World 4 !!!!");
		setLayout(null);
		setSize(275,190);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		lbl_mensaje=new JLabel();
		lbl_mensaje.setBounds(50, 10, 150, 30);
		add(lbl_mensaje);
		
		tf_mensaje=new JTextField(20);
		tf_mensaje.setBounds(50, 10, 150, 30);
		add(tf_mensaje);
		
		btn_aceptar=new JButton("Aceptar");
		btn_aceptar.setBounds(75, 45, 100, 20);
		btn_aceptar.addActionListener(this);
		add(btn_aceptar);
		
		setVisible(true);
	}
	
	public static void main(String[] args)
	{
		HelloWorld4 ventana = new HelloWorld4();
		
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
			////tf_mensaje.setEnabled(false);
			tf_mensaje.setText("");
		}
		
	}

}
