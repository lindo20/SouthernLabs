import java.util.HashMap;
import java.util.Map;

/**
 * @author Lindokuhle Dubazane
 * @author Given Sitole
 *
 * @version 1.0
 * Represents a bank that manages multiple bank accounts.
 */
class Bank
{
    private final String bankName;
    private final Map<String, BankAccount> accounts;

    /**
     * Constructs a new Bank object with the specified name.
     *
     * @param bankName  the name of the bank
     */
    Bank(final String bankName)
    {
        this.bankName = bankName;
        this.accounts = new HashMap<>();
    }
    public String getBankName()
    {
        return bankName;
    }

    /**
     * Adds a new bank account to the bank.
     *
     * @param account  the BankAccount object to add
     */
    public void addAccount(BankAccount account)
    {
        accounts.put(account.getAccountNumber(), account);
    }

    /**
     * Retrieves a bank account by its account number.
     *
     * @param accountNumber  the account number of the desired account
     * @return the BankAccount object, or null if not found
     */
    public BankAccount getAccount(String accountNumber)
    {
        return accounts.get(accountNumber);
    }

    /**
     * Removes a bank account from the bank by its account number.
     *
     * @param accountNumber  the account number of the account to remove
     */
    public void removeAccount(String accountNumber)
    {
        accounts.remove(accountNumber);
    }

    /**
     * Returns the total number of bank accounts in the bank.
     *
     * @return the number of accounts
     */
    public int getNumberOfAccounts()
    {
        return accounts.size();
    }

    /**
     * Returns the total balance of all accounts in the bank in CAD.
     *
     * @return the total balance in CAD
     */
    public double getTotalAccountsBalanceCdn()
    {
        double totalCDN = 0;

        for (BankAccount account : accounts.values())
        {
            totalCDN += account.getBalanceCDN();
        }
        return totalCDN;
    }

    /**
     * Deposits a specified amount into a specific account by account number.
     *
     * @param amountCdn    the amount to deposit in CAD
     * @param accountNum   the account number of the account to deposit into
     */
    public void depositTo(double amountCdn, String accountNum)
    {
        BankAccount account = accounts.get(accountNum);
        if (account != null)
        {
            account.deposit(amountCdn);
        }
    }

    /**
     * Prints all customer data and the total bank balance.
     */
    public void printAllCustomerData()
    {
        for (BankAccount account : accounts.values())
        {
            System.out.printf("Customer %s has CAD $%.2f in account #%s%n", (account.getMemberLastName().toUpperCase()),
                    account.getBalanceCDN(), account.getAccountNumber());
        }

        System.out.printf("Total bank balance in all accounts for %s is CAD $%.2f%n",
                bankName, getTotalAccountsBalanceCdn());
    }

}
