import java.util.EmptyStackException;

class MinimumStack
{
    private static class MinimumStackNode
    {
        private int data;
        private MinimumStackNode next;
        private MinimumStackNode substackMinimum;

        public MinimumStackNode(int data)
        {
            this.data = data;
        }
    }
    private MinimumStackNode top;
    private MinimumStackNode minimum;

    public void push(int data)
    {
        MinimumStackNode node = new MinimumStackNode(data);
        if (minimum == null || node.data < minimum.data)
        {
            node.substackMinimum = minimum;
            minimum = node;
        }
        node.next = top;
        top = node;
    }

    public int pop()
    {
        if (top == null) throw new EmptyStackException();
        if (top == minimum)
        {
            minimum = top.substackMinimum;
        }
        int topData = top.data;
        top = top.next;
        return topData;
    }

    public int min()
    {
        if (minimum == null) throw new EmptyStackException();
        return minimum.data;
    }

    public int peek()
    {
        if (top == null) throw new EmptyStackException();
        return top.data;
    }

    public void printStack()
    {
        MinimumStackNode current = top;
        while (current != null)
        {
            System.out.printf("%d -> ", current.data);
            current = current.next;
        }
        System.out.println("\n");
    }
}
