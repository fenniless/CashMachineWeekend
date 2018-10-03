 

/**
 * @author ZipCodeWilmington
 */
public abstract class Account {

    private AccountData accountData;

    public Account(AccountData accountData) {
        this.accountData = accountData;
    }

    public AccountData getAccountData() {
        return accountData;
    }

    public void deposit(int amount) {
        updateBalance(getBalance() + amount);
    }

    public boolean withdraw(int amount) {
        if (canWithdraw(amount)) {
            updateBalance(getBalance() - amount);
            return true;
        } else {
            return false;
        }
    }

    protected boolean canWithdraw(int amount) {
        return getBalance() >= amount;
    }

    public int getBalance() {
        return accountData.getBalance();
    }

    private void updateBalance(int newBalance) {
        accountData = new AccountData(accountData.getId(), accountData.getName(), accountData.getEmail(),
                newBalance);
    }
}
