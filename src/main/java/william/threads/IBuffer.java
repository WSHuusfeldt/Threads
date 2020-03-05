/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package william.threads;

/**
 *
 * @author APC
 * @param <T>
 */
public interface IBuffer<T> {
    public void put(T t) throws InterruptedException;
    public T get() throws InterruptedException;
}
