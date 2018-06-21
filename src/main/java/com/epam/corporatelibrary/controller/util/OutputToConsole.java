/**
 * 
 */
package com.epam.corporatelibrary.controller.util;

import java.util.List;

/**
 * @author Артем
 *
 */
public class OutputToConsole {
	private OutputToConsole() {

	}

	public static <T> void printList(List<T> list) {
		for (T item : list) {
			System.out.println(item);
		}
		System.out.println("=============================================");
	}
}
