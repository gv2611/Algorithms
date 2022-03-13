public class SortBinaryLinkedList {


  public void printLinkedList(ListNode node)
  {
    while(node!=null)
    {
      System.out.print(node.val+" --> ");
      node=node.next;

    }
    System.out.println("null");
  }

  public ListNode sortBinaryLL(ListNode A) {
    int countZero=0;
    int countOnes=0;
    ListNode backup=A;

    while(A!=null) {
      if (A.val == 0) {
        countZero++;
      } else if (A.val == 1) {
        countOnes++;
      }
      A=A.next;
    }
    A=backup;
      while (countZero != 0 && A!=null) {
        A.val=0;
        A=A.next;
        countZero--;
      }
    while (countOnes != 0 && A!=null) {
      A.val=1;
      A=A.next;
      countOnes--;
    }


    return backup;

  }
  public static void main(String[] args)
  {
    SortBinaryLinkedList sbl = new SortBinaryLinkedList();
    ListNode ln = new ListNode(1);
    ln.next=new ListNode(0);
    ln.next.next=new ListNode(1);
    ln.next.next.next= new ListNode(1);
    ln.next.next.next.next=new ListNode(0);
    sbl.printLinkedList(ln);

    ListNode sortted=  sbl.sortBinaryLL(ln);
    sbl.printLinkedList(sortted);


  }
}
