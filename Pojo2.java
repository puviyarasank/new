package com.day.com;

public class Pojo2 {
	public static void main(String[] args) {
		Pojo1 po = new Pojo1();
		po.setClgname("Panimalar");
		po.setRollno(2115);
		po.setPer(97.00);
		po.setResult("PASS");
		System.out.println("*****ANNA UNIVERSITY RESULTS*****");
		System.out.println("CLGNAME:" +po.getClgname());
		System.out.println("ROLLNO:" +po.getRollno());
		System.out.println("PERCENTAGE:"+po.getPer());
		System.out.println("RESULT:"+po.getResult());
	}

}
