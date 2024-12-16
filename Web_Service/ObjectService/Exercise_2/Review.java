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
        List<Student> response = os.requestListStudent("B21DCCN103", "MrC9O6hI");
        List<Student> ans = new ArrayList<>();
        for(Student x:response){
            if(x.getScore() >= 8.0 || x.getScore() < 5.0){
                ans.add(x);
            }
        }
        os.submitListStudent("B21DCCN103", "MrC9O6hI", ans);
    }
}
