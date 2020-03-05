/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package william.threads;

import java.util.LinkedList;

/**
 *
 * @author APC
 */
public class Buffer implements IBuffer<Integer> {

    LinkedList<Integer> list = new LinkedList<>();
    int capacity = 2;

    @Override
    public void put(Integer val) throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (list.size() == capacity) {
                    wait();
                }
                System.out.println("Put in: " + val);
                list.add(val++);
                notifyAll();
                Thread.sleep(1000);
            }
        }
    }

    @Override
    public Integer get() throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (list.size() == 0) {
                    wait();
                }
                int val = list.removeFirst();
                System.out.println("Got: " + val);

                notifyAll();
                Thread.sleep(1000);

            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Buffer buffer = new Buffer();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    buffer.put(30);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    buffer.get();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

    }

}
