package centralina.control;


import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Date;

import centralina.entity.Sensore;
import centralina.proxy.CentralinaProxy;


/***************************************************************************/
/*IN QUESTA CLASSE SONO REALIZZATE SIA IL COORDINATOR CHE LA BUSINESS LOGIC*/
/*DEL LAYER CONTROLLER DEL SUBSYSTEM CLIENT CENTRALINA					   */
/***************************************************************************/

public class GestoreCentralina {
	
	private CentralinaProxy proxy;
	
	
	public GestoreCentralina(){
	
	try {
		proxy= new CentralinaProxy();
		
	} catch (RemoteException | NotBoundException e) {
	
		e.printStackTrace();
	}
	
	}
	
	
	public Boolean ControlloSoglia(int IdSensore, int ValoreRilevato){
		
		Boolean risultato;
		Sensore sensore = Sensore.findSensoreByID(IdSensore);
		
		if(ValoreRilevato>sensore.getSoglia()){
			risultato=true;
		}else{
			risultato=false;
		}
		
		
		return risultato;
	}

	public Boolean GeneraAllarme(int IdAbitazione, int IdSensore) {
		Date data = new Date();
		return proxy.GeneraAllarme(IdAbitazione,IdSensore,data);
	}
	
	public void AttivaSegnalatori(){
		
		//ATTIVO I SEGNALATORI ACUSTICI
	}

}
