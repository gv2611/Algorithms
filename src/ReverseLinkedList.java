class ListNode {
     public int val;
     public ListNode next;
     ListNode(int x) { val = x; next = null; }
  }

//
//  Given 1->2->3->4->5->NULL,
//
//      return 5->4->3->2->1->NULL.

public class ReverseLinkedList {
  public ListNode reverseList(ListNode A) {
    ListNode prev = null;
    ListNode current = A;
    ListNode next = null;



      while (current != null) {
        next = current.next;
        current.next = prev;
        prev = current;
        current = next;
      }
      A = prev;
      return A;
    }



  public void printLinkedList(ListNode node)
  {
    while(node!=null)
    {
      System.out.print(node.val+" --> ");
      node=node.next;

    }
    System.out.println("null");
  }

  public static void main(String[] args)
  {
    ReverseLinkedList rll = new ReverseLinkedList();
    ListNode ln = new ListNode(1);
    ln.next=new ListNode(2);
    ln.next.next=new ListNode(3);
    ln.next.next.next= new ListNode(4);
    ln.next.next.next.next=new ListNode(5);
    rll.printLinkedList(ln);
    ListNode rev=rll.reverseList(ln);
    rll.printLinkedList(rev);

  }

}
