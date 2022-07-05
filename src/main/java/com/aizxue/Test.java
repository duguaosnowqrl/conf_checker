package com.aizxue;

import java.io.ByteArrayOutputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.util.Arrays;

import com.aizxue.commons.io.ByteBuffer;

public class Test {
	public static void main(String[] args) throws Exception {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(baos);
		DataOutput out = dos;
		out.writeUTF("哈哈不是ad防守打法");
		System.out.println(Arrays.toString(baos.toByteArray()));
		ByteBuffer buffer = new ByteBuffer();
		buffer.writeString("哈哈不是ad防守打法");
		System.out.println(Arrays.toString(buffer.toByteArray()));
	}
}
