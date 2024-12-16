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
        List<Integer> response = ds.getData("B21DCCN103", "31CdHnYm");
        int sum = 0;
        for(int x: response) sum += x;
        ds.submitDataInt("B21DCCN103", "31CdHnYm", sum);
    }
}
