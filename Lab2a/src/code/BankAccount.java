/**
 *  @author Lindokuhle Dubazane
 *  @author Given Sitole
 *
 * @version 1.0
 *
 * Represents a bank account with a balance, account number, and the account holder's last name.
 */
class BankAccount
{
    /**
     * Constructs a new BankAccount object.
     * @ param balanceCdn      the initial balance in the account
     * @ param accountNumber   the account number
     * @ param memberLastName  the last name of the account holder
     */

    private final String accountNumber;
    private final String memberLastName;
    private  double balanceCDN;

    BankAccount(final String accountNumber,
                final  String memberLastName,
                double balanceCDN)
    {
        this.accountNumber  =  accountNumber;
        this.memberLastName = memberLastName;
        this.balanceCDN     = balanceCDN;
    }

    /**
     * Returns the account number.
     *
     * @return the account number
     */
    public String getAccountNumber()
    {
        return accountNumber;
    }

    /**
     * Returns the last name of the account holder.
     *
     * @return the last name of the account holder
     */
    public String getMemberLastName()
    {
        return memberLastName;
    }

    /**
     * Returns the current balance in the account.
     *
     * @return the balance in CAD
     */
    public double getBalanceCDN()
    {
        return balanceCDN;
    }

    /**
     * Withdraws a specified amount from the account balance.
     *
     * @param amountCDN the amount to withdraw in CAD
     */
    public void withdraw(double amountCDN)
    {
        balanceCDN = balanceCDN - amountCDN;
    }

    /**
     * Deposits a specified amount into the account balance.
     *
     * @param amountCDN the amount to deposit in CAD
     */
    public void deposit(double amountCDN)
    {
        balanceCDN = balanceCDN + amountCDN;
    }

    /**
     * Transfers a specified amount from this account to another account.
     *
     * @param amountCDN         the amount to transfer in CAD
     * @param recipientAccount  the recipient account to transfer to
     */
    public void transfer(double amountCDN, BankAccount recipientAccount)
    {
       recipientAccount.deposit(amountCDN);
       withdraw(amountCDN);
    }
}
