import java.util.Random;
import java.util.random.RandomGenerator;

public class QuickEmiQuote {

    private static int principal_p;
    private static int tenure_n;
    private static double anualInterestRate_APR;
    private static double totalPayment;
    private static double totalInterest;
    private  static double monthlyRate_r;
    private static Random random = new Random();

    public static void main(String[] args) {
        randmomizeInputs();
        System.out.println("Principal= "+ principal_p +
                           "  tenure= " +tenure_n +
                           "  anual interest= " + anualInterestRate_APR);
    }


    static void randmomizeInputs()
    {
      principal_p = random.nextInt(5000,25001);
      tenure_n = random.nextInt(6,36);
      anualInterestRate_APR = RandomGenerator.getDefault().nextDouble(3.5,11.5);
    }

    /*
    * Compute EMI (Equated Monthly Installment – Use Math API)
     Monthly rate r = APR / 12 / 100
     EMI formula (use Math.pow):
    * */
    static  double calculateEmi()
    {
        monthlyRate_r = anualInterestRate_APR/(12/100);

        double emi = principal_p*monthlyRate_r*
                    Math.pow(1+monthlyRate_r,tenure_n)/
                    Math.pow(1+monthlyRate_r,tenure_n) -1;

        return emi;
    }

    static double getTotalPayment()
    {
        return calculateEmi() * tenure_n;
    }

    static double getTotalInterest()
    {
        return getTotalPayment() - principal_p;
    }
    /*
     Show multiple integer views of the EMI
    * */
    static void showMultipleIntegerViews()
    {
        System.out.printf("Integer value of EMI %d.2  is ", calculateEmi());
        //Rounded EMI to the nearest int using Math.round (e.g., $313)
        System.out.printf("Rounded value of EMI to the nearest is ", Math.round(calculateEmi()));
    }
}


