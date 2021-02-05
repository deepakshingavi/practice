
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class GetCovidData {
    public static void main(String[] args) {
        getAllDistrictsInfo();
    }

    public static void getAllDistrictsInfo()
    {
//        ArrayList<StateDetails> states = new ArrayList<StateDetails>();
        try {
            URL url = new URL("https://api.covid19india.org/state_district_wise.json");//your url i.e fetch data from .
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : "
                        + conn.getResponseCode());
            }
            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(in);


            Scanner sc = new Scanner(url.openStream());
            String inline = "";
            while(sc.hasNext())
            {
                inline+=sc.nextLine();
            }

            System.out.println(inline);

            /*JSONParser parse = new JSONParser();
            JSONObject jobj = (JSONObject)parse.parse(inline);
            ArrayList<String> set = new ArrayList<String>(jobj.keySet());

            for(Iterator iterator = set.iterator(); iterator.hasNext();)
            {
                String key = (String) iterator.next();
                JSONObject distdata = (JSONObject) jobj.get(key);
                JSONObject dists = (JSONObject) distdata.get("districtData");
                System.out.println(key);

                ArrayList<String> set2 = new ArrayList<String>(dists.keySet());
                for(Iterator itr = set2.iterator();itr.hasNext();)
                {
                    String key2 = (String) itr.next();
                    JSONObject district = (JSONObject) dists.get(key2);
                    System.out.println(key2);
                    System.out.println(district);
                }
                System.out.println("************");

            }*/

            conn.disconnect();

        }
        catch (Exception e) {
            System.out.println("Exception in NetClientGet:- " + e);
        }


    }


}
