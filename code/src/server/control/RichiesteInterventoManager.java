package server.control;

import java.util.List;

import server.entity.Intervento;


public class RichiesteInterventoManager {

	public  List<Intervento> getAllInterventiByTipo(String tipo) {

		return Intervento.getAllInterventiByTipo(tipo);
	}
}
