package com.atfuture.test;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.atfuture.domain.EvaluatedRecord;
import com.atfuture.domain.TypeNumber;
import com.atfuture.service.EvaluatedRecordService;
import com.atfuture.service.ParticipatedPersonService;
import com.atfuture.utils.Page_S;

@RunWith(value=SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class EvaluatedRecordActionTest {
	private static Logger logger=Logger.getLogger(EvaluatedRecord.class);
	@Resource
	private EvaluatedRecordService evaluatedRecordService;
	@Resource
	private ParticipatedPersonService participatedPersonService;
	private static Page_S page=Page_S.getDefaultInstace();
	@Test
	public void test(){
		List<TypeNumber> teTypeNumbers=evaluatedRecordService.getAssessmentCountByExpertId(1);
		Iterator<TypeNumber> iterator=teTypeNumbers.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}
	

	
}
