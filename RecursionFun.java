import java.util.Arrays;

/**
 * Complete the seven methods methods in this file using recursion, no loops.
 * Also complete these three methods inside LinkedList<E>: get(int) removeAll(E)
 * duplicateAll(E)
 * 
 * Also complete one method in ObstacleCourse that uses recursive backtracking.
 * findExit(int, int)
 * 
 * Note: I believe the given unit test tests all methods. We will be using this
 * same for for correctness of code.
 * 
 * We will not be using code coverage for points.
 *
 * @author Rick Mercer and Your Name
 */
public class RecursionFun {

	// Complete recursive method combinations that returns from n choose k.
	// This method is described in 17_SimpleRecursion.pptx.
	private static int recurrence(int num) {
		if (num <= 1) {
			return 1;
		} else {
			return num * recurrence(num - 1);
		}
	}

	public int combinations(int n, int k) {
		if (n == k) {
			return 1;
		}
		if (k == 1) {
			return n;
		}
		return combinations(n - 1, k - 1) + combinations(n - 1, k);
	}

	// Complete recursive method intWithCommas that returns the argument as a String
	// with commas in the correct places.
	//
	// intWithCommas(999) returns "999"
	// intWithCommas(1234) returns "1,234"
	// intWithCommas(1007) returns "1,007"
	// intWithCommas(1023004567) returns "1,023,004,567"
	//
	// Precondition: n >= 0
	private String helperIntWithCommas(int num, String temp) {
		if (num == 3) {
			num = 0;
			return helperIntWithCommas(num, temp) + ",";
		} else if (temp.length() == 1) {
			num++;
			return temp;

		} else {
			num++;
			return helperIntWithCommas(num, temp.substring(0, temp.length() - 1)) + temp.charAt(temp.length() - 1);
		}
	}

	public String intWithCommas(int n) {
		// TODO: Implement this method using recursion. Do not use a loop
		String temp = "";
		temp = String.valueOf(n);
		int num = 0;
		String result = helperIntWithCommas(num, temp);
		return result;
	}

	// Write recursive method reverseArray that reverses the array elements in a
	// filled array of ints. Use recursion; do not use a loop. The following
	// assertions must pass:
	//
	// int[] a = { 2, 4, 6 };
	// rf.reverseArray(a);
	// assertEquals(6, a[0]);
	// assertEquals(4, a[1]);
	// assertEquals(2, a[2]);
	//
	// Precondition: x.length > 0

	public void reverseArray(int[] x) {
		// You need a private helper that needs additional arguments.
		// like x and x.length to keep track of array the indexes
		// with no loop. Here is an example with the private helper
		// immediately below.

		reverseArray(x, 0, x.length - 1);
	}

	private void reverseArray(int[] a, int left, int right) {
		// TODO: Complete this method with a recursive algorithm.
		// Do NOT use a loop.
		if (left >= right) {
			return;
		}
		int temp = a[left];
		a[left] = a[right];
		a[right] = temp;
		reverseArray(a, ++left, --right);
	}

	// Write recursive method arrayRange that returns the maximum
	// integer minus the minimum integer in the filled array of
	// integers, Use recursion; do not use a loop.
	// Precondition: a.length > 0
	private int helperArrayRange(int min, int max, int[] a, int count) {
		if (a.length == count) {
			return max - min;
		} else {
			min = Math.min(min, a[count]);
			max = Math.max(max, a[count]);
			count++;
			return helperArrayRange(min, max, a, count);
		}
	}

	public int arrayRange(int[] a) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int count = 0;
		if (a.length == 1) {
			return 0;
		}
		int result = helperArrayRange(min, max, a, count);
		return result;
	}

	// Return true if nums has all int elements in ascending order.
	// If not isSorted, return false.
	public boolean isSorted(int[] nums) {
		// Need to send down 0 to keep track of the index
		if (nums.length <= 1) {
			return true;
		} else {
			int[] newInts = Arrays.copyOfRange(nums, 1, nums.length);
			return nums[0] <= nums[1] && isSorted(newInts);
		}
	}

	// Complete method found to return true if search is found in strs.
	// If not found, return false. Use equals, not ==.
	public boolean found(String search, String[] strs) {
		if (strs.length == 1) {
			return strs[0].equals(search);
		} else if (strs[0].equals(search)) {
			return true;
		} else {
			String[] newStrs = Arrays.copyOfRange(strs, 1, strs.length);
			return found(search, newStrs);
		}
	}
}
