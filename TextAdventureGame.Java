import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextAdventureGame {
    private final String playerName;
    private GameMode gameMode;
    private final List<Item> inventory;

    public TextAdventureGame(String playerName) {
        this.playerName = playerName;
        this.inventory = new ArrayList<>();
    }

    public void setGameMode(GameMode gameMode) {
        this.gameMode = gameMode;
    }

    public void start() {
        System.out.println("Welcome to the adventure, " + playerName + "!");
        System.out.println("Press 'P' to start your journey.");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();

        if ("P".equalsIgnoreCase(input)) {
            if (gameMode != null) {
                gameMode.play(this);
            } else {
                System.out.println("You must select a game mode before playing!");
            }
        } else {
            System.out.println("Invalid input. Please restart the game and try again.");
        }
    }

    public void explore() {
        System.out.println("\nYou find yourself at a crossroads. What will you do?");
        System.out.println("1. Search for items");
        System.out.println("2. Encounter a mysterious creature");
        System.out.println("3. Check your inventory");
        System.out.println("4. Quit the game");

        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine().trim();

        switch (choice) {
            case "1" -> searchForItems();
            case "2" -> encounterCreature();
            case "3" -> checkInventory();
            case "4" -> {
                System.out.println("Thank you for playing! Farewell, " + playerName + ".");
                System.exit(0);
            }
            default -> {
                System.out.println("Invalid choice. Try again.");
                explore();
            }
        }
    }

    private void searchForItems() {
        System.out.println("You scour the area and discover a shiny object!");
        Item foundItem = new Item("Silver Key", "Unlocks a hidden door.");
        inventory.add(foundItem);
        System.out.println("You have obtained: " + foundItem.getName());
        explore();
    }

    private void encounterCreature() {
        System.out.println("A shadowy figure emerges from the darkness!");
        System.out.println("What do you do?");
        System.out.println("1. Face the challenge head-on");
        System.out.println("2. Retreat to safety");

        Scanner scanner = new Scanner(System.in);
        String action = scanner.nextLine().trim();

        if ("1".equals(action)) {
            System.out.println("You bravely face the figure and emerge victorious!");
        } else if ("2".equals(action)) {
            System.out.println("You tactfully retreat to regroup.");
        } else {
            System.out.println("Hesitation can be dangerous... but you manage to escape unscathed.");
        }
        explore();
    }

    private void checkInventory() {
        System.out.println("\nYour Inventory:");
        if (inventory.isEmpty()) {
            System.out.println("It is currently empty. Start exploring to find items!");
        } else {
            for (Item item : inventory) {
                System.out.println("- " + item.getName() + ": " + item.getDescription());
            }
        }
        explore();
    }
}
