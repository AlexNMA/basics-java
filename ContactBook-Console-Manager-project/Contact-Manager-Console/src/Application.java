import java.io.Console;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) throws InterruptedException {

        Console console = System.console();
        Contact contact = new Contact();
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

                case 1:
                    System.out.println("Enter the name: ");
                    String name = console.readLine();
                    System.out.println("Enter the age: ");
                    int age = Integer.parseInt(console.readLine());
                    contact.addInList(name, age);
                    name = null;
                    age = 0;
                    break;

                case 2:
                    for (int i = 0; i < contact.getNumberOfElements(); i++) {
                        System.out.println(i + ") " + contact.getName(i) + " , " + contact.getAge(i) + " years old");
                    }
                    break;
                case 3:
                    System.out.println("Enter the name: ");
                    String nameEdit = console.readLine();
                    System.out.println("Enter the age: ");
                    int ageEdit = Integer.parseInt(console.readLine());
                    System.out.println("Enter ID ");
                    int id = Integer.parseInt(console.readLine());
                    contact.setInList(id, nameEdit, ageEdit);
                    System.out.println(contact.getName(id) + " " + contact.getAge(id) + " years old has updated");
                    break;
                case 4:
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
                    System.out.println("Are you sure you want to delete " + contact.getName(removeID) + " ?");
                    System.out.println("yes = y, no = any key");
                    tempString = console.readLine();
                    if (tempString.equals(y)) {
                        removeAgreement = true;
                    }
                    if (!tempString.equals(y)) {
                        removeAgreement = false;
                    }
                    if (removeAgreement) {
                        System.out.println(contact.getName(removeID) + " has been removed from the list");
                        contact.removeInList(removeID);
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
