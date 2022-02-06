package com.greatlearning.DSAssignment.question1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;

public class Skyscrapper {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack<Integer>();
		System.out.println("Enter the total no. of floors in the building: ");
		int floors = sc.nextInt();

		if (floors <= 0) {
			System.out.println("Invalid Number");
			System.out.println("Enter the total no. of floors in the building: ");
			floors = sc.nextInt();
		}

		Integer arr_floorsize[];
		Integer temp_floorsize[];
		Integer temp_floorsize2[];

		int largest_floorsize = floors;
		arr_floorsize = new Integer[floors + 1];
		temp_floorsize = new Integer[floors + 1];
		temp_floorsize2 = new Integer[floors + 1];

		int i;
		int j;
		int k;
		int l;
		int level_remove;

		for (i = 1; i <= floors; i++) {
			stack.push(i);
			System.out.println("Enter the floor size given on day: " + i);
			arr_floorsize[i] = sc.nextInt();
			if (arr_floorsize[i] <= 0) {
				System.out.println("Invalid number");
				System.out.println("Enter the floo size given on day:" + i);
				arr_floorsize[i] = sc.nextInt();
			}
		}

		j = 0;
		level_remove = 0;
		for (i = 1; i <= floors; i++) {
			System.out.println("Day:" + i);

			if (arr_floorsize[i] == largest_floorsize) {
				Integer temp_floor = (Integer) stack.pop();
				System.out.println(temp_floor + " ");
				l = 0;

				Arrays.sort(temp_floorsize, Collections.reverseOrder(Comparator.nullsFirst(Comparator.naturalOrder())));

				for (k = 0; k < j; k++) {
					if (temp_floorsize[k] == largest_floorsize) {
						temp_floor = (Integer) stack.pop();
						System.out.println(temp_floor + " ");
						level_remove++;
						largest_floorsize = largest_floorsize - 1;
					} else {
						if (temp_floorsize[k] != 0) {
							temp_floorsize2[l] = temp_floorsize[k];
							l++;
						}
					}
					if (largest_floorsize == 0) {
						break;
					}
				}
				System.out.println();

				temp_floorsize = temp_floorsize2;
				temp_floorsize2 = new Integer[floors];

				j = j - level_remove;
				level_remove = 0;
			} else {
				if (arr_floorsize[i] != 0) {
					temp_floorsize[j] = arr_floorsize[i];
					j = j + 1;
				}
				System.out.println();
			}

		}

	}

}
