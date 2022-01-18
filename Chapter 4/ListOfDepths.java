import java.util.LinkedList;

class DepthListCreator
{
    public LinkedList<LinkedList<BinaryNode>> createDepthList(BinaryNode root)
    {
        LinkedList<LinkedList<BinaryNode>> depthList = new LinkedList<LinkedList<BinaryNode>>();
        markNodeDepths(root);
        fillDepthList(root, depthList);

        return depthList;
    }

    public void fillDepthList(BinaryNode root, LinkedList<LinkedList<BinaryNode>> depthList)
    {
        if (root == null)
        {
            return;
        }
        if (root.depth > depthList.size())
        {
            LinkedList<BinaryNode> list = new LinkedList<BinaryNode>();
            depthList.add(list);
        }
        depthList.get(root.depth - 1).add(root);
        fillDepthList(root.left, depthList);
        fillDepthList(root.right, depthList);
    }

    public void markNodeDepths(BinaryNode root)
    {
        markNodeDepths(root, 1);
    }

    public void markNodeDepths(BinaryNode root, int depth)
    {
        if (root == null)
        {
            return;
        }
        root.depth = depth;
        markNodeDepths(root.left, depth+1);
        markNodeDepths(root.right, depth+1);
    }

    public static void printTree(BinaryNode root)
    {
        if (root != null)
        {
            System.out.printf("Root is %d with depth %d, ", root.data, root.depth);
            if (root.left != null)
            {
                System.out.printf("Left branch is %d with depth %d, ", root.left.data, root.left.depth);
            }
            if (root.right != null)
            {
                System.out.printf("Right branch is %d with depth %d, ", root.right.data, root.right.depth);
            }
            System.out.printf("\n");
            printTree(root.left);
            printTree(root.right);
        }
    }

    public static void printDepthList(LinkedList<LinkedList<BinaryNode>> depthList)
    {
        for (LinkedList<BinaryNode> list : depthList)
        {
            for (BinaryNode node : list)
            {
                System.out.printf("%d -> ", node.data);
            }
            System.out.printf("\n");
        }
    }
}
