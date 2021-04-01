package com.study.studyspring.cmm;

import java.io.Serializable;
import lombok.*;
/**
*@class Name :ComDefaultVO.java
*@Description : ComDefaultVO cass
*@Modification Information
*@ 다른사람꺼 소스 배끼는중
*
*
*	@author 개발부 김주희
*	@2021.04.01
*	@version 1.0
*
*
**/

@Getter
@Setter
public class ComDefaultVO implements Serializable {

	/** 
	 * crtl+1 => Add generated serial versio ID=>serialVersionUID만들어짐
	 */
	
	private static final long serialVersionUID = -7133210791075693690L;
	
	/** 아이디 */
	private String id;
	
	private String dataHouseId;
	
	/** 시스템 ID */
	private String searchCondition;
	
	/** 검색조건 */
	private String searchKeyword;
	
	/** 검색사용여부 */
	private String searchUseYn = "";

	/** 현재페이지 */
	private int pageIndex =1;
	
	/** 페이지갯수 */
	private int pageUnit= 10;
	
	/** 페이지 사이즈 */
	private int pageSize = 10;
	
	/** firstIndex */
	private int firstIndex =1;
	
	/**lastIndex */
	private int lastIndex=1;
	
	/** recordCountPerPage */
	private int recordCountPerPage=10;
	
	/**검색 keywordForm */
	private String searchKeywordFrom="";
	
	/**검색 keywordTo */
	private String searchKeywordTo="";
}