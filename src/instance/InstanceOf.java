package instance;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * 작성된 날짜: 2014. 3. 17.
 * Copyright 2013 BankwareGlobal co. All rights reserved.
 */

/**
 * @file .InstanceOf.java
 * @filetype java source file
 * @brief
 * @author Kihyun.Hwang
 * @version 1.0
 * @history
 *
 * 성 명			일 자				근 거 자 료 	  변 경 내 용
 * ------------ ------------- 	------------ ------------ 
 * 황 기 현 		2014. 3. 17. 		product 개발 	   신 규 작 성
 *
 */
public class InstanceOf {
	public static void main(String[] args) {
		
		
//		List<InstanceOfDomain> list = new ArrayList<InstanceOfDomain>();
//		list.add(new InstanceOfDomain());
//		
//		List<InstanceOfSubDomain> subList = new ArrayList<InstanceOfSubDomain>();
//		subList.add((InstanceOfSubDomain) list.get(0));	// ClassCastException: InstanceOfDomain cannot be cast to InstanceOfSubDomain
		
		
		
		
		List<InstanceOfSubDomain> subDomainList = new ArrayList<InstanceOfSubDomain>();
		InstanceOfSubDomain subDomain = new InstanceOfSubDomain();
		subDomain.setTestInt(5);
		subDomainList.add(subDomain);
		
		List<InstanceOfDomain> domainList = new ArrayList<InstanceOfDomain>();
		domainList.add(subDomainList.get(0));
		domainList.add((InstanceOfDomain)subDomainList.get(0));
		
		
		System.out.println(domainList.get(0).getClass().toString().split(Pattern.quote(" "))[1]);
		System.out.println(domainList.get(0) instanceof InstanceOfDomain);
		
		System.out.println(((InstanceOfSubDomain)domainList.get(0)).getTestInt());
		System.out.println(((InstanceOfSubDomain)domainList.get(1)).getTestInt());
		
	}
}

