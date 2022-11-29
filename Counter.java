import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {

	private final Lock lock = new ReentrantLock();
	private int value = 0;

	public void increment() {
		lock.lock();
		try {
			value++;
		} finally {
			lock.unlock();
		}
	}

	public int get() {
		lock.lock();
		try {
			return value;
		} finally {
			lock.unlock();
		}
	}
}