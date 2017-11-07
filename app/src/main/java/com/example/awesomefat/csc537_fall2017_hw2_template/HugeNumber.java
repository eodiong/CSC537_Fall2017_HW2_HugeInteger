package com.example.awesomefat.csc537_fall2017_hw2_template;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;


public class HugeNumber {

    public static LinkedList addLists(LinkedList l1, LinkedList l2)
    {
        LinkedList greaterList;
        if(l1.count>l2.count)
        {
            greaterList=l1;
        }
        else
        {
            greaterList=l2;
        }
        int temp1[]=new int[l1.count];
        int temp2[]=new int[l2.count];

        Node n1=l1.getNode();

        if(n1!=null) {
            int i=0;
            do {

                temp1[i] = n1.getPayload();
                n1=n1.getNextNode();
                i=i+1;
            }while (n1.getNextNode() != null);

            temp1[i] = n1.getPayload();

        }

        n1=l2.getNode();
        if(n1!=null) {
            int i=0;
            do {

                temp2[i] = n1.getPayload();
                i=i+1;
                n1=n1.getNextNode();
            }while (n1.getNextNode() != null);

            temp2[i] = n1.getPayload();
        }

        if(greaterList==l1)
        {
            int laster=-1;
            for (int i=temp1.length-1, j=temp2.length-1;i>=0;i--,j--)
            {
            if(j>=0)
                temp1[i]=temp1[i]+temp2[j];
            if(laster!=-1)
            {
                temp1[i]=temp1[i]+laster;
            }
            if(temp1[i]>=10)
            {
                laster=temp1[i]/10;
                temp1[i]=temp1[i]%10 ;

            }
            else
            {
                laster=-1;
            }

        }
        if(laster!=-1) {
            int temp3[] = temp1;
            temp1 = new int[temp1.length + 1];
            temp1[0] = laster;
            for (int i = 0; i < temp3.length; i++) {
                temp1[i + 1] = temp3[i];
            }
        }
            l1=new LinkedList();
            for(int i=0;i<temp1.length;i++)
            {

                l1.addEnd(temp1[i]);
            }
            return l1;
        }
        else
        {
            int laster=-1;
            for (int i=temp2.length-1, j=temp1.length-1;i>=0;i--,j--)
            {
                if(j>=0)
                    temp2[i]=temp2[i]+temp1[j];
                if(laster!=-1)
                {
                    temp2[i]=temp2[i]+laster;
                }
                if(temp2[i]>=10)
                {
                    laster=temp2[i]/10;
                    temp2[i]=temp2[i]%10;

                }
                else
                {
                    laster=-1;
                }


            }
            if(laster!=-1)
            {
                int temp3[]=temp2;
                temp2=new int[temp2.length+1];
                temp2[0]=laster;
                for(int i=0;i<temp3.length;i++)
                {
                    temp2[i+1]=temp3[i];
                }
            }
            l1=new LinkedList();
            for(int i=0;i<temp2.length;i++)
            {

                l1.addEnd(temp2[i]);
            }
            return l1;


        }

       // return l1;
    }


}
