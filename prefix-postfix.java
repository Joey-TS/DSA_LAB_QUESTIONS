import java.util.*;

class ourstack_string
{
    private int max;
    public String[] arr;
    private int top;

    //We need to join opreands and operator into one single element
    //if the scanned element in an operator. Hence we are using
    //a string array.
    public ourstack_string(int s)
    {
        max=s;
        arr=new String[max];
        top=-1;
    }
    
    public void pushitem(String item)
    {
        top++;
        arr[top]=item;
    }

    public String pop()
    {
        return arr[top--]; 
    }

    public String peek()
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

class PrefixToPostfix {
    public static String convert(String prefix) {
        ourstack_string stack = new ourstack_string(prefix.length());
        StringBuilder postfix = new StringBuilder();

        // Reverse the prefix expression
        String reversed = new StringBuilder(prefix).reverse().toString();

        for (int i = 0; i < reversed.length(); i++) {
            char ch = reversed.charAt(i);

            if (Character.isLetterOrDigit(ch)) 
            {
                // Operand, push to stack
                stack.pushitem(Character.toString(ch));
            } 
            else 
            {
                // Operator, pop two operands and append them to form a postfix expression
                String op1 = stack.pop();
                String op2 = stack.pop();
                String expr = op1 + op2 + Character.toString(ch);
                stack.pushitem(expr);
            }
        }

        // Reverse the final postfix expression
        String finalExpr = stack.pop();
        postfix.append(new StringBuilder(finalExpr).toString());

        return postfix.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter prefix expression: ");
        String prefix = scanner.nextLine();
        String postfix = convert(prefix);
        System.out.println("Postfix expression: " + postfix);
        scanner.close();
    }
}
