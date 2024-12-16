import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import vn.medianews.*;

public class Review {        
    public static void main(String[] args) {
        CharacterService_Service css = new CharacterService_Service();
        CharacterService cs = css.getCharacterServicePort();
        String response = cs.requestString("B21DCCN109", "j62rsTVH");
        String ans = "";
        for(char c:response.toCharArray()){
            if(Character.isAlphabetic(c)) ans += c;
        }
        StringBuilder sb = new StringBuilder(ans);
        ans = sb.reverse().toString();
        cs.submitCharacterString("B21DCCN109", "j62rsTVH", ans);
    }
}
