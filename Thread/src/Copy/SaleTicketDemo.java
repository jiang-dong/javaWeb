package Copy;

import java.util.concurrent.locks.ReentrantLock;

class Ticket {
    private int number = 30;
    ReentrantLock lock = new ReentrantLock();


    public void sale() {
        try {
            lock.lock();
            if (number > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出票数\t" + (number--) + "\t余下票数" + number);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


}

public class SaleTicketDemo {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();

        new Thread(() -> { for (int i = 1; i <= 10 ; i++)  ticket.sale(); },"A").start();
        new Thread(() -> { for (int i = 1; i <= 10 ; i++)  ticket.sale(); },"B").start();
        new Thread(() -> { for (int i = 1; i <= 10 ; i++)  ticket.sale(); },"C").start();


    }
}
