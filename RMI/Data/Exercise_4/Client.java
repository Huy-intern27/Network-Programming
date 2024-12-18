import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

public class Client {    
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService dataService = (DataService) registry.lookup("RMIDataService");
        String rp = (String) dataService.requestData("B21DCCN466", "CO70Guj0");
        List<Double> arr = new ArrayList<>();
        String[] tmp = rp.split(",");
        for(String x:tmp){
            arr.add(Double.parseDouble(x.trim()));
        }
        double sum = 0.0;
        for(double x: arr){
            sum += x;
        }
        double mean = sum / arr.size();
        double variance = 0.0;
        for(double x: arr){
            variance += Math.pow((x - mean), 2);
        }
        variance /= arr.size();
        double std = Math.sqrt(variance);
        String ans = String.format("%.2f", variance) + " : " + String.format("%.2f", std);
        dataService.submitData("B21DCCN466", "CO70Guj0", ans);
    }
    
}
