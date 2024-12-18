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
        ByteService byteService = (ByteService) registry.lookup("RMIByteService");
        byte[] data = (byte[]) byteService.requestData("B21DCCN100", "hfIuo8Xo");
        List<Byte> even = new ArrayList<>();
        List<Byte> odd = new ArrayList<>();
        for(byte x:data){
            if(x % 2 == 0) even.add(x);
            else odd.add(x);
        }
        byte[] ans = new byte[data.length];
        for(int i = 0; i< even.size(); i++){
            ans[i] = even.get(i);
        }
        for(int j = even.size(); j < data.length; j++){
            ans[j] = odd.get(j - even.size());
        }
        byteService.submitData("B21DCCN100", "hfIuo8Xo", ans);
    }
    
}
