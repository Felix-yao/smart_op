package com.kkgame.adx.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class OM {

	private static ObjectMapper INDENT_OUTPUT_OBJECT_MAPPER = new ObjectMapper()
			.configure(SerializationFeature.INDENT_OUTPUT, true)
			.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

	private static ObjectMapper OBJECT_MAPPER = new ObjectMapper().configure(SerializationFeature.INDENT_OUTPUT, false)
			.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

	public static String toJOSN(Object o) {
		return toJOSN(o, true);
	}

	public static String toJOSN(Object o, Boolean indentOutput) {
		try {
			if (indentOutput) {
				return INDENT_OUTPUT_OBJECT_MAPPER.writeValueAsString(o);
			} else {
				return OBJECT_MAPPER.writeValueAsString(o);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	public static <T> T toBean(String json, Class<T> clazz) {
		try {
			return INDENT_OUTPUT_OBJECT_MAPPER.readValue(json, clazz);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static <T> T toBean(String json, TypeReference<T> clazz) {
		try {
			return INDENT_OUTPUT_OBJECT_MAPPER.readValue(json, clazz);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static <T> T convert(Object o, TypeReference<T> clazz) {
		try {
			return INDENT_OUTPUT_OBJECT_MAPPER.convertValue(o, clazz);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

  public static <T> T convert (Object o, Class<T> clazz){
	  try{
		  return INDENT_OUTPUT_OBJECT_MAPPER.convertValue(o, clazz);
      }catch(Exception e){
    	throw new RuntimeException(e);
      }
}

}
