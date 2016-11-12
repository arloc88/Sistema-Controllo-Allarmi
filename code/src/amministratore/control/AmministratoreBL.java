package amministratore.control;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import amministratore.proxy.AmministratoreProxy;



public class AmministratoreBL {
	
	private AmministratoreProxy proxy;
	
	public AmministratoreBL(){
		try {
			proxy= new AmministratoreProxy();
			
		} catch (RemoteException | NotBoundException e) {
		
			e.printStackTrace();
		}
	}
	
	public void VisualizzaStatistiche(String tipo,int mese) throws RemoteException{
		//toDo try catch
		
		proxy.VisualizzaStatistiche(tipo, mese);
	}

}
