import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int inputChoice = 0;
        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.println("Pls choose (number only) :");
            System.out.println("1. Currency exchange");
            System.out.println("2. View History");
            System.out.println("3. Exit");

            if (scanner.hasNextInt()) {
                inputChoice = scanner.nextInt();
            } else {
                System.out.println("Wrong input, pls use only number");
                scanner.nextLine();
            }

            switch (inputChoice) {
                case (1):
                    CurrencyExchangeMenu.exchangeMenu();
                    break;

                case (3):
                    System.out.println("You choose exit");
                    return;
            }

        }


    }
}

