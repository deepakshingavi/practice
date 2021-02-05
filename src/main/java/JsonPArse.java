import org.json.JSONArray;
import org.json.JSONObject;

public class JsonPArse {

    public static void main(String[] args) {
        JSONObject jsonObj = new JSONObject("{\n" +
                "  \"success\": {\n" +
                "    \"total\": 1\n" +
                "  },\n" +
                "  \"contents\": {\n" +
                "    \"quotes\": [\n" +
                "      {\n" +
                "        \"quote\": \"Give me golf clubs, fresh air and a beautiful partner, and you can keep the clubs and the fresh air.\",\n" +
                "        \"length\": \"100\",\n" +
                "        \"author\": \"Jack Benny\",\n" +
                "        \"tags\": {\n" +
                "          \"0\": \"funny\",\n" +
                "          \"1\": \"golf\",\n" +
                "          \"2\": \"sports\",\n" +
                "          \"4\": \"tod\"\n" +
                "        },\n" +
                "        \"category\": \"funny\",\n" +
                "        \"language\": \"en\",\n" +
                "        \"date\": \"2020-05-17\",\n" +
                "        \"permalink\": \"https://theysaidso.com/quote/jack-benny-give-me-golf-clubs-fresh-air-and-a-beautiful-partner-and-you-can-keep\",\n" +
                "        \"id\": \"CzZGhQUP5nApJRq5BaqiggeF\",\n" +
                "        \"background\": \"https://theysaidso.com/img/qod/qod-funny.jpg\",\n" +
                "        \"title\": \"Funny Quote of the day\"\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  \"baseurl\": \"https://theysaidso.com\",\n" +
                "  \"copyright\": {\n" +
                "    \"year\": 2022,\n" +
                "    \"url\": \"https://theysaidso.com\"\n" +
                "  }\n" +
                "}");
        JSONArray contacts = jsonObj.getJSONObject("contents").getJSONArray("quotes"); // fetch quotes as JSON Array
        for (int i = 0; i < contacts.length(); i++) {   // Iterate over quotes
            String quote = contacts.getJSONObject(i).getString("quote");   // Fetch quote from JSON object
            String author = contacts.getJSONObject(i).getString("author"); // Fetch author from JSON object
            System.out.println(" quote=" + quote + " author="+author);
        }
    }
}
