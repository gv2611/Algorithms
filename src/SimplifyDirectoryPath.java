import java.util.Stack;

public class SimplifyDirectoryPath {

  public String simplifyPath(String A) {

    Stack<Character> path = new Stack<>();
    String result="/";


    char ch[] = A.toCharArray();
    for (int i = 0; i < ch.length-1; i++)
    {

    //  System.out.println(A.substring(i,i+1).equals(".."));
      String dir="";
      if(ch[i]=='.')
      {
        System.out.println("if 1 when i="+i+" and ch[i]="+ch[i]);

        if(ch[i+1]=='.' && !path.isEmpty())
        {
          System.out.println("if 2 when i="+i+" and ch[i]="+ch[i]);
          path.pop();
        }
        else
          continue;
      }
      else if(ch[i]!='.' && ch[i]!='/')
      {
        System.out.println("if 3 when i="+i+" and ch[i]="+ch[i]);

        path.push(ch[i]);
      }
      else if(ch[i]=='/')
      {
        if(!path.isEmpty() && path.peek()!='/')
        {
          path.push(ch[i]);
        }
        else
        continue;

      }
    }
    int len=ch.length;
    if(ch[len-1]!='.' && ch[len-1]!='/')
    {
      path.push(ch[len-1]);
    }
    System.out.println(path);
    Stack<Character> path2 = new Stack<>();

    while(!path.isEmpty())
    {
      path2.push(path.pop());
    }
    System.out.println("path2 print="+path2);
 //   System.out.println("path2 peek="+path2.peek());
String div="";
    while(!path2.isEmpty())
    {
      if(path2.peek()!='.'||path2.peek()!='/')
      {
        while (!path2.isEmpty() && path2.peek()!='/') {
          div = div + path2.pop();
        }
      }
      if(div!="")
      {
        result+=div;
      }
      if(!path2.isEmpty())
      {
        if(path2.peek()=='/')
        result+=path2.pop();
      }
      div="";
    }

    return result;
  }

  public static void main(String[] args)
  {
    SimplifyDirectoryPath simplify = new SimplifyDirectoryPath();
    String str= "/a/./b/..//../c/";
    String str2="/../../../../../a";
    String str3="/a//b//c//////d";
    String str4="/home/";
    String str5="/../";
    String str6="/home//foo/";
    String str7="/a/./b/../../c/";
    System.out.println(simplify.simplifyPath(str7));
  }
}
