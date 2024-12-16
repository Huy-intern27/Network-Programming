import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import vn.medianews.*;

public class Review {    
    public static String solve(int a){
        String ans = "";
        for(int i = 2; i <= Math.sqrt(a); i++){
            while(a % i == 0){
                ans += i;
                ans += ", ";
                a /= i;
            }
        }
        if(a != 1){
            ans += a;
        }
        else{
            ans = ans.trim();
            ans = ans.substring(0, ans.length() - 1);
        }
        return ans;
    }
    
    public static void main(String[] args) {
        DataService_Service dss = new DataService_Service();
        DataService ds = dss.getDataServicePort();
        List<Integer> arr = ds.getData("B21DCCN441", "oQmYBGJ5");
        List<String> ans = new ArrayList<>();
        for(int x:arr){
            ans.add(solve(x));
        }
        ds.submitDataStringArray("B21DCCN441", "oQmYBGJ5", ans);
    }
}
