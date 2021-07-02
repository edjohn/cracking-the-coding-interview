import java.util.EmptyStackException;
import java.util.ArrayList;

class SetOfStacks
{
    ArrayList<Stack> stacks = new ArrayList<Stack>();
    private int capacity;
    private Stack lastStack;

    public SetOfStacks(int capacity)
    {
        this.capacity = capacity;
    }

    public void push(int value)
    {
        if (lastStack == null || lastStack.isFull())
        {
            Stack stack = new Stack(capacity);
            stack.push(value);
            stacks.add(stack);
            lastStack = stack;
        }
        else
        {
            lastStack.push(value);
        }
    }

    public int pop()
    {
        if (lastStack == null) throw new EmptyStackException();

        int value = lastStack.pop();
        if (lastStack.isEmpty() && stacks.size() >= 2)
        {
            stacks.remove(stacks.size() - 1);
            lastStack = stacks.get(stacks.size() - 1);
        }
        return value;
    }

    public int popAt(int index)
    {
        Stack stack = stacks.get(index);
        int value = stack.pop();
        if (stack.isEmpty())
        {
            stacks.remove(index);
            shiftStacksAbove(index);
        }
        return value;
    }

    private void shiftStacksAbove(int index)
    {
        for (int i = index+1; i < stacks.size() - 1; i++)
        {
            Stack stack = stacks.get(i);
            Stack nextStack = stacks.get(i+1);

            stacks.set(i-1, stack);
            stacks.set(i, nextStack);
        }
    }

}
