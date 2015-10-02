import java.util.Arrays;

public class MaximumRectangle {
	public int maximalRectangle(char[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		final int m = matrix.length;
		final int n = matrix[0].length;
		int[] left = new int[n];
		int[] right = new int[n];
		int[] height = new int[n];

		Arrays.fill(left, 0);
		Arrays.fill(right, n);
		Arrays.fill(height, 0);

		int maxA = 0;
		int i, j;
		for (i = 0; i < m; i++) {
			int cur_left = 0, cur_right = n; // cur_right eclusive
			for (j = 0; j < n; j++) {
				if (matrix[i][j] == '1') {
					height[j]++;
					left[j] = Math.max(left[j], cur_left);
				} else {
					height[j] = 0;
					left[j] = 0;
					cur_left = j + 1;
				}
			}
			for (j = n - 1; j >= 0; j--) {
				if (matrix[i][j] == '1') {
					right[j] = Math.min(right[j], cur_right);

				} else {
					right[j] = n;
					cur_right = j;
				}
			}
			for (j = 0; j < n; j++) {
				maxA = Math.max(maxA, (right[j] - left[j]) * height[j]);
			}
		}
		return maxA;
	}
}
