# CashMachine
An example cash machine &lt;-> bank system implementation

uses JavaFX for the user interface.

## Lab Brief

Notice the structure of the current project before you start. Read thru the code. READ THRU THE CODE.
* 2 Account Classes: Basic, Premium
* Other Classes include Bank, Account, CashMachine.

Read them all, trying to get an idea of how it all goes together.

### Notice when reading the code...
* Each account has: id, name, email, balance
  * What does Premium account do that Basic does not?
* What are the two starter account already built into the project?
* Cash machine: enter account id to "login to account"
* enter a number then click deposit
* enter a number then click withdraw
* exit logs out of the account

## Things to Change for the Lab

* Add more accounts to the default constructor of the Bank class.
* when you overdraft an account, print an alert message to the areaInfo object

### Additional things to add

* make the account display more user friendly
  * add a Form layout that has separate TextFields for each piece of account info. You'll probablyfind a layout that lets you do this, a little like the FlowPane.
* make the login stuff more clear
  * disable the three buttons that operate on an account until a login happens and then enable them.
  * add another TextField for the amount entries. make it different from the fieldwhere you set the account ID.
* enable the amount entries to be floating point numbers instead of just integers when doing deposits and withdrawals.
* add a menu with a list of accounts in it and the menu action switched to that account. You may find that JavaFX already has such a thing.

* Add a New Account Window(!) that takes in the info required thru TextFields and creates the correct objects so that is can be changed like the pre-wired accounts.

___

NB:
When googling for information on how to do all this, be sure you start every query with "javafx " and your other search terms. That will limit the results to things that probably are closer to what you need.
