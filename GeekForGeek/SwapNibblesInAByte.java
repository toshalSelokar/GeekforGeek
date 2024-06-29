package GeekForGeek;

import java.util.Scanner;

public class SwapNibblesInAByte {

    public static void main(String arg[])
    {
        Scanner sc =new Scanner(System.in);

        System.out.print("Enter int: ");
        int n = sc.nextInt();
        System.out.print(swapNibbles(n));
    }

    private static int swapNibbles(int n) {

        int leftPart = n>>4;
//  As 15 bit value is 1111, if we use it with Bitwise & operator, it gives the same value.
//        for eg. 0100 & 1111 will give 0100.
        int rightPart = n & 15;

        rightPart = rightPart<<4;

        int ans = rightPart | leftPart;

        return ans;

    }
}
