package com.vijay.demo01;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class TestingReflaction {

	public static void main(String[] args) {
		Class reflactClass = Bike.class;
		

		System.out.println("---------------- 01 ----------------");
		String className = reflactClass.getName();
		System.out.println(className);

		System.out.println("\n---------------- 02 ----------------");
		int clasModifier = reflactClass.getModifiers();
		System.out.println(Modifier.isAbstract(clasModifier));
		System.out.println(Modifier.isPublic(clasModifier));

		Class[] interfaces = reflactClass.getInterfaces();

		Class classSuper = reflactClass.getSuperclass();
		System.out.println("\n---------------- 03 ----------------");
		System.out.println("Super Class : " + classSuper);

		System.out.println("\n---------------- 04 ----------------");
		Method[] classMethods = reflactClass.getMethods();

		for (Method m : classMethods) {
			System.out.println("Method Name : " + m.getName());

			System.out.println("Return Type : " + m.getReturnType());

			Class[] paramTypes = m.getParameterTypes();

			System.out.println("Parameters:");

			for (Class param : paramTypes) {
				System.out.println(param.getName());

			}

			System.out.println();
		}

		Constructor constructor = null;

		Object constructor2 = null;

		try {
			constructor = reflactClass.getConstructor(new Class[] {VehicleFactory.class});
			constructor2 = reflactClass.getConstructor(int.class, String.class).newInstance(12, "Random String");

		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Class[] constructorParams = constructor.getParameterTypes();
		
		for(Class constructorParam : constructorParams) {
			System.out.println(constructorParam.getName());
		}

		Bike newBike = null;
		
		VehicleFactory vehicleFactory = null;

		try {
			newBike = (Bike) constructor.newInstance(vehicleFactory);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		newBike.setName("XT-100");
		
		System.out.println("EnemyShip Name: "+ newBike.getName());
		
		Field privateStringName = null;
		
		Bike bikePrivate = new Bike(vehicleFactory);
		
		try {
			String idCodeString = "idCode";
			privateStringName = Bike.class.getDeclaredField(idCodeString);
			privateStringName.setAccessible(true);
			
			String valueOfName = (String) privateStringName.get(bikePrivate);
			System.out.println("Private Field Name : "+valueOfName);
			
			String methodName = "getPrivate";
			
			Method privateMethod = Bike.class.getDeclaredMethod(methodName, null);
			
			privateMethod.setAccessible(true);
			
			String privateReturnVal = (String) privateMethod.invoke(bikePrivate, null);
			System.out.println("Bike Private Method : "+ privateReturnVal);
			
			Class[] methodParams = new Class[] {Integer.TYPE, String.class};
			
			Object[] params = new Object[] {new Integer(10), new String("Random")};
			
			privateMethod = Bike.class.getDeclaredMethod("getOtherPrivate", methodParams);
			
			privateMethod.setAccessible(true);
			
			privateReturnVal = (String) privateMethod.invoke(bikePrivate, params);
			System.out.println("Bike Other Private Method : "+ privateReturnVal);
			
			
		} catch (NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
