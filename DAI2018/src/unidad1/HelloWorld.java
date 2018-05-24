package unidad1;
import javax.swing.*;
import java.awt.*;

public class HelloWorld extends JFrame
{
	private JLabel lbl_hello;
	
	public HelloWorld()
	{
		super("Hello World!!!");
		setLayout(new FlowLayout());
		setSize(200,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		lbl_hello=new JLabel("Hello World!!!!");
		
		add(lbl_hello);
		//pack();
		setVisible(true);
	}
	public static void main(String[] args)
	{
		HelloWorld ventana=new HelloWorld();

	}

}
