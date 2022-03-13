public class KthNodeFromMiddle {

  public int kthNodeFromMiddle(ListNode A, int B) {

    int len= findLength(A);
    int middle=(len/2)+1;
    int element = middle-B;
    int count=1;
    int val=0;

    if(element<0)
      return -1;

    while(count!=len)
    {
      if(count==element)
      {
        val=A.val;
      }
      A=A.next;
      count++;
    }
    return val;
  }

  private int findLength(ListNode A) {
    int count=0;
    while(A!=null) {
      count++;
      A=A.next;
    }
    return count;
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
    KthNodeFromMiddle kthMiddle = new KthNodeFromMiddle();
    ListNode ln = new ListNode(789);
//    ln.next=new ListNode(14);
//    ln.next.next=new ListNode(6);
//    ln.next.next.next= new ListNode(16);
//    ln.next.next.next.next=new ListNode(4);
//    ln.next.next.next.next.next=new ListNode(10);

    kthMiddle.printLinkedList(ln);
    int rev=kthMiddle.kthNodeFromMiddle(ln, 1);
  //  kthMiddle.printLinkedList(rev);
    System.out.println(rev);

  }
}
