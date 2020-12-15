package com.vijay.demo01;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> list = Arrays.asList(1, 5,4,10, 3, 7, 5);
		int a = list.stream()
		            .peek(num -> System.out.println("will filter " + num))
		            .filter(x -> x > 5)
		            .findFirst()
		            .get();
		System.out.println(a);
		
		Map<String,String> map = new HashMap<>();
		
		
		
	}

}
