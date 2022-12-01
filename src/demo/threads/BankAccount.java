package demo.threads;

public class BankAccount {
    int balance = 0;

    public synchronized void deposit(int amount){
        if(amount>0){
            balance+= amount;
            System.out.println("Vua nap so tien: "+amount);
            notify();
//            notifyAll();
        }
    }

    public synchronized void withdraw(int amount){
//        if(amount > 0 && amount < balance){
//            balance -= amount;
//            System.out.println("Vua rut so tien: "+amount);
//        }
        if(amount < 0){
            System.out.println("So tien can rut khong hop le");
            return;
        }
        while (amount > balance){
            System.out.println("Khong du tien de rut "+amount);
            try {
                wait();
            }catch (Exception e){}
        }
        balance-= amount;
        System.out.println("Vua rut so tien: "+amount);
    }
}