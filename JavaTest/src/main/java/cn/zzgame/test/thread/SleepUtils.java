package cn.zzgame.test.thread;

import java.util.concurrent.TimeUnit;

public class SleepUtils {
	public static void second(long time) {
		try {
			TimeUnit.SECONDS.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
