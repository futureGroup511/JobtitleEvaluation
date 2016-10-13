package com.future.utils;

public class StringUtils {
	//需要得到的字符的长度
	public static final int ACCOUNTNUMLENGTH = 4;
	
	
	
	//判断数组是否为可用数组  不为空，并且不是空格
	public static boolean isInvalidArr(String[] strArr){
		
		for(int i=0;i<strArr.length;i++){
			if(strArr[i]==null || strArr[i].trim() == ""){
				return false;
			}
		}
		return true;
	}
	
	public static boolean isValidArr(String[] strArr){
		
		if(strArr == null || strArr.length == 0) return false;
		if(strArr[0] == null || strArr[0].trim() == "" ) return false;
		return true;
	}
	
	
	//得到 0001 格式的自付出，根据数字 1，2等
	public static String getFourStr(int src){
		StringBuffer srcStr = new StringBuffer(src+"");
		srcStr.reverse();//取反
		int offset = srcStr.length();
		for(int i=0;i<ACCOUNTNUMLENGTH-offset;i++){
			srcStr.append('0');
		}
		return srcStr.reverse().toString();
	}
	
	//取得四位字符串的 非零起始至结尾    0090   --》    90
	public static Integer str2Int(String srcStr){
		StringBuffer sb = new StringBuffer(srcStr);
		int offset = srcStr.indexOf('0');
		sb.substring(offset+1);
		return Integer.parseInt(sb.toString());
	}
	

	/*public static void main(String[] args) {
		System.out.println(getFourStr(1022));
		System.out.println(str2Int("0213"));
		System.out.println(str2Int("1013"));
		System.out.println(str2Int("0203"));
		System.out.println(str2Int("0513"));
	}*/
}
