package com.atfuture.domain;

import java.util.Iterator;
import java.util.List;

public class TypeNumber {
	private int ANumber=0; //A类人数
	private int BNumber=0; //B类人数
	private int CNumber=0; //C类人数
	private int DNumber=0; //C类人数
	
	
	public static TypeNumber newInstance(){
		return new TypeNumber();
	}
	
	
	public void giveTypeNum(List<Object[]> result){
		Iterator<Object[]> iterator=result.iterator();
		while(iterator.hasNext()){
			Object[] objects=iterator.next();
			int typeNum=Integer.valueOf(objects[0].toString());
			String assessmentType=String.valueOf(objects[1]);
			if(ChooseType.Aassessment.equals(assessmentType)) setANumber(typeNum);
			if(ChooseType.Bassessment.equals(assessmentType)) setBNumber(typeNum);
			if(ChooseType.Cassessment.equals(assessmentType)) setCNumber(typeNum);
			if(ChooseType.Dassessment.equals(assessmentType)) setDNumber(typeNum);
		}
	}


	public int getANumber() {
		return ANumber;
	}


	public void setANumber(int aNumber) {
		ANumber = aNumber;
	}


	public int getBNumber() {
		return BNumber;
	}


	public void setBNumber(int bNumber) {
		BNumber = bNumber;
	}


	public int getCNumber() {
		return CNumber;
	}


	public void setCNumber(int cNumber) {
		CNumber = cNumber;
	}


	public int getDNumber() {
		return DNumber;
	}


	public void setDNumber(int dNumber) {
		DNumber = dNumber;
	}
	
	
}
