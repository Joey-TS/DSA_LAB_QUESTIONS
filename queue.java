import java.util.*;


class link
    {protected int data;
    public link next;
    public link(int d)
        {
            data=d;
            next=null;
        }
    public void displayLink()
        {
            System.out.println(data+" ");
        }
    }

class LinkedList
{
    private link first;
    private link last;
    public void linkedList()
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
            if (first==null)
                {first=nl;
                last=nl;
                }
            else
                {
                    last.next=nl;
                    last=nl;
                }
        }
    public void InsertFirst(int d)
        {
            link nl=new link(d);
            nl.next=first;
            first=nl;
        }
    public void InsertIntoPosition(int p, int d)
        {
            link temp = first;
            for (int i=0;i<p-1;i++)
                {
                    temp=temp.next;
                }
            link temp2=new link(d);
            temp2.next=temp.next;
            temp.next=temp2;
        }
    public link DeleteLast()
        {
            link secondlast=first;
            while(secondlast.next.next!=null)
                {secondlast=secondlast.next;}
            link temp=secondlast.next;
            secondlast.next=null;
            return temp;
        }
    public link DeleteFirst()
        {
            link temp=first;
            first=first.next;
            return temp;
        }
    public void DisplayList()
        {
            link current=first;
            while (current!=null)
                {
                    current.displayLink();
                    current=current.next;
                }
        }
    public link find(int key)
        {
            link cur=first;
            while(cur.data!=key)
                {if (cur.next==null)
                    {return null;}
                else
                    {
                        cur=cur.next;
                    }
                }
            return cur;
        }
    public link keydelete(int key)
        {
            link cur=first;
            link prev=first;
            if (first.data==key)
                {
                    link temp=first;
                    first=first.next;
                    return temp;
                }
            while (cur.data!=key)
                {
                    if (cur.data!=key)
                        {
                            return null;
                        }
                    else
                        {
                            prev=cur;
                            cur=cur.next;
                        }
                    }
            if (cur.data==key)
                {
                    prev.next=cur.next;
                    return prev;
                }
            else    
                {return null;}
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

class queue
{
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
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
