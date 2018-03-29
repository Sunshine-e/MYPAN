package com.ittahac.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.type.TypeReference;

public class JsonUtil {
	
	public static ObjectMapper getMapper() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		mapper.disable(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES);
		//设置序列化配置(全局),设置序列化时不输出空值.
		mapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS,    false);
		
		return mapper;
	}
	
	// 将对象转换为JSON字符串
	public static String toJson(Object object) {
		if(object == null){
			return "";
		}
		ObjectMapper mapper = getMapper();
		
		try {
			return mapper.writeValueAsString(object);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	
	// 将JSON字符串转换为对象
	public static <T> T toObject(String json, Class<T> clazz) {
		ObjectMapper mapper = getMapper();
		try {
			return mapper.readValue(json, clazz);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	// 将JSON字符串转换为对象
	@SuppressWarnings("rawtypes")
	public static <T> T toObject(String json, TypeReference typeReference) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = getMapper();
		return mapper.readValue(json, typeReference);
	}
	
	public static <T> List<T> getList(String jsonVal,Class<?> clazz){
		ObjectMapper mapper = getMapper();
		TypeFactory t = TypeFactory.defaultInstance(); 
		//指定容器结构和类型（这里是ArrayList和clazz）
		List<T> list = null;
		try {
			list = mapper.readValue(jsonVal,t.constructCollectionType(ArrayList.class,clazz));
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 如果T确定的情况下可以使用下面的方法：
		// List<T> list = objectMapper.readValue(jsonVal, new TypeReference<List<T>>() {}); 
		return list;
	}
}
