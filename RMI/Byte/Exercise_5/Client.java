import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {   
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService byteService = (ByteService) registry.lookup("RMIByteService");
        byte[] rp = byteService.requestData("B21DCCN470", "76iGK7eb");
        StringBuilder sb = new StringBuilder();
        for(byte b:rp){
            String tmp = String.format("%03o", b & 0xFF);
            sb.append(tmp);
        }
        byte[] ans = sb.toString().getBytes();
        byteService.submitData("B21DCCN470", "76iGK7eb", ans);
    }
    
}
