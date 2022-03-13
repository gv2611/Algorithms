import java.util.ArrayList;

public class MinStack {
  ArrayList<Integer> al = new ArrayList<>();

  public void push(int a)
  {
    al.add(a);
  }

  public void pop()
  {
    if(al.size()==0)
    {
      return;
    }
    else
      al.remove(al.size()-1);
  }

  public int top()
  {
    if(al.size()==0)
      return -1;
    else
      return al.get(al.size()-1);
  }

  public int getMin(){
    int min =Integer.MAX_VALUE;

    for(int i=0;i<al.size();i++)
    {
      if(al.get(i)<min)
        min=al.get(i);
    }

    return min;
  }

  public static void main(String[] args)
  {
    MinStack minstack = new MinStack();
    minstack.push(1);
    minstack.push(4);
    minstack.push(5);
    minstack.push(2);

    minstack.pop();
    System.out.println(minstack.top());
    System.out.println(minstack.getMin());
  }
}
