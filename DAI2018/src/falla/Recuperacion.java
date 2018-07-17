package falla;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Recuperacion extends JFrame implements ActionListener
{
	private JLabel lbl_nuevos_empleados, lbl_baja_empleados, lbl_total_empleados, lbl_imagen, lbl_mensaje;
	private JTextField tf_nuevos_empleados, tf_baja_empleados, tf_total_empleados;
	private JButton btn_calcular;

	Recuperacion()
	{
		super("Índice de rotación del personal");
		setLayout(new FlowLayout());
		setSize(320,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		lbl_nuevos_empleados = new JLabel("Nuevos empleados: ");
		add(lbl_nuevos_empleados);
		tf_nuevos_empleados = new JTextField(20);
		add(tf_nuevos_empleados);
		
		lbl_baja_empleados = new JLabel("Baja de empleados: ");
		add(lbl_baja_empleados);
		tf_baja_empleados = new JTextField(20);
		add(tf_baja_empleados);
		
		lbl_total_empleados = new JLabel("Total de empleados: ");
		add(lbl_total_empleados);
		tf_total_empleados = new JTextField(20);
		add(tf_total_empleados);
		
		
		btn_calcular=new JButton("Calcular");
		btn_calcular.addActionListener(this);
		add(btn_calcular);
		
		setVisible(true);
	}
	
	public static void main(String[] args) 
	{
		Recuperacion ventana=new Recuperacion();

	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==btn_calcular)
		{
			double nuevos = Double.parseDouble(tf_nuevos_empleados.getText());
			double baja = Double.parseDouble(tf_baja_empleados.getText());
			double total = Double.parseDouble(tf_total_empleados.getText());
			double rotacion;
			rotacion=(((nuevos-baja)/total))*100;
			System.out.println(rotacion);
			if (rotacion>20)
			{
				lbl_mensaje = new JLabel("Bueno");
				lbl_imagen = new JLabel(new ImageIcon("bueno.png"));
				lbl_imagen.setSize(50,50);
				//add(lbl_imagen);
				add(lbl_mensaje);
			}
			if (rotacion>10 && rotacion<=20)
			{
				lbl_mensaje = new JLabel("Regular");
				lbl_imagen = new JLabel(new ImageIcon("regular.png"));
				lbl_imagen.setSize(50,50);
				//add(lbl_imagen);
				add(lbl_mensaje);
			}
			if (rotacion<=10)
			{
				lbl_mensaje = new JLabel("Malo");
				lbl_imagen = new JLabel(new ImageIcon("malo.png"));
				lbl_imagen.setSize(50,50);
				//add(lbl_imagen);
				add(lbl_mensaje);
			}
				
		}
		
	}

}
