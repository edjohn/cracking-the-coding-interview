class KthFromLastFinder
{
    Node findKthFromLast(Node head, int k)
    {
        if (k < 0)
        {
            return head;
        }

        int node_count = 0;
        Node current_node = head;
        while (current_node != null)
        {
            node_count++;
            current_node = current_node.next;
        }

        if (k >= node_count)
        {
            return head;
        }

        int iteration_limit = node_count - k - 1;
        while (iteration_limit > 0)
        {
            head = head.next;
            iteration_limit--;
        }
        return head;
    }
}
