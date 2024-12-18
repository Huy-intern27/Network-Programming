import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Base64;


public class Client {   
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService byteService = (ByteService) registry.lookup("RMIByteService");
        byte[] rp = byteService.requestData("B21DCCN105", "basdfDnt");
        String tmp = new String(rp);
        byte[] ans = Base64.getDecoder().decode(rp);
        byteService.submitData("B21DCCN105", "basdfDnt", ans);
    }
    
}
