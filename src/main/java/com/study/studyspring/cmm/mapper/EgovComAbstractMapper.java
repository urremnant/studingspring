package com.study.studyspring.cmm.mapper;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowire;

import com.study.studyspring.cmm.resolver.CommonMap;


public abstract class EgovComAbstractMapper{
	/*
	 * logger => 디버그 작업 편함
	 * 레벨지정 가능
	 * 빠름
	 * log4j 로그기록 어디다 할지 지정가능
	 *https://m.blog.naver.com/PostView.nhn?blogId=minjincodi&logNo=60063653&proxyReferer=https:%2F%2Fwww.google.com%2F 참조
	 */
	protected Logger logger =LoggerFactory.getLogger(getClass());
	
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate query;
	
	/**
	 * 
	 * @param queryId -  입력 처리 SQL mapping 쿼리 ID
	 * 
	 * @return DBMS가 지원하는 경우 insert 적용 결과 count
	 **/
	
	public int insert(String queryId) {
//		logger.debug("=========sql id=========='"+ queryId +"'");
		return query.insert(queryId);
	}
	
	/**
	 * 입력 처리 SQL mapping 을 실행한다.
	 *
	 * @param queryId -  입력 처리 SQL mapping 쿼리 ID
	 * @param parameterObject - 입력 처리 SQL mapping 입력 데이터를 세팅한 파라메터 객체(보통 VO 또는 Map)
	 *
	 * @return DBMS가 지원하는 경우 insert 적용 결과 count
	 */
	public int insert(String queryId, Object parameterObject) {
//		logger.debug("=========sql id=========='"+ queryId +"'");
		return query.insert(queryId, parameterObject);
	}
	
	
	/**
	 * 수정 처리 SQL mapping 을 실행한다.
	 *
	 * @param queryId - 수정 처리 SQL mapping 쿼리 ID
	 *
	 * @return DBMS가 지원하는 경우 update 적용 결과 count
	 */
	
	public int update(String queryId) {
//		logger.debug("============== sql id ============== : '" + queryId + "'");
		return query.update(queryId);
	}
	
	/**
	 * 수정 처리 SQL mapping 을 실행한다.
	 *
	 * @param queryId - 수정 처리 SQL mapping 쿼리 ID
	 * @param parameterObject - 수정 처리 SQL mapping 입력 데이터(key 조건 및 변경 데이터)를 세팅한 파라메터 객체(보통 VO 또는 Map)
	 *
	 * @return DBMS가 지원하는 경우 update 적용 결과 count
	 */
	public int update(String queryId, Object parameterObject) {
//		logger.debug("============== sql id ============== : '" + queryId + "'");
		return query.update(queryId, parameterObject);
	}
	
	/**
	 * 삭제 처리 SQL mapping 을 실행한다.
	 *
	 * @param queryId - 삭제 처리 SQL mapping 쿼리 ID
	 *
	 * @return DBMS가 지원하는 경우 delete 적용 결과 count
	 */
	public int delete(String queryId) {
//		logger.debug("============== sql id ============== : '" + queryId + "'");
		return query.delete(queryId);
	}
	
	
	/**
	 * 삭제 처리 SQL mapping을 실행한다
	 * 
	 * @param queryId - 삭제 처리 SQL mapping 쿼리 ID
	 * @parameterObject - 삭제 처리 SQL mapping 입력 데이터(일반적으로 key 조건)를 세팅한 파라메터 객체 
	 * 
	 * 
	 */
	public int delete(String queryId, Object parameterObject) {
//		logger.debug("============== sql id ============== : '" + queryId + "'");
		return query.delete(queryId, parameterObject);
	}
	
	//코드 검사 안함
	//CHECKSTYLE:OFF
	/**
	 * 명명규칙에 맞춰 selectOne()로 변경한다.
	 * @deprecated select() 메소드로 대체
	 * 
	 * @see EgovAbstractMapper.selectOne()
	 */
	//CHECKSTYLE:ON
	//코드 검사 함
	@Deprecated
	public Object selectByPk(String queryId, Object parameterObject) {
//		logger.debug("============== sql id ============== : '" + queryId + "'");
		return query.selectOne(queryId, parameterObject);
	}
	
	
	
	/**
	 * 
	 * 단건조회 처리 SQL mapping을 실행한다.
	 * 
	 * @param queryId -단건 조회 처리 SQL mapping 쿼리 ID 
	 *
	 * @return 결과 객체 - SQL mapping 파일에서 지정한 resultType/resultMap에 의한 단일 결과 객체(vo,map)
	 * 
	 */
	/* 
	 * <T>는 generic 변수 클래스 사용할 타입을 외부에서 결정함
	 * */
	public <T> T selectOne(String queryId) {
//		logger.debug("============== sql id ============== : '" + queryId + "'");
		return query.selectOne(queryId);
	}
	
	/**
	 * 단건조회 처리 SQL mapping 을 실행한다.
	 *
	 * @param queryId - 단건 조회 처리 SQL mapping 쿼리 ID
	 * @param parameterObject - 단건 조회 처리 SQL mapping 입력 데이터(key)를 세팅한 파라메터 객체(보통 VO 또는 Map)
	 *
	 * @return 결과 객체 - SQL mapping 파일에서 지정한 resultType/resultMap 에 의한 단일 결과 객체(보통 VO 또는 Map)
	 */
	public <T> T selectOne(String queryId, Object parameterObject) {
//		logger.debug("============== sql id ============== : '" + queryId + "'");
		return query.selectOne(queryId, parameterObject);
	}
	
	/**
	 * 결과 목록을 Map을 변환한다.
	 * 모든 구문이 파라미터를 필요하지 않기에 파라미터 객체를 요구 x
	 * 
	 * @param queryId - 단건 조회 처리 SQL mapping 쿼리 ID
	 * @param mapKey - 결과 객체의 프로퍼티 중 하나를 키로 사용
	 * 
	 * 
	 */
	/*
	 * http://www.tcpschool.com/java/java_collectionFramework_map
	 * https://velog.io/@gillog/Map-%EC%BB%AC%EB%A0%89%EC%85%98-HashMap
	 * <K,V> =>Map컬랙션 클래스 <Key,Value>
	 * key-value 쌍으로 저장(key값은 중복 불가, value값은 중복 가능)
	 * 순서 지정가능
	 * <K,V>도 위의 T와 같이 불명확한 data type으로 지정한 것이다.
	 * 
	 */
	public <K,V> Map<K,V> selectMap(String queryId,String mapKey){
//		logger.debug("============== sql id ============== : '" + queryId + "'");
		return query.selectMap(queryId, mapKey);
	}
	
	/*
	 * RowBounds =>mybatis에서 paging 해주는 class
	 * RowBounds 파라미터는 마이바티스로 하여금 특정 개수 만큼의 레코드를 건너띄게 한다. RowBounds클래스는 offset과 limit 둘다 가지는 생성자가 있다.
	 * RowBounds rowBounds = new RowBounds(offset, limit); 

	 */

	/**
	 * 결과 목록을 Map 을 변환한다.
	 * 모든 구문이 파라미터를 필요로 하지는 않기 때문에, 파라미터 객체를 요구하지 않는 형태로 오버로드되었다.
	 *
	 * @param queryId - 단건 조회 처리 SQL mapping 쿼리 ID
	 * @param parameterObject - 맵 조회 처리 SQL mapping 입력 데이터(조회 조건)를 세팅한 파라메터 객체(보통 VO 또는 Map)
	 * @param mapKey - 결과 객체의 프로퍼티 중 하나를 키로 사용
	 * @param rowBounds - 특정 개수 만큼의 레코드를 건너띄게 함
	 *
	 * @return 결과 객체 - SQL mapping 파일에서 지정한 resultType/resultMap 에 의한 단일 결과 객체(보통 VO 또는 Map)의 Map
	 */
	
	public <K,V> Map<K,V> selectMap(String queryId, Object parameterObject, String mapKey, RowBounds rowBounds){
		
		return query.selectMap(queryId, parameterObject, mapKey, rowBounds);
		
	}
	//CHECKSTYLE:OFF
	/**
	 * 명명규칙에 맞춰 selectList()로 변경한다.
	 * 
	 * @see EgovAbstractMapper.selectList()
	 * @deprecated List<?> 메소드로 대체
	 * 
	 */
	//CHECKSTYLE:ON
	
	/*
	 * List <?>는 함수에서 일회성 인자로 받는 변수를 제한하기 용이함.
	 * Object Class에서 지원하는 기능을 사용하는 메서드 구현
	 * https://velog.io/@strawberry/Java-Generic-E-ListE-%EC%9D%B4%EB%9E%80
	 * 사실상 >나 T,E,V,K도 ?와 같은개념이지만 무엇이 들어가는지 알수 있게 약자로 써놓음
	 * T:type,E:Element,V:value,K:key
	 */
	@Deprecated
	public List<?> list(String queryId, Object parameterObject) {
//		logger.debug("============== sql id ============== : '" + queryId + "'");
		return query.selectList(queryId, parameterObject);
	}
	
	/**
	 * 리스트 조회 처리 SQL mapping 을 실행한다.
	 *
	 * @param queryId - 리스트 조회 처리 SQL mapping 쿼리 ID
	 * @param parameterObject - 리스트 조회 처리 SQL mapping 입력 데이터(조회 조건)를 세팅한 파라메터 객체(보통 VO 또는 Map)
	 *
	 * @return 결과 List 객체 - SQL mapping 파일에서 지정한  resultType/resultMap 에 의한 결과 객체(보통 VO 또는 Map)의 List
	 */
	
	/*
	 * E는 안에 상세하게 E타입을 넣는데 얘는 Elements의 약자임
	 */
	public <E> List<E> selectList(String queryId){
//		logger.debug("============== sql id ============== : '" + queryId + "'");
		return query.selectList(queryId);
	}
	
	/**
	 * 부분 범위 리스트 조회 처리 SQL mapping 을 실행한다.
	 * (부분 범위 - pageIndex 와 pageSize 기반으로 현재 부분 범위 조회를 위한 skipResults, maxResults 를 계산하여 ibatis 호출)
	 *
	 * @param queryId - 리스트 조회 처리 SQL mapping 쿼리 ID
	 * @param parameterObject - 리스트 조회 처리 SQL mapping 입력 데이터(조회 조건)를 세팅한 파라메터 객체(보통 VO 또는 Map)
	 * @param pageIndex - 현재 페이지 번호
	 * @param pageSize - 한 페이지 조회 수(pageSize)
	 *
	 * @return 부분 범위 결과 List 객체 - SQL mapping 파일에서 지정한 resultType/resultMap 에 의한 부분 범위 결과 객체(보통 VO 또는 Map) List
	 */
	
	public List<?> listWithPaging(String queryId,Object parameterObject, int pageIndex,int pageSize){
		int skipResults = pageIndex * pageSize;
		//int maxResults = (pageIndex * pageSize) + pageSize;
		RowBounds rowBounds = new RowBounds(skipResults, pageSize);
		return query.selectList(queryId, parameterObject, rowBounds);
	}
	
	/**
	 * SQL 조회 결과를 Resulthandler를 이용해서 출력한다.
	 * ResultHandler를 상속해 구현한 커스텀 핸들러의 handReuslt()메소드에 따라 실행됨
	 * 
	 * @param queryId
	 * @param hander
	 * 
	 * @return 결과 List 객체 - SQL mapping 파일에서 지정한 resultType/resultMap 에 의한 결과 객체(보통 VO 또는 Map)의 List
	 */
	
	/*
	 * 대용량데이터 select하여 호출할시 Out of Memory에러 발생 가능하기때문에
	 * Result handler를 통해 반복작업 수행
	 * HTTP 응답으로 나가도록 함으로써 WAS 메모리에 영향을 받지 않고 대량 데이터를 조회할 수 있도록 하는 예제 소스
	 * spring Boot에서 Mybatis ResultHander실행할대 이슈가 있는거 같음
	 */
	public void listToOutUsingResultHander(String queryId,ResultHandler hander) {
		//		logger.debug("============== sql id ============== : '" + queryId + "'");
		query.select(queryId, hander);
	}
	
	/*
	 * throws 예외를 전가시킴
	 * https://kingpodo.tistory.com/57
	 * Exception는 메소드 생성자 = 수행할때 밸생하는 exception을 선언할때 사용하는 keyword
	 * throw 강제 예외 => 사람이 예외처리 시킨거
	 * 아래는 select라는 함수가 Exception이라는 예외를 던짐
	 */
	//목록조회
	public List select(String sqlId,Map map) throws Exception{
		
		return query.selectList(sqlId,map);
	}
	
	//목록 조회시
	public Object SelectObject(String sqlId,Map map) throws Exception {
//		logger.debug("============== sql id ============== : '" + sqlId + "'");
		return query.selectList(sqlId, map);
	}
	
	//단순 등록시
	public void insert(String sqlId,Map map) throws Exception{
//		logger.debug("============== sql id ============== : '" + sqlId + "'");
		query.insert(sqlId, map);
	}
	

	//단순 등록시
	public Object insertObject(String sqlId, Map map) throws Exception {
		return query.insert(sqlId, map);
	}
	
	
	//삭제시
	public void delete(String sqlId,Map map) throws Exception {
		query.delete(sqlId, map);
	}
	
	public Object deleteObject(String sqlId,Map map) throws Exception {
		return query.delete(sqlId, map);
	}
	
	//업데이트시
	public void update(String sqlId,Map map)throws Exception {
		query.update(sqlId, map);
	}
	
	//업데이트시
	public Object updateObject(String sqlId, Map map) throws Exception {
		return query.update(sqlId, map);
	}
	
	public List<?> selectCommonMap(String sqlId,CommonMap map) throws Exception{
		return query.selectList(sqlId, map);
	}
	
	public Object insertCommonMapToObject(String sqlId,CommonMap map) throws Exception{
		return query.insert(sqlId, map);
	}
	
	public Object deleteCommonMapToObject(String sqlId, CommonMap map) throws Exception{
		return query.delete(sqlId, map);
	}
	
	public Object updateCommonMapToObject(String sqlId,CommonMap map) throws Exception{
		return query.update(sqlId, map);
	}
}