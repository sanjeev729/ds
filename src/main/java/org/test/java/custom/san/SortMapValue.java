package org.test.java.custom.san;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SortMapValue {

	public static void main(String[] args) {

		List<Test> test = new ArrayList<>();
		test.add(new Test(9, "ashgjha"));
		test.add(new Test(2, "njhw"));
		test.add(new Test(3, "kkwkw"));
		test.add(new Test(4, "ssse"));

		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("Ashok", 5);
		map.put("kishore", 20);
		map.put("kan", 10);
		map.put("Asha", 10);
		
		
		List<Map.Entry<String, Integer>> list=new ArrayList<>(map.entrySet());

		Collections.sort(list,(a,b)-> b.getValue()-a.getValue());
		
		Map<String, Integer> map2 = new LinkedHashMap<String, Integer>();
		
		list.stream().forEach(x->map2.put(x.getKey(), x.getValue()));

		for (Map.Entry<String, Integer> en : map2.entrySet()) {
            System.out.println("Key = " + en.getKey() +
                          ", Value = " + en.getValue());
        }
		//System.out.println(map);
	}

}
