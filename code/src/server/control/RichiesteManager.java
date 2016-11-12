package server.control;

import java.util.List;

import server.entity.Segnalazione;

public class RichiesteManager {
	
	public List<Segnalazione> getAllSegnalazioniByTipo(String t,int mese){
		return Segnalazione.getAllSegnalazioniByTipo(t,mese);
	}
	
	
	public void ElencoAllarmi(){
		
	}

	
}
