package ru.ncedu.java.tasks;

import org.junit.Test;

/**
 * Created by Антон on 26.03.2017.
 */
public class ArchiveComparatorTest {


    @Test
    public void getMap() throws Exception {
        ArchiveComparator obj1 = new ArchiveComparator("C:\\buf1.zip");
        ArchiveComparator obj2 = new ArchiveComparator("C:\\buf2.zip");
        obj1.compare(obj2);
 //       System.out.println( map.toString());
    }

}