import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

public class Client {    
    public static boolean palindrome(String s){
        for(int i = 0; i<= s.length() / 2; i++){
            if(i >= 0 && i <= s.length() - 1){
                if(s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService dataService = (DataService) registry.lookup("RMIDataService");
        String rp = (String) dataService.requestData("B21DCCN112", "NsaHVEXm");
        int n = Integer.parseInt(rp.split(";")[0].trim());
        int k = Integer.parseInt(rp.split(";")[1].trim());
        List<Integer> ans = new ArrayList<>();
        for(int i = n; i< k ; i++){
            if(palindrome(Integer.toString(i))) ans.add(i);
        }
        dataService.submitData("B21DCCN112", "NsaHVEXm", ans);
    }
    
}
