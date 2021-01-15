package com.mycompany.webapp.dto;

import org.springframework.web.multipart.MultipartFile;

public class Ch14Member {

	private String mid;
	private String mname;
	private String mpassword;
	private boolean menabled;
	private String mrole;
	private String mphoto; //데이터베이스의 내용을 가져온 것을 저장하기 위한 필드
	private MultipartFile mphotoAttach; //다운로드 받기 위한 필드
	
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMpassword() {
		return mpassword;
	}
	public void setMpassword(String mpassword) {
		this.mpassword = mpassword;
	}
	public boolean isMenabled() {
		return menabled;
	}
	public void setMenabled(boolean menabled) {
		this.menabled = menabled;
	}
	public String getMrole() {
		return mrole;
	}
	public void setMrole(String mrole) {
		this.mrole = mrole;
	}
	public String getMphoto() {
		return mphoto;
	}
	public void setMphoto(String mphoto) {
		this.mphoto = mphoto;
	}
	public MultipartFile getMphotoAttach() {
		return mphotoAttach;
	}
	public void setMphotoAttach(MultipartFile mphotoAttach) {
		this.mphotoAttach = mphotoAttach;
	}
	
}
