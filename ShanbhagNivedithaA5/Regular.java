import java.text.DecimalFormat; // Needed to import in order to use Decimal Format function
public class Regular extends Service {

    //To have the format as 2 decimal places
    private static final DecimalFormat df = new DecimalFormat("0.00");

    //Start price of Regular service set to 5
    private double startPrice = 5;

    //Regular constructor to pass packageName and weight of the package
    Regular(String packageName, int weight) {
        super();
        super.setWeight(weight); //To set the weight of the package
        super.setPackageName(packageName); //To set the packageName
        super.setDays(14); //To set the days of regular service = 14
        super.setRate(0.60); //To set the regular service to 0.60
        TotalPriceFromRegular(super.getWeight()); //To get the weight
    }


    //TotalPriceFromRegular method to get the total price of regular service formula
    public double TotalPriceFromRegular(int weight) {
        double total_price = (startPrice + ((weight - 1) * super.getRate()));
        super.setTotalPrice(total_price);
        return total_price;
    }

    //To print out the Receiver package name, delivery speed and total price of regular service
    @Override
    public void printInfo() {
        System.out.println(super.getPackageName() + "'s package");
        System.out.println("Service: Regular");
        System.out.println("Delivery Speed: " + super.getDays() + " days");
        System.out.println("Total Price: $" + df.format(super.getTotalPrice()) + "\n");
    }


    @Override
    public void printInfo(double priceDiff) {}
}


/* Sources referred for Regular class:
1. https://www.geeksforgeeks.org/super-keyword/
2. https://www.programiz.com/java-programming/super-keyword
3. https://beginnersbook.com/2014/07/super-keyword-in-java-with-example/
4. https://www.geeksforgeeks.org/the-override-annotation-in-java/
 */