package rocks.zipcode.atm;

import javafx.scene.control.TextArea;
import javafx.util.Pair;
import rocks.zipcode.atm.bank.Account;
import rocks.zipcode.atm.bank.AccountData;
import rocks.zipcode.atm.bank.Bank;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author ZipCodeWilmington
 */
public class CashMachine {

    private final Bank bank;
    private AccountData accountData = null;
    private TextArea areaInfo;

    public CashMachine(Bank bank) {

        this.bank = bank;
    }

    private Consumer<AccountData> update = data -> {
        accountData = data;
    };


    public void login(int id) {
        tryCall(
                () -> bank.getAccountById(id),
                update
        );
    }

    public void deposit(float amount) {
        if (accountData != null) {
            tryCall(
                    () -> bank.deposit(accountData, amount),
                    update
            );
        }
    }

    public void withdraw(float amount) {
//        getResultWindow().appendText("hello world");
        if (accountData != null) {
            tryCall(
                    () -> bank.withdraw(accountData, amount), update
            );
        }

    }

    public void exit() {
        if (accountData != null) {
            accountData = null;
        }
    }

    @Override
    public String toString() {
        return accountData != null ? accountData.toString() : "Please Login First";
    }

    private <T> void tryCall(Supplier<ActionResult<T> > action, Consumer<T> postAction) {
        try {
            ActionResult<T> result = action.get();
            if (result.isSuccess()) {
                T data = result.getData();
                postAction.accept(data);
            } else {
                String errorMessage = result.getErrorMessage();
                throw new RuntimeException(errorMessage);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    public void setResultWindow(TextArea areaInfo) {
        this.areaInfo = areaInfo;
    }

    public TextArea getResultWindow(){
        return this.areaInfo;
    }
}
