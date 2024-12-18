import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Client {   
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService byteService = (ByteService) registry.lookup("RMIByteService");
        byte[] data = byteService.requestData("B21DCCN106", "JfXljtHI");
        StringBuilder sb = new StringBuilder();
        for(byte b: data){
            String tmp = String.format("%02x", b);
            sb.append(tmp);
        }
        byte[] ans = sb.toString().getBytes();
        byteService.submitData("B21DCCN106", "JfXljtHI", ans);
    }
    
}
