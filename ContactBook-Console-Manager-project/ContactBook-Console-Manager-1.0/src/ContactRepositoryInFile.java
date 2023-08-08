import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ContactRepositoryInFile {

    private FileInputStream fileInputStream;
    private FileOutputStream fileOutputStream;
    private String filepath;

    public ContactRepositoryInFile(String filepath) throws IOException {
        this.filepath = filepath;
    }

    public void addInList(Contact contact) throws IOException {
        fileOutputStream = new FileOutputStream(filepath, true);
        String serializedContact = lastId() + " " + contact.getName() + " " + contact.getAge() + "\n";
        byte[] serializedContactBytes = serializedContact.getBytes();
        fileOutputStream.write(serializedContactBytes);
        fileOutputStream.flush();
        fileOutputStream.close();
    }

    public void removeFromList(int id) throws IOException {
        ArrayList<Contact> contacts = getAllContacts();
        ArrayList<Contact> newContacts = new ArrayList<>();
        File file = new File(filepath);
        file.delete();
        file.createNewFile();
        for (Contact contact : contacts) {
            if (contact.getId() != id) {
                newContacts.add(contact);
            }
        }
        setAllContacts(newContacts);
    }

    public void setInList(Contact contact) throws IOException {
        ArrayList<Contact> contacts = getAllContacts();
        ArrayList<Contact> newContacts = new ArrayList<>();
        File file = new File(filepath);
        file.delete();
        file.createNewFile();
        for (Contact contactList : contacts) {
            if (contactList.getId() == contact.getId()) {
                newContacts.add(new Contact(contactList.getId(), contact.getName(), contact.getAge()));
            } else if (contactList.getId() != contact.getId()) {
                newContacts.add(contactList);
            }

        }
        setAllContacts(newContacts);
    }

    public Contact getFromList(int id) throws IOException {
        ArrayList<Contact> contacts = getAllContacts();
        Contact getContacts = new Contact();
        for (Contact contact : contacts) {
            if (contact.getId() == id) {
                getContacts = contact;
            }
        }
        return getContacts;
    }

    public ArrayList<Contact> getAllContacts() throws IOException {
        ArrayList<Contact> contacts = new ArrayList<>();
        fileInputStream = new FileInputStream(new File(filepath));

        while (fileInputStream.available() > 0) {
            String line = "";
            int readByte;
            do {
                readByte = fileInputStream.read();
                line += (char) readByte;
            } while (readByte != '\n' && readByte != -1);

            String[] tokens = line.split(" ");

            int contactId = Integer.parseInt(tokens[0].trim());
            String name = tokens[1];
            int age = Integer.parseInt(tokens[2].trim());

            Contact contact = new Contact(contactId, name, age);
            contacts.add(contact);
        }
        fileInputStream.close();
        return contacts;
    }

    private void setAllContacts(ArrayList<Contact> contacts) throws IOException {
        fileOutputStream = new FileOutputStream(filepath);
        for (Contact contact : contacts) {
            int id = contact.getId();
            String serializedContact = id + " " + contact.getName() + " " + contact.getAge() + "\n";
            byte[] serializedContactBytes = serializedContact.getBytes();
            fileOutputStream.write(serializedContactBytes);
        }
        fileOutputStream.flush();
        fileOutputStream.close();
    }

    public int lastId() throws IOException {
        ArrayList<Contact> contacts = getAllContacts();
        int lastID = 0;
        for (Contact contact : contacts) {
            if (lastID <= contact.getId()) {
                lastID = contact.getId() + 1;
            }
        }
        return lastID;
    }

}
