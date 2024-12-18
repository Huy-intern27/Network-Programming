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
        String s = characterService.requestCharacter("B21DCCN107", "o8pi84gW");
        String key = s.trim().split(";")[0];
        String str = s.trim().split(";")[1];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i< str.length(); i++){
            char tmp = (char) (str.charAt(i) ^ key.charAt(i % key.length()));
            sb.append(tmp);
        }
        String ans = sb.toString();
        characterService.submitCharacter("B21DCCN107", "o8pi84gW", ans);
        
    }
    
}
