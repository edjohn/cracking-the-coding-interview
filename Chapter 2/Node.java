class Node
{
    Node next = null;
    int data;

    Node(int value)
    {
        data = value;
    }

    void append(int value)
    {
        Node new_node = new Node(value);
        Node current_node = this;
        while (current_node.next != null)
        {
            current_node = current_node.next;
        }
        current_node.next = new_node;
    }

    static void printList(Node head)
    {
        Node current_node = head;
        while (current_node != null)
        {
            System.out.printf("%d -> ", current_node.data);
            current_node = current_node.next;
        }
        System.out.println("\n");
    }

    static Node createList(int ...values)
    {
        Node head = new Node(values[0]);
        for (int i = 1; i < values.length; i++)
        {
            head.append(values[i]);
        }
        return head;
    }
}