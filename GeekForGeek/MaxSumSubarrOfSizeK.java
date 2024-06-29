package GeekForGeek;

/*
Given an array of integers Arr of size N and a number K. Return the maximum sum of a subarray of size K.
NOTE*: A subarray is a contiguous part of any given array.

Example 1:
Input:
N = 4, K = 2
Arr = [100, 200, 300, 400]
Output:
700
Explanation:
Arr3  + Arr4 =700,
which is maximum.

Example 2:
Input:
N = 4, K = 4
Arr = [100, 200, 300, 400]
Output:
1000
Explanation:
Arr1 + Arr2 + Arr3 + Arr4 =1000,
which is maximum.

Your Task:
You don't need to read input or print anything. Your task is to complete the function maximumSumSubarray() which takes the integer K, vector Arr with size N, containing the elements of the array and returns the maximum sum of a subarray of size K.
Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)
 */

import java.util.ArrayList;
import java.util.Scanner;

public class MaxSumSubarrOfSizeK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("size of array: ");
        int N = sc.nextInt();

        ArrayList<Integer> Arr = new ArrayList<>(N);


        for (int i = 0; i < N; i++) {
            System.out.print(i+" index: ");
            Arr.add(sc.nextInt());

        }

        System.out.print("Size of a output Subarray: ");
        int K = sc.nextInt();


        System.out.println(maximumSumSubarray(K, Arr, N));
        System.out.println(maximumSumSubarray1(K, Arr, N));

    }

//    Correct code, but Exceeds time limit as the Time Complexity for the below code is of O(N) while Space Complexity is of O(1)
    private static long maximumSumSubarray(int K, ArrayList<Integer> Arr,int N){
        // code here
        long sum = 0;
        long maxSum = Long.MIN_VALUE;

        int i = 0;
        int j = 0;

        while (j<N){
            sum += Arr.get(j);

            maxSum = Math.max(sum, maxSum);

            j++;

            if (j == i + K) {
                sum = 0;
                i++;
                j = i;
            }
        }



        return maxSum;
    }

//    Solution with same Time and Space complexity but it is a little bit faster than the earlier
    private static long maximumSumSubarray1(int K, ArrayList<Integer> Arr,int N){
        long sum = 0;
        long maxSum = Long.MIN_VALUE;

        int i = 0;
        int j = 0;

        while (j<N) {
            sum += Arr.get(j);

            if(j-i+1==K){
                maxSum = Math.max(sum, maxSum);
                sum = sum - Arr.get(i);
                i++;
            }
            j++;
        }
        return maxSum;
    }
}
