class ListPartitioner
{
    Node partition(Node head, int value)
    {
        if (head == null || head.next == null)
        {
            return head;
        }

        Node previous_node = head;
        Node current_node = head.next;
        while (current_node != null)
        {
            Node next_node = current_node.next;
            if (current_node.data < value)
            {
                previous_node.next = next_node;
                current_node.next = head.next;
                head.next = current_node;
            }
            else
            {
                previous_node = current_node;
            }
            current_node = next_node;
        }

        if (head.data >= value)
        {
            Node second_node = head.next;
            previous_node.next = head;
            head.next = null;
            return second_node;
        }
        return head;
    }
}