import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        while (true) {
            int inputChoice = 0;
            System.out.println("Pls choose (number only) :");
            System.out.println("1. Currency exchange");
            System.out.println("2. View History");
            System.out.println("3. Exit");

            if (scanner.hasNextInt()) {
                inputChoice = scanner.nextInt();
            } else {
                System.out.println("Wrong input, pls use only number");
                scanner.nextLine();

                switch (inputChoice) {
                    case (1):
                        System.out.println("test");
                        break;

                    case (3):
                        System.out.println("You choose exit");
                        break;
                }

            }


        }
    }
}
