import java.util.Scanner;

class ourstack{
    private int max;
    public char[] arr;
    private int top;

    public ourstack(int s)
    {
        max=s;
        arr=new char[max];
        top=-1;
    }
    
    public void pushitem(char item)
    {
        top++;
        arr[top]=item;
    }

    public char pop()
    {
        char j=arr[top];
        top--;
        return j;
    }

    public char peek()
    {return arr[top];}

    public boolean isFull()
    {
        if (top==(max-1))
            {return true;}
        else 
            {return false;}
    }

    public boolean isEmpty()
    {
        if (top==-1)
            {return true;}

        else 
            {return false;}
    }
}

class stackuse
{
    public static void main(String[] args)
    {
        Scanner s= new Scanner(System.in);
        
        //calculating string size
        System.out.println("Enter the string to check if palindrome : ");
        String UserString = s.nextLine();
        char[] a=new char[UserString.length()];
        for (int j = 0; j < UserString.length(); j++) {
            a[j] = UserString.charAt(j);}

        ourstack os = new ourstack(a.length);
        for (int i=0;i<a.length;i++)
            {
                os.pushitem(a[i]);
            }
        
        System.out.println("Reversed string is : ");
        for (int i=0;i<a.length;i++)
            {
                System.out.print(os.pop());
            }
        System.out.print("\n");

        boolean isPalindrome = true;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != os.arr[i]) {
                isPalindrome = false;
                break;
            }
        }
        if (isPalindrome) {
            System.out.println("The string is palindromic.");
        } else {
            System.out.println("The string is not palindromic.");
        }
    s.close();
    }
}

