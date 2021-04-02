package com.study.studyspring.cmm.resolver;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.study.studyspring.cmm.LoginVO;
import java.util.Set;
import lombok.*;

@Getter
@Setter
public class CommonMap{
	Logger logger =LoggerFactory.getLogger(getClass());
	
	/* 여기에도 serialVersionUID 넣어야하나요**/
	LoginVO lv =new LoginVO();
	Map<String,Object> map =new HashMap<String,Object>();

	public Object get(String key) {
		return map.get(key);
	}
	
	public void put(String key,Object value) {
		map.put(key, value);
	}
	
	public Object remove(String key) {
		return map.remove(key);
	}
	
	public boolean containsKey(String key) {
		return map.containsKey(key);
	}
	
	public boolean containsValue(Object value) {
		return map.containsValue(value);
	}
	
	public void clear(){
        map.clear();
    }
     
    public Set<Entry<String, Object>> entrySet(){
        return map.entrySet();
    }
     
    public Set<String> keySet(){
        return map.keySet();
    }
     
    public boolean isEmpty(){
        return map.isEmpty();
    }
     
    public void putAll(Map<? extends String, ?extends Object> m){
        map.putAll(m);
    }
     
    public Map<String,Object> getMap(){
        return map;
    }
}