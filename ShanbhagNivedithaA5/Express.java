import java.lang.Math; // Needed to import in order to use Math.ceil() function
import java.text.DecimalFormat; //Needed to import in order to use Decimal Format function

public class Express extends Service {

    //To have the format as 2 decimal places
    private static final DecimalFormat df = new DecimalFormat("0.00");

    //Start price of Express service set to 10
    private double startPrice = 10;

    //Express class variables
    private int length;
    private int width;
    private int height;
    private int DIMWeight;


    //Express constructor to pass in package name, weight, length, width and height of the package
    Express(String packageName, int weight, int length, int width, int height) {
        super();
        this.length = length;
        this.width = width;
        this.height = height;
        super.setWeight(weight);
        super.setPackageName(packageName);
        super.setDays(5);
        super.setRate(1.10);
        Dimensional_PriceCalc(super.getWeight());
    }

    //Dimensional_PriceCalc method to calculate the total price of the package and return the totalPrice
    double Dimensional_PriceCalc(int weight) {

        double totalPrice;
        double DIMW = (double) (length * width * height) / 166;
        DIMWeight = (int) Math.ceil(DIMW);

        if (DIMWeight > weight) {
            totalPrice = (startPrice + ((DIMWeight - 1) * super.getRate()));
        } else
            totalPrice = (startPrice + ((weight - 1) * super.getRate()));

        super.setTotalPrice(totalPrice);
        return totalPrice;
    }

    @Override
    public void printInfo() {}

    //To print out the Express service package, delivery speed, total price of express package and the price difference
    @Override
    public void printInfo(double priceDiff) {
        System.out.println("Service: Express");
        System.out.println("Delivery Speed: " + super.getDays() + " days");
        System.out.println("Total Price: $" + df.format(super.getTotalPrice()));
        System.out.println("Express service costs $" + df.format(priceDiff) + " more than Regular service.\n");
    }
}


/* Sources referred for Express class:
1. https://www.geeksforgeeks.org/super-keyword/
2. https://www.programiz.com/java-programming/super-keyword
3. https://beginnersbook.com/2014/07/super-keyword-in-java-with-example/
4. https://www.geeksforgeeks.org/the-override-annotation-in-java/
 */
