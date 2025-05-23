public class Player {
    private String name;
    private int balance;
    private int betAmount;
    private int betNumber;
    private String betColor;

    public Player(String name, int balance) {
        this.name = name;
        this.balance = balance;
        this.betAmount = 0;
        this.betNumber = 0;
        this.betColor = "";
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public int getBetAmount() {
        return betAmount;
    }

    public int getBetNumber() {
        return betNumber;
    }

    public String getBetColor() {
        return betColor;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void addMoney(int amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Invalid amount. Please enter a positive value.");
        }
    }

    public void placeBet(int amount, int number, String color) {
        if (amount > balance) {
            System.out.println("Insufficient balance to place the bet.");
        } else if (amount <= 0) {
            System.out.println("Bet amount must be greater than zero.");
        } else if (number < 0 || number > 36) {
            System.out.println("Bet number must be between 0 and 36.");
        } else {
            balance -= amount;
            betAmount = amount;
            betNumber = number;
            betColor = color;
            System.out.println(name + " placed a bet of " + amount + ". Remaining balance: " + balance);
        }
    }
    
}
