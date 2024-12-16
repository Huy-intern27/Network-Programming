import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import vn.medianews.*;

public class Review {    
    public static int solve(String a){
        int count = 0;
        for(Character c:a.toCharArray()){
            if(c == 'u') count ++;
            else if(c == 'e') count ++;
            else if(c == 'o') count ++;
            else if(c == 'a') count ++;
            else if(c == 'i') count ++;
        }
        return count;
    }
    
    public static void main(String[] args) {
        CharacterService_Service css = new CharacterService_Service();
        CharacterService cs = css.getCharacterServicePort();
        List<String> arr = cs.requestStringArray("B21DCCN102", "9njNnDoq");
        Collections.sort(arr, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                int compare = Integer.compare(solve(o1), solve(o2));
                if(compare == 0){
                    return 1;
                }
                return compare;
            }
        });
        cs.submitCharacterStringArray("B21DCCN102", "9njNnDoq", arr);
    }
}
