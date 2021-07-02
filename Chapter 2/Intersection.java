class IntersectionChecker
{
    static Node findIntersectingNode(Node first_head, Node second_head)
    {
        Node first_list_current_node = first_head;
        Node second_list_current_node = second_head;
        int first_list_passes = 1;
        int second_list_passes = 1;
        while (first_list_current_node.next != null || second_list_current_node.next != null)
        {
            if (first_list_current_node.next != null)
            {
                first_list_current_node = first_list_current_node.next;
                first_list_passes++;
            }
            if (second_list_current_node.next != null)
            {
                second_list_current_node = second_list_current_node.next;
                second_list_passes++;
            }
        }

        if (first_list_current_node != second_list_current_node)
        {
            System.out.println("Lists do not intersect\n");
            return null;
        }

       int passes_to_reach_intersection = first_list_passes <= second_list_passes ? first_list_passes : second_list_passes;
       Node current_node = first_list_passes <= second_list_passes ? second_head : first_head; 
       for (int i = 1; i < passes_to_reach_intersection; i++)
       {
           current_node = current_node.next;
       }
       return current_node;
    }
}

