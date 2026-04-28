package DataStructurePatternWise.Array.TwoPointers;

public class TrapingRainWater {
    public static int trap(int[] height) {
        int low = 0 , high = height.length-1 , leftMax = 0 , rightMax = 0;
        int trapWater = 0;
        while (low < high) {
            if (height[low] < height[high]) {
                leftMax = Math.max(leftMax , height[low]);
                trapWater += leftMax - height[low];
                low++;
            } else {
                rightMax = Math.max(rightMax , height[high]);
                trapWater += rightMax-height[high];
                high--;
            }
        }

        return trapWater;
    }
    public static void main(String[] args) {
        int[] arr = {1 , 0 , 0, 2 , 8,  0 , 0 , 7 , 5};
        int trapWater = TrapingRainWater.trap(arr);
        System.out.println(trapWater);

    }
}
