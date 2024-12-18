import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {   
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService byteService = (ByteService) registry.lookup("RMIByteService");
        byte[] data = byteService.requestData("B21DCCN103", "DYpOL1AL");
        byte[] keyByte = "PTIT".getBytes();
        byte[] ans = new byte[data.length];
        for(int i = 0; i< data.length; i++){
            ans[i] = (byte) (data[i] ^ keyByte[i % keyByte.length]);
        }
        byteService.submitData("B21DCCN103", "DYpOL1AL", ans);
    }
    
}
