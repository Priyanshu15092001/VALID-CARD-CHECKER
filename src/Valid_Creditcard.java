import java.util.*;
public class Valid_Creditcard
{long card_num;
    static int countCardNum(long n)
    { int c=0;
        while(n!=0)
        {++c;
            n /= 10;
        }
        return c;
    }
    int cardValidCheck(long card_num)
    {
        int count= Valid_Creditcard.countCardNum(this.card_num);
        if (count>=13&&count<=16)
        {String cardtype=Valid_Creditcard.cardType(String.valueOf(card_num));
            if (cardtype.equals("INVALID"))
            {
                System.out.println("Error! Invalid card type");
                return 1;
            }
            else
            {
                int totalsum=Valid_Creditcard.validCardNum(this.card_num,count);
                if (totalsum%10==0)
                {
                    System.out.println("VALID CARD NUMBER");
                    System.out.println("Card Type: "+cardtype);
                    return 0;
                }
                else
                {
                    System.out.print("INVALID CARD NUMBER!!");
                    System.out.println(" Try another number.");
                    return 1;
                }
            }
        }
        else
        { System.out.println("Error! Card Number length should be between 13-16 digits ");
            return 1;
        }
    }
    static String cardType(String n)
    {if (n.charAt(0)=='4')
        return("Visa");
    else if (n.charAt(0)=='5')
        return("Mastercard");
    else if(n.charAt(0)=='6')
        return ("Discover cards");
    else if (n.charAt(0)=='3')
        if(n.charAt(1)=='7')
            return ("American Express card");
        else
            return("INVALID");
    else
        return("INVALID");
    }
    static int validCardNum(long n,int count)
    { int evensum=0,oddsum=0,c=1;
        while(c!=count+1)
        {int lastdig= (int) (n%10);
            if (c%2==0)
            {int mul=lastdig*2;
                if (mul>=10)
                {
                    evensum=evensum+(mul%10)+(int)(mul/10);
                }
                else
                {
                    evensum=evensum+mul;
                }
            }
            else
            {
                oddsum=oddsum+lastdig;
            }
            ++c;
            n /= 10;
        }

        return (evensum+oddsum);
    }
}
class Main {
    public static void main(String[] args) {
        int flag = 1;
        Scanner kb = new Scanner(System.in);
        Valid_Creditcard ob = new Valid_Creditcard();
        while (flag == 1) {
            System.out.print("Enter Credit Card Number = ");
            ob.card_num = kb.nextLong();
            flag = ob.cardValidCheck(ob.card_num);
        }
    }
}
