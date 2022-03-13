class ListNode3 {
  public int val;
  public ListNode3 next;
  ListNode3(int x) { val = x; next = null; }
}

public class KReverseLinkedList {

  public ListNode3 reverseList(ListNode3 A, int B) {
    if (A == null) {
      return null;
    }
    ListNode3 current = A;

    ListNode3 prev = null;
    int count = 0;

    //1->2->3->4->5->6->null
    //next =3
    //2->1->null
    //prev = 2
    //current =3

    while (current != null && count++ < B)
    {
      ListNode3 next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }
    A.next = reverseList(current, B);
    return prev;
  }

  public static int findLength(ListNode3 A) {
    int count=0;
    while(A!=null) {
      count++;
      A=A.next;
    }
    return count;
  }

  public void printLinkedList(ListNode3 node)
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
    KReverseLinkedList krll = new KReverseLinkedList();
    ListNode3 ln = new ListNode3(1);
    ln.next=new ListNode3(2);
    ln.next.next=new ListNode3(3);
    ln.next.next.next= new ListNode3(4);
    ln.next.next.next.next=new ListNode3(5);
    ln.next.next.next.next.next=new ListNode3(6);

    krll.printLinkedList(ln);
    ListNode3 rev=krll.reverseList(ln,2);
    krll.printLinkedList(rev);

  }
}
