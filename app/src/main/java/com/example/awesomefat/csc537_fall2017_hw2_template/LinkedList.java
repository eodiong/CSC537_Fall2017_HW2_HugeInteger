package com.example.awesomefat.csc537_fall2017_hw2_template;

/**
 * Created by awesomefat on 10/31/17.
 */

public class LinkedList
{
    private Node head;
    int count=0;

    public LinkedList()
    {
        this.head = null;
    }

    public int removeEnd()
    {
        if(this.head.getNextNode() == null)
        {
            int valToReturn = this.head.getPayload();
            this.head = null;
            count=0;
            return valToReturn;
        }
        else
        {
            Node currNode = this.head;
            while(currNode.getNextNode().getNextNode() != null)
            {
                currNode = currNode.getNextNode();
            }
            int valToReturn = currNode.getNextNode().getPayload();
            currNode.setNextNode(null);
            count=count-1;
            return valToReturn;
        }
    }
    public void addEnd(int payload)
    {
        Node n = new Node(payload);
        if(this.head == null)
        {
            this.head = n;
            count=1;
        }
        else
        {
            Node currPos = this.head;
            while(currPos.getNextNode() != null)
            {
                currPos = currPos.getNextNode();
            }
            currPos.setNextNode(n);
            count=count+1;
        }
    }

    public int removeFront()
    {
        Node temp = this.head;
        this.head = this.head.getNextNode();
        temp.setNextNode(null);
        count=count-1;
        return temp.getPayload();
    }

    public void addFront(int payload)
    {
        Node n = new Node(payload);
        if(this.head == null)
        {
            this.head = n;
            count=1;
        }
        else
        {
            //there is already at least one thing in the list
            n.setNextNode(this.head);
            this.head = n;
            count=count+1;
        }
    }

    public void display()
    {
        if(this.head == null)
        {
            System.out.println("Empty List");
        }
        else
        {
            this.head.display();
        }
    }

    public  Node getNode()
    {
        return this.head;
    }
}
