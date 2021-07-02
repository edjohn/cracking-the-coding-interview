class ArrayStack
{
    private int stackCount = 3;
    private int maxStackSize;
    private int[] stackElements;
    private int[] stackIndexes;

    public ArrayStack(int maxStackSize)
    {
        this.maxStackSize = maxStackSize;
        this.stackElements = new int[maxStackSize*stackCount];
        this.stackIndexes = new int[stackCount];
    }

    public void push(int stackNumber, int value)
    {
        stackIndexes[stackNumber]++;
        stackElements[indexOfTop(stackNumber)] = value;
    }

    public int pop(int stackNumber)
    {
        int topIndex = indexOfTop(stackNumber);
        int topValue = stackElements[topIndex];
        stackElements[topIndex] = 0;
        stackIndexes[stackNumber]--;
        return topValue;

    }

    public int peek(int stackNumber)
    {
        return stackElements[indexOfTop(stackNumber)];
    }

    public boolean isEmpty(int stackNumber)
    {
        return stackIndexes[stackNumber] == 0;
    }

    public boolean isFull(int stackNumber)
    {
        return stackIndexes[stackNumber] == maxStackSize;
    }

    private int indexOfTop(int stackNumber)
    {
        int arrayOffset = stackNumber*maxStackSize;
        int currentStackSize = stackIndexes[stackNumber];
        return arrayOffset + currentStackSize - 1;
    }
}
