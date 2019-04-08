package ga;
import java.util.ArrayList; 
import java.util.Collections;

public class Routes
{
    private ArrayList routes = new ArrayList<Node>();
    private double fitness = 0; 
    private int distance = 0;

    public Routes()
    {
        for (int i = 0; i < RoutesManager.numberOfNodes(); i++) 
        { 
            routes.add(null);
        }
    }

    public Routes(ArrayList routes)
    { 
        this.routes = routes;
    }
 
    public void generateIndividual() 
    {
        for (int nodeIndex = 0; nodeIndex < RoutesManager.numberOfNodes(); nodeIndex++) 
        { 
            setNode(nodeIndex, RoutesManager.getNode(nodeIndex));
        }

        Collections.shuffle(routes);
    }

    public Node getNode(int routesPosition) 
    {  
        return (Node)routes.get(routesPosition);
    }

    public void setNode(int routesPosition, Node node) 
    { 
        routes.set(routesPosition, node);
        fitness = 0;
        distance = 0;
    }

    public double getFitness() 
    { 
        if (fitness == 0) 
        {
            fitness = 1/(double)getDistance();
        }
        return fitness;
    }

    
    public int getDistance(){ if (distance == 0) 
    {
        int routesDistance = 0;
        for (int nodeIndex=0; nodeIndex < routesSize(); nodeIndex++) 
        {
            Node fromNode = getNode(nodeIndex);
            Node destinationNode;
            if(nodeIndex+1 < routesSize())
            { 
                destinationNode = getNode(nodeIndex+1);
            }
            else
            {
                destinationNode = getNode(0);
            }
            routesDistance += fromNode.distanceTo(destinationNode);
        }
        distance = routesDistance;
    }

return distance;

}
 



public int routesSize() { return routes.size();
}




public boolean containsNode(Node node){ return routes.contains(node);
}


@Override

public String toString() { String geneString = "|";
for (int i = 0; i < routesSize(); i++) { geneString += getNode(i)+"|";
}

return geneString;

}

}
 
