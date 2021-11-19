package Liang.chpt25;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author bobgils
 */
public class TestMyTreeMap {
    public static void main(String[] args) {
        // Create a map
        MyOrderedMap<String, Integer> map = new MyTreeMap<>();

        // add elements to map
        map.put("Smith", 30);
        map.put("Anderson", 31);
        map.put("Lewis", 29);
        map.put("Cook", 29);
        map.put("Smith", 65);
        map.put("Masterson", 55);

        System.out.println(map.size() + " entries in map: " + map);
        System.out.println("All the keys in the "+ map.keySet());
        System.out.println("All the values in the map "+ map.values());

        System.out.println("key-value mapping associated with the least key in this map: " + map.firstEntry());
        System.out.println("key-value mapping associated with the largest key in this map: " + map.lastEntry());
        System.out.println("key-value mapping associated with the least key greater than or equal to Johnson: " + map.ceilingEntry("Johnson"));
        System.out.println("key-value mapping associated with the greatest key less than or equal to Johnson: " + map.floorEntry("Johnson"));
        System.out.println("key-value mapping associated with the least key greater than or equal to Adams: " + map.ceilingEntry("Adams"));
        System.out.println("key-value mapping associated with the greatest key less than or equal to Adams: " + map.floorEntry("Adams"));
        System.out.println("key-value mapping associated with the least key greater than or equal to Zulu: " + map.ceilingEntry("Zulu"));
        System.out.println("key-value mapping associated with the greatest key less than or equal to Zulu: " + map.floorEntry("Zulu"));
        System.out.println("key-value mapping associated with the greatest key strictly less than  Lewis: " + map.lowerEntry("Lewis"));
        System.out.println("key-value mapping associated with the greatest key strictly greater than to Lewis: " + map.higherEntry("Lewis"));
        System.out.println("The age for " + "Lewis is " + map.get("Lewis"));

        System.out.println("Is Smith in the map? " + map.containsKey("Smith"));
        System.out.println("Is Jackson in the map? " + map.containsKey("Jackson"));
        System.out.println("Is age 33 in the map? " + map.containsValue(33));

        map.remove("Smith");

        System.out.println(map.size() + " entries in map after remove(\"Smith\"): " + map);
        System.out.println("The new first entry in the map"+ map.firstEntry());
        System.out.println("Is Smith in the map? " + map.containsKey("Smith"));
        System.out.println();
        System.out.println("The next greater key-value from Anderson is " + map.ceilingEntry("Anderson"));
        System.out.println("The next less key-value from Cook is " + map.floorEntry("Cook"));
        System.out.println();


        map.clear();
        System.out.println(map.size() + " entries in map after clear(): " + map);
    }
}
