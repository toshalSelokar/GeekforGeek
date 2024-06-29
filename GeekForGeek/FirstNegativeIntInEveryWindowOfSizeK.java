package GeekForGeek;

/*
Given an array A[] of size N and a positive integer K, find the first negative integer for each and every window(contiguous subarray) of size K.

Example 1:
Input :
N = 5
A[] = {-8, 2, 3, -6, 10}
K = 2
Output :
-8 0 -6 -6
Explanation :
First negative integer for each window of size k
{-8, 2} = -8
{2, 3} = 0 (does not contain a negative integer)
{3, -6} = -6
{-6, 10} = -6


Example 2:
Input :
N = 8
A[] = {12, -1, -7, 8, -15, 30, 16, 28}
K = 3
Output :
-1 -1 -7 -15 -15 0

Your Task:
You don't need to read input or print anything. Your task is to complete the function printFirstNegativeInteger() which takes the array A[], its size N and an integer K as inputs and returns the first negative number in every window of size K starting from the first till the end. If a window does not contain a negative integer , then return 0 for that window.
Expected Time Complexity: O(N)
Expected Auxiliary Space: O(K)
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FirstNegativeIntInEveryWindowOfSizeK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Size of array: ");
        int N = sc.nextInt();

        long[] A = new long[N];

        for (int i = 0; i < N; i++) {
            System.out.print(i+" index: ");

            A[i] = sc.nextInt();
        }

        System.out.print("Target Subarray Size: ");
        int K = sc.nextInt();

        long[] result = printFirstNegativeInteger(A, N, K);

        long[] res = printFirstNegativeInteger1(A, N, K);

        // Print the result array
        for (long value : result) {
            System.out.print(value + " ");
        }
        System.out.println();

        for (long value : res) {
            System.out.print(value + " ");
        }
    }

    private static long[] printFirstNegativeInteger1(long[] a, int n, int k) {
        Queue<Integer> que = new LinkedList<>();   //TC = O(N)  && SC = O(K)

        int start = 0;
        int end = 0;
        int index = 0;

        long[] answer = new long[n-k+1];

        while(end<n) {
            if (a[end] < 0) {
                que.add(end);
            }
            if (end - start + 1 == k) {
                while (!que.isEmpty() && que.peek() < start) {
                    que.poll();  // Remove indices from the queue that are outside the current window.
                }

                if (que.isEmpty()) {
                    answer[index] = 0; //If the queue is empty, it means there are no negative integers in the current window, so add 0 to the result. Otherwise, add the negative integer at the front of the queue.
                } else
                    answer[index] = a[que.peek()];
                index++;
                start++;

            }
            end++;
        }
        return answer;
    }

    //    Below method gives the required result but it takes little more time.
//    It passed 10067 / 10100 of test cases but for the 10067th test case it gives Time Limit Exceeded error.
    public static long[] printFirstNegativeInteger(long A[], int N, int K) {
        int i = 0;
        int j = 0;

        long[] ans = new long[N-K+1];

        while(j<N && j<=i+K-1 && i< N-K+1){
            if(A[j]<0){
                ans[i] = A[j];
                i++;
                j=i;
            } else if (j-i+1==K) {
                    i++;
                    j=i;
                } else {
                    ans[i] = 0;
                    j++;
            }



        }

        return ans;
    }
}
