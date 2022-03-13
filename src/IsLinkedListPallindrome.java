import java.util.Stack;

public class IsLinkedListPallindrome {
  static int lPalin(ListNode head) {
    Stack<Integer> listNodes = new Stack<>();
    int check=0;
    if(head==null)
      return 0;

    ListNode element= head;

    while(head!=null)
    {
      listNodes.push(head.val);
      head=head.next;
    }
System.out.println(listNodes);
    while(element!=null)
    {
      int elem=listNodes.pop();
      if(elem==element.val)
      {
        check=1;
      }
      else {
        check = 0;
        break;
      }
      element=element.next;

    }
return check;

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
    IsLinkedListPallindrome palin = new IsLinkedListPallindrome();
    ListNode ln = new ListNode(1);
    ln.next=new ListNode(2);
    ln.next.next=new ListNode(3);
    ln.next.next.next= new ListNode(2);
    ln.next.next.next.next=new ListNode(1);
    palin.printLinkedList(ln);
    int rev=palin.lPalin(ln);
   // palin.printLinkedList(rev);
    System.out.println(rev);

  }

}
