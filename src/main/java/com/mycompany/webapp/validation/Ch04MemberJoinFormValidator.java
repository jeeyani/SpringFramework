package com.mycompany.webapp.validation;

import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.mycompany.webapp.dto.Ch04Member;


public class Ch04MemberJoinFormValidator implements Validator{
	
	private static final Logger logger = LoggerFactory.getLogger(Ch04MemberJoinFormValidator.class);

	@Override
	public boolean supports(Class<?> clazz) {
		
		boolean support = Ch04Member.class.isAssignableFrom(clazz);
		return support;
		
	}

	@Override
	public void validate(Object target, Errors errors) {
		logger.info("실행- 각 필드마다 유효성 검사 실시");
		
		Ch04Member member = (Ch04Member) target;
		
		if(member.getMid() == null || member.getMid().trim().equals("")) {
			errors.rejectValue("mid","errors.mid.required");
		} else if(member.getMid().length() <4) {
			errors.rejectValue("mid","errors.mid.minlength",new Object[] {4},"");
		}
		
		if(member.getMpassword() == null || member.getMpassword().trim().equals("")) {
			errors.rejectValue("mpassword","errors.mpassword.required");
		} else if(member.getMpassword().length() <8) {
			errors.rejectValue("mpassword","errors.mpassword.minlength",new Object[] {8},"");
		}
		
		if(member.getMemail() == null || member.getMemail().trim().equals("")) {
			errors.rejectValue("memail","errors.memail.required");
		} else  {
			String emailEx = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
			Pattern emailPattern = Pattern.compile(emailEx);
			if(! emailPattern.matcher(member.getMemail()).matches()) {
			errors.rejectValue("memail","errors.memail.invalid");
			}
		}
		if(member.getMtel() == null || member.getMtel().trim().equals("")) {
			errors.rejectValue("mtel","errors.mtel.required");
		} else  {
			String telEx = "^\\d{3}-\\d{3,4}-\\d{4}$";
			Pattern telPattern = Pattern.compile(telEx);
			if(!telPattern.matcher(member.getMtel()).matches()) {
				errors.rejectValue("mtel","errors.mtel.invalid");
			}
		}
		
	}


	


}
