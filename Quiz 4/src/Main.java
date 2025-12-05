public class Main
{
    public static void main(String[] args)
    {
        Player player1 = new Player(1, "Ranica", 45);
        Player player2 = new Player(2, "Daniel", 34);
        Player player3 = new Player(3, "Enjo", 20);

        HashTable hashTable = new HashTable();
        hashTable.put(player1.getName(), player1);
        hashTable.put(player2.getName(), player2);
        hashTable.put(player3.getName(), player3);

        //hashTable.printHashTable();
        //System.out.println(hashTable.get("Ranica"));

        hashTable.remove("Ranica");
        hashTable.remove("Daniel");
        hashTable.remove("Enjo");
        hashTable.printHashTable();
    }
}