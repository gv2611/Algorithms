import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.time.Instant;
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

class PageFetcher implements Callable<ArrayList<String>>
{
  private final int pageNumber;
  private final String city;
  private final int maxCost;
  ArrayList<String> foodOutletsBelowMaxCost;

  PageFetcher(int pageNumber, String city, int maxCost) {
    this.pageNumber = pageNumber;
    this.city = city;
    this.maxCost = maxCost;
    this.foodOutletsBelowMaxCost = new ArrayList<>();
  }

  public static String readUrl(String urlString) throws Exception {
    BufferedReader reader = null;
    try {
      URL url = new URL(urlString);
      reader = new BufferedReader(new InputStreamReader(url.openStream()));
      StringBuilder stringBuilder = new StringBuilder();
      int read;
      char[] chars = new char[1024];
      while ((read = reader.read(chars)) != -1)
        stringBuilder.append(chars, 0, read);

      return stringBuilder.toString();
    } finally {
      if (reader != null)
        reader.close();
    }
  }

  @Override
  public ArrayList<String> call() throws Exception {
    String json1 = null;
    try {
      json1 = readUrl("https://jsonmock.hackerrank.com/api/food_outlets?city=" + city + "&page=" + this.pageNumber);
    } catch (Exception e) {
      e.printStackTrace();
      return this.foodOutletsBelowMaxCost;
    }

    JSONObject jsonObject1 = new JSONObject(json1);
    System.out.println(Thread.currentThread() + " = " + json1);
    JSONArray jsonarr1 = (JSONArray) jsonObject1.get("data");

    for (int j = 0; j < jsonarr1.length(); j++) {
      JSONObject jsonObject2 = (JSONObject) jsonarr1.get(j);
      if ((int) jsonObject2.get("estimated_cost") <= maxCost) {
        foodOutletsBelowMaxCost.add(jsonObject2.getString("name"));
      }
    }
    return this.foodOutletsBelowMaxCost;
  }
}

class Result {

  /*
   * Complete the 'getRelevantFoodOutlets' function below.
   *
   * URL for cut and paste
   * https://jsonmock.hackerrank.com/api/food_outlets?city=<city>&page=<pageNumber>
   *
   * The function is expected to return an array of strings.
   *
   * The function accepts a city argument (String) and maxCost argument(Integer).
   */

  public static List<String> getRelevantFoodOutlets(String city, int maxCost) {
    ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);
    HashSet<String> outlets = new HashSet<>();

    try {
      URL url = new URL("https://jsonmock.hackerrank.com/api/food_outlets?city=" + city + "&page=1");

      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
      connection.setRequestMethod("GET");
      connection.addRequestProperty("Content-Type", "application/json");
      connection.connect();

      String json = PageFetcher.readUrl("https://jsonmock.hackerrank.com/api/food_outlets?city=" + city + "&page=1");
      JSONObject jsonObject = new JSONObject(json);
      int total_pages = jsonObject.getInt("total_pages");

      ArrayList<Future<ArrayList<String>>> futures = new ArrayList<>();
      for (int i = 1; i <= total_pages; i++) {
        PageFetcher pageFetcher = new PageFetcher(i, city, maxCost);
        Future<ArrayList<String>> f = executor.submit(pageFetcher);
        futures.add(f);
      }

      for (Future<ArrayList<String>> f : futures) {
        ArrayList<String> foodOutletsBelowMaxCost = f.get();
        outlets.addAll(foodOutletsBelowMaxCost);
      }
    } catch (Exception e) {
      System.out.println("Exception " + e);
    }

    return new ArrayList<String>(outlets);
  }
}

public class RelevantFoodOutlet {
  public static void main(String[] args) throws IOException {

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("/Users/c5317813/Desktop/Algorithms/abc.txt")));
    String city = bufferedReader.readLine();
    int maxCost = Integer.parseInt(bufferedReader.readLine().trim());

    List<String> result = Result.getRelevantFoodOutlets(city, maxCost);
  //  List<String> result = Result.getRelevantFoodOutlets("seattle", 150);

  //  System.out.println(result);

    for (int i = 0; i < result.size(); i++) {
      bufferedWriter.write(result.get(i));

      if (i != result.size() - 1) {
        bufferedWriter.write("\n");
      }
    }
    bufferedWriter.newLine();
    bufferedReader.close();
    bufferedWriter.close();
  }
}

