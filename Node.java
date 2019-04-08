package ga;

public class Node 
{ 
    int x;
    int y;
    
    public Node()
    {
        this.x = (int)(Math.random()*200); this.y = (int)(Math.random()*200);
    }

    public Node(int x, int y)
    { 
        this.x = x;
        this.y = y;
    }




public int getX()
{ 
return this.x;
}





public int getY()
{ 
return this.y;
}




public double distanceTo(Node Node){

int xDistance = Math.abs(getX() - Node.getX()); int yDistance = Math.abs(getY() - Node.getY());
double distance = Math.sqrt( (xDistance*xDistance) + (yDistance*yDistance) );
return distance;
}



@Override

public String toString()
{ 
return getX()+", "+getY();
}

}
