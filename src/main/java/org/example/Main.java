package org.example;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(sumStrings("082161734233463333485105351877", "1380443235483315064520680"));
    }

    public static String sumStrings(String a, String b) {
        if (a == "")a = "0";
        if (b == "")b = "0";
        int carry = 0;
        String result = "";

        if (a.length() > b.length()) {
            int length = a.length() - b.length();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < length; i++) {
                sb.append("0");
            }
            b = new StringBuilder(b).reverse().toString() + sb.toString();
            b = new StringBuilder(b).reverse().toString();
        }
        else if (b.length() > a.length()) {
            int length = b.length() - a.length();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < length; i++) {
                sb.append("0");
            }
            a = new StringBuilder(a).reverse().toString() + sb.toString();
            a = new StringBuilder(a).reverse().toString();
        }

        for (int i = a.length() - 1; i >= 0; i--) {
            int digitA = a.charAt(i) - '0';
            int digitB = b.charAt(i) - '0';

            int resultingNumber = digitA + digitB + carry;
            if (resultingNumber >= 10) {
                result = (resultingNumber % 10) + result;
                carry = 1;
            } else {
                result = resultingNumber + result;
                carry = 0;
            }
        }
        if (carry > 0) {
            result = carry + result;
        }
        if (result.charAt(0) == '0'){
           result = result.substring(1, result.length());
        }

        return result;
    }
}