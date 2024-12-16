import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import vn.medianews.*;

public class Review {        
    public static void main(String[] args) {
        CharacterService_Service css = new CharacterService_Service();
        CharacterService cs = css.getCharacterServicePort();
        String response = cs.requestString("B21DCCN104", "7IMif7y0");
        if(response.contains(" ")){
            String[] arr = response.trim().toLowerCase().split("\\s+");
            String PascalCase = "";
            String camelCase = "";
            String snake_case = "";
            for(int i = 0; i< arr.length; i++){
                if(i == 0){
                    camelCase += arr[i];
                }
                else{
                    camelCase += arr[i].substring(0, 1).toUpperCase();
                    camelCase += arr[i].substring(1).toLowerCase();
                }
                PascalCase += arr[i].substring(0, 1).toUpperCase();
                PascalCase += arr[i].substring(1).toLowerCase();
                
                snake_case += arr[i];
                snake_case += "_";
            }
            snake_case = snake_case.substring(0, snake_case.length() - 1);
            List<String> ans = new ArrayList<>();
            ans.add(PascalCase);
            ans.add(camelCase);
            ans.add(snake_case);
            cs.submitCharacterStringArray("B21DCCN104", "7IMif7y0", ans);
        }
        else{
            String[] arr = response.trim().toLowerCase().split("_");
            String PascalCase = "";
            String camelCase = "";
            String snake_case = "";
            for(int i = 0; i< arr.length; i++){
                if(i == 0){
                    camelCase += arr[i];
                }
                else{
                    camelCase += arr[i].substring(0, 1).toUpperCase();
                    camelCase += arr[i].substring(1).toLowerCase();
                }
                PascalCase += arr[i].substring(0, 1).toUpperCase();
                PascalCase += arr[i].substring(1).toLowerCase();
                
                snake_case += arr[i];
                snake_case += "_";
            }
            snake_case = snake_case.substring(0, snake_case.length() - 1);
            List<String> ans = new ArrayList<>();
            ans.add(PascalCase);
            ans.add(camelCase);
            ans.add(snake_case);
            cs.submitCharacterStringArray("B21DCCN104", "7IMif7y0", ans);
        }
    }
}
