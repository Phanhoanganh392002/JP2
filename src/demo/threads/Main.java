package demo.threads;

public class Main {
    public static void main(String[] args){
        BankAccount ba = new BankAccount();
        new Thread(()->{
            for(int i=0;i<10;i++){
                ba.deposit(200);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    //throw new RuntimeException(e);
                }
            }
        }).start();
        new Thread(()->{
            ba.withdraw(1000);
        }).start();
    }
    public static void main3(String[] args){
        Number n = new Number();
        Number n1 = new Number();

        Runnable r = ()->{
            for (int i=0;i<20;i++){
                //synchronized (n){
                n.changeNumber();
                n.printNumber();
                //}
                try {
                    Thread.sleep(1000);
                }catch (Exception e){}
            }
        };

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        Thread t3 = new Thread(r);
        t1.start();
//        try {
//            t1.join();
//        }catch (Exception e){}
        t2.start();
        t3.start();
    }

    public static void main2(String[] args){

        Subthread s1 = new Subthread();
        s1.start();

        SubRun s2 = new SubRun();
        Thread t1 = new Thread(s2);

        t1.setPriority(Thread.MAX_PRIORITY);

        t1.start();

        for(int i=0;i<20;i++){
            System.out.println("Main i="+i);
            try {
                Thread.sleep(1000);
            }catch (Exception e){

            }
        }

        Runnable r1 = new Runnable() {
            @Override
            public void run() {

            }
        };
        Thread t2 = new Thread(r1);
        t2.start();

        Runnable r2 = ()->{
            // chinh la ham run
        };


        new Thread(()->{

        }).start();
    }
}