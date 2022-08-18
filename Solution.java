import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/*

there will be two cases:

(1) s.length < t.length:
zzzzx
zzzzzzzz
4
erase s.length - i + 1 elements
add t.length - i + 1 elements

(2) s.length > t.length:
zzzzzzzz
zzy
4
erase s.length - i + 1 elements
add t.length - i + 1 elements

what if k is more than what we need?

zzzzzzzz
zzzy
15
farthest: position 2

hackerhappy
hackerrank
9
farthest: position 7

aba
aba
7
farthest: position 1

asxley
ash
2

 */

public class Solution {
	
	static Scanner fs;
	
	public static void main(String[] args) {
		fs = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int T = 1;
		//T = fs.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			char[] s = fs.next().toCharArray();
			char[] t = fs.next().toCharArray();
			int k = fs.nextInt();
			int[] a = new int[Math.min(s.length, t.length)];
			for (int i = 0; i < Math.min(s.length, t.length); i++) {
				int farthest = (s.length - i) + (t.length - i);
				a[i] = farthest;
			}
			//System.out.println(Arrays.toString(a));
			boolean checker = false;
			for (int i = 0; i < a.length; i++) {
				if (a[i] > k && s[i] != t[i]) {
					checker = false;
					break;
				}
				if (a[i] == k) {
					checker = true;
					break;
				}
			}
			int diff = Math.abs(s.length - t.length);
			if (checker && diff > 0) {
				if (diff > k) {
					checker = false;
				}
			}
			if (!checker) {
				checker = (a[0] <= k);
			}
			out.println(checker ? "Yes" : "No");
		}
		fs.close();
		out.close();
	}
	
	static void sort(int[] a) {
		ArrayList<Integer> arr = new ArrayList<>();
		for (int x : a) {
			arr.add(x);
		}
		Collections.sort(arr);
		for (int i = 0; i < a.length; i++) {
			a[i] = arr.get(i);
		}
	}
	
	static int[] readArray(int n) {
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = fs.nextInt();
		}
		return a;
	}
}
