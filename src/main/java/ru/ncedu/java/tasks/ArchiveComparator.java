package ru.ncedu.java.tasks;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Created by Антон on 26.03.2017.
 */
public class ArchiveComparator {
    private Map <Long,String> map;
    public ArchiveComparator(String archivePath) {
        try (ZipInputStream zin = new ZipInputStream(new FileInputStream(archivePath))) {
            ZipEntry entry;
            String name;
            long size;
            map = new LinkedHashMap<>();
            while ((entry = zin.getNextEntry()) != null) {

                name = entry.getName(); // получим название файла
                size = entry.getSize();  // получим его размер в байтах
                map.put(size,name);
            //    System.out.printf("Название: %s \t размер: %d \n", name, size);
            }
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
    }
    public Map<?,?> getMap (){
        return map;
    }
    public String compare(ArchiveComparator obj) throws Exception {
        Iterator<Map.Entry<Long, String>> iteratorOld = map.entrySet().iterator();
        Iterator<Map.Entry<Long, String>> iteratorNew = map.entrySet().iterator();
        Map<?, ?> objMap = obj.getMap();
        ArrayList<String> resultOld = new ArrayList<String>();
        ArrayList<String> resultNew = new ArrayList<String>();
        while (iteratorOld.hasNext()|| iteratorNew.hasNext())
        {
            if (iteratorOld.hasNext())
            {
                Map.Entry<Long, String> nextOld = iteratorOld.next();
                if (objMap.get(nextOld.getKey())==null)
                {
                    resultOld.add("- "+String.format("%1$"+50+"s",nextOld.getValue()));
                    resultNew.add("");
                }else
                {
                    if (nextOld.getValue().equals(objMap.get(nextOld.getKey())))
                    {
                        resultOld.add("* " + String.format("%1$" + 50 + "s", nextOld.getValue()));
                        resultNew.add("* " + String.format("%1$" + 50 + "s", objMap.get(nextOld.getKey())));
                    }else {
                        resultOld.add("? " + String.format("%1$" + 50 + "s", nextOld.getValue()));
                        resultNew.add("? " + String.format("%1$" + 50 + "s", objMap.get(nextOld.getKey())));
                    }
                }
            }
            if (iteratorNew.hasNext())
            {
                Map.Entry<Long, String> nextNew = iteratorNew.next();
                if (map.get(nextNew.getKey())==null)
                {
                    resultNew.add("+ "+String.format("%1$"+50+"s",nextNew.getValue()));
                    resultOld.add("");
                }
            }
        }
        StringBuilder compareResult = new StringBuilder();
        Iterator<String> iterator2 = resultNew.iterator();
        Iterator<String> iterator1 = resultOld.iterator();
        while (iterator1.hasNext()&&iterator2.hasNext()) {
            compareResult.append(iterator1.next() + " | " + iterator2.next() + "\n");
        }
        System.out.println(compareResult.toString());
        return null;
    }
}
