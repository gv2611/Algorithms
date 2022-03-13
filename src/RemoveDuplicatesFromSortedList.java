import java.util.HashMap;

public class RemoveDuplicatesFromSortedList {


  public ListNode deleteDuplicates(ListNode A) {

    if(A==null)
      return null;
    if(A.next==null)
      return A;

    ListNode backup=A;

    while(A.next!=null )
    {
      if(A.val==A.next.val)
      {
        ListNode nextNode=A.next.next;
        if(nextNode!=null)
        {
          A.next=nextNode;
        }
       else
         A.next=null;
      }
      else
      A=A.next;
    }

    return backup;
  }

  public ListNode deleteDuplicates2(ListNode A) {
    HashMap<Integer, Integer> count = new HashMap<>();
    ListNode backup = A;

    while(A!=null)
    {
      count.put(A.val,count.getOrDefault(A.val,0)+1);
      A=A.next;

    }
   // System.out.println(count);

    A=backup;
    ListNode current=null;
    ListNode prev=null;
    while (A!=null)
    {
      if(count.get(A.val) ==1)
      {
        if(current==null)
        {
          current=A;
        }
        else
        {
          prev=current;
          current=A;
          prev.next=current;
        }
      }
      if(A.next==null && count.get(A.val)>1)
      {
        current.next=null;
      }
      A=A.next;
    }
    return backup;
  }


  public void printLinkedList(ListNode node)
  {
    while(node!=null) {
      System.out.print(node.val+" --> ");
      node=node.next;
    } System.out.println("null");
  }

  public static void main(String[] args)
  {
    RemoveDuplicatesFromSortedList removeDupli = new RemoveDuplicatesFromSortedList();
    ListNode ln = new ListNode(1);
    ln.next=new ListNode(3);
    ln.next.next=new ListNode(5);
    ln.next.next.next= new ListNode(3);
    ln.next.next.next.next=new ListNode(3);
    removeDupli.printLinkedList(ln);
    ListNode sorted=  removeDupli.deleteDuplicates2(ln);
    removeDupli.printLinkedList(sorted);


  }
}
