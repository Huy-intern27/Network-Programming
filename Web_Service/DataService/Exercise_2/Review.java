import java.util.ArrayList;
import java.util.List;
import vn.medianews.*;

public class Review {    
    public static void main(String[] args) {
        DataService_Service dss = new DataService_Service();
        DataService ds = dss.getDataServicePort();
        List<Integer> arr = ds.getData("B21DCCN239", "mYuaqugS");
        List<String> ans = new ArrayList<>();
        for(int x:arr){
            String tmp = Integer.toBinaryString(x);
            ans.add(tmp);
        }
        ds.submitDataStringArray("B21DCCN239", "mYuaqugS", ans);
    }
}
