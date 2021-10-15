public class User {
    public String name;
    public String email;
    private int balance;
    public String password;

    public User(String name, String email, int balance, String password){
        this.name = name;
        this.email = email;
        this.balance = balance;
        this.password = password;

    }

    public int getBalance(){

        return balance;
    }


    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public boolean verifyPassword(String password) {
        if (password.equals(this.password)){
            return true;
        } else {
            return false;
        }
    }

    public void payForPurchase(int totalPrice){

        this.balance -= totalPrice;
        Supermarket.updateTotalMoneyEarned(totalPrice);

    }
}
