package server.proxy;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

import rmi.RMIInterface;
import server.control.CoordinatorCOR;

public class GestoreProxy extends UnicastRemoteObject implements RMIInterface{
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static CoordinatorCOR gestoreCentrale = new CoordinatorCOR();
	
	protected GestoreProxy() throws RemoteException {
		super();
	
	}


	
	public static void main (String[] args)
	{
		String host="//localhost/service";
		try {
			GestoreProxy server = new GestoreProxy();
			System.err.println("Attivazione Centrale Operativa...");
			
			UnicastRemoteObject.unexportObject(server, true);
			LocateRegistry.createRegistry(1099);
			
			Naming.rebind(host, server);
			
			System.err.println("Attivazione Completata");
			
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}



	@Override
	public Boolean GeneraAllarme(int IdAbitazione, int IdSensore, Date date)
			throws RemoteException {
		// TODO Auto-generated method stub
			return gestoreCentrale.GeneraAllarme(IdAbitazione, IdSensore, date);

	}



	@Override
	public void VisualizzaStatistiche(String tipo, int mese) {
		// TODO Auto-generated method stub
		
		 gestoreCentrale.VisualizzaStatistiche(tipo, mese);
		
	}
	
	@Override
	public void VisualizzaInterventi(String tipo) {
		// TODO Auto-generated method stub
		
		 gestoreCentrale.VisualizzaInterventi(tipo);
		
	}


}
