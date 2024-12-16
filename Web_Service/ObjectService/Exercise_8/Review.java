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
        Employee employee = os.requestEmployee("B21DCCN109", "CQGk1hJ1");
        LocalDate start = employee.getStartDate().toGregorianCalendar().toZonedDateTime().toLocalDate();
        LocalDate end = employee.getEndDate().toGregorianCalendar().toZonedDateTime().toLocalDate();
        long between = Math.abs(ChronoUnit.DAYS.between(start, end));
        long weekend = 0;
        for(LocalDate date = start; date.isBefore(end) || date.equals(end); date = date.plusDays(1)){
            if(date.getDayOfWeek().getValue() == 6 || date.getDayOfWeek().getValue() == 7) weekend ++;
        }
        between -= weekend;
        employee.setWorkingDays((int) between + 1);
        os.submitEmployee("B21DCCN109", "CQGk1hJ1", employee);
    }
}
