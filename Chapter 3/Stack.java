import java.util.EmptyStackException;

public class Stack
{
    private static class StackNode
    {
        private int data;
        private StackNode next;

        public StackNode(int data)
        {
            this.data = data;
        }
    }

    private StackNode top;

    public int pop()
    {
        if (top == null) throw new EmptyStackException();
        int item = top.data;
        top = top.next;
        return item;
    }

    public void push(int item)
    {
        StackNode node = new StackNode(item);
        node.next = top;
        top = node;
    }

    public int peek()
    {
        if (top == null) throw new EmptyStackException();
        return top.data;
    }

    public boolean isEmpty()
    {
        return top == null;
    }

    public void printStack()
    {
        StackNode node = top;
        while (node != null)
        {
            System.out.printf("%d -> ", node.data);
            node = node.next;
        }
    }
}