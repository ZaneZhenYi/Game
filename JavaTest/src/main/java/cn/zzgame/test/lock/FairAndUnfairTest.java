package cn.zzgame.test.lock;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.junit.Test;

public class FairAndUnfairTest {
	
	private static Lock fairLock = new ReentrantLock2(true);
	private static Lock unFairLock = new ReentrantLock2(false);
	
	@Test
	public void fair() {
		testLock(fairLock);
	}
	
	@Test
	public void unFair() {
		testLock(unFairLock);
	}
	
	private void testLock(Lock lock) {
		for (int i = 0; i < 5; i++) {
			new Thread(new Job(lock), i + "").start();
		}
	}
	
	private static class Job implements Runnable {

		private Lock lock;
		public Job(Lock lock) {
			this.lock = lock;
		}
		
		@Override
		public void run() {
			lock.lock();
			try {
				System.out.println("Lock by [" + Thread.currentThread().getName() + "], Waiting by " + ((ReentrantLock2)lock).getQueuedThreads());
				System.out.println("Lock by [" + Thread.currentThread().getName() + "], Waiting by " + ((ReentrantLock2)lock).getQueuedThreads());
			} finally {
				lock.unlock();
			}
		}
		
	}
	
	private static class ReentrantLock2 extends ReentrantLock {
		private static final long serialVersionUID = 1L;
		public ReentrantLock2(boolean fair) {
			super(fair);
		}
		public Collection<Thread> getQueuedThreads() {
			List<Thread> threads = new ArrayList<Thread>(super.getQueuedThreads());
			Collections.reverse(threads);
			return threads;
		}
	}
}
