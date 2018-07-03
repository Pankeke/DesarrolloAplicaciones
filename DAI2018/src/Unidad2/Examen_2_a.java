package Unidad2;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Examen_2_a extends JFrame implements ActionListener
{
	private JLabel lbl_mensaje, lbl_nombre, lbl_monto;
	private JTextField tf_nombre, tf_monto;
	private JButton btn_calcular;
	
	public Examen_2_a()
	{
		super("Calculo del impuesto al salario");
		setLayout(new FlowLayout());
		setSize(340,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		lbl_nombre=new JLabel("Nombre: ");
		add(lbl_nombre);
		tf_nombre=new JTextField(20);
		add(tf_nombre);
		
		lbl_monto=new JLabel("Monto: ");
		add(lbl_monto);
		tf_monto=new JTextField(10);
		add(tf_monto);
		
		lbl_mensaje=new JLabel();
		add(lbl_mensaje);
		
		btn_calcular=new JButton("Calcular");
		btn_calcular.addActionListener(this);
		add(btn_calcular);
		
		setVisible(true);
	}
	
	public static void main(String[] args)
	{
		Examen_2_a ventana=new Examen_2_a();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==btn_calcular)
		{
			double[] limite_inferior= {5952.85,88793.05};
			double[] limite_superior= {50524.92,103218.05};
			double[] cuota_fija= {2966.91,7130.48};
			double[] porcentajes= {10.88,16.00};
			double sueldo=Double.parseDouble(tf_monto.getText());
			
			for(int i=0; i<limite_inferior.length; i++)
			{
				if(sueldo>=limite_inferior[i] && sueldo<=limite_superior[i])
				{
					double excedente=sueldo-limite_inferior[i];
					double impuesto=excedente*(porcentajes[i]/100);
					double total_impuesto=cuota_fija[i]+impuesto;
					lbl_mensaje.setText("El empleado: "+tf_nombre.getText()+" con sueldo: "+sueldo+" pagara: "+total_impuesto+" de impuesto");
				}
			}
			
		}
		
	}

}
