import java.util.Scanner;

public class Client {
    private DispenseChain c1;

    public Client() {
        this.c1 = new Dollar50Dispencer();
        DispenseChain c2 = new Dollar20Dispencer();
        DispenseChain c3 = new Dollar10Dispencer();

        c1.setNextChain(c2);
        c2.setNextChain(c3);
    }

    public void dispense(Currency currency){
        c1.dispense(currency);
    }
    public void dispense(int ammount){
        c1.dispense(new Currency(ammount));
    }

    public static void main(String[] args) {
        Client atm = new Client();

        while (true){
            int amount = 0 ;
            System.out.println("Enter amount to dispense");
            Scanner scan = new Scanner(System.in);
            amount = scan.nextInt();

            if (amount % 10 !=0){
                System.out.println("Anount should be in multiple of 10");
                return;
            }

            //atm.c1.dispense(new Currency(amount));
            atm.dispense(new Currency(amount));
        }
    }
}