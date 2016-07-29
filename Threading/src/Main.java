import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        int i;
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> primeList = new ArrayList<Integer>();
        Random rand = new Random();

        for(i = 0; i < 100; i++)
            list.add(rand.nextInt(1000));

        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        ArrayList<Integer> list3 = new ArrayList<Integer>();

        i = 0;
        while(i < 100) {
            if(i<100) {
                list1.add(list.get(i));
                i++;
            }
            if(i<100) {
                list2.add(list.get(i));
                i++;
            }
            if(i<100) {
                list3.add(list.get(i));
                i++;
            }
        }

        PrimeList p1 = new PrimeList(list1, primeList);
        PrimeList p2 = new PrimeList(list2, primeList);
        PrimeList p3 = new PrimeList(list3, primeList);

        p1.start();
        p2.start();
        p3.start();

        p1.join();
        p2.join();
        p3.join();
    }
}
