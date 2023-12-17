package com.sist.temp;

import java.lang.reflect.Method;

class A{
	public void aaa() {
		System.out.println("A:aaa() Call...");
	}
	public void bbb() {
		System.out.println("A:bbb() Call...");
	}
	public void ccc() {
		System.out.println("A:ccc() Call...");
	}
}
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 자바 코딩이 가능할 때 사용
		/* A a=new A();
		a.aaa();
		a.bbb();
		a.ccc(); */
		
		// 클래스 이름으로 메모리 할당하는 과정
		try {
			Class clsName=Class.forName("com.sist.temp.A");
			Object obj=clsName.getDeclaredConstructor().newInstance();
			/*A a=(A)obj;
			a.aaa();
			a.bbb();
			a.ccc();*/
			
			Method[] methods=clsName.getDeclaredMethods();
			for(Method m:methods) {
				m.invoke(obj,null);
			}
		}catch(Exception ex) {}
		
		//
		
	}

}
