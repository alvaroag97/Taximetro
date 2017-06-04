package GUI;

import java.awt.EventQueue;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu {

	private JFrame frame;
	private Date Fechaconhora;
	
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
					Menu window = new Menu();
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
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnSubida = new JButton("Sube pasajero");
		btnSubida.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				taxi taxi = new taxi();
				taxi.getFrame().setVisible(true);
				frame.dispose();
				
			}
		});
		btnSubida.setBounds(252, 66, 149, 111);
		frame.getContentPane().add(btnSubida);
		
		JButton btnCaja = new JButton("Caja del dia");
		btnCaja.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Listado lista = new Listado();
				lista.getFrame().setVisible(true);
				frame.dispose();
			}
		});
		btnCaja.setBounds(44, 66, 149, 111);
		frame.getContentPane().add(btnCaja);
	}
}
