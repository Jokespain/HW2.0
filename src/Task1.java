class Student implements Cloneable {
    private String name;
    private int age;
    private String mobilePhone;
    public Student(String name, int age, String mobilePhone) {
        this.name = name;
        this.age = age;
        this.mobilePhone = mobilePhone;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getMobilePhone() {
        return mobilePhone;
    }
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
public class Task1 {
    public static void main(String[] args) {
        Student student1 = new Student("Инна", 23, "1567890");
        try {
            Student student2 = (Student) student1.clone();
            System.out.println("Студент 1:");
            System.out.println("Имя: " + student1.getName());
            System.out.println("Возраст: " + student1.getAge());
            System.out.println("Мобильный телефон: " + student1.getMobilePhone());

            System.out.println("\nСтудент 2 (клон):");
            System.out.println("Имя: " + student2.getName());
            System.out.println("Возраст: " + student2.getAge());
            System.out.println("Мобильный телефон: " + student2.getMobilePhone());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}