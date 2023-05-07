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

class PostfixToInfix {
    public static String convert(String postfix) {
        ourstack_string stack = new ourstack_string(postfix.length());
        StringBuilder infix = new StringBuilder();

        // Reverse the postfix expression
        //String reversed = new StringBuilder(postfix).reverse().toString();

        for (int i = 0; i < postfix.length(); i++) {
            char ch = postfix.charAt(i);

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
                String expr = "("+op2 + Character.toString(ch)+ op1 +")";
                stack.pushitem(expr);
            }
        }

        // Reverse the final postfix expression
        String finalExpr = stack.pop();
        infix.append(new StringBuilder(finalExpr).toString());

        return infix.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter postfix expression: ");
        String postfix = scanner.nextLine();
        String infix = convert(postfix);
        System.out.println("infix expression: " + infix);
        scanner.close();
    }
}
