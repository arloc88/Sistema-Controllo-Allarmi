package centralina.proxy;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Date;

import rmi.RMIInterface;


public class CentralinaProxy {
	
	private RMIInterface stub;

	public CentralinaProxy() throws RemoteException, NotBoundException {
		
		Registry registry=  LocateRegistry.getRegistry("localhost");
		
		stub= (RMIInterface)registry.lookup("service");
	}
	
	public Boolean GeneraAllarme(int IdAbitazione, int IdSensore,Date data) {
		try {
			return stub.GeneraAllarme(IdAbitazione,IdSensore,data);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
}

}
