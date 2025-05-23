import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // Create players and roulette
        Scanner scanner = new Scanner(System.in);
        Player player1 = new Player("P1", 1000);
        Player player2 = new Player("P2", 1000);
        Roulette roulette = new Roulette(0, "red");
        roulette.addPlayer(player1);
        roulette.addPlayer(player2);

        // Game loop
        boolean running = true;
        while (running) {
            System.out.println("\n--- Roulette Game Menu ---");
            System.out.println("1. Place Bets");
            System.out.println("2. Spin Roulette");
            System.out.println("3. Show Balances/Players");
            System.out.println("4. Show Bets");
            System.out.println("5. Add Money To Player");
            System.out.println("6. Add Player");
            System.out.println("7. Remove Player");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    for (Player player : roulette.getPlayers()) {
                        System.out.println(player.getName() + ", enter your bet amount:");
                        int amount = scanner.nextInt();
                        System.out.println(player.getName() + ", enter the number you want to bet on (0-36):");
                        int number = scanner.nextInt();
                        scanner.nextLine(); // consume newline
                        System.out.println(player.getName() + ", enter the color you want to bet on (red/black):");
                        String color = scanner.nextLine().trim().toLowerCase();
                        player.placeBet(amount, number, color);
                    }
                    break;
                case 2:
                    roulette.spin();
                    break;
                case 3:
                    for (Player player : roulette.getPlayers()) {
                        System.out.println(player.getName() + "'s balance: " + player.getBalance());
                    }
                    break;
                case 4:
                    System.out.println("Bets placed by players:");
                    for (Player p : roulette.getPlayers()) {
                        System.out.println(p.getName() + " - Bet Amount: " + p.getBetAmount() +
                                ", Bet Number: " + p.getBetNumber() + ", Bet Color: " + p.getBetColor());
                    }
                    break;
                case 5:
                    System.out.println("Enter the player name:");
                    String playerName = scanner.nextLine().trim();
                    Player player = roulette.getPlayerByName(playerName);
                    if (player != null) {
                        System.out.println("Enter the amount to add:");
                        int amountToAdd = scanner.nextInt();
                        player.addMoney(amountToAdd);
                        System.out.println("Added " + amountToAdd + " to " + playerName + "'s balance.");
                    } else {
                        System.out.println("Player not found.");
                    }
                    break;
                case 6:
                    System.out.println("Enter the player name:");
                    String newPlayerName = scanner.nextLine().trim();
                    System.out.println("Enter the initial balance:");
                    int initialBalance = scanner.nextInt();
                    Player newPlayer = new Player(newPlayerName, initialBalance);
                    roulette.addPlayer(newPlayer);
                    System.out.println("Added new player: " + newPlayerName);
                    break;
                case 7:
                    System.out.println("Enter the player name:");
                    String removePlayerName = scanner.nextLine().trim();
                    Player removePlayer = roulette.getPlayerByName(removePlayerName);
                    if (removePlayer != null) {
                        roulette.removePlayer(removePlayer);
                        System.out.println("Removed player: " + removePlayerName);
                    } else {
                        System.out.println("Player not found.");
                    }
                    break;
                case 8:
                    running = false;
                    System.out.println("99% of gamblers quit before they hit it big...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();

    }
}
