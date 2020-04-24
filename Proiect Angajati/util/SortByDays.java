package util;

import model.Concediu;

import java.util.Comparator;

public class SortByDays implements Comparator<Concediu> {

    @Override
    public int compare(Concediu o1, Concediu o2) {
        return o1.getZileConcediu() - o2.getZileConcediu();
    }
}
