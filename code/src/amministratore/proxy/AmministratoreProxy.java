package amministratore.proxy;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import rmi.RMIInterface;

public class AmministratoreProxy {
	
	private RMIInterface stub;
	
	public AmministratoreProxy() throws RemoteException, NotBoundException {
		Registry registry=  LocateRegistry.getRegistry("localhost");
		
		stub= (RMIInterface)registry.lookup("service");
	}
	
	public void VisualizzaStatistiche(String tipo,int mese) throws RemoteException{
		stub.VisualizzaStatistiche(tipo, mese);
	}
	

}
