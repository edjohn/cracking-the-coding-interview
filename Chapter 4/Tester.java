import java.util.LinkedList;

public class Tester {
    public static void main(String[] args)
    {
        BalanceChecker balanceChecker = new BalanceChecker();
        BinaryNode one = new BinaryNode(1);
        BinaryNode two = new BinaryNode(2);
        BinaryNode three = new BinaryNode(3);
        BinaryNode four = new BinaryNode(4);
        one.left = two;
        one.right = three;
        three.left = four;
        System.out.println(balanceChecker.isBalanced(one));
    }
}
