package TwoPointers;

public class ContainerWithMostWater11_greedyAlso {
//    public static int mostWater(int[] heigth) {
//        int maxWater = 0;
//        int area = 0;
//        for (int i=0; i<heigth.length; i++) {
//            for (int j=i+1; j<heigth.length; j++) {
//                int width = j-i;
//                int height = Math.min(heigth[i] , heigth[j]);
//                area = width*height;
//                maxWater = Math.max(maxWater , area);
//            }
//
//        }
//        return maxWater;
//    }
public  int maxArea(int[] height) {
    int maxWater = 0;
    int left = 0, right = height.length-1;
    while (left < right) {
        int width = right - left;
        int ht = Math.min(height[left] , height[right]);
        int currentMax = width*ht;
        maxWater = Math.max(maxWater ,currentMax );
        if (height[left] < height[right])  left++;
        else right--;
    }
    return maxWater;
}
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        ContainerWithMostWater11_greedyAlso c = new ContainerWithMostWater11_greedyAlso();
        int ans = c.maxArea(height);
        System.out.println(ans);
    }
}
