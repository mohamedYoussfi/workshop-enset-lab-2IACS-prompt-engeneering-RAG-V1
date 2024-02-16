// Create new public class Customer
public class Customer {
    // id attribute
    private int id;
    // name attribute
    private String name;
    // age attribute
    private int age;

    // Constructor
    public Customer(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // default constructor
    public Customer() {
    }

    // getter and setter methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    // toString method
    @Override
    public String toString() {
        return "Customer [id=" + id + ", name=" + name + ", age=" + age + "]";
    }
}