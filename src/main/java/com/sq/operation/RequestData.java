package com.sq.operation;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonGenerator.Feature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.TypeFactory;

/**
 * 
 * @author An
 *
 */
public class RequestData {

	String apiForeUrl = "http://localhost:8989/task-api/task/";

	/**
	 * 向api发送请求的并且返回数据的方法
	 * 
	 * @param url
	 *            请求的url路径
	 * @param httpMethod
	 *            请求方式
	 * @param parmas
	 *            参数
	 */
	@SuppressWarnings("unchecked")
	public <T> List<T> requestApiDataForList(String url, HttpMethod httpMethod, Object parmas, Class<T> clazz) {
		StringBuffer sb = new StringBuffer();
		sb.append(apiForeUrl);
		sb.append(url);

		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Object> entity = new HttpEntity<Object>(parmas, header);

		ResponseEntity<GenericResponse> responseEntity = restTemplate().exchange(sb.toString(), httpMethod, entity,
				GenericResponse.class);

		GenericResponse response = responseEntity.getBody();

		if (null == response) {
			return null;
		}

		List<T> list;

		if (null == clazz) {
			list = objectMapper().convertValue(response.getData(), List.class);
		} else {
			JavaType objectType = TypeFactory.defaultInstance().constructCollectionType(List.class, clazz);
			list = objectMapper().convertValue(response.getData(), objectType);
		}

		return list;
	}
	
	/**
	 * 向api发送请求的并且返回数据的方法
	 * 
	 * @param url
	 *            请求的url路径
	 * @param httpMethod
	 *            请求方式
	 * @param parmas
	 *            参数
	 * @param clazz
	 */
	public <T> T requestApiDataForPojo(String url, HttpMethod httpMethod, Object parmas, Class<T> clazz) {
		StringBuffer sb = new StringBuffer();
		sb.append(apiForeUrl);
		sb.append(url);

		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Object> entity = new HttpEntity<Object>(parmas, header);

		ResponseEntity<Object> responseEntity = restTemplate().exchange(sb.toString(), httpMethod, entity,
				Object.class);
		
		Object obj = responseEntity;

		if (null == obj) {
			return null;
		}

		T objectValue = objectMapper().convertValue(obj, clazz);

		return objectValue;
	}


	public RestTemplate restTemplate() {

		RestTemplate restTemplate = new RestTemplate();

		restTemplate.getMessageConverters().add(createJsonHttpMessageConverter());

		return restTemplate;
	}

	public ObjectMapper objectMapper() {

		ObjectMapper jacksonObjectMapper = new ObjectMapper();
		jacksonObjectMapper.configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
		jacksonObjectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

		jacksonObjectMapper.configure(Feature.WRITE_BIGDECIMAL_AS_PLAIN, true);
		jacksonObjectMapper.getFactory().enable(Feature.WRITE_BIGDECIMAL_AS_PLAIN);

		jacksonObjectMapper.setSerializationInclusion(Include.NON_NULL);

		jacksonObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		return jacksonObjectMapper;
	}

	private HttpMessageConverter<Object> createJsonHttpMessageConverter() {

		MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
		jsonConverter.setObjectMapper(objectMapper());
		return jsonConverter;
	}

}
