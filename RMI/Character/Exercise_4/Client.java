import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
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
    public static void main(String[] args) throws RemoteException, NotBoundException, UnsupportedEncodingException {
        Registry registry = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService characterService = (CharacterService) registry.lookup("RMICharacterService");
        String s = characterService.requestCharacter("B21DCCN110", "UbY0t9bW");
        s = s.replaceAll("[{}\"]", "");
        String[] tmp = s.trim().split(",");
        List<String> even = new ArrayList<>();
        List<String> odd = new ArrayList<>();
        for(int i = 0; i< tmp.length; i++){
            tmp[i] = tmp[i].trim();
            if(i % 2 == 0){
                even.add(tmp[i]);
            }
            else{
                odd.add(tmp[i]);
            }
        }
        String ans = "";
        for(String x: even){
            ans += x + ", ";
        }
        ans = ans.substring(0, ans.length() - 2);
        ans += "; ";
        for(String x: odd){
            ans += x + ", ";
        }
        ans = ans.substring(0, ans.length() - 2);
        characterService.submitCharacter("B21DCCN110", "UbY0t9bW", ans);
    }
    
}
