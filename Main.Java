import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt for player name
        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();
        
        // Create a game instance
        TextAdventureGame game = new TextAdventureGame(playerName);
        
        // Prompt for game mode
        System.out.println("Choose your game mode:");
        System.out.println("1 - Story");
        System.out.println("2 - Survival");

        int mode;
        while (true) {
            System.out.print("Enter 1 or 2: ");
            if (scanner.hasNextInt()) {
                mode = scanner.nextInt();
                if (mode == 1 || mode == 2) {
                    break;
                }
            }
            System.out.println("Invalid input. Please enter 1 for Story or 2 for Survival.");
            scanner.nextLine(); // Clear invalid input
        }

        // Set the game mode based on the user's choice
        if (mode == 1) {
            game.setGameMode(new StoryMode() {});
        } else {
            game.setGameMode(new SurvivalMode() {});
        }

        // Start the game
        game.start();
        
        // Close the scanner
        scanner.close();
    }
}
