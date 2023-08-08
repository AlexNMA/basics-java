public class Contact {
    private int id;
    private String name;
    private int age;

    public Contact(int id, String name, int age) {
        this.name = name;
        this.age = age;
        this.id = id;

    }

    public Contact() {

    }

    public Contact(String name, int age) {
        this.name = name;
        this.age = age;

    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}