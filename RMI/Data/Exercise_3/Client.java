import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Client {    
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService dataService = (DataService) registry.lookup("RMIDataService");
        String rp = (String) dataService.requestData("B21DCCN106", "Gxqt5zvw");
        int k = Integer.parseInt(rp.split(";")[1].trim());
        String numbers = rp.split(";")[0];
        int[] cnt = new int[100005];
        String[] tmp = numbers.split(",");
        List<Integer> tmp2 = new ArrayList<>();
        for(String x:tmp){
            tmp2.add(Integer.parseInt(x.trim()));
        }
        for(int x:tmp2){
            cnt[x] = 1;
        }
        List<Integer> ans = new ArrayList<>();
        for(int x:tmp2){
            if(cnt[x] == 1){
                ans.add(x);
                cnt[x] = 0;
            }
        }
        Collections.sort(tmp2);
        int result = tmp2.get(tmp2.size() - k);
        dataService.submitData("B21DCCN106", "Gxqt5zvw", result);
    }
    
}
