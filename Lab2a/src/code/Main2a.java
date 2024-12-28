/**
 *  @author Lindokuhle Dubazane
 *  @author Given Sitole
 *
 * @version 1.0
 */
class Main
{
    public static void main(final String[] args)
    {
        Bank bank = new Bank("Bank of Kanada");

        BankAccount account1 = new BankAccount("abc111","woods" , 100.0);
        BankAccount account2 = new BankAccount("def222","gates",200.0);
        BankAccount account3 = new BankAccount("ghi333","bezos",300.0);
        BankAccount account4 = new BankAccount("jkl444","zuckerberg",400.0);

        bank.addAccount(account1);
        bank.addAccount(account2);
        bank.addAccount(account3);
        bank.addAccount(account4);


        bank.depositTo(22.22, "def222");

        bank.getAccount("abc111").transfer(5.00, bank.getAccount("ghi333"));

        bank.printAllCustomerData();

    }
}
