package in.co.codeWithMayank.c10_c99.I_Arrays;

import java.io.*;
// import java.util.*;

public class c70_array_inverseOfArray {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        int[] inv = inverse(a);
        display(inv);
    }

    public static void display(int[] a) {
        StringBuilder sb = new StringBuilder();

        for (int val : a) {
            sb.append(val + "\n");
        }
        System.out.println(sb);
    }

    public static int[] inverse(int[] a) {
        int[] ans = new int[a.length];
        for (int i = 0; i < a.length; i++)
            ans[a[i]] = i;

        return ans;
    }

}