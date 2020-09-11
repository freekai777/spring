package com.freekai;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

@RunWith(JUnit4.class)
public class JTest {

	@Test
	public void test(){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now);
		Set<String> set = new HashSet<>();
		for (int i = 0; i < 100; i++) {
			set.add("SYS" + now.format(formatter).substring(2));
		}
		set.iterator().forEachRemaining(i-> System.out.println(i));
	}

	@Test
	public void test1(){
		Long aa = 1595904904715L;
		Instant instant = Instant.ofEpochMilli(aa);
		LocalDateTime localDateTime1 = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
		LocalDateTime localDateTime = LocalDateTime.ofEpochSecond(aa, 3, ZoneOffset.ofHours(8));
		System.out.println(localDateTime1);
//		System.out.println(localDateTime.get);
	}
}
