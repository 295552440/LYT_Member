package com.lyt.member.util;
public abstract  class Constant {
	
	
	public static int PAGE_SIZE = 15;// 默认每页记录�?
	public static int PAGE_SIZE_Photo = 15;// 默认每页记录�?
	public static int PAGE_SIZE_RecommendArticleList = 15;//首页左侧默认显示推荐文章�?
	public static int PAGE_SIZE_NewArticleList_OfBloggerhome = 10;//博主首页默认显示文章�?
	public static int Num_TopArticleList = 6;// 首页右侧默认显示热门文章�?
	public static int Num_NewArticleList = 6;// 首页右侧默认显示�?��文章�?
	public static int Num_TopBlogList = 3;// 首页右侧默认显示博主�?
	public static int Num_RecommendBlogList = 3;// 首页右侧默认显示推荐博主�?
	public static int HEADFILEMAXSIZE = 2097152;//用户头像图片文件�?���?
	public static int PHOTOMAXSIZE = 5242880;//普�?图片�?���?
	public static String ablumMiniImage="images/upload/1.jpg";//默认相册缩略�?
	public static String headImage="headImag/example.jpg";//默认头像
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static int getPAGE_SIZE() {
		return PAGE_SIZE;
	}
	public static void setPAGE_SIZE(int pAGE_SIZE) {
		PAGE_SIZE = pAGE_SIZE;
	}
	
	
	
	
	
}

