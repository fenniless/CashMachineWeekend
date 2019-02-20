package rocks.zipcode.atm;

import com.sun.xml.internal.bind.v2.model.core.ID;
import javafx.geometry.Insets;
import rocks.zipcode.atm.bank.Account;
import rocks.zipcode.atm.bank.Bank;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.layout.FlowPane;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ZipCodeWilmington
 */
public class CashMachineApp extends Application {

    private TextField field = new TextField();
    private CashMachine cashMachine = new CashMachine(new Bank());


    private Parent createContent() {
        VBox vbox = new VBox(10);
        vbox.setPrefSize(600, 600);
        vbox.setPadding(new Insets(10, 10, 10, 10));

        TextArea areaInfo = new TextArea();
        field.setPromptText("Enter your account number");
        field.setText("1000");
        areaInfo.setText(cashMachine.toString());



        Button btnSubmit = new Button("Login");
        btnSubmit.setOnAction(e -> {
            int id = Integer.parseInt(field.getText());
            cashMachine.login(id);

            areaInfo.setText(cashMachine.toString());
        });



            Button btnDeposit = new Button("Deposit");
            btnDeposit.setOnAction(e -> {
                float amount = Float.parseFloat(field.getText());
                cashMachine.deposit(amount);

                areaInfo.setText(cashMachine.toString());
            });



        Button btnWithdraw = new Button("Withdraw");
        btnWithdraw.setOnAction(e -> {
            float amount = Float.parseFloat(field.getText());
            cashMachine.withdraw(amount);

            areaInfo.setText(cashMachine.toString());
        });

        Button btnExit = new Button("Exit");
        btnExit.setOnAction(e -> {
            cashMachine.exit();
            areaInfo.setText(cashMachine.toString());

        });

        FlowPane flowpane = new FlowPane();


        if (cashMachine.toString().equals("Please Login First")) {
            flowpane.getChildren().add(btnSubmit);
            flowpane.getChildren().add(btnDeposit);
            flowpane.getChildren().add(btnWithdraw);
        } else {
            //thought i could put some buttons in here.
            //maybe once someone logs in, this will update.
            //it doesnt.

        }

        flowpane.getChildren().add(btnExit);
        vbox.getChildren().addAll(field, flowpane, areaInfo);
        return vbox;
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(createContent()));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}