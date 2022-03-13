import java.util.HashMap;
import java.util.Set;

public class Test {

  public int abc(int arr[])
  {
    HashMap<Integer, Integer> hm = new HashMap<>();

    for(int i=0;i<arr.length;i++)
    {
//      if(!hm.containsKey(arr[i]))
//      {
//        hm.put(arr[i],1);
//      }
//      else
//      {
//        int count=hm.get(arr[i]);
//        count++;
//        hm.put(arr[i],count);
//      }

      hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
    }

    int arr2[]= new int[3];
    findMaxMin(hm.keySet());


    return 0;
  }

  private void findMaxMin(Set<Integer> keySet) {
    int small=Integer.MAX_VALUE, middle=0, large=Integer.MIN_VALUE;
    for (Integer n:keySet
         ) {

      if(n>large) {
        large = n;

      }
      if(n<small)
      {
        small=n;
      }
    }

    for (Integer n:keySet
    ) {
      if(n!=small && n!=large)
      {
        middle=n;
      }
    }


    if(keySet.contains(small))
    System.out.println("small="+small+"middle="+middle+"large="+large);
  }


  public static void main(String[] args)
  {

    Test t = new Test();
    int arr[] = {1,2,0,2,2,1,1,0,0};

    t.abc(arr);
  }
}
