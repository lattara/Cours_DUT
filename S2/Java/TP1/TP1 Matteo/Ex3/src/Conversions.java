public class Conversions 
{
public static char test (char c) 
{
    if ()
    {
        System.out.print("Erreur : salaire négatif ");
        return 0;
    }
    else if (revenu<=20000)
    {
        return revenu*.05;
    }
    else if (revenu<=40000)
    {
        return revenu*0.1;
    }
    else if (revenu<=60000)
    {
        return revenu*0.15;
    }
    else
    {
        return revenu*0.3;
    }
}

public static void main(String[] args) 
{
    System.out.print("");
    System.out.println(test('a'));
}
}