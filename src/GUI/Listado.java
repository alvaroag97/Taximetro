package GUI;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTextField;

import Models.Pasajero;
import Models.controlador;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Listado {

	private JFrame frame;
	private JTextField txtDinero;
	private JTextField txtFecha;
	
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Listado window = new Listado();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Listado() {
		initialize();
		RellenarFormulario(controlador.ObtenerPasajero(controlador.indice));
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtFecha = new JTextField();
		txtFecha.setBounds(113, 79, 86, 20);
		frame.getContentPane().add(txtFecha);
		txtFecha.setColumns(10);
		
		txtDinero = new JTextField();
		txtDinero.setColumns(10);
		txtDinero.setBounds(113, 151, 86, 20);
		frame.getContentPane().add(txtDinero);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(28, 82, 46, 14);
		frame.getContentPane().add(lblFecha);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(28, 154, 46, 14);
		frame.getContentPane().add(lblPrecio);
		
		
	}
	private void RellenarFormulario(Pasajero pas){
		try{
			
			txtFecha.setText(""+pas.getFecha());
			txtDinero.setText(""+pas.getDinero());
		
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage(),"", JOptionPane.ERROR_MESSAGE);
		}
	}
}
