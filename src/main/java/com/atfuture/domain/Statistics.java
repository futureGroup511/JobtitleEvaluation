package com.atfuture.domain;

import java.util.Iterator;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="statistics")
public class Statistics {
	//统计id
	private Integer sta_id;
	//统计所属申报人
	private ParticipatedPerson sta_participatedPerson;
	//A类专家评论得分
	private float sta_AScored;
	//B类专家评论得分
	private float sta_BScored;
	private float sta_CScored;
	//总得分
	private float sta_AllScored;
	
	private final static String  AITEMS="A";
	private final static String  BITEMS="B";
	private final static String  CITEMS="C";
	
	@Id
	@GeneratedValue
	@Column(name="sta_id")
	public Integer getSta_id() {
		return sta_id;
	}
	public void setSta_id(Integer sta_id) {
		this.sta_id = sta_id;
	}
	@OneToOne()
	public ParticipatedPerson getSta_participatedPerson() {
		return sta_participatedPerson;
	}
	public void setSta_participatedPerson(ParticipatedPerson sta_participatedPerson) {
		this.sta_participatedPerson = sta_participatedPerson;
	}
	public float getSta_AScored() {
		return sta_AScored;
	}
	public void setSta_AScored(float sta_AScored) {
		this.sta_AScored = sta_AScored;
	}
	public float getSta_BScored() {
		return sta_BScored;
	}
	public void setSta_BScored(float sta_BScored) {
		this.sta_BScored = sta_BScored;
	}
	public float getSta_CScored() {
		return sta_CScored;
	}
	public void setSta_CScored(float sta_CScored) {
		this.sta_CScored = sta_CScored;
	}
	public float getSta_AllScored() {
		return sta_AllScored;
	}
	public void setSta_AllScored(float sta_AllScored) {
		this.sta_AllScored = sta_AllScored;
	}
	public static Statistics newInstance(){
		return new Statistics();
		
	}
	
	public void setScoredByTypes(List<Object[]> result){
		Iterator<Object[]> iterator=result.iterator();
		while(iterator.hasNext()){
			Object[] objects=iterator.next();
			String type=String.valueOf(objects[1]);
			float scored=Float.valueOf(objects[0].toString());
			if(type.equals(AITEMS)) this.setSta_AScored(scored);
			else if(type.equals(BITEMS)) this.setSta_BScored(scored);
			else if(type.equals(CITEMS)) this.setSta_CScored(scored);
			
		}
		//计算总值
		this.sta_AllScored=(float) (this.sta_AScored*0.50+this.sta_BScored*0.30+this.sta_CScored*0.20);
	}
}
