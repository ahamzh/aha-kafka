package com.halo.kafka.utils;

import com.fasterxml.jackson.databind.json.JsonMapper;
import lombok.SneakyThrows;

/**
 * @author shoufeng
 */
public class JacksonUtils {
	
	public static final JsonMapper JSON_MAPPER = new JsonMapper();

	@SneakyThrows
	public static <T> String toJsonString(T obj) {

		return JSON_MAPPER.writeValueAsString(obj);
	}

	@SneakyThrows
	public static <T> T parse(String sourceJson, Class<T> tClass) {

		return JSON_MAPPER.readValue(sourceJson, tClass);
	}

}
