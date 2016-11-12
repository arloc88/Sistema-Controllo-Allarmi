package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;


	
	public interface RMIInterface extends Remote{
		public Boolean GeneraAllarme(int IdAbitazione,int IdSensore, Date date) throws RemoteException;

		public void VisualizzaStatistiche(String tipo, int mese) throws RemoteException;
		
		public void VisualizzaInterventi(String tipo) throws RemoteException;
		
	}


