package homework14;

public class Lesson11 {
    public static void main(String[] args) {
        int number = 10;
        int[] numbers = new int[5];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i * 10;
        }
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
        System.out.println();
        int[] numbers1 = {1, 2, 3};
        for (int i = 0; i < numbers1.length; i++) {
            System.out.println(numbers1[i]);
        }
    }
}

class Person {
    String name;
    int age;

    // Lesson 15
    void speak() {
        for (int i = 0; i < 3; i++) {
            System.out.println("Меня зовут " + name + "," + "мне " + age + "лет");
        }
    }

    void sayHello() {
        System.out.println("Привет!");
    }
}