import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Client {   
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService byteService = (ByteService) registry.lookup("RMIByteService");
        byte[] rp = byteService.requestData("B21DCCN102", "7nmGqumL");
        List<Byte> arr = new ArrayList<>();
        byte cnt = 1;
        for(int i = 1; i< rp.length; i++){
            if(rp[i] == rp[i - 1]){
                cnt ++;
            }
            else{
                arr.add(rp[i - 1]);
                arr.add(cnt);
                cnt = 1;
            }
        }
        arr.add(rp[rp.length - 1]);
        arr.add(cnt);
        byte[] ans = new byte[arr.size()];
        for(int i = 0; i< arr.size(); i++){
            ans[i] = arr.get(i);
        }
        byteService.submitData("B21DCCN102", "7nmGqumL", ans);
    }
    
}
