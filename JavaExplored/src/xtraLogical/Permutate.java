/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xtraLogical;

import java.util.ArrayList;
import java.util.Arrays;
 
public class Permutate {
  private static void permute(int n, int[] nums, ArrayList<String> p,
			String aux, boolean[] used) {
		///System.out.println(aux);
		if (aux.length() == n) {
			p.add(aux);
                        System.out.println("added to al");
			return;
		}
		for (int i = 0; i < n; i++) {
			if (!used[i]) {
				used[i] = true;
                                System.out.println("recursion = " + i);
				permute(n, nums, p, aux + nums[i], used);
                                System.out.println("---------false = " + i);
				used[i] = false;
			}
		}
		//return false;
	}
 
	private static int[] generate(int n) {
		int[] num = new int[n];
		for (int i = 1; i <= n; i++) {
			num[i - 1] = i;
		}
		return num;
	}
 
	public static ArrayList<String> permute(int n) {
		int[] nums = generate(n);
		ArrayList<String> l = new ArrayList<>();
		boolean[] used = new boolean[n];
		Arrays.fill(used, false);
                
		permute(n, nums, l, "", used);
		return l;
	}
 
	public static void main(String... args) {
		int n= 3;
		ArrayList<String> p = permute(n);
		System.out.println(p);
		System.out.println("Length = " + p.size());
	}
}