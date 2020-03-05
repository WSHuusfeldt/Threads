/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package william.threads;

/**
 *
 * @author APC
 */
import java.util.Scanner;

/*
    A quick little program that shows what multithreading can do in its very basic state.
    The program asks the user for an amount of threads to be created and then how heavy
    the workload of each thread should go through.
*/
public class Init {

    public static void main(String[] args) {      
        int input1 = 0;
        int input2 = 0;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Please type in the amount of threads you wish to create..");
        while(true) {            
            try {
                input1 = sc.nextInt();
                break;
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Please try again.");
            }            
        }
        
        System.out.println("Please type in the amount of loops each thread will go through..");
        while(true) {            
            try {
                input2 = sc.nextInt();
                break;
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Please try again.");
            }            
        }
        
        for (int i = 0; i < input1; ++i) {
            Task taskRunner = new Task(input2);
            System.out.println("New thread with id: " + taskRunner.getId() + " has been started..");            
            taskRunner.start();
        }              
        System.out.println("Main thread ended..");
    }
}


class Task extends Thread {
    
    private int flow;
    
    public Task(int flow) {
        this.flow = flow;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < flow; ++i) {
            //Computer is counting ..
        }
        System.out.println("Thread with id: " + this.getId() + " has finished..");
    }
}
