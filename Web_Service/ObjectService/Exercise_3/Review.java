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
        List<EmployeeY> arr = os.requestListEmployeeY("B21DCCN104", "CHoTwBnV");
        Collections.sort(arr, new Comparator<EmployeeY>(){
            @Override
            public int compare(EmployeeY o1, EmployeeY o2) {
                OffsetDateTime datetime1 = o1.getStartDate().toGregorianCalendar().toZonedDateTime().toOffsetDateTime();
                OffsetDateTime datetime2 = o2.getStartDate().toGregorianCalendar().toZonedDateTime().toOffsetDateTime();
                
                return datetime1.compareTo(datetime2);
                        
            }
        });
        os.submitListEmployeeY("B21DCCN104", "CHoTwBnV", arr);
    }
}
