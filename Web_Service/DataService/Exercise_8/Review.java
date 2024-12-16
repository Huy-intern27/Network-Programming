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
    public static List solve(int a){
        List<Integer> ans = new ArrayList<>();
        for(int i = 1; i <= Math.sqrt(a); i++){
            if(a % i == 0 && i != a/i){
                ans.add(i);
                ans.add(a/i);
            }
        }
        return ans;
    }
    
    
    public static void main(String[] args) {
        DataService_Service dss = new DataService_Service();
        DataService ds = dss.getDataServicePort();
        double response = ds.getDataDouble("B21DCCN104", "GXbQcJFA");
        int a = Integer.parseInt(Double.toString(response).split("[.]")[0]);
        List<Integer> ans = new ArrayList<>();
        List<Integer> tmp = solve(a);
        Collections.sort(tmp);
        ans.add(tmp.size());
        for(int x: tmp) ans.add(x);
        ds.submitDataIntArray("B21DCCN104", "GXbQcJFA", ans);
    }
}
