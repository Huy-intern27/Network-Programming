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
        List<StudentY> arr = os.requestListStudentY("B21DCCN470", "fqhA2SYy");
        Map<String, Float> mp = new LinkedHashMap<>();
        for(StudentY x:arr){
            if(mp.containsKey(x.getSubject())){
                if(mp.get(x.getSubject()) < x.getScore()){
                    mp.put(x.getSubject(), x.getScore());
                }
            }
            else{
                mp.put(x.getSubject(), x.getScore());
            }
        }
        Map<String, StudentY> mp2 = new LinkedHashMap<>();
        for(StudentY x:arr){
            if(mp.containsKey(x.getSubject())){
                float value = mp.get(x.getSubject());
                float score = x.getScore();
                int compare = Float.compare(value, score);
                if(compare == 0){
                    if(!mp2.containsKey(x.getSubject())){
                        mp2.put(x.getSubject(), x);
                    }
                }
            }
        }
        List<StudentY> ans = new ArrayList<>();
        for(String x:mp2.keySet()){
            ans.add(mp2.get(x));
        }
        
        os.submitListStudentY("B21DCCN470", "fqhA2SYy", ans);
    }
}
