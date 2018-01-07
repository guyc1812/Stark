package com.avengers.tony.JavaBasic.comparator;

import com.avengers.tony.JavaBasic.comparator.Avenger;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service("myComparator")
public class MyComparator {

    /**
     * JAVA 7
     * Comparator<Avenger> ComparatorDemo = new Comparator<Avenger>(){
     * public int compare(UTRSuite a1, UTRSuite a2) {
     * return a1.getName().compareTo(a2.getName());
     * }
     * };
     * <p>
     * JAVA 8
     * Comparator<Avenger> comparatorByName = Comparator.comparing(Avenger::getName);
     */

    public List<Avenger> AvengersByName(List<Avenger> avengers) {

        Comparator<Avenger> comparatorByName = Comparator.comparing(Avenger::getName);
        avengers.sort(comparatorByName);
        return avengers;

    }

    public List<Avenger> AvengersByNameReversed(List<Avenger> avengers) {

        Comparator<Avenger> comparatorByName = Comparator.comparing(Avenger::getName).reversed();
        avengers.sort(comparatorByName);
        return avengers;

    }

    public List<Avenger> AvengersByAge(List<Avenger> avengers) {

        Comparator<Avenger> comparatorByAge = Comparator.comparing(Avenger::getAge);
        avengers.sort(comparatorByAge);
        return avengers;

    }

    public List<Avenger> AvengersByAgeReversed(List<Avenger> avengers) {

        Comparator<Avenger> comparatorByAge = Comparator.comparing(Avenger::getAge).reversed();
        avengers.sort(comparatorByAge);
        return avengers;

    }

}
