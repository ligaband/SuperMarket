public class Product {
    private String productName;
    private int weight;
    private int amount;
    private int costPrice;
    private int sellingPrice;




    Product(String productName, int weight, int amount, int costPrice, int sellingPrice){
        this.productName = productName;
        this.weight = weight;
        this.amount = amount;
        this.costPrice = costPrice;
        this.sellingPrice = sellingPrice;


    }



    public String getProductName() {

        return productName;
    }



    public void sellProduct(int amount){
        this.amount -= amount;

    }



    public int getWeight() {

        return weight;
    }

    public int getAmount() {

        return amount;
    }

    public int getCostPrice() {

        return costPrice;
    }

    public int getSellingPrice() {

        return sellingPrice;
    }

    public String toString(){
        return "Product name: " + productName +
                "\nWeight:\t" + weight +
                "\nAvailable amount:\t" + amount +
                "\nCost price:\t" + costPrice + "\nSelling price:\t" + sellingPrice + "\n----------";
    }
}
