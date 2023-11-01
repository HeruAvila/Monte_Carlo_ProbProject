

public class Main {
    public static void main(String[] args) {
        System.out.println(isBusy(getRanNum(51)));
        System.out.println(getRanNum(51) + " "+getRanNum(52)+" "+getRanNum(53));
    }

    public static double getRanNum(int n)
    {
        int xnought = 1000;
        int multiplier = 24693;
        int increment = 3517;
        double modulus = 131072;
        int number= n+1;
        double[] ranNums = new double[number];
        randomNumberGen(xnought,multiplier,increment,modulus,number,ranNums);
        return(uRepresent(ranNums[n],modulus));
    }

    public static void randomNumberGen(int seed, int mult, int inc, double mod, int noOfRandom, double[] randomNums)
    {
        randomNums[0] = seed;
        for(int i =1; i <noOfRandom;i++)
        {
            randomNums[i] = (((randomNums[i-1]*mult)+inc) % mod); //Appendix Formula
        }
    }
    public static double uRepresent(double number, double mod)
    {
        //gets decimal format and then rounds to 4 digits
        number = number / mod;
        number =Math.round(number*10000);
        number = number/10000;
        return number;
    }

    public static busyState isBusy(double randomNum)
    {
        randomNum = ((int)(randomNum*100))+1;
        if(randomNum<=20)
        {
            return busyState.BUSY;
        }
        else if(randomNum<=50)
        {
            return busyState.UNAVAILABLE;
        }
        else
        {
            return busyState.AVAILABLE;
        }
    }

}