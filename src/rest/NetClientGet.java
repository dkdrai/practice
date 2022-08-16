package rest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;


public class NetClientGet {

    // http://localhost:8080/RESTfulExample/json/product/get
    public static void main(String[] args) {
        try {
            URL url = new URL("https://jsonmock.hackerrank.com/api/countries?name=India");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));
            String output;
            System.out.println("Output from Server .... \n");
            StringBuilder sb = new StringBuilder();
            int count = 0;
            while ((output = br.readLine()) != null) {
                System.out.println(output);
                count++;
                sb.append(output);
            }
            System.out.println("");
            System.out.println("Output: " + sb);
            System.out.println("count: " + count);
            conn.disconnect();

            String json = new String(sb);
            String script = "Java.asJSONCompatible(" + json + ")";

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}