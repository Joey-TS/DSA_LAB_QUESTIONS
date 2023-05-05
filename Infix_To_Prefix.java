import java.util.*;

class ourstack1{
    private int max;
    public char[] arr;
    private int top;

    public ourstack1(int s)
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

class InfixToPrefix 
{
    public static int getPrecedence(char operator) 
    {
        switch(operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return 0;
        }
    }

    public static String convert(String infix) 
    {
        ourstack1 stack1 = new ourstack1(infix.length());
        String prefixstring= new String();
        
        for (int i =(infix.length()-1); i>=0; i--) 
        {
            char ch = infix.charAt(i);
            
            if (Character.isLetterOrDigit(ch)) 
            {
                prefixstring+=ch;
            } 
            else if (ch == '(') 
            {
                while (!stack1.isEmpty() && stack1.peek() != ')') 
                {
                    prefixstring+=(stack1.pop());
                }
                
                stack1.pop();
            } 
            else if (ch == ')') 
            {
                stack1.pushitem(ch);
            } 
            else 
            {
                while (!stack1.isEmpty() && getPrecedence(ch) <= getPrecedence(stack1.peek())) 
                {
                    prefixstring+=(stack1.pop());
                }
                
                stack1.pushitem(ch);
            }
        }
        
        while (!stack1.isEmpty()) 
        {
            prefixstring+=(stack1.pop());
        }

        String prefixstring1= new String();
        for (int i =(infix.length()-1); i>=0; i--) 
            {
                prefixstring1+=prefixstring.charAt(i);
            }
        return prefixstring1;//.toString();
    }

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter infix expression: ");
        String infix = scanner.nextLine();
        String prefix = convert(infix);
        System.out.print("Prefix expression: "+prefix);
        scanner.close();
    }
}
