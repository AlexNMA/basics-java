import java.util.ArrayList;

public class ContactRepositoryInMemory {
    private ArrayList<Contact> list;

    public ContactRepositoryInMemory(String filepath) {
        list = new ArrayList<Contact>();
    }

    public void addInList(Contact contact) {
        list.add(contact);
    }

    public void removeFromList(int id) {
        list.remove(id);
    }

    public void setInList(int id, Contact contact) {
        list.set(id, contact);
    }

    public Contact getFromList(int id) {
        return list.get(id);
    }

    public ArrayList<Contact> getList() {
        return list;
    }

    public int getNumberOfElements() {
        return list.size();
    }
}
