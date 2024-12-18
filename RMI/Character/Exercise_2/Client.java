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
    public static String change(String s) {
        int num = Integer.parseInt(s);

        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanNumerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder roman = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                roman.append(romanNumerals[i]);
                num -= values[i];
            }
        }

        return roman.toString();
    }
    
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService characterService = (CharacterService) registry.lookup("RMICharacterService");
        String rp = characterService.requestCharacter("B21DCCN102", "BwZQSdPq");
        System.out.println(rp);
        String ans = change(rp);
        System.out.println(ans);
        characterService.submitCharacter("B21DCCN102", "BwZQSdPq", ans);
    }
    
}
