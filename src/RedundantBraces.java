import java.util.Stack;

public class RedundantBraces {
  public int braces(String a) {
    Stack<Character> brackets = new Stack<>();

    char ch[]= a.toCharArray();
    for(int i=0;i<a.length();i++)
    {
      if(ch[i]=='(' || ch[i]=='+' || ch[i]=='-' || ch[i]=='/' || ch[i]=='*')
      {
        brackets.push(ch[i]);
        continue;
      }
      else if(ch[i]==')')
      {
        if(brackets.isEmpty())
          return 1;
        char lastChar=brackets.pop();
        if(lastChar=='(')
          return 1;
        else if(lastChar=='+' || lastChar=='-' ||lastChar=='/' || lastChar=='*')
        {
          brackets.pop();
        }

      }
    }

    if(brackets.isEmpty() ||( brackets.contains('+') || brackets.contains('-') || brackets.contains('/') || brackets.contains('*')))
      return 0;
    else
      return 1;

  }

  public static void main(String[] args)
  {
    RedundantBraces rb = new RedundantBraces();
    String str= "((a+b))";
    System.out.println(rb.braces(str));
  }
  }
