package threads;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExecutorTest {
	public static void main(String[] args) {

		Thread t1 = new Thread() {
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("th1...");
			}
		};

		Thread t2 = new Thread() {
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("...th2");
			}
		};

		ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(2);

		executor.schedule(t2, 1, TimeUnit.SECONDS); // 1회성
		executor.scheduleWithFixedDelay(t1, 1, 5, TimeUnit.SECONDS); // 주기적으로 실행

		System.out.println("done");
	}
}
