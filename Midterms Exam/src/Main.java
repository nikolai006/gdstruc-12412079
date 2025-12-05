import java.util.Random;
import java.util.Scanner;

public class Main
{
    private ArrayStack playerDeck;
    private ArrayStack playerHand;
    private ArrayStack discardedPile;
    private Random randomCard;

    public Main()
    {
        playerDeck = new ArrayStack(30);
        playerHand = new ArrayStack(10);
        discardedPile = new ArrayStack(10);
        randomCard = new Random();

        initializeDeck();
    }

    private void initializeDeck()
    {
        String[] cardNames = {
                "Knight", "Paladin", "Rogue", "Assassin", "Berserker",
                "Wizard", "Priest", "Necromancer", "Vampire", "Taoist",
                "Elf", "Druid", "Alchemist", "Engineer", "Robot",
                "Costume Prince", "Demonmancer", "Trap Master", "Miner", "Officer",
                "Werewolf", "Airbender", "warliege", "Arcane Knight", "Physicist",
                "Sword Master", "Lancer", "Astromancer", "Trickster", "Bard",
                "Machina", "Gunner", "Captain", "The Beheaded", "Special Forces",
                "Time Travelling Ninja", "Inter-Dimensional Traveler", "Element Envoy"
        };

        for (int i = 0; i < 30; i++)
        {
            String cardName = cardNames[i % cardNames.length];
            playerDeck.push(new Card(cardName));
        }
    }

    private void drawCards(int count)
    {
        System.out.println("\n>>> COMMAND: Draw " + count + " card(s)");

        int drawn = 0;
        for (int i = 0; i < count && !playerDeck.isEmpty(); i++)
        {
            Card card = playerDeck.pop();
            playerHand.push(card);
            drawn++;
        }

        System.out.println("Player drew " + drawn + " cards");
        if (drawn < count)
        {
            System.out.println("(Could not draw all cards - deck is empty!)");
        }
    }

    private void discardCards(int count)
    {
        System.out.println("\n>>> COMMAND: Discard " + count + " card(s)");

        int discarded = 0;
        for (int i = 0; i < count && !playerHand.isEmpty(); i++)
        {
            Card card = playerHand.pop();
            discardedPile.push(card);
            discarded++;
        }

        System.out.println("Discarded " + discarded + " card(s)");
        if (discarded < count)
        {
            System.out.println("(Could not discard all cards - hand is empty!)");
        }
    }

    private void getCardsFromDiscard(int count)
    {
        System.out.println("\n>>> COMMAND: Get " + count + " card(s) from discarded pile");

        int retrieved = 0;
        for (int i = 0; i < count && !discardedPile.isEmpty(); i++)
        {
            Card card = discardedPile.pop();
            playerHand.push(card);
            retrieved++;
        }

        System.out.println("Retrieved " + retrieved + " card(s) from discard pile");
        if (retrieved < count)
        {
            System.out.println("(Could not retrieve all cards - discard pile is empty!)");
        }
    }

    private void displayGameState()
    {
        System.out.println("\n+---{ GAME STATE }---+");

        System.out.println("\nCards in Hand:");
        if (playerHand.isEmpty())
        {
            System.out.println("  (No cards in hand)");
        }
        else
        {
            ArrayStack tempStack = new ArrayStack(playerHand.size());
            while (!playerHand.isEmpty())
            {
                Card card = playerHand.pop();
                System.out.println("  - " + card);
                tempStack.push(card);
            }
            while (!tempStack.isEmpty())
            {
                playerHand.push(tempStack.pop());
            }
        }

        System.out.println("\nRemaining cards in player deck: " + playerDeck.size());
        System.out.println("Cards in discarded pile: " + discardedPile.size());
        System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n");
    }

    public void play()
    {
        Scanner scanner = new Scanner(System.in);
        int turnNumber = 1;

        System.out.println("+---{ CARD GAME STARTED }---+");
        System.out.println("The game will give random commands each turn.");
        System.out.println("The game ends when the player deck is empty.\n");

        while (!playerDeck.isEmpty())
        {
            System.out.println("\n+---{ TURN " + turnNumber + " }---+");

            int commandType = randomCard.nextInt(3);
            int amount = randomCard.nextInt(5) + 1; // 1 to 5

            switch (commandType)
            {
                case 0:
                    drawCards(amount);
                    break;
                case 1:
                    discardCards(amount);
                    break;
                case 2:
                    getCardsFromDiscard(amount);
                    break;
            }

            displayGameState();

            System.out.print("Press [ENTER] to continue to next turn...");
            scanner.nextLine();

            turnNumber++;
        }

        System.out.println("\n+---{ GAME OVER }---+");
        System.out.println("The player deck is empty!");
        System.out.println("Total turns played: " + (turnNumber - 1));

        scanner.close();
    }

    public static void main(String[] args)
    {
        Main game = new Main();
        game.play();
    }
}
