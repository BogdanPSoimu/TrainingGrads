import java.util.ArrayList;

public class PrimeList extends Thread {
    private ArrayList<Integer> list;
    private ArrayList<Integer> primeList;

    public PrimeList() {}

    public PrimeList(ArrayList<Integer> list, ArrayList<Integer> primeList) {
        this.list = list;
        this.primeList = primeList;
    }

    public ArrayList<Integer> getList() {
        return list;
    }

    public void setList(ArrayList<Integer> list) {
        this.list = list;
    }

    public ArrayList<Integer> getPrimeList() {
        return primeList;
    }

    public void setPrimeList(ArrayList<Integer> primeList) {
        this.primeList = primeList;
    }

    public boolean isPrime(int n) {
        for(int i = 2; i <= n/2; i++) {
            if(n % i == 0)
                return false;
        }
        return true;
    }

    public synchronized void completeList() {
        for(int i = 0; i < list.size(); i++) {
            if(isPrime(list.get(i)))
                primeList.add(list.get(i));
        }
    }

    @Override
    public void run() {
        completeList();
        System.out.println(getPrimeList().toString());
    }
}
