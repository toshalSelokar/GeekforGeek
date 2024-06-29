package GeekForGeek;

/*
Given a binary array arr of size N and an integer M. Find the maximum number of consecutive 1's produced by flipping at most M 0's.


Example 1:
Input:
N = 3
arr[] = {1, 0, 1}
M = 1
Output:
3
Explanation:
Maximum subarray is of size 3
which can be made subarray of all 1 after
flipping one zero to 1.


Example 2:
Input:
N = 11
arr[] = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1}
M = 2
Output:
8
Explanation:
Maximum subarray is of size 8
which can be made subarray of all 1 after
flipping two zeros to 1.



Your Task:
Complete the function findZeroes() which takes array arr and two integers n, m, as input parameters and returns an integer denoting the answer.
Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)
 */

import javax.imageio.ImageTranscoder;
import java.util.Scanner;

public class MaximizeNumOf1s {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print(i+" index: ");
            arr[i] = sc.nextInt();
        }

        System.out.print("Number of Zeros to be replaced with 1: ");
        int m = sc.nextInt();

        System.out.println(findZeroes(arr, n, m));   // Needs some work. it is not giving the correct output.
        System.out.println(findZeroes1(arr, n, m));  // optimized solution


    }

    private static int findZeroes(int arr[], int n, int m) {

        int a = 0;
        int max1 = 0;
        int max = 0;

        int left = 0;

        for (int right = 0; right < n; right++) {

            if (a <= m && arr[right] == 0) {
                arr[right] = 1;
                max1 += 1;
                a += 1;
                max = Math.max(max1, max);
            } else {
                max1 += 1;
                max = Math.max(max1, max) - 1;
                continue;
            }


            if (a > m) {
                max = max - 1;
                max1 = 0;
                a = 0;
                left++;
                right = left;
            }


        }

        return max;
    }

    private static int findZeroes1(int arr[], int n, int m) {

        int left = 0;
        int right = 0;
        int zeroCount = 0;
        int maxLength = 0;

        while (right < arr.length) {
            if (arr[right] == 0){
                zeroCount++;
            }

            while (zeroCount > m){
                if (arr[left] == 0){
                    zeroCount--;
                }
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }
}
