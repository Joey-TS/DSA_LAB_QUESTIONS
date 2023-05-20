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

class PrefixEvaluation {
    public static int evaluate(String prefix) 
    {
        int result= 0;
        ourstack_eval os= new ourstack_eval(prefix.length());
        for (int i=(prefix.length()-1); i>=0;i--)
        {
            char ch = prefix.charAt(i);
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
        System.out.print("Enter prefix expression: ");
        String prefix = scanner.nextLine();
        int result=evaluate(prefix);
        System.out.println("The evaluated result is :"+result);
        scanner.close();
        }
    
}
