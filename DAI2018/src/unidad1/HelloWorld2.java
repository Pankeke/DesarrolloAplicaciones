package unidad1;

import javax.swing.*;
import java.awt.*;

public class HelloWorld2 extends JFrame
{
	private JLabel lbl_mensaje;
	private JButton btn_aceptar;
	
	public HelloWorld2()
	{
		super("HelloWorld2");
		setLayout(null);
		setSize(200,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		lbl_mensaje=new JLabel("aqui esta la etiqueta");
		lbl_mensaje.setBounds(50, 10, 150, 30);
		add(lbl_mensaje);
		
		btn_aceptar=new JButton("aceptar");
		btn_aceptar.setBounds(70, 40, 150, 30);
		add(btn_aceptar);
		
		setVisible(true);
	}
	
	public static void main(String[] args) 
	{
		HelloWorld2 ventana=new HelloWorld2();
		
	}

}
