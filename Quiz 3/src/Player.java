import java.util.Objects;

public class Player
{
    private int id;
    private String name;
    private int level;

    public Player(int id, String name, int level)
    {
        this.id = id;
        this.name = name;
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString()
    {
        return "Player{" +
                "ID: " + id +
                ", Name: " + name + '\'' +
                ", Level: " + level +
                '}';
    }
}
