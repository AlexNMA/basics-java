import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) throws InterruptedException, IOException {

        Console console = System.console();
        ContactRepositoryInFile contactRepository;
        contactRepository = new ContactRepositoryInFile("database.txt");
        int option;
        boolean CONTINUE = true;
        boolean removeAgreement = false;
        boolean redirected = false;
        Scanner input = new Scanner(System.in);

        while (CONTINUE) {

            if (redirected) {
                option = 2;
                redirected = false;
            } else {
                option = menu(input);
            }

            switch (option) {

                case 1: {
                    System.out.println("Enter the name: ");
                    String name = console.readLine();
                    System.out.println("Enter the age: ");
                    int age = Integer.parseInt(console.readLine());
                    Contact contact = new Contact(contactRepository.lastId(), name, age);
                    contactRepository.addInList(contact);
                }
                break;

                case 2: {
                    ArrayList<Contact> contacts = new ArrayList<>(contactRepository.getAllContacts());
                    for (Contact contact : contacts) {
                        System.out.println(contact.getId() + ") " + contact.getName() + " , " + contact.getAge() + " years old");
                    }
                }
                break;

                case 3: {
                    System.out.println("Enter the name: ");
                    String nameEdit = console.readLine();
                    System.out.println("Enter the age: ");
                    int ageEdit = Integer.parseInt(console.readLine());
                    System.out.println("Enter ID ");
                    int id = Integer.parseInt(console.readLine());
                    Contact contact = new Contact(id, nameEdit, ageEdit);
                    contactRepository.setInList(contact);
                    System.out.println(contact.getName() + " " + contact.getAge() + " years old has updated");
                }
                break;

                case 4: {
                    String y = "y";
                    System.out.println("To delete a contract write the contract id.");
                    System.out.println("To find out the contract id on the view page");
                    System.out.println("You want to be redirected to the viewing page? Press yes = y, no = any key");
                    String tempString;
                    tempString = console.readLine();
                    if (tempString.equals(y)) {
                        redirected = true;
                        break;
                    }
                    System.out.println("Write the id of the contract you want to delete");
                    int removeID = Integer.parseInt(console.readLine());
                    System.out.println("Are you sure you want to delete " + contactRepository.getFromList(removeID).getName() + " ?");
                    System.out.println("yes = y, no = any key");
                    tempString = console.readLine();
                    if (tempString.equals(y)) {
                        removeAgreement = true;
                    }
                    if (!tempString.equals(y)) {
                        removeAgreement = false;
                    }
                    if (removeAgreement) {
                        System.out.println(contactRepository.getFromList(removeID).getName() + " has been removed from the list");
                        contactRepository.removeFromList(removeID);
                    }
                }
                break;

                case 5:
                    CONTINUE = false;
                    break;

            }

        }

        input.close();

    }

    public static int menu(Scanner input) {
        int selection;
        System.out.println("Choose an option:");
        System.out.println("1) Add contacts");
        System.out.println("2) View contacts");
        System.out.println("3) Edit contacts");
        System.out.println("4) Remove contacts");
        System.out.println("5) Exit");
        selection = input.nextInt();
        if (selection < 0 || selection > 6) {
            System.out.println("Please choose between 1 and 5");
            selection = 5;
        }
        return selection;

    }
}
