import java.util.Scanner;

public class Main {

    Scanner scanner = new Scanner(System.in);
    Scanner intScanner = new Scanner(System.in);


    Supermarket supermarket = new Supermarket();

    public static void main(String[] args) {

        Main main = new Main();

        main.addProductMenu();
        main.menu();
    }

    void addProductMenu() {
        System.out.println("Please add products to the supermarket.");

        addProduct();

        String userInput = "";

        do {
            System.out.println("Select 1 to add products or select 2 to enter supermarket menu.");

            userInput = scanner.nextLine();
            switch (userInput){

                case "1":
                    addProduct();
                    break;
                case "2":
                    System.out.println("Let's start...");
                    break;
                default:
                    System.out.println("Please enter a valid input!");
            }

        } while (!userInput.equals("2"));
    }

    void menu() {

        String user = "";

        System.out.println("WELCOME TO THE SUPERMARKET");

        do {
            System.out.println("\nPlease choose your type of user or enter QUIT to exit supermarket:\n");
            System.out.println("1. Buyer");
            System.out.println("2. Sales representative");
            System.out.println("3. Owner\n");


            user = scanner.nextLine();
            switch (user) {
                case "Quit":
                    System.out.println("Exit Supermarket...");
                    break;
                case "1":
                    buyer();
                    break;
                case "2":
                    salesRepresentative();
                    break;
                case "3":
                    owner();
                default:
                    break;

            }
        } while (!user.toUpperCase().equals("QUIT"));
        return;
    }

    void salesRepresentative() {

        String salesRepresentative = "";

        do {

            System.out.println("Please choose an activity or enter QUIT to exit the program:");
            System.out.println("1. Add product");
            System.out.println("2. View all products");


            salesRepresentative = scanner.nextLine();
            switch (salesRepresentative) {
                case "Quit":
                    System.out.println("Exit Supermarket...");
                    break;
                case "1":
                    addProduct();
                    break;
                case "2":
                    getProducts();
                    break;
                default:
                    break;

            }

        }while (!salesRepresentative.toUpperCase().equals("QUIT"));
    }

    void owner(){
        String owner = "";

        do {

            System.out.println("Please choose an activity or enter QUIT to exit the program:");
            System.out.println("1. Please register a new user");
            System.out.println("2. Money earned");
            System.out.println("3. Money spent");
            System.out.println("4. View profit");
            System.out.println("5. View sales history");



            owner = scanner.nextLine();
            switch (owner) {
                case "Quit":
                    System.out.println("Exit Supermarket...");
                    break;
                case "1":
                    addNewUser();
                    break;
                case "2":
                    earnedMoney();
                    break;
                case "3":
                    spentMoney();
                    break;
                case "4":
                    viewProfit();
                    break;
                case  "5":
                    viewSalesHistory();
                    break;
                default:
                    break;

            }

        }while (!owner.toUpperCase().equals("QUIT"));

    }

    void buyer() {

        User currentUser = buyerLogIn();
        if (currentUser != null) {
            String buyer = "";
            do {
                System.out.println("\nPlease choose an activity or enter QUIT to exit the program:");
                System.out.println("1. View all products");
                System.out.println("2. Buy products");
                System.out.println("3. View available balance");

                buyer = scanner.nextLine();
                switch (buyer) {
                    case "Quit":
                        break;
                    case "1":
                        viewAllProducts();
                        break;
                    case "2":
                        buyProducts(currentUser);
                        break;
                    case "3":
                        System.out.println("Available balance is: " + currentUser.getBalance());
                    default:
                        break;
                }

            } while (!buyer.toUpperCase().equals("QUIT"));

        }else{
            System.out.println("Invalid Email or Password!!");
            buyer();
        }
    }

    void viewAllProducts(){
        System.out.println("Supermarket products: ");
        for (Product product : supermarket.getProducts()) {
            System.out.println("Name: " + product.getProductName() + "\nWeight: " + product.getWeight() + "\nPrice: " + product.getSellingPrice() + "\nAvailable amount: " + product.getAmount() + "\n-------------");

        }
    }

    void buyProducts(User currentUser) {

        getProducts();

        System.out.println("Enter the name of desired product: ");
        String productName = scanner.nextLine();

        Product product = supermarket.findByName(productName);

        System.out.println("Please enter amount: ");
        int amount = intScanner.nextInt();

        supermarket.sellProduct(product, currentUser, amount);


    }





    User buyerLogIn() {

        System.out.println("Enter your email");
        String email = scanner.nextLine();

        User currentUser = supermarket.findByEmail(email);

        System.out.println("Enter your password");
        String password = scanner.nextLine();

        if(currentUser != null) {
            if(currentUser.verifyPassword(password)) {
                return currentUser;
            }
        }

        return null;
    }




    void earnedMoney(){

        System.out.println("Supermarket earned: " + Supermarket.getTotalMoneyEarned() + " EUR");
    }

    void spentMoney(){

        System.out.println("Supermarket spent: " + Supermarket.getTotalMoneySpent() + " EUR");
    }

    void viewProfit(){
        System.out.println("Supermarket profit is: " + supermarket.getProfit());
    }

    void viewSalesHistory() {
        System.out.println("Sold products review: ");

        for (Product product : supermarket.getSoldProducts()) {
            System.out.println("Name: " + product.getProductName() + "\nWeight: " + product.getWeight() + "\nSold amount: " + product.getAmount() + "\nCost Price: " + product.getCostPrice() + "\nSelling Price: " + product.getSellingPrice() + "\n----------");

        }

    }


    void addProduct() {

        System.out.println("Product name: ");
        String productName = scanner.nextLine();

        System.out.println("Product weight: ");
        int productWeight = intScanner.nextInt();

        System.out.println("Product amount available: ");
        int productAmount= intScanner.nextInt();

        System.out.println("Product cost price: ");
        int productCostPrice = intScanner.nextInt();

        System.out.println("Product selling price: ");
        int productSellingPrice = intScanner.nextInt();

        Product product = new Product(productName, productWeight, productAmount, productCostPrice, productSellingPrice);
        supermarket.addProduct(product);



    }

    void getProducts() {
        System.out.println("Supermarket products:\n");
        for (Product product : supermarket.getProducts()) {
            System.out.println(product);


        }
    }

    void addNewUser() {
        System.out.println("Add a new user.");
        System.out.println("Enter user's name: ");
        String userName = scanner.nextLine();

        System.out.println("Enter user's email: ");
        String userEmail = scanner.nextLine();

        System.out.println("Available user's balance: ");
        int userBalance = intScanner.nextInt();

        System.out.println("Enter user's password: ");
        String userPassword = scanner.nextLine();


        User user = new User(userName, userEmail, userBalance, userPassword);
        supermarket.addUser(user);

    }
}








