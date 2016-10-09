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
import com.atfuture.domain.Expert;
import com.atfuture.domain.ParticipatedPerson;
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
	public void TestFindByExpertAndSoOn(){
		Expert expert=Expert.newInstance();
		expert.setExp_id(1);
		//先得到专家，要想查同单位或者同专业的先查人员，不想查的直接写null
		List<ParticipatedPerson> persons=participatedPersonService.findByExpertUnitAndSpecialt(1, 1);
		Page_S data=evaluatedRecordService.findByExpertUnitAndSpecialty(expert, page,null);
		printfPagedata(data);
	}
	
	@Test
	public void TestLikeFindByExpert(){
		Page_S data=evaluatedRecordService.likeFindByExpertNameOrAllassessment("夏", "30", page);
		printfPagedata(data);
	}
	
	
	public void printfPagedata(Page_S page){
		List<EvaluatedRecord> es=page.getRecordlist();
		Iterator<EvaluatedRecord> iterator=es.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}
}
