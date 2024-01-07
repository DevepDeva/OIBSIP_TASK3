
import java.util.Scanner;
class AccountHolder {
    public String Transcation="Transcation History \n1";
    private double balance;
    int p =0;
    public AccountHolder(double initialBalance){
        balance=initialBalance;
    }
    public double getBalance(){
        return balance;
    }
    public void deposit(double amount){
        if(amount>0){

            balance += amount;
            p++;
            Transcation+=(""+ p +":diposit="+amount+"Total balance:"+balance+"\n");
            System.out.println("Money Deposit:"+amount);
        }else{
            System.out.println("Invalid amount for deposit!");
        }
    }
    public void withdraw(double amount){
        if(amount>0 && amount<=balance){
            balance -= amount;
            p++;
            Transcation+=(""+ p +": withdraw="+amount+"Total balance:"+balance+"\n");
            System.out.println("Money withdraw:"+amount);
        }else {
            System.out.println("Insufficient funds or invalid amount for withdrawl!");
        }
    }
    public  void transfer(double ac_no,double amount)
    {
        if(amount>0 && amount<=balance){
            balance-=amount;
            p++;
            Transcation+=(""+ p +":Transfer ="+amount+"Total balance:"+balance+"Transfer account no="+ac_no+"\n");
            System.out.println("Money Transfered:"+amount);
        }else {
            System.out.println("Insufficient funds or invalid amount for transfer !! ");
        }
    }
}
class ATM{
    private AccountHolder account;
    private Scanner scanner;
    public ATM(AccountHolder account){
        this.account=account;
        scanner =new Scanner(System.in);
    }
    public void showMenu(){
        System.out.println("-------------------WELCOME TO ATM----------------------");
        System.out.println("ATM Menu:");
        System.out.println("1.Check Balance");
        System.out.println("2.Deposit Cash");
        System.out.println("3.Withdraw Cash");
        System.out.println("4.Show Transacation");
        System.out.println("5.Transfer Amount");
        System.out.println("6.Exit");
    }
    public void begin(){
        System.out.println("Enter the pin");
        int pin=scanner.nextInt();
        if(pin==8650)
        {
            int choice;
            do{
                showMenu();
                System.out.println("Enter your choice:");
                choice=scanner.nextInt();
                switch (choice){
                    case 1:
                        checkBalance();
                        break;
                    case 2:
                        deposit();
                        break;
                    case 3:
                        withdraw();
                        break;
                    case 4:
                        System.out.println(account.Transcation);
                         break;
                    case 5:
                        transfer();
                        break;
                    case 6:
                        System.out.println("Exiting ATM.Thank You!");
                        break;
                    default:
                        System.out.println("Invalid choice.Please select a valid option");
                }

            }while(choice !=6);
        }
        else
        {
            System.out.println("Invalid pin\nPress 1.Try again \nPress 0.Exit");
            int choose=scanner.nextInt();
            if(choose==1)
            {
                begin();
            }
        }
    }
    private  void checkBalance(){
        System.out.println("Current Balance:"+account.getBalance());
    }
    private void deposit(){
        System.out.print ("Enter deposit amount:");
        double amount=scanner.nextDouble();
        account.deposit(amount);
    }
    private void withdraw(){
        System.out.print("Enter withdrawl account:");
        double amount=scanner.nextDouble();
        account.withdraw(amount);
    }
    private void transfer(){
        System.out.println("Enter the Account Number");
        double ac_no=scanner.nextDouble();
        System.out.print("Enter Transfer Amount:");
        double amount=scanner.nextDouble();
        account.transfer(ac_no,amount);
    }
}
