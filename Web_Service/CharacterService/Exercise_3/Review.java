import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import vn.medianews.*;

public class Review {    
    public static void main(String[] args) {
        CharacterService_Service css = new CharacterService_Service();
        CharacterService cs = css.getCharacterServicePort();
        List<Integer> arr = cs.requestCharacter("B21DCCN100", "ClyRCO4x");
        int du = arr.get(0) % arr.size();
        Collections.rotate(arr, du);
        cs.submitCharacterCharArray("B21DCCN100", "ClyRCO4x", arr);
    }
}
