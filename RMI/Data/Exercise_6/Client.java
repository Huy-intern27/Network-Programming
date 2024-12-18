import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

public class Client {   
    public static boolean prime(int n){
        for(int i = 2; i<= Math.sqrt(n); i++){
            if(n % i == 0) return false;
        }
        return true;
    }
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService dataService = (DataService) registry.lookup("RMIDataService");
        int n = (int) dataService.requestData("B21DCCN114", "ntfyABOC");
        List<Integer> ans = new ArrayList<>();
        for(int i = 2; i<= n; i++){
            if(prime(i)) ans.add(i);
        }
        dataService.submitData("B21DCCN114", "ntfyABOC", ans);
    }
    
}
