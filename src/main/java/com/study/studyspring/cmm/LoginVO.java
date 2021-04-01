package com.study.studyspring.cmm;

import java.io.Serializable;
import lombok.*;

@Getter
@Setter
public class LoginVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5571393192867197089L;
	
	/** 이름 */
	private String s_id;
	
	/** 주민등록번호 */
	private String s_name;
	
	/** 이메일주소 */
	private String s_email;
	
	/** 비밀번호 */
	private String s_userSe;
	
	/** 조직(부서)ID */
	private String s_deptID;
	
	/** 조직(부서)명 */
	private String s_orgnztNm;
	
	/** 조직(부서) 전체 명 */
	private String s_orgnztFullNm;
	
	/** 고유아이디 */
	private String s_uniqId;
	
	/** 로그인 후 이동할 페이지 */
	private String s_url;
	
	/** 사용자 IP정보 */
	private String s_ip;
}