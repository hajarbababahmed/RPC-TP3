import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class MonserviceRPCClient {
    public static void main(String[] args) {
        try {
            
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            
            MonserviceRPCInterface MonService = (MonserviceRPCInterface) registry.lookup("MonserviceRPCInterface");

            
            int prix=200;

            int prix1 = MonService.encherprix(prix);
            System.out.println("Le nouveau prix du produit est : " + prix1);

            int prix2 = MonService.demandeprix(prix);
            System.out.println("Le prix demandé est : " + prix2);

            int prix3 = MonService.comparaison(prix, prix2);
            if (prix3 > prix) {
                System.out.println("Le prix est accepté.");
                MonService.accepterprix(prix3);
            } else {
                System.out.println("La vente est refusée.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}      
