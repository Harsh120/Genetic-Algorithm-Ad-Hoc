package ga;

public class Network {

    Routes[] tours;

    public Network(int networkSize, boolean initialise) 
    { 
        tours = new Routes[networkSize];
        if (initialise)
            {
                for (int i = 0; i < networkSize(); i++) 
                { 
                    Routes newRoutes = new Routes(); 
                    newRoutes.generateIndividual(); 
                    saveRoutes(i, newRoutes);
                }
            }
    }
public void saveRoutes(int index, Routes tour) 
{ 
    tours[index] = tour;
}

public Routes getRoutes(int index) 
{ 
    return tours[index];
}

public Routes getFittest() 
{ 
    Routes fittest = tours[0];

for (int i = 1; i < networkSize(); i++) 
{
    if (fittest.getFitness() <= getRoutes(i).getFitness()) 
        { 
            fittest = getRoutes(i);
        }

}
return fittest;
}


public int networkSize() 
{
    return tours.length;
}

}