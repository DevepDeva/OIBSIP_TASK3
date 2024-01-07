public class ATMMain {
    public static void main(String[] args) {
                 AccountHolder userAccount = new AccountHolder(10000);
                 ATM atm=new ATM(userAccount);
                 atm.begin();
    }
}