package example;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ninemax-199 on 2014/4/14.
 */
public class Locks {
    public void lock(){
        Lock lock=new ReentrantLock();
        lock.lock();
        lock.unlock();
    }

}
