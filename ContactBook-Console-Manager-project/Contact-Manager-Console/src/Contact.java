import java.util.ArrayList;

public class Contact {
    private String name;
    private int age;
    private ArrayList<Contact> list = new ArrayList<Contact>();

    public Contact(String name, int age) {
        this.name = name;
        this.age = age;

    }

    public Contact() {

    }

    public String getName(int i) {
        return list.get(i).name;
    }

    public int getAge(int i) {
        return list.get(i).age;
    }

    public int getNumberOfElements() {
        return list.size();
    }

    public void addInList(String name, int age) {

        list.add(new Contact(name, age));
    }

    public void removeInList(int id) {
        list.remove(id);
    }

    public void setInList(int id, String name, int age) {
        list.set(id, new Contact(name, age));
    }

}
