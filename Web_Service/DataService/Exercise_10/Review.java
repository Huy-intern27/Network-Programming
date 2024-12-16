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
        List<Integer> response = ds.getData("B21DCCN114", "YSTfanxS");
        int[] cnt = new int[100001];
        for(int x:response){
            cnt[x] = 1;
        }
        List<Integer> ans = new ArrayList<>();
        for(int x: response){
            if(cnt[x] == 1){
                ans.add(x);
                cnt[x] = 0;
            }
        }
        ds.submitDataIntArray("B21DCCN114", "YSTfanxS", ans);
    }
}
