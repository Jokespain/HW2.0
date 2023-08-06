package Homework6;

public class Task2 {
    public static void main(String[] args) {
        KeyValueStorage<String, Integer> storage = new KeyValueStorage<>();

        storage.put("one", 1);
        storage.put("two", 2);
        storage.put("three", 3);
        System.out.println(storage.get("one"));
        System.out.println(storage.get("three"));
        System.out.println(storage.containsKey("two"));
        System.out.println(storage.containsKey("four"));
        storage.remove("two");
        storage.clear();
    }
}