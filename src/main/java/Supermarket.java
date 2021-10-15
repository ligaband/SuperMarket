import java.util.ArrayList;

public class Supermarket {
    private ArrayList<Product> products;
    private ArrayList<User> users;
    private ArrayList<Product> soldProducts;
    public static int totalMoneySpent;
    public static int totalMoneyEarned;


    public Supermarket() {
        this.products = new ArrayList<>();
        this.users = new ArrayList<>();
        this.soldProducts = new ArrayList<>();


    }


    public void addProduct(Product product) {

        this.products.add(product);
        totalMoneySpent += product.getCostPrice() * product.getAmount();
    }


    public static void updateTotalMoneySpent(int moneyEarned) {

        totalMoneyEarned+= moneyEarned;
    }

    public static void updateTotalMoneyEarned(int moneyEarned) {

        totalMoneyEarned += moneyEarned;
    }

    public static int getTotalMoneySpent() {

        return totalMoneySpent;
    }

    public static int getTotalMoneyEarned() {

        return totalMoneyEarned;
    }

    public int getProfit() {
        return totalMoneyEarned - totalMoneySpent;

    }


    public void addUser(User user) {

        this.users.add(user);
    }


    public ArrayList<Product> getSoldProducts() {
        return soldProducts;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public User findByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }

        return null;
    }

    public Product findByName(String productName) {
        for (Product product : products) {
            if (productName.equalsIgnoreCase(product.getProductName())) {
                return product;
            }
        }
        return null;
    }

    public void sellProduct(Product product, User currentUser, int amount) {
        if (product.getAmount() != 0) {
            if (amount <= product.getAmount()) {
                int totalPrice = amount * product.getSellingPrice();

                if (currentUser.getBalance() >= totalPrice) {
                    currentUser.payForPurchase(totalPrice);

                    product.sellProduct(amount);

                    Product soldProduct = new Product(product.getProductName(), product.getWeight(), amount, product.getCostPrice(), totalPrice);
                    this.soldProducts.add(soldProduct);
                    System.out.println("Thank you for your purchase!");
                } else {
                    System.out.println("Not enough funds, please check your balance!");
                }

            } else {
                System.out.println("Your desired amount is not available, please try again. Available amount is: " + product.getAmount());
            }
        }else{
            System.out.println("Product is sold out!");

        }
    }
}
