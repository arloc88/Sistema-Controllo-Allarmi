package server.control;

import java.util.Date;
import java.util.List;
import java.util.Random;

import server.entity.Abitazione;
//import server.entity.Allarme;
import server.entity.Intervento;
import server.entity.Segnalazione;
import server.entity.Sensore;





public class CoordinatorCOR {
	
	private RichiesteManager gestoreRichieste;
	private RichiesteInterventoManager gestoreIntervento;
	private SegnalazioneManager segnalazioneManager;
	
	
	
	public CoordinatorCOR(RichiesteInterventoManager gestoreIntervento,SegnalazioneManager segnalazioneManager,RichiesteManager gestoreRichieste){
		super();

		this.segnalazioneManager = segnalazioneManager;
		this.gestoreIntervento = gestoreIntervento;
		this.gestoreRichieste = gestoreRichieste;

	}
	
	public CoordinatorCOR(){

		this.gestoreIntervento = new RichiesteInterventoManager();
		this.segnalazioneManager = new SegnalazioneManager();
		this.gestoreRichieste = new RichiesteManager();
		
	}

	public Boolean GeneraAllarme(int idAbitazione,int idSensore, Date data){
		
		//System.out.println(" VERIFICA DATI................. ");
		
		//(segnalazioneManager.VerificaDati(idAbitazione, idSensore));
		//Se non va a buon fine restituisco false altrimenti ....
		
		Abitazione abitazione = segnalazioneManager.getAbitazioneById(idAbitazione);
		
		System.out.println("richiesta di Segnalazione... identificazione centralina ");
		System.out.println("richiesta da parte della centralina: " + abitazione.getNome());
		System.out.println("Identificazione Sensore...");
				
		Sensore sensore = segnalazioneManager.getSensoreById(idSensore);
		//segnalazioneManager.VerificaDati(idAbitazione, idSensore);
		System.out.println("Allarme sensore di tipo: " + sensore.getTipo());
		System.out.println(" VERIFICA DATI................. ");
		System.out.println("Creiamo Segnalazione...");
		//Apriamo una segnalazione che all'atto della creazione si mette nello stato iniziale "aperta"
		
		Segnalazione segnalazione = segnalazioneManager.CreaSegnalazione(abitazione,data);
		
		//System.out.println("Segnalazione creata passaggio in gestione...");
		
		//VERIFICA FUNZIONAMENTO SEGNALAZIONE 
		//DA COMMENTARE		
		System.out.println("SEGNALAZIONE CREATA: ");
		System.out.println("ID: " + segnalazione.getID());
		System.out.println("Nome Abitazione: " + segnalazione.getAbitazione().getNome());
		System.out.println("Data Segnalazione: " + segnalazione.getData());

	//si effettuano i controlli del caso e mettiamo la segnalazione in "gestione"
		
		//System.out.println("Segnalazione creata.");
		
		System.out.println("Registro intervento...");
		Random rand=new Random();
		int randint=rand.nextInt(100);
		segnalazioneManager.CreaIntervento(segnalazione.getID()+randint,segnalazione,0);
		System.out.println("Intervento Registrato");
		System.out.println("\n");
		
/******  RACCOLGO DATI SMS  *****************************/
//		RaccogliInfoSms();
/**********  INVIO NOTIFICA AL GESTORE  ******************************************/
//		NotificaGestore();
		
		return true;
		
	}
	
	
	public void VisualizzaStatistiche(String tipo, int mese){
		
		List<Segnalazione> lista = gestoreRichieste.getAllSegnalazioniByTipo(tipo,mese );
		for(Segnalazione segnalazioni: lista){
			System.out.println("Segnalazione in data: " + segnalazioni.getData());
			System.out.println("Segnalazione dell'abitazione con ID: " + segnalazioni.getAbitazione().getID());
			System.out.println("Segnalazione dell'abitazione di: " + segnalazioni.getAbitazione().getNome());
			System.out.println("tipo: " + segnalazioni.getAbitazione().getAbitazioneDb().getSensoreDb().getTipo());
			System.out.println("Gestore: " + segnalazioni.getAbitazione().getAbitazioneDb().getSensoreDb().getGestoreDb().getTipo());
			
		}
	}

		public void VisualizzaInterventi(String tipo){
		List<Intervento> list = gestoreIntervento.getAllInterventiByTipo(tipo);
		
		for(Intervento interventi: list){
			
			System.out.println("intervento ID: " + interventi.getID());
			System.out.println("Tipo: " + interventi.getTipo());
			System.out.println("Data " + interventi.getData());
			System.out.println("Esito: " + interventi.getEsito());
			System.out.println("Segnalazione relativa: " + interventi.getSegnalazione().getID());
			System.out.println("\n");
		}
		
		}
	}
	
