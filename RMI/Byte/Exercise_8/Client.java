import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {   
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService byteService = (ByteService) registry.lookup("RMIByteService");
        byte[] rp = byteService.requestData("B21DCCN114", "Xmpi6d7g");
        byte size = (byte) rp.length;
        for(int i = 0; i< rp.length; i++){
            rp[i] = (byte) (rp[i] + size);
        }
        byteService.submitData("B21DCCN114", "Xmpi6d7g", rp);
    }
    
}
