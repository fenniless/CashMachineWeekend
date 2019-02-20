package rocks.zipcode.atm.bank;

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

    public void deposit(float amount) {

        updateBalance(getBalance() + amount);
    }

    public boolean withdraw(float amount) {
        if (canWithdraw(amount)) {
            updateBalance(getBalance() - amount);
            return true;
        } else {
            return false;
        }
    }

    protected boolean canWithdraw(float amount) {

        return getBalance() >= amount;
    }

    public float getBalance() {
        return accountData.getBalance();
    }

    private void updateBalance(float newBalance) {
        accountData = new AccountData(accountData.getId(), accountData.getName(), accountData.getEmail(),
                newBalance);
    }
}
