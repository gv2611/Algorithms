import java.util.*;

class MinimumSquads
{

  // Function to return the depth of the tree
  static int findDepth(int x, ArrayList<Integer> child[])
  {
    int mx = 0;
    for (Integer ch : child[x])
      mx = Math.max(mx, findDepth(ch, child));
    return mx + 1;
  }

  static int minimumGroups(List<Integer> parents)
  {
    int n=parents.size()-1;
    ArrayList<Integer>[] child = new ArrayList[n + 1];
    for (int i = 0; i <= n; i++)
    {
      child[i] = new ArrayList<Integer>();
    }

    for (int i = 1; i <= n; i++)
      if (parents.get(
          i
      ) != -1)
        child[parents.get(i)].add(i);
    int res = 0;

    for (int i = 1; i <= n; i++)

      if (parents.get(i) == -1) {
        res = Math.max(res, findDepth(i, child));
        System.out.println(res);
      }

    return res;
  }

  // Driver code
  public static void main(String[] args)
  {

    int par[] = {-1,8,6,0,7,3,8,9,-1,6};

    ArrayList<Integer> al = new ArrayList<>(Arrays.asList(-1,8,6,0,7,3,8,9,-1,6));
    ArrayList<Integer> al2 = new ArrayList<>(Arrays.asList( -1, 1, 1, 2, 2, 5, 6));
 //   -1, 1, 2, 1, 4

    int n = par.length - 1;
    System.out.print(minimumGroups(al2));
  }
}