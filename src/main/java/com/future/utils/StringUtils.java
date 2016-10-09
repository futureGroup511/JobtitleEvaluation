package com.future.utils;

public class StringUtils {

	
	
	
	
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
}
