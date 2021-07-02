class MiddleDeleter
{
    void deleteMiddle(Node middle_node)
    {
        if (middle_node == null)
        {
            return;
        }
        
        Node current_node = middle_node;
        while (current_node.next != null)
        {
            current_node.data = current_node.next.data;
            if (current_node.next.next == null)
            {
                current_node.next = null;
            }
            else
            {
                current_node = current_node.next;
            }
        }
    }
}