package cn.zzgame.test.lock;

public class ThreadTest1 extends Thread {
	private Thread parent;

	public ThreadTest1(Thread parent) {
		this.parent = parent;
	}

	public void run() {
		while (true) {
			System.out.println("sub thread is running...");
			long now = System.currentTimeMillis();
			while (System.currentTimeMillis() - now < 2000) {
				// 为了避免Thread.sleep()而需要捕获InterruptedException而带来的理解上的困惑,
				// 此处用这种方法空转2秒
			}
			parent.interrupt();
		}
	}

	public static void main(String[] args) {
		ThreadTest1 t = new ThreadTest1(Thread.currentThread());
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			System.out.println("Parent thread will die...");
		}
		System.out.println("Main Thread");
	}
}
