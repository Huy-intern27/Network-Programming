import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService ds = (DataService) registry.lookup("RMIDataService");
        int n = (int) ds.requestData("B21DCCN440", "DWeGte4n");
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 1; i<= n; i++){
            for(int j = i + 1; j<= n; j++){
                for(int k = j + 1; k <= n; k++){
                    if(i * i + j * j == k * k){
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(i);
                        tmp.add(j);
                        tmp.add(k);
                        ans.add(tmp);
                    }
                }
            }
        }
        ds.submitData("B21DCCN440", "DWeGte4n", ans);
    }
    
}
