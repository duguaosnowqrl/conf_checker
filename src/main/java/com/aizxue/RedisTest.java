package com.aizxue;

import redis.clients.jedis.Jedis;

public class RedisTest {
	public static void main(String[] args) {
		Jedis jedis = new Jedis("192.168.103.128",6379);
		jedis.select(5);
		byte[] arr = "你好啊 哈哈哈好！！！".getBytes();
		jedis.set("aaa".getBytes(),arr);
		jedis.lpush("bbb".getBytes(), arr);
//		String str = jedis.get("aaa");
//		System.out.println(str);
	}
}
