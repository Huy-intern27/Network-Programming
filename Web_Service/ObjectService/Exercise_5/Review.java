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
        ProductY product = os.requestProductY("B21DCCN466", "y6YD7gTO");
        float tmp = product.getPrice() * (1 + product.getTaxRate() / 100) * (1 - product.getDiscount() / 100);
        product.setFinalPrice(tmp);
        os.submitProductY("B21DCCN466", "y6YD7gTO", product);
    }
}
