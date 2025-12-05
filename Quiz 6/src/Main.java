import java.util.Random;

public class Main
{

    public static void main(String[] args)
    {
        Tree tree = new Tree();
        Random rand = new Random();
        int[] count = {0};

        for (int i = 0; i < 7; i++)
        {
            int randomNum = rand.nextInt(100);
            tree.insert(randomNum);
        }
        tree.insert(25);

        tree.traverseInOrder(count);
        System.out.println("\nGetting value 25: " +tree.get(25));

        System.out.println("\nMin: " + tree.getMin());
        System.out.println("Max: " + tree.getMax());

        System.out.println("\nDescending Order: ");
        tree.traverseInDescendingOrder(count);
    }
}
