import java.util.Queue;
import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue<E> {

	private ReentrantLock lock = new ReentrantLock(true);
	private Condition notEmpty = lock.newCondition();
	private Condition notFull = lock.newCondition();
	private Queue<E> queue = new LinkedList<E>();
	private int max = 100;

	public void put(E e) throws Exception {
		lock.lock();
		try {
			while (queue.size() == max)
				notFull.wait();
			queue.add(e);
			notEmpty.signalAll();
		} finally {
			lock.unlock();
		}
	}

	public E take() throws Exception {
		lock.lock();
		try {
			while (queue.isEmpty())
				notEmpty.wait();
			E val = queue.remove();
			notFull.signalAll();
			return val;
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) throws Exception {
		var queue = new BlockingQueue<Integer>();
		Runnable producer = () -> {
			while (true)
				queue.put(100);
		};
		Runnable consumer = () -> {
			while (true)
				System.out.println(queue.take());
		};
		new Thread(producer).start();
		new Thread(consumer).start();
	}
}