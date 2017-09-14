/**
    Examen Primer Parcial
 *@author:  Alex Snz
 */
package ExamenC;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class Ventana extends JFrame {


	JTextField pantalla;

	double resultado;

        double resultado2;
	String operacion;


	JPanel panelNumeros, panelOperaciones;


	boolean nOperacion = true;


	public Ventana() {
		super();
		setSize(700, 750);
		setTitle("Conversor");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);
                setLocationRelativeTo(null);


		JPanel ventanita = (JPanel) this.getContentPane();
		ventanita.setLayout(new BorderLayout());

		pantalla = new JTextField("0", 20);
		pantalla.setBorder(new EmptyBorder(4, 4, 4, 4));
		pantalla.setHorizontalAlignment(JTextField.RIGHT);
		pantalla.setEditable(false);
		ventanita.add("North", pantalla);

		panelNumeros = new JPanel();
		panelNumeros.setLayout(new GridLayout(4, 4));
		panelNumeros.setBorder(new EmptyBorder(4, 4, 4, 4));

		for (int n = 1; n <= 9; n++) 
                {
			bNum("" + n);
		}
                bNum("0");
		bNum(".");
		ventanita.add("Center", panelNumeros);

		panelOperaciones = new JPanel();
		panelOperaciones.setLayout(new GridLayout(6, 1));
		panelOperaciones.setBorder(new EmptyBorder(4, 4, 4, 4));

		BotonOperacion("Convertir");                
		BotonOperacion("Borrar");

		ventanita.add("East", panelOperaciones);

		validate();
	}
	private void bNum(String digito) 
        {
		JButton btn = new JButton();
		btn.setText(digito);
		btn.addMouseListener(new MouseAdapter() 
                {

			@Override
			public void mouseReleased(MouseEvent evt) 
                        
                        {
				JButton btn = (JButton) evt.getSource();
				numero(btn.getText());
			}
		});

		panelNumeros.add(btn);
	}

	private void BotonOperacion(String operacion) 
        {
		JButton btn = new JButton(operacion);
		btn.setForeground(Color.RED);

		btn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent evt) {
				JButton btn = (JButton) evt.getSource();
				operacion(btn.getText());
			}
		});

		panelOperaciones.add(btn);
	}

	private void numero(String digito) 
        {
		if (pantalla.getText().equals("0") || nOperacion) {
			pantalla.setText(digito);
		} else {
			pantalla.setText(pantalla.getText() + digito);
		}
		nOperacion = false;
	}
	private void operacion(String tecla) 
        {
		if (tecla.equals("Convertir")) {
			calcularResultado();
		} else if (tecla.equals("Borrar")) {
			resultado = 0;
			pantalla.setText("");
			nOperacion = true;
		} else {
			operacion = tecla;
			if ((resultado > 0) && !nOperacion) {
				calcularResultado();
			} else {
				resultado = new Double(pantalla.getText());
			}
		}

		nOperacion = true;
	}

	private void calcularResultado() 
        {
            double convertir = new Double(pantalla.getText());
            resultado = convertir/17;
            pantalla.setText("" + resultado);
            operacion = "";
	}
}
