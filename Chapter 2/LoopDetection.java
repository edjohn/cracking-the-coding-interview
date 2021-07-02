class LoopDetection
{
    static Node findLoopNode(Node head)
    {
        Node slow_pointer = head;
        Node fast_pointer = head;
        while (fast_pointer != null && fast_pointer.next != null)
        {
            slow_pointer = slow_pointer.next;
            fast_pointer = fast_pointer.next.next;
            if (slow_pointer == fast_pointer)
            {
                slow_pointer = head;
                while (slow_pointer != fast_pointer)
                {
                    slow_pointer = slow_pointer.next;
                    fast_pointer = fast_pointer.next;
                }
                return slow_pointer;
            }
        }
        return null;
    }
}