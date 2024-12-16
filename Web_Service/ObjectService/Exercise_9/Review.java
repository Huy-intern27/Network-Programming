import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
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
        List<Project> arr = os.requestListProject("B21DCCN100", "ITKyvE4i");
        List<Project> ans = new ArrayList<>();
        for(Project x:arr){
            if(x.getCompletionPercentage() >= 80.0){
                LocalDate current = LocalDate.now();
                LocalDate start = x.getDueDate().toGregorianCalendar().toZonedDateTime().toLocalDate();
                
                long between = ChronoUnit.DAYS.between(current, start);
                if(between <= 15){
                    ans.add(x);
                }
            }
        }
        os.submitListProject("B21DCCN100", "ITKyvE4i", ans);
    }
}
