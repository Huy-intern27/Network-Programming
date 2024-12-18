import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {   
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService byteService = (ByteService) registry.lookup("RMIByteService");
        byte[] rp = byteService.requestData("B21DCCN109", "n5RXu8Qf");
        byte[] cnt = new byte[100005];
        for(int i = 0; i< 100005; i++){
            cnt[i] = 0;
        }
        for(byte x:rp){
            cnt[x] ++;
        }
        byte maxValue = 0;
        for(byte x: rp){
            if(maxValue < cnt[x]) maxValue = cnt[x];
        }
        byte ans = 0;
        for(byte x:rp){
            if(cnt[x] == maxValue){
                ans = x;
                break;
            }
        }
        byte[] result = new byte[2];
        result[0] = ans;
        result[1] = maxValue;
        byteService.submitData("B21DCCN109", "n5RXu8Qf", result);
    }
    
}
