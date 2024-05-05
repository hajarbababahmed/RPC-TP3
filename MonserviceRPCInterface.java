import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MonserviceRPCInterface extends Remote {
     int encherprix(int p) throws RemoteException;
     int demandeprix(int p1) throws RemoteException;
     int comparaison(int p, int p1) throws RemoteException;
     void accepterprix(int p) throws RemoteException;
     
}
