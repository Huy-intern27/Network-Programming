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
        List<Integer> response = ds.getData("B21DCCN106", "QXYOD8oN");
        List<String> ans = new ArrayList<>();
        for(int x:response){
            String tmp1 = Integer.toHexString(x);
            tmp1 = tmp1.toUpperCase();
            String tmp2 = Integer.toOctalString(x);
            String res = tmp2 + "|" + tmp1;
            ans.add(res);
        }
        ds.submitDataStringArray("B21DCCN106", "QXYOD8oN", ans);
    }
}
