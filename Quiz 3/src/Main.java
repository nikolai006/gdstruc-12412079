import java.util.Scanner;
import java.util.Random;

public class Main
{
    public static void main(String[] args)
    {
        ArrayQueue playerQueue = new ArrayQueue(50);
        ArrayQueue lobby = new ArrayQueue(10);
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);
        int games = 0;
        int maxGames = 10;


        String[] names = {"Amiya", "Exusiai", "SilverAsh", "Blaze", "Eyjafjalla", "Saria",
                "Ifrit", "Hoshiguma", "Siege", "Ch'en", "Mostima", "Schwarz",
                "Hellagur", "Bagpipe", "Thorns", "Surtr", "Mudrock", "Mountain",
                "Texas", "Lappland", "Specter", "Blue Poison", "Ptilopsis", "Warfarin",
                "Gravel", "Shaw", "Perfumer", "Courier", "Melantha", "Kroos"};

        for (int i = 1; i <= 50; i++)
        {
            String name = names[rand.nextInt(names.length)] + i;
            int level = rand.nextInt(45) + 1; // Random level 1-45
            playerQueue.push(new Player(i, name, level));
        }

        while (games < maxGames)
        {
            int playersJoining = rand.nextInt(8);

            for (int i = 0; i < playersJoining && !playerQueue.isEmpty() && lobby.size() < 5; i++)
            {
                Player player = playerQueue.pop();
                lobby.push(player);
            }

            int currentLobbySize = lobby.size();

            System.out.println("Current players: " + currentLobbySize + " / 5 in the lobby");
            System.out.println("Press [ENTER] To Scan Again");
            scan.nextLine();
            System.out.println("Key Pressed!\n");

            if (currentLobbySize >= 5) {
                games++;
                System.out.println("+--{ Game " + games + " Started! }--+");

                // Pop 5 players from lobby
                for (int i = 0; i < 5; i++) {
                    Player player = lobby.pop();
                    System.out.println("Player in game: " + player);
                }

                System.out.println("Game " + games + " / " + maxGames + " completed!\n");
            } else {
                System.out.println("Not enough players yet. Keep waiting...\n");
            }
        }

        System.out.println("Server 2AD34RR full! Changing concurrent server");
        System.out.println("Total Games Created: " + games);
        scan.close();
    }
}