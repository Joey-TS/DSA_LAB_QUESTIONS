import java.util.*;

class ourstack_eval{
    private int max;
    public int[] arr;
    private int top;

    public ourstack_eval(int s)
    {
        max=s;
        arr=new int[max];
        top=-1;
    }
    
    public void pushitem(int item)
    {
        top++;
        arr[top]=item;
    }

    public int pop()
    {
        return arr[top--]; 
    }

    public int peek()
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

class PostfixEvaluation {
    public static int evaluate(String postfix) 
    {
        int result= 0;
        ourstack_eval os= new ourstack_eval(postfix.length());
        for (int i=0; i<postfix.length();i++)
        {
            char ch = postfix.charAt(i);
            if (Character.isDigit(ch))
            {
                int a=ch-'0';
                os.pushitem(a);
            }
            else
            {
                int op2=os.pop();
                int op1 = os.pop();

                switch (ch) {
                    case '+':
                    {
                        op1+=op2;
                        os.pushitem(op1);
                        break;
                    }
                    case '-':
                    {
                        op1-=op2;
                        os.pushitem(op1);
                        break;
                    }
                    case '/':
                    {
                        op1/=op2;
                        os.pushitem(op1);
                        break;
                    }
                    case '*':
                    {
                        op1*=op2;
                        os.pushitem(op1);
                        break;
                    }
                    case '^':
                    {
                        op1^=op2;
                        os.pushitem(op1);
                        break;
                    }
                }
            }
        }
        result=os.peek();
        return result;
    }
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter postfix expression: ");
        String postfix = scanner.nextLine();
        int result=evaluate(postfix);
        System.out.println("The evaluated result is :"+result);
        scanner.close();
        }
    
}
