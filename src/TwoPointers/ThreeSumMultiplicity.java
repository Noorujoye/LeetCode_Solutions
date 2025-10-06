package TwoPointers;

import java.util.Arrays;

class ThreeSumMultiplicity {
    public static int threeSumMulti(int[] arr, int target) {


        Arrays.sort(arr);
        long res = 0;
        int mod = 1000000007;


        for (int i=0; i<arr.length-2; i++) {

            int left = i+1;
            int right = arr.length-1;


            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];

                if (sum<target) left++;
                else if (sum > target) right--;
                else if (sum == target) {

                    int ele1 = arr[left];
                    int ele2 = arr[right];
                    int count1 = 0;
                    int count2 = 0;
                    while (left <= right && arr[left] == ele1) {count1++; left++;}
                    while (left <= right && arr[right] == ele2) {count2++; right--;}

                    if (ele1 == ele2) {
                        res+= (count1*(count1-1))/2;
                    } else {
                        res+= count1*count2;
                    }
                    res %= mod;
                }
            }
        }
        return (int)res;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2,2,3,3,4,4,5,5};
        int target = 8;
        Three3SumEqualsZero three3SumEqualsZero = new Three3SumEqualsZero();

        int result = threeSumMulti(arr,target);
        System.out.println(result);

    }
}
