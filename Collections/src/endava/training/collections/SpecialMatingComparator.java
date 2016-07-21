package endava.training.collections;


import java.util.Comparator;

public class SpecialMatingComparator implements Comparator<Penguin> {
    //number of mating partners, average age of mating partners, name comparator
    @Override
    public int compare(Penguin p1, Penguin p2) {
        if (p1.getMatingPartners().size() == p2.getMatingPartners().size())
            if (Double.compare(p1.mateAverageAge(), p2.mateAverageAge()) == 0)
                return p1.getName().compareTo(p2.getName());
            else return Double.compare(p1.mateAverageAge(), p2.mateAverageAge());
        else if (p1.getMatingPartners().size() > p2.getMatingPartners().size())
            return 1;
        else return -1;

    }
}
