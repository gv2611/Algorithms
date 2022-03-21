import java.util.*;
import java.io.*;

class ArrayChallenge {

  public static String arrayChallenge(String str) {
    int count=0;

    HashMap<String, List<String> > map
        = new HashMap<>();
    String [] strSplit =str.split(" ");
    String [] sortedStrings = new String[strSplit.length];
    for(int i=0;i<strSplit.length;i++) {
      String word = strSplit[i];
      char[] letters = word.toCharArray();
      Arrays.sort(letters);
      String newWord = new String(letters);
      sortedStrings[i] = newWord;
    }
    printArray(strSplit);
    printArray(sortedStrings
    );

    for(int i=0;i<sortedStrings.length;i++)
    {
      if(map.containsKey(sortedStrings[i]))
      {
        map.get(sortedStrings[i]).add(strSplit[i]);
      }
      else
      {
        List<String> words = new ArrayList<>();
        words.add(strSplit[i]);
        map.put(sortedStrings[i], words);

      }

    }

      return String.valueOf(map.size());



    }

    public static void printArray(String [] str)
    {
      for(int i=0;i<str.length;i++)
      {
        System.out.print(str[i]+" ");
      }
      System.out.println();
    }


  public static void main (String[] args) {
    // keep this function call here     
//    Scanner s = new Scanner(System.in);
//    System.out.print(ArrayChallenge(s.nextLine()));
    ArrayChallenge ac = new ArrayChallenge();
    System.out.println(ac.arrayChallenge("aa aa odg dog gdo"));

  }

}