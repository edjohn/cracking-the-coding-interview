public class Palindrome
{
    static boolean isPalindrome(Node head)
    {
        Node reversed_list_head = createReversedList(head);
        return isSameList(head, reversed_list_head);
    }

    static Node createReversedList(Node head)
    {
        Node original_list_current_node = head;
        Node reversed_list_current_node = new Node(head.data);
        while (original_list_current_node.next != null)
        {
            Node reversed_list_next_node = new Node(original_list_current_node.next.data);
            reversed_list_next_node.next = reversed_list_current_node;
            original_list_current_node = original_list_current_node.next;
            reversed_list_current_node = reversed_list_next_node;
        }
        return reversed_list_current_node;
    }

    static boolean isSameList(Node first_head, Node second_head)
    {
        Node first_list_current_node = first_head;
        Node second_list_current_node = second_head;

        while (first_list_current_node != null)
        {
            if (first_list_current_node.data != second_list_current_node.data)
            {
                return false;
            }
            first_list_current_node = first_list_current_node.next;
            second_list_current_node = second_list_current_node.next;
        }
        return true;
    }
}