import java.util.Random;
import java.util.random.RandomGenerator;

public class QuickEmiQuote {

    private static int principal_p;
    private static int tenure_n;
    private static double anualInterestRate_APR;
    private static int totalPayment;
    private static int totalInterest;
    private  static double monthlyRate_r;
    private static double emi;
    private static Random random = new Random();

    public static void main(String[] args) {
        randmomizeInputs();
        computeEmi();
        tryAsampleQuote();
    }

    static void randmomizeInputs()
    {
      principal_p = random.nextInt(5000,25001);
      tenure_n = random.nextInt(6,37);
      anualInterestRate_APR = Math.round( RandomGenerator.getDefault().nextDouble(3.5,11.5) *10)/10.0;
    }

    static void computeEmi()
    {
        monthlyRate_r = anualInterestRate_APR / 12 / 100;
        emi = (principal_p * monthlyRate_r) * Math.pow(1 + monthlyRate_r,tenure_n)/ Math.pow(1 + monthlyRate_r, tenure_n) -1;
        totalPayment = Math.round((int)emi) * tenure_n;
        totalInterest = totalPayment - principal_p;
    }

    static void tryAsampleQuote()
    {
        System.out.println("Monthly rate   :" + monthlyRate_r);
        System.out.println("Total payment  :" + totalPayment);
        System.out.println("Total Interest :" + totalInterest);
    }
}


