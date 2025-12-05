import java.util.EmptyStackException;

public class ArrayQueue
{
    private Player[] stack;
    private int top;

    public ArrayQueue(int capacity)
    {
        stack = new Player[capacity];
    }

    public void push(Player player)
    {
        if (top == stack.length)
        {
            Player[] newStack = new Player[2 + stack.length];
            System.arraycopy(stack,0, newStack, 0, stack.length);
            stack = newStack;
        }

        stack[top++] = player;
    }

    public Player pop()
    {
        if(isEmpty())
        {
            throw new EmptyStackException();
        }
        Player poppedPlayer = stack[--top];
        stack[top] = null;
        return poppedPlayer;
    }

    public Player peek()
    {
        if(isEmpty())
        {
            throw new EmptyStackException();
        }
        return stack[top - 1];
    }

    public boolean isEmpty()
    {
        return top == 0;
    }

    public int size()
    {
        return top;
    }

    public void printStack()
    {
        for (int i = top - 1; i >= 0; i--)
        {
            System.out.println(stack[i]);
        }
    }
}
