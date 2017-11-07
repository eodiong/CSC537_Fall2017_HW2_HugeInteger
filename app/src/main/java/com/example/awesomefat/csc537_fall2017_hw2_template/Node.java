package com.example.awesomefat.csc537_fall2017_hw2_template;

/**
 * Created by awesomefat on 10/31/17.
 */

public class Node
{
    private int payload;
    private Node nextNode;

    public Node(int payload)
    {
        this.payload = payload;
        this.nextNode = null;
    }

    public void display()
    {
        System.out.print(this.payload + " -> ");
        MainActivity.displayString=MainActivity.displayString+this.payload;
        if(this.nextNode != null)
        {
            this.nextNode.display();
        }
        else
        {
            System.out.println("");
        }
    }

    public int getPayload()
    {
        return payload;
    }

    public Node getNextNode()
    {
        return nextNode;
    }

    public void setNextNode(Node nextNode)
    {
        this.nextNode = nextNode;
    }
}
