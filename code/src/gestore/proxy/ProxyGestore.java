package gestore.proxy;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import rmi.RMIInterface;

public class ProxyGestore {
	
	private RMIInterface stub;
	
	public ProxyGestore() throws RemoteException, NotBoundException {
		Registry registry=  LocateRegistry.getRegistry("localhost");
		
		stub= (RMIInterface)registry.lookup("service");
	}
	
	public void VisualizzaInterventi(String tipo) throws RemoteException{
		stub.VisualizzaInterventi(tipo);
	}
	

}
