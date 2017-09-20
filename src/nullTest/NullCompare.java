/**
 * 작성된 날짜: 2014. 9. 3.
 * Copyright 2013 BankwareGlobal co. All rights reserved.
 */
package nullTest;

import handlingObject.objectValue.TestObject;

/**
 * @file nullTest.NullCompare.java
 * @filetype java source file
 * @brief
 * @author Kihyun.Hwang
 * @version 1.0
 * @history
 *
 * 성 명			일 자				근 거 자 료 	  변 경 내 용
 * ------------ ------------- 	------------ ------------ 
 * 황 기 현 		2014. 9. 3. 	product 개발 	   신 규 작 성
 *
 */
public class NullCompare {
	 public static void main(String[] args) throws InterruptedException {

        // Two different objects having different values
        System.out.println("======  Two different objects having different values");
        TestObject Obj_1 = new TestObject("First obj", 1);
        TestObject Obj_2 = new TestObject("Second obj", 2);
        System.out.println("Obj_1 : " + Obj_1 + "   Obj_2 : " + Obj_2);
        compareTwoObjects(Obj_1, Obj_2);
       
        // Two objects having same values
        System.out.println("======  Two different objects having same values");
        Obj_2.setS("First obj");
        Obj_2.setI(1);
        System.out.println("Obj_1 : " + Obj_1 + "   Obj_2 : " + Obj_2);
        System.out.println("Obj_1.getS() : " + Obj_1.getS() + "\tObj_1.getI() : " + Obj_1.getI() + "\tObj_2.getS() : " + Obj_2.getS() + "\tObj_2.getI() : " + Obj_2.getI());
        compareTwoObjects(Obj_1, Obj_2);
       
        // Two String objects having same values
        System.out.println("======  Two String objects having same values");
        String s1 = "1ab";
        String s2 = "1ab";
        String s3 = s1;
        compareTwoObjects(s1, s2);
        compareTwoObjects(s2, s3);
       
        System.out.println(s1==s2);
        // Two objects
        System.out.println("======  Two same objects");
        Obj_1 = Obj_2;
        System.out.println("Obj_1 : " + Obj_1 + "   Obj_2 : " + Obj_2);
        compareTwoObjects(Obj_1, Obj_2);
       
        // Null Objects Compare
        System.out.println("======  Two Null objects");
        Obj_1 = null;
        Obj_2 = null;
        System.out.println("Obj_1 : " + Obj_1 + "   Obj_2 : " + Obj_2);
        Thread.sleep(1000);
        compareTwoObjects(Obj_1, Obj_2);
    }
    private static void compareTwoObjects(Object o1, Object o2){
        if(o1 == o2)
            System.out.println("Obj_1 is equal to Obj_2. ( compared by == operation )");
        else
            System.out.println("Obj_1 is not equal to Obj_2. ( compared by == operation )");
        if(o1.equals(o2))
            System.out.println("Obj_1 is equal to Obj_2. ( compared by equals() function )");
        else
            System.out.println("Obj_1 is not equal to Obj_2. ( compared by equals() function )");
        System.out.println();
    }

}

