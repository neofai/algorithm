import java.util.ArrayList;
import java.util.List;

public class Transaction {
    Account account;

    List<String> transactions;

    public Transaction(Account account) {
        transactions = new ArrayList<>();
        this.account = account;
    }

    public synchronized boolean deposit(int money) {
        account.setBlance(account.getBlance() + money);
        transactions.add("Depositing $" + money);
        return true;
    }

    public synchronized boolean withdraw(int money) {
        if (account.getBlance() < money) {
            transactions.add(null);
            return false;
        }
        transactions.add("Withdrawing $" + money);
        account.setBlance(account.getBlance() - money);
        return true;
    }

    public List<String> getTransaction() {
        return transactions;
    }
}
