import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService dataService = (DataService) registry.lookup("RMIDataService");
        int n = (int) dataService.requestData("B21DCCN103", "bjp3M5Bo");
        List<Integer> ans = new ArrayList<>();
        for(int i = 2; i<= Math.sqrt(n); i++){
            if(n % i == 0){
                while(n % i == 0){
                    ans.add(i);
                    n /= i;
                }
            }
        }
        if(n != 1) ans.add(n);
        dataService.submitData("B21DCCN103", "bjp3M5Bo", ans);
    }
    
}
