import java.util.ArrayList;
import java.util.List;
import vn.medianews.*;

public class Review {
    public static int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a%b);
    }
    
    public static void main(String[] args) {
        DataService_Service dss = new DataService_Service();
        DataService ds = dss.getDataServicePort();
        double n = ds.getDataDouble("B21DCCN440", "o8hcMOUc");
        String[] tmp = Double.toString(n).split("[.]");
        int scale = tmp[1].length();
        int tu = (int) (Math.ceil(n * (Math.pow(10, scale))));
        int mau = (int) Math.pow(10, scale);
        List<Integer> arr = new ArrayList<>();
        arr.add(tu / gcd(tu, mau));
        arr.add(mau / gcd(tu, mau));
        ds.submitDataIntArray("B21DCCN440", "o8hcMOUc", arr);
    }
}
