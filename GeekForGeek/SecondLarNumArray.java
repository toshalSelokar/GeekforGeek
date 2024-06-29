package GeekForGeek;

import java.util.Arrays;
import java.util.Scanner;

public class SecondLarNumArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please give the size of arrray: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {

            System.out.print("Please enter the value for " + i + " index: ");
            arr[i] = sc.nextInt();

        }
        System.out.println(print2largest(arr, n));

    }
    private static int print2largest(int arr[], int n){
            // code here

            Arrays.sort(arr);
            int lar = arr[n - 1];
            int secLar = 0;
            for (int i = n - 2; i >= 0; i--) {


                if(arr[0] == lar) {
                    return -1;
                }else if (arr[i] == lar) {
                    lar = arr[i];
                } else {
                    secLar = arr[i];
                    break;
                }



            }

        // if(arr.length==0){
        //     return -1;
        // } else if(arr[n-2] < arr[n-1]){
        // return arr[n-2];
        // } else
        // return -1;
        return secLar;
    }

}
