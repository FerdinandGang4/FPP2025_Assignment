import java.util.Random;
import java.util.random.RandomGenerator;

public class QuickEmiQuote {

    private static int principal_p;
    private static int tenure_n;
    private static double anualInterestRate_APR;
    private static double totalPayment;
    private static double totalInterest;
    private  static double monthlyRate_r;
    private static double emi;
    private static Random random = new Random();

    public static void main(String[] args) {
        randmomizeInputs();
        computeEmi();
        integerViewOfEmi();
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
        monthlyRate_r = anualInterestRate_APR / 12 / 100.0;
        double power = Math.pow(1 + monthlyRate_r,tenure_n);
        emi = principal_p * monthlyRate_r * power/ (power -1.0);
        totalPayment = emi * tenure_n;
        totalInterest = totalPayment - principal_p;

        int emiTruncated = (int)emi;
        long emiRounded = Math.round(emi);
    }

    static void integerViewOfEmi()
    {
        int emiTruncated = (int)emi;
        long emiRounded = Math.round(emi);
    }
    static void tryAsampleQuote()
    {
        System.out.println("======================================");
        System.out.println("      EMI Quote (sample)      ");
        System.out.println("======================================");
        System.out.printf("Monthly rate   $%,.3f %n", monthlyRate_r);
        System.out.printf("Total payment  $%,.2f %n", totalPayment);
        System.out.printf("Total Interest $%,.2f %n ", totalInterest);
    }
}


