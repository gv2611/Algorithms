import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {


  public static void main(String[] args) {
    LongestSubstring ls = new LongestSubstring();
    String s = "abcabcbb";
    //abcdeahij
    int len = ls.findLongestSubstring2(s);
    System.out.println(len);
  }


  private int findLongestSubstring2(String s) {
    char [] ch= s.toCharArray();
    Set<Character> hm = new HashSet<Character>();
    int left=0;
    int right=0;
    int result=0;
    int maxResult=0;
    while(right<s.length())
    {
      if(!hm.contains(ch[right])) {
        hm.add(ch[right]);
        result++;
        if(result>maxResult)
        {
          maxResult=result;
        }
        right++;
      }
      else
      {
        hm.remove(ch[left]);
        left++;
        result--;
      }
    }
    return maxResult;
  }
}
