package centralina.control;

import java.awt.BorderLayout;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SensoreInterface {

	private JFrame frame;
	private JTextField textFieldID;
	private JTextField textFieldValore;
	private JTextField textFieldAbitazione;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SensoreInterface window = new SensoreInterface();
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
	public SensoreInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		GestoreCentralina gestore = new GestoreCentralina();

		frame = new JFrame();
		frame.setBounds(100, 100, 409, 308);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		Timer     timer = new Timer();
		Timer 	valore=new Timer();
		
		
		
		
		
class val extends TimerTask {
			
	        public void run(){
	        
	        	Random rand=new Random();
	    		int randint=rand.nextInt(13);
	    		textFieldValore.setText(Integer.toString(randint));;
	        }
	    }
		
		class Dati extends TimerTask {
			
	        public void run(){
	        int idSensore = Integer.parseInt(textFieldID.getText());
			int valore = Integer.parseInt(textFieldValore.getText());
			int idAbitazione = Integer.parseInt(textFieldAbitazione.getText());
			Boolean risultato = gestore.ControlloSoglia(idSensore, valore);
			Boolean result = false;
			if (risultato == true) {

				// attiviamo l'allarme sonoro

				System.out.println("Invio Segnalazione alla Centrale Operativa");
				result = gestore.GeneraAllarme(idAbitazione, idSensore);

			} else {
				System.out.println("Soglia bassa...nessun problema");
			}

			if (result == true) {
				System.out.println("Invio Allarme Alla Centrale Riuscito");
			} else {
				System.out.println("Non Invio Allarme Alla Centrale");
			}
			
	        }
	    }
		TimerTask task =new Dati();
		TimerTask taskval=new val();
		valore.schedule(taskval, 5000, 18000);
		timer.schedule(task, 10000, 20000);
		
		JLabel lblIdAbitazione = new JLabel("ID Abitazione");

		textFieldAbitazione = new JTextField();
		textFieldAbitazione.setColumns(10);

		JLabel lblId = new JLabel("ID sensore");

		textFieldID = new JTextField();
		textFieldID.setColumns(10);

		JLabel lblValoreRilevato = new JLabel("Valore Rilevato");

		textFieldValore = new JTextField();
		textFieldValore.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(47)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblValoreRilevato)
						.addComponent(lblId)
						.addComponent(lblIdAbitazione))
					.addGap(68)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(textFieldID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldAbitazione, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldValore, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(73, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIdAbitazione)
						.addComponent(textFieldAbitazione, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(22)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblId)
						.addComponent(textFieldID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblValoreRilevato)
						.addComponent(textFieldValore, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(103, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);

		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.NORTH);

		JLabel lblTitolo = new JLabel("Simulazione Interfaccia Sensore");
		panel_1.add(lblTitolo);
		lblTitolo.setFont(new Font("Tahoma", Font.PLAIN, 30));
	}

}
