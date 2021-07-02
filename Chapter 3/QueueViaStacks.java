class MyQueue
{
    private Stack queueStack;
    private Stack bufferStack;

    public MyQueue()
    {
        queueStack = new Stack();
        bufferStack = new Stack();
    }

    public void add(int value)
    {
        while (!queueStack.isEmpty())
        {
            bufferStack.push(queueStack.pop());
        }
        queueStack.push(value);
        while (!bufferStack.isEmpty())
        {
            int bufferValue = bufferStack.pop();
            queueStack.push(bufferValue);
        }
    }

    public int remove()
    {
        return queueStack.pop();
    }

    public int peek()
    {
        return queueStack.peek();
    }

    public boolean isEmpty()
    {
        return queueStack.isEmpty();
    }


    
}
