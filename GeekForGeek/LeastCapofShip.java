package GeekForGeek;

import java.util.Scanner;

public class LeastCapofShip {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Array length: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Array value at "+ i+" index: ");
            arr[i]= sc.nextInt();
        }

        System.out.print("Days to carry: ");
        int d = sc.nextInt();
        int capacity = leastWeightCapacity(arr, n, d);
        System.out.println(capacity);
    }

    private static int leastWeightCapacity(int[] arr, int n, int d) {
        // code here

        int maxCap = 0;
        for(int i = 0; i<n; i++){
            maxCap = maxCap + arr[i];
        }

        int leastCap= 0;

        for(int i= 0; i<n; i++){
            if(arr[i]>leastCap){
                leastCap = arr[i];
            }
        }

        int desiredCap=0;
        int sum = 0;
        for(int i = 0; i<n; i++){
            sum = sum + arr[i];
            if(sum<=(maxCap/d) + 1 ){

                desiredCap = desiredCap + arr[i];
            }

        }

        return desiredCap;

    }
}
