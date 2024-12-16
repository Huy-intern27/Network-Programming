import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import vn.medianews.*;

public class Review {    
    public static void main(String[] args) {
        DataService_Service dss = new DataService_Service();
        DataService ds = dss.getDataServicePort();
        List<Integer> arr = ds.getData("B21DCCN791", "FPv5UUKG");
        List<String> ans = new ArrayList<>();
        for(int x:arr){
            ans.add(Integer.toString(x));
        }
        Collections.sort(ans);
        Collections.reverse(ans);
        String result = "";
        for(String x:ans){
            result += x;
        }
        ds.submitDataString("B21DCCN791", "FPv5UUKG", result);
    }
}
