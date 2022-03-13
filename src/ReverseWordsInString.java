public class ReverseWordsInString {
  public String reverseWords(String s) {
    String words[]=s.split("\\s");
    String reveseString="";
    for(int i=0;i<words.length;i++)
    {
      StringBuilder sb= new StringBuilder(words[i]);
      sb=sb.reverse();
      reveseString+=sb.toString()+" ";

    }
    return reveseString.trim();


  }
  public static void main(String[] args) {
    ReverseWordsInString reverse = new ReverseWordsInString();
    System.out.println(reverse.reverseWords("Let's take LeetCode contest"));


  }


  }
