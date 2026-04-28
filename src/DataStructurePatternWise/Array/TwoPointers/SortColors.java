package DataStructurePatternWise.Array.TwoPointers;

public class SortColors {
    public static int[] sortColors(int[] colors) {
        int red = 0, white = 0, blue = 0;
        for (int i : colors) {
            if (i == 0) red++;
            if (i == 1) white++;
            if (i == 2) blue++;
        }
        int idx = 0;
        while (red-- > 0) {
            colors[idx++] = 0;
        }
        while (white-- > 0) {
            colors[idx++] = 1;
        }
        while (blue-- > 0) {
            colors[idx++] = 2;
        }
        return colors;
    }

    // Two Pointer Approach
    public static int[] Optimized(int[] colors) {
        int mid = 0;
        int low = 0;
        int high = colors.length - 1;
        while (mid <= high) {
            if (colors[mid] == 0) {
                swap(colors, low, mid);
                low++;
                mid++;
            } else if (colors[mid] == 1) {
                mid++;
            } else {
                swap(colors, mid, high);
                high--;
            }
        }
        return colors;
    }

    private static void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }

public static void main(String[] args) {
        int[] colors = {1 , 2, 0 , 0 , 2, 1, 2, 0};
        colors = SortColors.sortColors(colors);
        for (int i : colors) {
            System.out.print(i + " ");
        }
        System.out.println("\n\n\n");
        int[] colors1 = {1 , 2, 0 , 0 , 2, 1, 2, 0 , 0 , 0  , 2};
        colors1 = SortColors.Optimized(colors1);
        for (int i : colors1) {
            System.out.print(i + " ");
        }
    }
}
