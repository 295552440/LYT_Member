package com.lyt.member.util;

import java.util.Random;

public abstract  class Constant {
	
	
	public static int PAGE_SIZE = 15;// 默认每页记录数
	public static int PAGE_SIZE_MemberList = 10;// 会员列表默认每页记录数
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static int getPAGE_SIZE() {
		return PAGE_SIZE;
	}
	public static void setPAGE_SIZE(int pAGE_SIZE) {
		PAGE_SIZE = pAGE_SIZE;
	}
	
	public static String getRandomNum(int length) {
		if (length <= 0) {
			length = 1;
		}
		StringBuilder res = new StringBuilder();
		Random random = new Random();
		int i = 0;
		while (i < length) {
			res.append(random.nextInt(10));
			i++;
		}
		return res.toString();
	}
	
	
	
}

