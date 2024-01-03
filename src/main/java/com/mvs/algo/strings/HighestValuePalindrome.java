package com.mvs.algo.strings;

public class HighestValuePalindrome {

    /**
     * 
     * Palindromes are strings that read the same from the left or right, for
     * example madam or 0110.
     * 
     * You will be given a string representation of a number and a maximum number of
     * changes you can make. Alter the string, one digit at a time, to create the
     * string representation of the largest number possible given the limit to the
     * number of changes. The length of the string may not be altered, so you must
     * consider 's left of all higher digits in your tests. For example is valid, is
     * not.
     * 
     * Given a string representing the starting number, and a maximum number of
     * changes allowed, create the largest palindromic string of digits possible or
     * the string '-1' if it is not possible to create a palindrome under the
     * contstraints.
     * Constraints: 0 < n <= 10^5, 0 <= k <= 10^5, s contains only digits 0-9.
     */
    public static String highestValuePalindrome(String s, int n, int k) {
        if (s == null || s.length() == 0) {
            return s;
        }

        char[] arr = s.toCharArray();
        int left = 0;
        int right = n - 1;

        // first iterate on the string from both sides left and right
        // if left not eq right then
        // replace with maksimum of left and right
        // k-- (decrement total changes)
        // if k < 0 then return "-1" (no change possible)
        // since we have changes left, we will change all possible digits to '9'
        // to get the largest palindrom
        while (left < right) {
            if (arr[left] != arr[right]) {
                arr[left] = arr[right] = (arr[left] > arr[right]) ? arr[left] : arr[right];
                k--;
            }
            left++;
            right--;
        }

        if (k < 0) {
            return "-1";
        }

        // not possible to make it palindrom
        left = 0;
        right = n - 1;
        while (left <= right) {
            // middle point case
            if (left == right && k > 0) {
                arr[left] = '9';
                left++;
                right--;
                continue;
            }

            if (arr[left] < '9') {
                // if we left more than 2 changes then if the both left and right not changed we
                // have to make 2 changes
                if (k >= 2 && arr[left] == s.charAt(left) && arr[right] == s.charAt(right)) {
                    k -= 2;
                    arr[left] = arr[right] = '9';

                    // if one of left and right has been changed then we should count only one
                    // change.
                } else if (k >= 1 && (arr[left] != s.charAt(left) || arr[right] != s.charAt(right))) {
                    k--;
                    arr[left] = arr[right] = '9';
                }
            }
            left++;
            right--;
        }

        return new String(arr);
    }

    public static void main(String[] args) {
        String s = "3943";
        int n = 4;
        int k = 1;
        System.out.println(highestValuePalindrome(s, n, k));
    }
}
