package com.aizxue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class LogReader {
	public static void main(String[] args) throws Exception {
		String path = "G:\\ssh\\log.txt";
		FileReader fr = new FileReader(path);
		BufferedReader br = new BufferedReader(fr);
		FileWriter fw = new FileWriter("G:\\ssh\\log-ext.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		String line = null;
		while((line = br.readLine()) != null) {
			if(line.indexOf("chat发来消息") > -1) {
				continue;
			}
			if(line.indexOf("world发来消息") > -1) {
				continue;
			}
			if(line.indexOf("red check") > -1) {
				continue;
			}
			if(line.indexOf("offline") > -1) {
				continue;
			}
			StringBuilder sb = new StringBuilder();
			LineReader lr = new LineReader(line);
			sb.append(lr.nextWorld());
			sb.append(" ");
			lr.nextWorld();
			lr.nextWorld();
			lr.nextWorld();
			String mod = lr.nextWorld();
			sb.append(mod);
//			if(!"offline".equals(mod)) {
				sb.append(" ");
				sb.append(lr.nextWorld());
//			}
			sb.append("\n");
			System.out.println(sb.toString());
			bw.write(sb.toString());
		}
		System.out.println("数据读取完毕");
		br.close();
		bw.close();
	}
}

class LineReader {
	String str;
	int index = 0;
	LineReader(String str){
		this.str = str;
	}
	
	int nextSpace(){
		while(true) {
			if(str.charAt(index) != ' ') {
				continue;
			}
			if(index < 21) {
				continue;
			}
			return index;
		}
	}
	
	String nextWorld() {
		StringBuilder sb = new StringBuilder();
		boolean start = false;
		try {
			while(true) {
				if(str.charAt(index) != ' ') {
					sb.append(str.charAt(index));
					start = true;
				}else {
					if(index < 21) {
						sb.append(str.charAt(index));
					}else {
						if(!start) {
							index++;
							continue;
						}
						break;
					}
				}
				index++;
			}
		} catch (Exception e) {
			System.out.println(str);
			throw e;
		}
		return sb.toString();
	}
}
