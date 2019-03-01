package test.java.kylindc.model.arraylistmap;

import main.java.kylindc.model.arraylistmap.ArrayListMap;

import java.util.Map;

public class ArrayListMapTest {
    public static void main(String[] args) {
        Map<String, String> arrayListMap = new ArrayListMap();
        arrayListMap.put("ni", "hao");
        arrayListMap.put("ni", "ha");
        System.out.println(arrayListMap.get("ni"));
        System.out.println(arrayListMap.containsKey("ni"));
        System.out.println(arrayListMap.containsValue("ha"));
        System.out.println(arrayListMap.isEmpty());
        arrayListMap.remove("ni");
        System.out.println(arrayListMap.isEmpty());
    }
}
