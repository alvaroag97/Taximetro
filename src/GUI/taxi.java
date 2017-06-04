package GUI;

import java.awt.Choice;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.Timer;

import Models.Pasajero;
import Models.controlador;

import javax.swing.JRadioButton;



public class taxi extends JFrame implements ActionListener {

	private JFrame frame;
	
	private boolean Error;
	private JButton btnInicio;
	private DateFormat HoraActual;
	private Date mydate;
	private Date hora;

	private int seconds, minutes, hours;
	private Timer chronometer;
	private JLabel time;

	private DateFormat dateFormat;
	private JTextField txtPrecio;
	private JRadioButton EntreSemana;
	private JRadioButton Findes;
	
	ArrayList<Pasajero> pasajero = new ArrayList<Pasajero>();
	private DecimalFormat df;
	private JRadioButton Noche;
	private JRadioButton Aeropuerto;

	// String matricula, String marca, String modelo, int puertas, String color,
	// String diesel, int anioMatric, int cv
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
					taxi window = new taxi();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @wbp.parser.entryPoint
	 */
	public taxi() {

		initialize();
		setPropiedades();
		setAdapters();
		setModoleer();
	
		

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();

		HoraActual = new SimpleDateFormat("HH:mm:ss");

		btnInicio = new JButton("Iniciar");
		btnInicio.addActionListener(this);

		seconds = 0;
		

		time = new JLabel("0");

		getContentPane().add(btnInicio);
		getContentPane().add(time);

		chronometer = new Timer(1000, this);

		// String matricula, String marca, String modelo,
		// int puertas, String color, String diesel, int anioMatric, int
		// cv,String tipoVehiculo
		// introducidos, en el caso que se
		// le de a editar

	}

	private void setPropiedades() {
		// Propiedades del frame
		frame.setBounds(200, 200, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(57, 152, 97, 14);
		frame.getContentPane().add(lblPrecio);

		JLabel lblTiempo = new JLabel("Tiempo invertido");
		lblTiempo.setBounds(57, 87, 97, 14);
		frame.getContentPane().add(lblTiempo);

		btnInicio.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnInicio.setBounds(291, 21, 151, 130);
		frame.getContentPane().add(btnInicio);

		time.setBounds(156, 81, 104, 27);
		frame.getContentPane().add(time);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(156, 146, 104, 27);
		frame.getContentPane().add(txtPrecio);
		
		EntreSemana = new JRadioButton("Entre semana");
		EntreSemana.setBounds(45, 362, 109, 23);
		frame.getContentPane().add(EntreSemana);
		
		Findes = new JRadioButton("Fin de semana");
		Findes.setBounds(45, 401, 109, 23);
		frame.getContentPane().add(Findes);
		
		ButtonGroup grupo1 = new ButtonGroup();
		grupo1.add(EntreSemana);
		grupo1.add(Findes);
	
		
		Noche = new JRadioButton("Sup. Noche");
		Noche.setBounds(294, 362, 109, 23);
		frame.getContentPane().add(Noche);
		
		Aeropuerto = new JRadioButton("Sup. Aeropuerto");
		Aeropuerto.setBounds(291, 401, 132, 23);
		frame.getContentPane().add(Aeropuerto);
		
		ButtonGroup grupo2 = new ButtonGroup();
		grupo2.add(Noche);
		grupo2.add(Aeropuerto);
		
		JButton btnPagar = new JButton("Pagar");
		btnPagar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				Date date = new Date();
				
				controlador.AnadirEmpleado((""+txtPrecio.getText()), date);
				Menu menu = new Menu();
				menu.getFrame().setVisible(true);
				frame.dispose();
			}
		});
		
		btnPagar.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnPagar.setBounds(291, 201, 151, 130);
		frame.getContentPane().add(btnPagar);
		
		df = new DecimalFormat("#.00");
	}

	private void setAdapters() {


	}

	// Este metodo es para poder inicializar este frame con todo deshabilitado
	// para tener que darle a editar si quieres cambiar algo
	private void setModoleer() {

		for (Component c : frame.getContentPane().getComponents()) {
			if (c instanceof JTextField)
				c.setEnabled(false);
		}

	}

	
//	private void Comprobacion() {
//		
//		recargarListaRepAux();
//		 {
//
//			for (int i = ListaReparaciones.size(); i > 0; i--) {
//				ListaReparaciones
//						.add(new Reparacion(TextID.getText(), time.getText(), TextPrecio.getText(), Estado.getText()));
//			}
//		}
//	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof Timer) {
			seconds++;
		
			
			time.setText(""+ seconds);
		if(Noche.isSelected()){	
			if(Findes.isSelected()){
				txtPrecio.setText((df.format(6.55+(seconds/230.7))));
				
			}else if(EntreSemana.isSelected()){
				txtPrecio.setText((df.format(5.65+(seconds/333.3))));
			
			}
		}else if(Aeropuerto.isSelected()){
			if(Findes.isSelected()){
				txtPrecio.setText((df.format(5+4.55+(seconds/230.7))));
			
			}else if(EntreSemana.isSelected()){
				txtPrecio.setText((df.format(5+3.65+(seconds/333.3))));
		
			}
		}
			
			return;
		} else if (e.getSource() instanceof JButton) {
			JButton button = (JButton) e.getSource();
			if (button.getText().equals("Iniciar")) {
				btnInicio.setBackground(java.awt.Color.red);
				Findes.setEnabled(false);
				EntreSemana.setEnabled(false);
				Noche.setEnabled(false);
				Aeropuerto.setEnabled(false);
				chronometer.start();
				button.setText("Parar");
			} else if (button.getText().equals("Parar")) {
				chronometer.stop();
				
				btnInicio.setBackground(java.awt.Color.green);
				btnInicio.setEnabled(false);
				button.setText("Iniciar");

			}
		}
	}
}

		
	

		
	
	

