package DataStructurePatternWise.Array.TwoPointers;

public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int low = 0;
        int high = height.length-1;
        int maxArea = 0;

        while (low < high) {
            int width = high - low;
            int area = width * Math.min(height[low] , height[high]);
            maxArea = Math.max(maxArea , area);
            if (height[low] < height[high]) {
                low++;
            } else {
                high--;
            }
        }
        return maxArea;
    }
    public static void main(String[] args) {
        int[] height = {1 , 2, 4, 8 , 10 , 3 , 8 , 0  , 3 , 5 ,10};
        int max = ContainerWithMostWater.maxArea(height);
        System.out.println(max);
    }
}
