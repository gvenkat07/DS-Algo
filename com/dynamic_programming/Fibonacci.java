package com.dynamic_programming;

public class Fibonacci {
	public static void main(String[] args) {

		Fibonacci fibo = new Fibonacci();
		System.out.println("Fibonacci of 12 : " + fibo.fibonacci(12));

	}

	private int fibonacci(int number) {
		int[] arr = new int[number + 1];

		for (int i = 0; i < number + 1; i++) {
			arr[i] = -1;
		}
		// return calculateFibonacciTopToBottom(arr, number);
		return calculateFibonacciBottomToTop(number);

	}

	private int calculateFibonacciBottomToTop(int number) {

		if (number < 2) {
			return number;
		}

		int firstValue = 0;
		int secondValue = 1;
		int sum = 0;

		for (int i = 2; i < number + 1; i++) {
			sum = firstValue + secondValue;
			firstValue = secondValue;
			secondValue = sum;
		}
		System.out.println("Fibonacci using Bottom Up approach");
		return sum;

	}

	private int calculateFibonacciTopToBottom(int[] arr, int number) {

		if (number < 2) {
			arr[number] = number;
			return number;
		}

		if (arr[number] == -1) {
			arr[number] = calculateFibonacciTopToBottom(arr, number - 1)
					+ calculateFibonacciTopToBottom(arr, number - 2);

		}
		return arr[number];
	}

}
