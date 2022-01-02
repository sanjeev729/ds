package org.test.java.custom.san;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorEx {

	public static void main(String[] args) {
		Test[] arr = new Test[4];
		arr[0] = new Test(1, "ashgjha");
		arr[1] = new Test(4, "xcuyxguw");
		arr[2] = new Test(3, "hfghf");
		arr[3] = new Test(2, "zzz");
		// Arrays.sort(arr);
		Arrays.sort(arr, (a, b) -> a.getName().compareTo(b.getName()));
		System.out.println(Arrays.toString(arr));
	}

}

class Test implements Comparable<Test> {
	int i;
	String name;

	public Test(int j, String name) {
		this.i = j;
		this.name = name;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Test [i=" + i + ", name=" + name + "]";
	}

	@Override
	public int compareTo(Test o) {

		return this.i - o.i;
	}

}
