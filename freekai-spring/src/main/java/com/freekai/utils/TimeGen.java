package com.freekai.utils;

import javax.management.RuntimeErrorException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

public class TimeGen {

	private Long lastTimeStamp = -1L; // 上次生成的时间戳

	public synchronized Long time(){
		Long result = currentMills();
		if(result < lastTimeStamp){ // 可能发生了时钟回退
			throw new RuntimeErrorException(new Error("生成序列号失败"));
		}

		if((Objects.equals(result, lastTimeStamp))) { //同一时刻生成==>毫秒内序列
			System.out.println("===same time==");
			result = tilNextMillis(lastTimeStamp);
		}
		lastTimeStamp = result;
		return result;
	}

	/**
	 * 阻塞到下一个毫秒，直到获得新的时间戳
	 *
	 * @param lastTimestamp 上次生成ID的时间截
	 * @return 当前时间戳
	 */
	protected long tilNextMillis(long lastTimestamp) {
		long timestamp = currentMills();
		while (timestamp <= lastTimestamp) {
			timestamp = currentMills();
		}
		return timestamp;
	}

	private Long currentMills(){
		return System.currentTimeMillis();
	}

	public static void main(String[] args) throws InterruptedException {
		TimeGen timeGen = new TimeGen();
		Set<Long> set = new HashSet<>();
		for (int i = 0; i < 100; i++) {
//			set.add(timeGen.time());
		}
		CountDownLatch c = new CountDownLatch(1);
//		System.out.println(set.size());
		Thread t  = new Thread(()->{
			try {
				c.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for (int i = 0; i < 100; i++) {
				set.add(timeGen.time());
			}
		});
		Thread t2  = new Thread(()->{
			try {
				c.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for (int i = 0; i < 100; i++) {
				set.add(timeGen.time());
			}
		});
		t.start();
		t2.start();
		c.countDown();
		t.join();
		t2.join();
		System.out.println(set.size());
	}
}
