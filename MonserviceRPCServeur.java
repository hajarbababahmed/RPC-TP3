import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MonserviceRPCServeur extends UnicastRemoteObject implements MonserviceRPCInterface{
    protected MonserviceRPCServeur() throws RemoteException {
        super();
    }


    
    int p = 100;
    public int encherprix(int p) throws RemoteException {
        System.out.println("le prix de produit est" +p);
	return p;
    }

    public int demandeprix(int p1) throws RemoteException {
	return p1;
    }

    public int comparaison(int p, int p1) throws RemoteException {
        if (p1 > p){
		p = p1;
		return demandeprix(p1);
	}

	else {
		System.out.println("le prix est refusé");
		return demandeprix(p1);
                
		}
     }

    public void accepterprix(int p){
		System.out.println("le prix de vendre est: " +p);}



    public static void main(String[] args) {
        try {
            MonserviceRPCServeur serveur = new MonserviceRPCServeur();
            java.rmi.registry.LocateRegistry.createRegistry(1099).rebind("MonserviceRPCServeur", serveur);
            System.out.println("Serveur RMI prêt.");
        } catch (Exception e) {
            e.printStackTrace();
       }
    }
}
