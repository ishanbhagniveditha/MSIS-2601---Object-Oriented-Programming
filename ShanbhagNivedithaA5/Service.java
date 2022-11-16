public abstract class Service {

    //Service class variables
    private int days;
    private int weight;
    private double rate;
    private String packageName;
    private double totalPrice;

    Service() {}

    //Set days
    public void setDays(int days) {this.days = days;}

    //Set PackageName
    public void setPackageName(String packageName) {this.packageName = packageName;}

    //Set weight of the package
    public void setWeight(int weight) {
        this.weight = weight;
    }


    //Set rate of the package
    public void setRate(double rate) {this.rate = rate;}


    //Set the total price of the package
    public void setTotalPrice(double price) {
        this.totalPrice = price;
    }

    //Getter function to get days
    public int getDays() {return days;}

    //Getter function to get weight of the package
    public int getWeight() {return weight;}

    //Getter function to get PackageName
    public String getPackageName() {return packageName;}

    //Getter function to get Rate
    public double getRate() {return rate;}

    //Getter function to get TotalPrice
    public double getTotalPrice() {return totalPrice;}


    //A method to compare price between the Regular and express delivery service.
    //To return the difference value
    public double comparePrice(Regular regularObj, Express expressObj) {
        double difference = expressObj.getTotalPrice() - regularObj.getTotalPrice();
        return difference;
    }

    //Abstract printInfo() method
    public abstract void printInfo();


    //Abstract printInfo(double priceDiff) method
    public abstract void printInfo(double priceDiff);
}

/* Sources referred for Service class:
1) https://www.geeksforgeeks.org/abstract-classes-in-java/
2) https://www.w3schools.com/java/java_abstract.asp
3) https://cs-fundamentals.com/java-programming/java-classes-and-objects
4) https://www.w3schools.com/java/java_encapsulation.asp
5) https://www.geeksforgeeks.org/getter-and-setter-in-java/
 */