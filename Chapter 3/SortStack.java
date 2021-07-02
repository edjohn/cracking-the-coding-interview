public void sortStack()
{
    StackNode node = top;
    Stack buffer = new Stack();
    while (node != null)
    {
        StackNode maximum = node;
        StackNode maximumPrevNode = null;
        StackNode subNode = node.next;
        StackNode prevNode = node;
        while (subNode != null)
        {
            if (subNode.data > maximum.data)
            {
                maximum = subNode;
                maximumPrevNode = prevNode;
            }
            prevNode = subNode;
            subNode = subNode.next;
        }
        if (maximumPrevNode != null)
        {
            maximumPrevNode.next = maximum.next;
        }
        else
        {
            node = node.next;
        }
        buffer.push(maximum.data);
    }
    top = buffer.top;
}