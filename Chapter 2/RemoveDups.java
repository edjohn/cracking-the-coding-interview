import java.util.HashSet;

class DupeRemover
{
    static void removeDupesWithoutBuffer(Node head)
    {
        while (head != null)
        {
            Node prev_node = head;
            Node current_node = head.next;
            int filter_value = head.data;
            while (current_node != null)
            {
                if (current_node.data == filter_value)
                {
                    prev_node.next = current_node.next;
                }
                else
                {
                    prev_node = current_node;
                }
                current_node = current_node.next;
            }
            head = head.next;
        }
    }

    static void removeDupesWithBuffer(Node head)
    {
        HashSet<Integer> set = new HashSet<Integer>();

        if (head == null)
        {
            return;
        }
        Node previous_node = head;
        Node current_node = head.next;
        set.add(previous_node.data);
        while (current_node != null)
        {
            if (set.contains(current_node.data))
            {
                previous_node.next = current_node.next;
            }
            else
            {
                set.add(current_node.data);
                previous_node = current_node;
            }
            current_node = current_node.next;
        }
    }
}