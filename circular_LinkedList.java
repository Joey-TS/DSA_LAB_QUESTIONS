// Joseph Thrickoyickal Shyju
// Roll no 106
// Reg no 20221534

import java.util.*;

class link
    {protected int data;
    public link next;
    public link prev;
    public link(int d)
        {
            data=d;
            next=null;
            prev=null;
        }
    public void displayLink()
        {
            System.out.println(data+" ");
        }
    }

class LinkedListC
{
    private link first;
    private link last;
    public LinkedListC()
        {
            first=null;
            last=null;
        }
    public boolean isEmpty()
        {
            return first==null;
        }
    public void InsertLast(int d)
        {
            link nl = new link(d);
            if (isEmpty())
                    {
                        first=nl;
                        last=nl;
                    }
            
            else
                    {
                        last.next = nl;
                        last = nl;
                        last.next = first;
                    }
            nl.next=null;
        }
    public link DeleteFirst()
        {
            link temp=first;
            first=first.next;
            last.next=first;
            return temp;
        }
    public void DisplayList() 
        {
        link current = first;
        do {
            current.displayLink();
            current = current.next;
            } 
        while (current != first&&current!=null);
        }

    public int CountList()
        {
            link current = first;
            int count=0;
            while(current!=null)
                {
                    count++;
                    current=current.next;
                }
            return count;
        }
}

class cirqueue
{
    public static void main(String[] args) {
        LinkedListC ll = new LinkedListC();
        Scanner s= new Scanner(System.in);
        int choice=0;

        while(true)
            {
                System.out.println("\n\n1. Insert into queue \n2. Delete from queue \n3.Count elements inside queue \n4. Display elements inside queue \n5. Exit");
                choice=s.nextInt();
                if (choice==1)
                    {
                        System.out.println("Enter the element to enter :");
                        int element=s.nextInt();
                        ll.InsertLast(element);
                        System.out.println("\n");
                    }
                else if (choice==2)
                    {
                        link deleted=ll.DeleteFirst();
                        System.out.println("The element "+deleted.data+" has been removed from the queue\n");
                    }
                else if (choice==3)
                    {
                        int count=ll.CountList();
                        System.out.println("The number of elements inside the queue is :"+count+"\n");
                    }
                else if (choice==4)
                    {
                        System.out.println("Contents of the queue :");
                        ll.DisplayList();
                        System.out.println("\n");
                    }
                else
                    {break;}
            }
        s.close();
    }
}