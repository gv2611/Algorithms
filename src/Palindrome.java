public class Palindrome {

  public static void main(String[] args)
  {
    Palindrome palin = new Palindrome();
    boolean check=palin.checkIfPalindrome(2002);
    System.out.println(check);

  }

  private boolean checkIfPalindrome(int n) {

    if(n/10 < 1)
    {
      return true;
    }
    checkIfPalindrome(n%10);
    return false;
  }
}
