class SumListsMaker
{
    static int SumListsReverseOrder(Node first_head, Node second_head)
    {
        int sum = 0;
        int carry_value = 0;
        int multiplier = 1;
        Node first_list_current_node = first_head;
        Node second_list_current_node = second_head;
        while (first_list_current_node != null || second_list_current_node != null)
        {
            if (first_list_current_node == null)
            {
                sum += (second_list_current_node.data + carry_value) * multiplier;
                carry_value = 0;
                second_list_current_node = second_list_current_node.next;

            }
            else if (second_list_current_node == null)
            {
                sum += (first_list_current_node.data + carry_value) * multiplier;
                carry_value = 0;
                first_list_current_node = first_list_current_node.next;
            }
            else
            {
                int summed_digit = first_list_current_node.data + second_list_current_node.data + carry_value;
                if (summed_digit >= 10)
                {
                    carry_value = 1;
                }
                else
                {
                    carry_value = 0;
                }
                sum += (summed_digit % 10) * multiplier;
                first_list_current_node = first_list_current_node.next;
                second_list_current_node = second_list_current_node.next;
            }
            multiplier *= 10;
        }
        return carry_value == 1 ? sum + multiplier : sum;
    }

    static int SumListsForwardOrder(Node first_head, Node second_head)
    {
        int sum = 0;
        int multiplier = 0;
        Node first_list_current_node = first_head;
        Node second_list_current_node = second_head;
        while (first_list_current_node != null || second_list_current_node != null)
        {
            if (first_list_current_node == null)
            {
                Node new_head = new Node(0);
                new_head.next = first_head;
                first_head = new_head;
                second_list_current_node = second_list_current_node.next;
            }
            if (second_list_current_node == null)
            {
                Node new_head = new Node(0);
                new_head.next = second_head;
                second_head = new_head;
                first_list_current_node = first_list_current_node.next;
            }
            else
            {
                first_list_current_node = first_list_current_node.next;
                second_list_current_node = second_list_current_node.next;
            }
            multiplier = (multiplier == 0 ? 1 : multiplier * 10);
        }

        first_list_current_node = first_head;
        second_list_current_node = second_head;
        while (first_list_current_node != null)
        {
            int summed_digit = first_list_current_node.data + second_list_current_node.data;
            if (summed_digit >= 10)
            {
                sum += multiplier*10;
            }
            sum += summed_digit % 10 * multiplier;
            first_list_current_node = first_list_current_node.next;
            second_list_current_node = second_list_current_node.next;
            multiplier /= 10;
        }
        return sum;
    }
}

