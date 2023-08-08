import java.io.Console;

public class Application {

    public static void main(String[] console_arguments) {

        Console console = System.console();

        System.out.println("How many dice you want to roll?");
        int NumberOfDices = Integer.parseInt(console.readLine());
        int n = 0;
        int m = 0;
        String cont = "y";

        while (true) {
                n = GenerateRandom();
                m = GenerateRandom();

            if (NumberOfDices == 2) {
                System.out.println("You rolled a " + n + " and a " + m);
            } else {
                System.out.println("You rolled a " + n);

            }
            System.out.println("Again? yes = y no = any key");
            if (cont != console.readLine())
            {
                break;
            }
        }
    }

    private static int GenerateRandom() {
        int min = 1;
        int max = 6;

        int random_int = (int) Math.floor(Math.random() * (max - min + 1) + min);
        return random_int;
    }

}
