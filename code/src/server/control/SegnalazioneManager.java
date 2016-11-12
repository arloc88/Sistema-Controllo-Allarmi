package server.control;

import java.util.Date;
import java.util.Random;


import server.entity.Abitazione;
import server.entity.Intervento;
import server.entity.Segnalazione;
import server.entity.Sensore;



public class SegnalazioneManager {
	
	
	public Segnalazione CreaSegnalazione(Abitazione abitazione,Date date){
		
		Random rand=new Random();
		int randint=rand.nextInt(100);
		
		//@SuppressWarnings("deprecation")
		Segnalazione segnalazione = new Segnalazione(abitazione.getID()+randint,0,date,abitazione);
		segnalazione.salva();
		
		return segnalazione;
		
	}
	
	public Intervento CreaIntervento(int id,Segnalazione segnalazione,int esito){
		Date date = new Date();
		
		Intervento intervento = new Intervento(id,date,segnalazione,esito);
		intervento.salva();
		
		return intervento;
		
	}

public Sensore getSensoreById(int id){
		
		return Sensore.findSensoreByID(id);
	}

public Abitazione getAbitazioneById(int id){
	
	return Abitazione.findAbitazioneById(id);
}

// In questa funzione gli passo 
public boolean VerificaDati(int idAbitazione,int idSensore){
	Abitazione a = this.getAbitazioneById(idAbitazione);
	
	
	int s;
	if(a.getID()==idAbitazione)
		
		s=a.getAbitazioneDb().getSensoreDb().getID();
	
	else 
		return false;
	
		if(s==idSensore)
			return true;
	
		else 
	return false;
}

public void RaccogliInfoSms(){
	
}

public void NotificaGestore(){
	
}
}
