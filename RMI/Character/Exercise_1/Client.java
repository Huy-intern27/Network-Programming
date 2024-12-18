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
        CharacterService characterService = (CharacterService) registry.lookup("RMICharacterService");
        String rp = characterService.requestCharacter("B21DCCN100", "CIQe6Bfh");
        String ans = Base64.getEncoder().encodeToString(rp.getBytes());
        characterService.submitCharacter("B21DCCN100", "CIQe6Bfh", ans);
    }
    
}
