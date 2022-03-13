class ListNode2{
  public int val;
  public ListNode2 next;
  ListNode2(int x) { val = x; next = null; }
}
public class SortLinkedList {

  public ListNode2 sortList(ListNode2 A) {
    ListNode2 backup=A; ListNode2 backup2=A;
    int len=findLength(A);
    while(len!=0)
    {
      backup=A;
      while (backup!=null&&backup.next!=null)
      {
        if(backup.val<backup.next.val)
        {
          backup=backup.next;
        }
        else
        {
          int temp=backup.val;
          backup.val=backup.next.val;
          backup.next.val=temp;
        }
      }
      len--;
    }
    return backup2;
  }


  private ListNode2 mergeSorted(ListNode2 A, ListNode2 B)
  {
    ListNode2 result=null;
    if(A==null)
      return B;
    if(B==null)
      return A;
    if(A.val <= B.val)
    {
      result=A;
      result.next=mergeSorted(A.next,B);
    }
    else{
      result=B;
      result.next=mergeSorted(A,B.next);
    }
return result;
  }
private ListNode2 mergeSort(ListNode2 A)
{
  if(A==null || A.next==null)
    return A;

  ListNode2 mid=findMiddle(A);
  ListNode2 nextofMid = mid.next;

  mid.next=null;
  ListNode2 left=mergeSort(A);
  ListNode2 right=mergeSort(nextofMid);

  ListNode2 sorted = mergeSorted(left,right);
  return sorted;
}

  private ListNode2 findMiddle(ListNode2 node)
  {
    if(node==null)
      return node;
    ListNode2 slow =node;
    ListNode2 fast=node;
    while(fast.next!=null && fast.next.next!=null) {
      slow=slow.next;
      fast=fast.next.next;
    }
    return slow;
  }

  private int findLength(ListNode2 A) {
    int count=0;
    while(A!=null) {
      count++;
      A=A.next;
    }
    return count;
  }

  public void printLinkedList(ListNode2 node)
  {
    while(node!=null) {
      System.out.print(node.val+" --> ");
      node=node.next;
    } System.out.println("null");
  }

  public static void main(String[] args)
  {
    SortLinkedList sll = new SortLinkedList();
    ListNode2 ln = new ListNode2(1);
    ln.next=new ListNode2(5);
    ln.next.next=new ListNode2(4);
    ln.next.next.next= new ListNode2(3);
    ln.next.next.next.next=new ListNode2(2);
    sll.printLinkedList(ln);

    ListNode2 sorted=  sll.mergeSort(ln);
    sll.printLinkedList(sorted);


  }
}
