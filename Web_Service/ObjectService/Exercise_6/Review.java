import java.time.LocalDate;
import java.time.OffsetDateTime;
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
        ObjectService_Service oss = new ObjectService_Service();
        ObjectService os = oss.getObjectServicePort();
        List<Order> arr = os.requestListOrder("B21DCCN468", "iQ1NoGhl");
        Map<String, Float> mp = new HashMap<>();
        for(Order x:arr){
            if(mp.containsKey(x.getCustomerId())){
                mp.put(x.getCustomerId(), mp.get(x.getCustomerId()) + x.getAmount());
            }
            else{
                mp.put(x.getCustomerId(), x.getAmount());
            }
        }
        float max_value = 0;
        for(String x:mp.keySet()){
            if(max_value < mp.get(x)){
                max_value = mp.get(x);
            }
        }
        String id = "";
        for(String x:mp.keySet()){
            if(mp.get(x) == max_value){
                id = x;
                break;
            }
        }
        List<Order> ans = new ArrayList<>();
        for(Order x:arr){
            if(id.equals(x.getCustomerId())){
                ans.add(x);
            }
        }
        System.out.println(id);
        os.submitListOrder("B21DCCN468", "iQ1NoGhl", ans);
    }
}
