package ga;
import java.io.*;
import java.util.Scanner;

public class adhoc_GA {

public static void main(String[] args) {

Test t = new Test();
Thread r = new Thread(t);
r.run();

long startTime = System.nanoTime();

Network net = new Network(50, true);

System.out.println("Initial distance: " + net.getFittest().getDistance());
net = GA.evolveNetwork(net); 
for (int i = 0; i < 100; i++) 
{
net = GA.evolveNetwork(net);
}

System.out.println("Finished");

System.out.println("Final distance: " + net.getFittest().getDistance()); 
System.out.println("Solution:");
System.out.println(net.getFittest());
long endTime   = System.nanoTime();
long totalTime = endTime - startTime;
System.out.println(totalTime+" nanosecond");
System.out.println(totalTime/1000000000.0+" second");
}

}
