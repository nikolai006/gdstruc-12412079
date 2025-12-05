public class Node {
    private int data;
    private Node rightChild;
    private Node leftChild;


    public void insert(int value)
    {
        if(value == data)
        {
            return;
        }

        if (value< data)
        {
            if(leftChild == null)
            {
                leftChild = new Node(value);
            }
            else {
                leftChild.insert(value);
            }
        }
        else
        {
            if (rightChild == null)
            {
                rightChild = new Node(value);
            }
            else
            {
                rightChild.insert(value);
            }
        }
    }

    public void traverseInOrder(int[] count)
    {
        if(leftChild != null)
        {
            leftChild.traverseInOrder(count);
        }
        count[0]++;
        System.out.println("Node " + count[0] + " - Data : " + data);

        if(rightChild != null)
        {
            rightChild.traverseInOrder(count);
        }
    }

    public void traverseInDescendingOrder(int[] count)
    {
        if (rightChild != null)
        {
            rightChild.traverseInDescendingOrder(count);
        }
        count[0]++;
        System.out.println("Node " + count[0] + " - Data : " + data);

        if (leftChild != null)
        {
            leftChild.traverseInDescendingOrder(count);
        }
    }

    public Node get(int value)
    {
        if(value == data)
        {
            return this;
        }
        if (value < data)
        {
            if(leftChild != null) {
                return leftChild.get(value);
            }
        }
        else
        {
            if(rightChild != null)
            {
                return rightChild.get(value);
            }
        }


        return null;
    }

    public Node getMin() {
        if (leftChild == null) {
            return this;
        }
        return leftChild.getMin();
    }

    public Node getMax() {
        if (rightChild == null) {
            return this;
        }
        return rightChild.getMax();
    }


    public Node(int _data)
    {
        this.data = _data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    @Override
    public String toString() {
        return "Node {" +
                "Data = " + data +
                '}';
    }
}