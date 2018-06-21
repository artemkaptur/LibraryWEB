/**
 * 
 */
package com.epam.corporatelibrary.controller.util;

import java.util.Scanner;

/**
 * @author Артем
 *
 */
public class InputFromConsole {
	private InputFromConsole() {
	}

	public static String scanInfo() {
		System.out.println("Type your string:");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String result = sc.nextLine();
		// sc.close();
		return result;
	}
}
