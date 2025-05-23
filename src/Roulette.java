import java.util.ArrayList;

public class Roulette {
    private int number;
    private String color;
    private ArrayList<Player> players;

    public Roulette(int number, String color) {
        this.number = number;
        this.color = color;
        this.players = new ArrayList<Player>();
    }

    public int getNumber() {
        return number;
    }

    public String getColor() {
        return color;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    private void generateRandomNumber() {
        this.number = (int) (Math.random() * 37); // Generates a number between 0 and 36
        this.color = (number % 2 == 0) ? "red" : "black"; // Simple color assignment for demonstration
    }

    public Player getPlayerByName(String name) {
        for (Player player : players) {
            if (player.getName().equalsIgnoreCase(name)) {
                return player;
            }
        }
        return null; // Player not found
    }

    public void removePlayer(Player player) {
        players.remove(player);
    }

    public void spin() {
        generateRandomNumber();
        System.out.println("Roulette spun! Number: " + number + ", Color: " + color);
        for (Player player : players) {
            if (player.getBetNumber() == number) {
                player.setBalance(player.getBalance() + player.getBetAmount() * 35); // Winning on number
                System.out.println(player.getName() + " wins " + player.getBetAmount() + " on number " + number + "!");
            } else if (player.getBetColor().equals(color)) {
                player.setBalance(player.getBalance() + player.getBetAmount() * 2); // Winning on color
                System.out.println(player.getName() + " wins " + player.getBetAmount() + " on color " + color + "!");
            } else {
                System.out.println(player.getName() + " loses " + player.getBetAmount() + ".");
            }
        }
    }

    @Override
    public String toString() {
        return "Roulette{" +
                "number=" + number +
                ", color='" + color + '\'' +
                '}';
    }
}
