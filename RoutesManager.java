package ga;


import java.util.ArrayList;


public class RoutesManager {

private static ArrayList destinationNodes = new ArrayList<Node>();

public static void addNode(Node node) 
{ 
    destinationNodes.add(node);
}


public static Node getNode(int index)
{ 
    return (Node)destinationNodes.get(index);
}

public static int numberOfNodes()
{ 
    return destinationNodes.size();
}

}
