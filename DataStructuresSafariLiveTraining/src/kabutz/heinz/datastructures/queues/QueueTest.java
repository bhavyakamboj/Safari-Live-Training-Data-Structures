package kabutz.heinz.datastructures.queues;

import java.util.*;
import java.util.concurrent.*;

public class QueueTest {

	public static void main(String[] args) {
		// if you need put() and take()
		BlockingQueue<?> lbq = new LinkedBlockingQueue<>();
		// otherwise use this one
		Queue<?> clq = new ConcurrentLinkedQueue<>();
		
		// non thread-safe
		Queue<?> ll = new LinkedList<>();
		Queue<?> pq = new PriorityQueue<>();
		Queue<?> ad = new ArrayDeque<>();
		
		// thread-safe, blocking
		BlockingQueue<?> abq = new ArrayBlockingQueue<>(10);
		BlockingQueue<?> lbd = new LinkedBlockingDeque<>();
		BlockingQueue<?> sq  = new SynchronousQueue<>();
		BlockingQueue<?> dq  = new DelayQueue<>();
		BlockingQueue<?> pbq = new PriorityBlockingQueue<>();
		BlockingQueue<?> ltq = new LinkedTransferQueue<>();
		
		// thread-safe, not blocking
		Queue<?> clq1 = new ConcurrentLinkedQueue<>();
		Queue<?> cld = new ConcurrentLinkedDeque<>();
		
		// LinkedBlockingQueue unbounded
		ExecutorService fixed = new ThreadPoolExecutor(10,10,0L,TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<>(1000));
		// new ArrayBlockingQueue
		// new LinkedTransferQueue
		// SynchronousQueue - size 0 always empty
		ExecutorService cached = Executors.newCachedThreadPool();

	}

}
