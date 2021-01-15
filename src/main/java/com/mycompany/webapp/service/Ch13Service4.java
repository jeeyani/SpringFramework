package com.mycompany.webapp.service;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Ch13Service4 {

	private static final Logger logger = LoggerFactory.getLogger(Ch13Service4.class);
	
	
	private List skillList;
	private Set skillSet;
	private Map skillMap;
	private Properties skillProp; //키와 값 둘다 String타입!!
	
	
	public void setSkillList(List skillList) {
		this.skillList = skillList;
	}
	
	public void setSkillSet(Set skillSet) {
		this.skillSet = skillSet;
	}
	
	public void setSkillMap(Map skillMap) {
		this.skillMap = skillMap;
	}
	
	public void setSkillProp(Properties skillProp) {
		this.skillProp = skillProp;
	}
	
	
}
