import java.io.*;
import static java.util.stream.Collectors.joining;

class Result10 {

  /*
   * Complete the 'getSwapTime' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts STRING color as parameter.
   */

  public static int getSwapTime(String color) {
    // Write your code here

    int flag = 0;
    int countOfTurns = 0;
    char ch[] = color.toCharArray();
    for (int j = 0; j < ch.length; j++) {
      if (flag == 1) {
        ++countOfTurns;
      }
      for (int i = 0; i < ch.length - 1; i++) {

        if (ch[i] == '0' && ch[i + 1] == '1') {
          ch[i + 1] = '0';
          ch[i] = '1';
          flag = 1;
          continue;
        }
        printCharArray(ch);
      }
    }
    if (countOfTurns == 0) {
      return countOfTurns;
    } else
      return countOfTurns - 1;
  }

  public static int getSwapTime2(String color) {
    int count = 0;
    char ch[] = color.toCharArray();
    while(true) {
      int swaps = 0;
      char ch2[] = ch.clone();
      for (int i = 0; i < color.length() - 1; i++) {
        if (ch[i] == '0' && ch[i+1] == '1') {
          ch2[i] = '1';
          ch2[i+1] = '0';
          swaps++;
          i++;
        } else {
          ch2[i] = ch[i];
        }
      }
      printCharArray(ch);
      ch = ch2;
      if (swaps == 0) {
        break;
      }
      count++;
    }
    return count;
  }


  public static int getSwap(String color)
  {
    char ch[] = color.toCharArray();
    int numberOfOnes = findNumberOfOnes(ch);
    int consecutiveOnes = findConsecutiveOnes(ch);
    int indexLastOne = findIndexOfLastOne(ch);

    if(indexLastOne==-1)
    {
      return 0;
    } else if (numberOfOnes == ch.length) {
      return 0;
    }
    else
    {
      return indexLastOne - numberOfOnes + 1 + consecutiveOnes;
    }
  }

  private static int findIndexOfLastOne(char[] ch) {
    for(int i=ch.length-1;i>=0;i--)
    {
      if(ch[i]=='1')
      {
        return i;
      }
    }
    return -1;
  }

  private static int findConsecutiveOnes(char[] ch) {
    int consecOnes=0;
    for(int i=0;i <ch.length-1;i++)
    {
      if(ch[i]=='1' && ch[i+1]=='1')
      {
        consecOnes++;
      }
    }
    return consecOnes;
  }


  private static int findNumberOfOnes(char[] ch) {
    int ones=0;
    for(int i=0;i<ch.length;i++)
    {
      if(ch[i]=='1')
      {
        ones++;
      }
    }
    return ones;
  }


  private static void printCharArray(char[] ch) {
    for (int i = 0; i < ch.length; i++) {
      System.out.print(" " + ch[i]);
    }
    System.out.println();
  }

  static char[] swap(String str, int i, int j) {
    char ch[] = str.toCharArray();
    char temp = ch[i];
    ch[i] = ch[j];
    ch[j] = temp;
    return ch;
  }

}

public class ParadeInHackerland {
  public static void main(String[] args) throws IOException {
    //    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    //    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
    //
    //    String color = bufferedReader.readLine();
    //
    //    int result = Result.getSwapTime(color);
    //
    //    bufferedWriter.write(String.valueOf(result));
    //    bufferedWriter.newLine();
    //
    //    bufferedReader.close();
    //    bufferedWriter.close();

    String color = "1100111001";
    Result parade = new Result();
    int output = Result10.getSwap(color);
    System.out.println(output);
//    System.out.println(Result10.getSwapTime(color));
    System.out.println(Result10.getSwapTime2(color));
  }
}