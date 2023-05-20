import java.util.*;

class ourstack_char
{
    private int max;
    public char[] arr;
    private int top;

    public ourstack_char(int s)
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
        if(this.isEmpty())
        {System.out.println("Stack underflow.");}
        return arr[top--]; 
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

public class delimiter_matching {

    public static void delimitercheck(String expression)
    {
        ourstack_char os = new ourstack_char(expression.length());
        boolean check=true;

        for (int i = 0; i < expression.length(); i++) 
        {
            char ch = expression.charAt(i);
            switch (ch) {
                case '{':
                case '[':
                case '(':
                    {os.pushitem(ch);
                    break;}
                case '}':
                case ']':
                case ')':
                    {
                    if (!os.isEmpty())
                        {char item = os.pop();
                            if ((ch == '}' && item != '{') || (ch == ']' && item != '[')|| (ch == ')' && item != '('))
                            {
                                System.out.println("Warining : Mismatch for \""+item+"\" at index "+i);
                                check=false;
                            }
                        }
                    else
                        {
                            System.out.println("Mismatch found: " + ch + " at " + i);
                            check=false; 
                        }
                    break;
                   }
                }
        }

        //checking if stack is not empty, i.e. if any delimiter is missin in expression
        if (!os.isEmpty())
        {
            char item = os.pop();
            System.out.println("Warining : Closing delimiter for \" "+item+"\" is missing");
            check=false;
        }

        //if expression is okay
        if (check==true)
        {System.out.println("Expression has correctly matched delimiters");}
    }

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter prefix expression: ");
        String expression = scanner.nextLine();
        delimitercheck(expression);
        scanner.close();
    }
    
}
