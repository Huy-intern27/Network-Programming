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
        List<Customer> response = os.requestListCustomer("B21DCCN440", "4zcxNMzo");
        List<Customer> ans = new ArrayList<>();
        for(Customer x:response){
            if(x.getTotalSpent() > 5000 && x.getPurchaseCount() >= 5){
                ans.add(x);
            }
        }
        os.submitListCustomer("B21DCCN440", "4zcxNMzo", ans);
    }
}
