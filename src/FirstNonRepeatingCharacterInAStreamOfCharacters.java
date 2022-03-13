import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeatingCharacterInAStreamOfCharacters {

  public String solve(String A) {
    char ch[] = A.toCharArray();
    HashMap<Character,Integer> hm = new HashMap<>();
    StringBuffer result=new StringBuffer();
    Queue<Character> nonRepeatt = new LinkedList<>();
    for(int i=0;i<ch.length;i++)
    {
      if(!hm.containsKey(ch[i]))
      {
        nonRepeatt.add(ch[i]);
        hm.put(ch[i], 1);
        result=result.append(nonRepeatt.peek());
      }
      else if(hm.containsKey(ch[i]))
      {
        nonRepeatt.remove(ch[i]);
        if(nonRepeatt.isEmpty()) {
          result=result.append('#');
          continue;
        }
        result = result.append(nonRepeatt.peek());
        continue;
      }
    }
    return result.toString();
    }

  public static void main(String[] args)
  {
    FirstNonRepeatingCharacterInAStreamOfCharacters first = new FirstNonRepeatingCharacterInAStreamOfCharacters();
    String str="xxikrwmjvsvckfrqxnibkcasompsuyuogauacjrr";
    System.out.println(first.solve(str));


  }
}
