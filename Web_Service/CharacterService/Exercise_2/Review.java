import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import vn.medianews.*;

public class Review {    
    public static void main(String[] args) {
        CharacterService_Service css = new CharacterService_Service();
        CharacterService cs = css.getCharacterServicePort();
        String[] arr = cs.requestString("B21DCCN239", "ZkFsxKtN").trim().split("\\s+");
        String ans = "";
        int max_value = Integer.MIN_VALUE;
        int min_value = Integer.MAX_VALUE;
        int idx1 = -1, idx2 = -1;
        for(int i = 0; i < arr.length; i++){
            int size = arr[i].trim().length();
            if(size > max_value){
                max_value = size;
                idx1 = i;
            }
            if(size < min_value){
                min_value = size;
                idx2 = i;
            }
        }
        ans += arr[idx1];
        ans += "; ";
        ans += arr[idx2];
        cs.submitCharacterString("B21DCCN239", "ZkFsxKtN", ans);
    }
}
