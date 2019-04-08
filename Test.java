package ga;

import ga.RoutesManager;
import java.util.Scanner;

public class Test implements Runnable{
    public void run()
    {
        System.out.println("Enter the number of nodes : ");
        Scanner sc = new Scanner(System.in);
        int number_of_nodes = sc.nextInt();
        int[] numbers = new int[number_of_nodes];       
        for(int i = 0; i < numbers.length; i++)
        {
            int x = (int)(Math.random()*200 + 1);
            int y = (int)(Math.random()*200 + 1);
            ga.Node node = new ga.Node(x,y);
            RoutesManager.addNode(node);
        }
        Thread.yield();
    }
    
}
