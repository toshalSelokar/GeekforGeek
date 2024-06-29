package GeekForGeek;

/*
Given a string you need to print the size of the longest possible substring that has exactly K unique characters. If there is no possible substring then print -1.

Example 1:
Input:
S = "aabacbebebe", K = 3
Output:
7
Explanation:
"cbebebe" is the longest substring with 3 distinct characters.

Example 2:
Input:
S = "aaaa", K = 2
Output: -1
Explanation:
There's no substring with 2 distinct characters.

Your Task:
You don't need to read input or print anything. Your task is to complete the function longestKSubstr() which takes the string S and an integer K as input and returns the length of the longest substring with exactly K distinct characters. If there is no substring with exactly K distinct characters then return -1.
Expected Time Complexity: O(|S|).
Expected Auxiliary Space: O(|S|).
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class LongestKUniqueCharSubString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("String: ");
        String s = sc.next();

        System.out.print("No. of Unique characters: ");
        int k = sc.nextInt();

        System.out.println(longestkSubstr(s, k));

    }
    public static int longestkSubstr(String s, int k) {

        if(k<0 || s == null || s.length()==0){
            return -1;
        }
        // code here
        HashMap<Character, Integer> list = new HashMap();
        int left = 0;
        int mx = -1;

        for (int right = 0; right < s.length(); right++) {

            char rightChar = s.charAt(right);
            list.put(rightChar, list.getOrDefault(rightChar,0)+1);

            while(list.size()>k){
                char leftChar = s.charAt(left);
                list.put(leftChar, list.getOrDefault(leftChar, 0)-1);

                if(list.get(leftChar)==0){
                    list.remove(leftChar);
                }
                left++;
            }
            if(list.size()==k){
                mx = Math.max(mx, right-left+1);
            }

        }



        return mx;
        
    }
}
