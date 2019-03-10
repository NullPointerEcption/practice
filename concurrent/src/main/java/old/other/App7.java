package old.other;

/**
 * 向账户里面存钱
 */
public class App7 {
    public static void main(String[] args) {
        Account account = new Account(0.0);
        for (int i = 0; i < 100; i++) {
            new Thread(new AddBalance(account, 1.0)).start();
        }
    }
}

class Account {

    private volatile double balance;//余额

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public /*synchronized*/ void addBalance(double addBalance) {
        double newBalance = balance + addBalance;
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.balance = newBalance;
        System.out.println("余额为:" + balance);
    }
}

class AddBalance implements Runnable {

    private Account account;
    private Double addBalance;

    public AddBalance(Account account, Double addBalance) {
        this.account = account;
        this.addBalance = addBalance;
    }

    @Override
    public void run() {
        this.account.addBalance(addBalance);
    }
}
