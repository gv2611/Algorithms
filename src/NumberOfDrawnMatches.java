import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import java.net.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import com.google.gson.Gson;
import org.json.*;


class Result2
{

  public static int getNumDraws(int year) {
    int count=0;

    try
    {
      URL url = new URL("https://jsonmock.hackerrank.com/api/football_matches?year="+year+"&page=1");
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
      connection.setRequestMethod("GET");
      connection.connect();
      String json = readUrl("https://jsonmock.hackerrank.com/api/football_matches?year=" + year + "&page=1");
      JSONObject jsonObject = new JSONObject(json);
      int total_page = jsonObject.getInt("total_pages");

      for(int i=1;i<=total_page;i++)
      {
       // System.out.println("inside for");
        String json2 = readUrl("https://jsonmock.hackerrank.com/api/football_matches?year=" + year + "&page="+i);
        System.out.println(json2);
        JSONObject jsonObject1 = new JSONObject(json2);
        JSONArray jsonarr1 = (JSONArray) jsonObject1.get("data");
        for (int j = 0; j < jsonarr1.length(); j++) {
          JSONObject jsonObject2 = (JSONObject) jsonarr1.get(j);
          if ( jsonObject2.get("team1goals").equals(jsonObject2.get("team2goals"))) {
            count++;
          }

          }

        }

    }
    catch (Exception e)
    {
      System.out.println("Exception : "+e);
    }

    return count;



  }

  private static String readUrl(String urlString) throws Exception {
    BufferedReader reader = null;
    try {
      URL url = new URL(urlString);
      reader = new BufferedReader(new InputStreamReader(url.openStream()));
      StringBuffer buffer = new StringBuffer();
      int read;
      char[] chars = new char[1024];
      while ((read = reader.read(chars)) != -1)
        buffer.append(chars, 0, read);

      return buffer.toString();
    } finally {
      if (reader != null)
        reader.close();
    }

  }



}

public class NumberOfDrawnMatches {
  public static void main(String[] args) throws IOException {
//    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//    int year = Integer.parseInt(bufferedReader.readLine().trim());

    int result = Result2.getNumDraws(2011);
    System.out.println(result);

//    bufferedWriter.write(String.valueOf(result));
//    bufferedWriter.newLine();
//
//    bufferedReader.close();
//    bufferedWriter.close();
  }
}
