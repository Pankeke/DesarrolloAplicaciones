package unidad1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dinner extends JFrame
{
	private Container contents; 
	private JLabel labelText; 
	private JLabel labelImage; 
	// Constructor 
	public Dinner()
	{
		super( "What's for dlnner?"); 
		contents = getContentPane(); 
		//call JFrame constructor 
		//get content pane 
		setLayout(new FlowLayout()); // set layout manager
		// use the JLabeI constructor with a String argument
		labelText=new JLabel("Sushi tonight?");
		// set label properties 
		labelText.setForeground(java.awt.Color.WHITE); 
		labelText.setBackground(java.awt.Color.BLUE); 
		labelText.setOpaque(true); 
		// use the JLabel constructor with an Imagelcon argument 
		labelImage=new JLabel( new ImageIcon("sushi.jpg")); 
		// set tool tip text 
		labelImage.setToolTipText("photo of sushi"); 
		// add the two labels to the content pane 
		contents.add(labelText); 
		contents.add(labelImage); 
		setSize(300, 200); 
		setVisible( true ); 
		

	}
	public static void main(String[] args)
	{
		Dinner dinner=new Dinner(); 
		dinner.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	}
	
}
