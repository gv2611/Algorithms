
public class ParttitionList {


  public ListNode partition(ListNode A, int B) {

    ListNode bigPointer=null;
    ListNode smallPointer=null;
    ListNode prev=A;
    ListNode backup=A;

    while (A!=null) {

      if (A.val >= B) {
        bigPointer = A;
      //  A=A.next;
      }
      if (A.val < B && smallPointer!=null) {

        prev=smallPointer;
        smallPointer = A;
        ListNode nxt=smallPointer.next;
        smallPointer.next=bigPointer;
        bigPointer.next=nxt;
        prev.next=smallPointer;
      //  A=A.next;
      }
      A=A.next;

     // printLinkedList(A);
    }
    return backup;
  }


  public ListNode partition2(ListNode A, int B) {

    ListNode small=null, big=null;
    ListNode smallStart=null, bigStart=null;

    while(A!=null)
    {
      if(A.val<B)
      {

        small=A;
        ListNode nextNode= null;
        small.next=nextNode;
        small=small.next;
      }

      if(A.val>=B)
      {
        big=A;
        ListNode nextNode = null;
        big.next=nextNode;
        big=big.next;
      }
      A=A.next;
    }

    printLinkedList(smallStart);
    printLinkedList(bigStart);
    return big;


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
    ParttitionList part = new ParttitionList();
    ListNode ln = new ListNode(5);
    ln.next=new ListNode(4);
    ln.next.next=new ListNode(3);
    ln.next.next.next= new ListNode(2);
    ln.next.next.next.next=new ListNode(9);
    ln.next.next.next.next.next=new ListNode(0);
    part.printLinkedList(ln);
    ListNode sorted=  part.partition2(ln,3);
    part.printLinkedList(sorted);
  }
}
