package com.poc2.response;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;
@Data
public class ApiResponse {
	private boolean isSuccess;
	private Map<Object,Object> result=new HashMap<Object, Object>();
}
