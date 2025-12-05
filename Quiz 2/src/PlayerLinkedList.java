public class PlayerLinkedList
{
    private PlayerNode head;
    private int size;

    public PlayerLinkedList()
    {
        head = null;
        size = 0;
    }

    public void addToFront(Player player)
    {
        PlayerNode playerNode = new PlayerNode(player);
        playerNode.setNextPlayer(head);
        head = playerNode;
        size++;
    }

    public boolean removePlayer(Player player)
    {
        if(head == null)
        {
            return false;
        }

        if (head.getPlayer().equals(player))
        {
            head = head.getNextPlayer();
            size--;
            return true;
        }

        return false;
    }

    public int size()
    {
        return size;
    }

    public boolean contains(Player player)
    {
        PlayerNode current = head;

        while( current != null)
        {
            if(current.getPlayer().equals(player))
            {
                return true;
            }
            current = current.getNextPlayer();
        }
        return false;
    }

    public int indexOf(Player player)
    {
        PlayerNode current = head;
        int index = 0;

        while( current != null)
        {
            if(current.getPlayer().equals(player))
            {
                return index;
            }
            current = current.getNextPlayer();
            index++;
        }

        return -1;
    }

    public void printList()
    {
        PlayerNode current = head;
        System.out.print("HEAD -> ");

        while (current != null)
        {
            System.out.print(current);
            System.out.print(" -> ");
            current = current.getNextPlayer();
        }
        System.out.println("null");
    }
}