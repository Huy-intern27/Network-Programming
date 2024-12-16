import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import vn.medianews.*;


public class Review {        
    public static void main(String[] args) {
        DataService_Service dss = new DataService_Service();
        DataService ds = dss.getDataServicePort();
        List<Integer> response = ds.getData("B21DCCN100", "HNtBog7T");
        Collections.sort(response);
        Map<Integer, Integer> mp = new LinkedHashMap<>();
        for(int x: response){
            if(mp.containsKey(x)){
                mp.put(x, mp.get(x) + 1);
            }
            else mp.put(x, 1);
        }
        List<String> ans = new ArrayList<>();
        for(int x:response){
            if(mp.get(x) != 0){
                String tmp = x + ", " + mp.get(x);
                ans.add(tmp);
                mp.put(x, 0);
            }
        }
        ds.submitDataStringArray("B21DCCN100", "HNtBog7T", ans);
    }
}
