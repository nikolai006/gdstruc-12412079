import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main (String[] args) {
//        List<Player> playerList = new ArrayList<>();

//        playerList.add(new Player(1, "Ranica", 45));
//        playerList.add(new Player(2, "Daniel", 34));
//        playerList.add(new Player(3, "Enjo", 20));
//        playerList.add(new Player(4, "Arnold", 38));
//        playerList.add(new Player(5, "Yeongsam", 27));

//        System.out.println(playerList.get(1));

//        playerList.remove(3);
//        playerList.add(3, new Player(13, "Mika", 60));
//        playerList.forEach(player->System.out.println(player));
//        for (Player p : playerList)
//        {
//            System.out.println(p);
//        }

        Player player1 = new Player(1, "Ranica", 45);
        Player player2 = new Player(2, "Daniel", 34);
        Player player3 = new Player(3, "Enjo", 20);

        PlayerLinkedList playerLinkedList = new PlayerLinkedList();

        playerLinkedList.addToFront(player1);
        playerLinkedList.addToFront(player2);
        playerLinkedList.addToFront(player3);

        playerLinkedList.printList();
        System.out.println("Number of players: " + playerLinkedList.size());

        if (playerLinkedList.contains(player1)) {
            System.out.println(player1 + " is in the list!");
        }

        int position = playerLinkedList.indexOf(player1);
        if (position != -1) {
            System.out.println("This player is found at index " + position);
        }
    }
}