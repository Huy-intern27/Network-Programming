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
        List<OrderY> arr = os.requestListOrderY("B21DCCN107", "xx4L6daX");
        List<OrderY> ans = new ArrayList<>();
        for(OrderY x: arr){
            if(x.getStatus().equals("pending") || x.getStatus().equals("processing")){
                LocalDate current = LocalDate.now();
                LocalDate start = x.getOrderDate().toGregorianCalendar().toZonedDateTime().toLocalDate();
                
                long between = ChronoUnit.DAYS.between(current, start);
                if(Math.abs(between) >= 30) ans.add(x);
                
            }
        }
        
        os.submitListOrderY("B21DCCN107", "xx4L6daX", ans);
    }
}
