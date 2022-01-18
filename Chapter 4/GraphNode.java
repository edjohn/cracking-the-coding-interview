import java.util.ArrayList;

class Graph
{
    public ArrayList<Node> nodes = new ArrayList<Node>();
}

class Node
{
    public String name;
    public ArrayList<Node> children;
    public boolean visited;

    public Node(String name)
    {
        this.name = name;
        this.children = new ArrayList<Node>();
        this.visited = false;
    }

    public void printChildren()
    {
        System.out.printf("Node %s has children: ", name);
        for (Node child : children) 
        {
            System.out.printf("%s, ", child.name);
        }
        System.out.println("\n");
    }
}