package ga;

public class GA {

private static final double mutationRate = 0.015; 
private static final int routesnamentSize = 5; 
private static final boolean elitism = true;

public static Network evolveNetwork(Network net) 
{
Network newNetwork = new Network(net.networkSize(), false);
int elitismOffset = 0; 
if (elitism) 
{
newNetwork.saveRoutes(0, net.getFittest()); elitismOffset = 1;
}

for (int i = elitismOffset; i < newNetwork.networkSize(); i++) 
{
Routes parent1 = routesnamentSelection(net); 
Routes parent2 = routesnamentSelection(net);
Routes child = crossover(parent1, parent2);
newNetwork.saveRoutes(i, child);
}

for (int i = elitismOffset; i < newNetwork.networkSize(); i++) 
{ 
    mutate(newNetwork.getRoutes(i));
}
return newNetwork;
}

public static Routes crossover(Routes parent1, Routes parent2) 
{
Routes child = new Routes();
int startPos = (int) (Math.random() * parent1.routesSize()); 
int endPos = (int) (Math.random() * parent1.routesSize());

for (int i = 0; i < child.routesSize(); i++) 
{
    if (startPos < endPos && i > startPos && i < endPos) {
    child.setNode(i, parent1.getNode(i));
}

else if (startPos > endPos) 
{
    if (!(i < startPos && i > endPos)) { child.setNode(i, parent1.getNode(i));
}
}
}

for (int i = 0; i < parent2.routesSize(); i++) 
{
    if (!child.containsNode(parent2.getNode(i))) 
    {
        for (int ii = 0; ii < child.routesSize(); ii++) 
        {
            if (child.getNode(ii) == null) 
            { 
                child.setNode(ii, parent2.getNode(i)); 
                break;
            }

}
}
}
return child;
}
 
private static void mutate(Routes routes) 
{
    for(int routesPos1=0; routesPos1 < routes.routesSize(); routesPos1++)
    {
        if(Math.random() < mutationRate)
        {
            int routesPos2 = (int) (routes.routesSize() * Math.random());
            Node city1 = routes.getNode(routesPos1); 
            Node city2 = routes.getNode(routesPos2);
            routes.setNode(routesPos2, city1); 
            routes.setNode(routesPos1, city2);
        }

    }
}

private static Routes routesnamentSelection(Network net) 
{
    Network routesnament = new Network(routesnamentSize, false);
    for (int i = 0; i < routesnamentSize; i++) 
    {
        int randomId = (int) (Math.random() * net.networkSize()); 
        routesnament.saveRoutes(i, net.getRoutes(randomId));
    }
    Routes fittest = routesnament.getFittest(); return fittest;
}
}
