package gestore.control;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import gestore.proxy.ProxyGestore;



public class GestoreBL {
	
	private ProxyGestore proxy;
	
	public GestoreBL(){
		try {
			proxy= new ProxyGestore();
			
		} catch (RemoteException | NotBoundException e) {
		
			e.printStackTrace();
		}
	}
	
	public void VisualizzaInterventi(String tipo) throws RemoteException{
		//toDo try catch
		
		proxy.VisualizzaInterventi(tipo);
	}

}
