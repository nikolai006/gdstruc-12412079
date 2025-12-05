
public class HashTable
{
    private Player[] hashTable;
    private static final Player deleted = new Player(0, " ", 0);

    public HashTable() {
        hashTable = new Player[10];
    }

    private int hashKey(String key) {
        return key.length() % hashTable.length;
    }

    public void put(String key, Player value)
    {
        int hashedKey = hashKey(key);
        int startIndex = hashedKey;

        while (hashTable[hashedKey] != null && hashTable[hashedKey] != deleted)
        {
            hashedKey = (hashedKey + 1) % hashTable.length;

            if (hashedKey == startIndex) {
                System.out.println("Hash table is full!");
                return;
            }
        }

        hashTable[hashedKey] = value;
    }

    public Player get(String key)
    {
        int hashedKey = hashKey(key);
        int startIndex = hashedKey;

        return hashTable[hashedKey];
    }

    public boolean remove(String key)
    {
        int hashedKey = hashKey(key);
        int startIndex = hashedKey;

        while (hashTable[hashedKey] != null)
        {
            if (hashTable[hashedKey].getName().equals(key))
            {
                hashTable[hashedKey] = deleted;
                return true;
            }
            hashedKey = (hashedKey + 1) % hashTable.length;

            if (hashedKey == startIndex) {
                break;
            }
        }

        return false;
    }

    public void printHashTable()
    {
        for (int i = 0; i < hashTable.length; i++)
        {
            if (hashTable[i] == deleted) {
                System.out.println("Element " + i + " <deleted>");
            } else {
                System.out.println("Element " + i + " " + hashTable[i]);
            }
        }
    }
}
