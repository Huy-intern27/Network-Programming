import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import vn.medianews.*;

public class Review {        
    public static int count(String a){
        int count = 0;
        for(char c: a.toCharArray()){
            c = Character.toLowerCase(c);
            if(c == 'u' || c == 'o' || c == 'a' || c == 'e' || c == 'i'){
                count ++;
            }
            
        }
        return count;
    }
    
    public static void main(String[] args) {
        CharacterService_Service css = new CharacterService_Service();
        CharacterService cs = css.getCharacterServicePort();
        List<String> response = cs.requestStringArray("B21DCCN105", "EqEzPujx");
        Collections.sort(response);
        List<String> ans = new ArrayList<>();
        Set<Integer> size = new LinkedHashSet<>();
        for(String x:response){
            size.add(count(x));
        }
        for(int x:size){
            List<String> tmp = new ArrayList<>();
            for(String y:response){
                if(count(y) == x){
                    tmp.add(y);
                }
            }
            String res = "";
            for(String z:tmp) {
                res += z;
                res += ", ";
            }
            res= res.trim();
            res = res.substring(0, res.length() - 1);
            ans.add(res);
        }
        cs.submitCharacterStringArray("B21DCCN105", "EqEzPujx", ans);
    }
}
