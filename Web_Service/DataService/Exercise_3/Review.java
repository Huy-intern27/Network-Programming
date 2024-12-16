import java.util.ArrayList;
import java.util.List;
import vn.medianews.*;

public class Review {    
    public static void main(String[] args) {
        DataService_Service dss = new DataService_Service();
        DataService ds = dss.getDataServicePort();
        List<Integer> arr = ds.getData("B21DCCN467", "4iyFyXaI");
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        for(int x:arr){
            if(x % 2 == 0) even.add(x);
            else odd.add(x);
        }
        List<Integer> ans = new ArrayList<>();
        int idx1 = 0, idx2 = 0;
        for(int i = 0; i < arr.size(); i++){
            if(i % 2 == 0){
                if(idx1 == even.size()){
                    if(idx2 < odd.size()){
                        for(int j = idx2; j< odd.size(); j++){
                            ans.add(odd.get(j));
                        }
                        break;
                    }
                    break;
                }
                else{
                    ans.add(even.get(idx1));
                    idx1 ++;
                }
            }
            else{
                if(idx2 == odd.size()){
                    if(idx1 < even.size()){
                        for(int j = idx2; j< even.size(); j++){
                            ans.add(even.get(j));
                        }
                        break;
                    }
                    break;
                }
                else{
                    ans.add(odd.get(idx2));
                    idx2 ++;
                }
            }
        }
        ds.submitDataIntArray("B21DCCN467", "4iyFyXaI", ans);
    }
}
