package com.atfuture.domain;

public class TypeNumber {
	
	
	private String assessmentType;
	private int count;
	private Evaluate[] evaluates={Evaluate.EXCELLENT,Evaluate.GOOD,Evaluate.MEDIUM,Evaluate.POOR};

	public String getAssessmentType() {
		return assessmentType;
	}


	public void setAssessmentType(String assessmentType) {
		for (Evaluate e:evaluates) {
			if(e.getValue().equals(assessmentType)){
				this.assessmentType=e.getName();
				break;
			}else this.assessmentType = assessmentType;
		}
		
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public static TypeNumber newInstance(){
		return new TypeNumber();
	}
	@Override
	public String toString() {
		return "TypeNumber [assessmentType=" + assessmentType + ", count=" + count + "]";
	}
	
}
