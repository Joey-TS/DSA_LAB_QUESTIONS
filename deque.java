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

class LinkedListD
{
    private link first;
    private link last;
    public LinkedListD()
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
                {first=new link(d);}
            nl.next=null;
            last=first;
            while(last.next!=null)
                {last=last.next;}
            last.next=nl;
        }
    public void InsertFirst(int d)
        {
            link nl=new link(d);
            if (first==null)
                {first = new link(d);
                }
            else
                {
                nl.next=first;
                first=nl;
                }
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
