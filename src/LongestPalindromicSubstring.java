public class LongestPalindromicSubstring {

  public String longestPalindrome(String s) {
    String st= "abcd";

    if(s.length()==1)
    {
      return s;
    }
    return st;


  }

  public static void main(String[] args)
  {
    LongestPalindromicSubstring palindromicSubstring = new LongestPalindromicSubstring();
    String s= "babad";
    System.out.println(palindromicSubstring.longestPalindrome(s));
  }
}

