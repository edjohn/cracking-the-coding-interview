import java.util.ArrayList;

class RouteChecker
{
    ArrayList<Boolean> truthValues = new ArrayList<Boolean>();
    public boolean routeExistsBetween(Node firstNode, Node secondNode)
    {

        if (firstNode == null)
        {
            return false;
        }
        visit(firstNode);
        for (Node child : firstNode.children)
        {
            if (child == secondNode)
            {
                return true;
            }
            if (child.visited == false)
            {
                truthValues.add(routeExistsBetween(child, secondNode));
            }
        }
        return truthValues.contains(true);
    }

    public void visit(Node node)
    {
        node.visited = true;
    }
}
