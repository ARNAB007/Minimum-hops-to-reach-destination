class MinHopAlgorithm
{
	// Find minimum jumps required to reach the destination
	public static int findMinJumps(int[] arr, int i, int n, int[] lookup)
	{
		// base case: destination is reached
		if (i == n - 1) {
			return 0;
		}

		// base case: array index out of bound or destination is
		// unreachable from source
		if (i >= n || arr[i] == 0) {
			return Integer.MAX_VALUE;
		}

		// if the sub-problem is seen before
		if (lookup[i] != 0) {
			return lookup[i];
		}

		// find the minimum jumps required to reach the destination by considering
		// the minimum of all elements reachable from arr[i]
		int min_jumps = Integer.MAX_VALUE;
		for (int j = i + 1; j <= i + arr[i]; j++)
		{
			int cost = findMinJumps(arr, j, n, lookup);
			if (cost != Integer.MAX_VALUE) {
				min_jumps = Math.min(min_jumps, cost + 1);
			}
		}

		// save sub-problem solution and return minimum jumps required
		return (lookup[i] = min_jumps);
	}

	public static void main(String[] args)
	{
		int[] arr = { 2, 3, 1, 1, 3 };

		// create an auxiliary array for storing solution to the sub-problems and
		// initialized with 0
		int[] lookup = new int[arr.length];

		System.out.println("Minimum jumps required to reach the destination are " +
									findMinJumps(arr, 0, arr.length, lookup));
	}
}