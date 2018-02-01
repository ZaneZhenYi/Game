package cn.zzgame.test.thread;

public class DefaultThreadPoolTest {
	public static void main(String[] args) {
		int count = 20;
		DefaultThreadPool<Runnable> threadPools = new DefaultThreadPool<Runnable>(count);
		for (int i = 0 ; i < count; i++)
			threadPools.execute(new Runnable() {
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName());
				}
			});
	}
}
