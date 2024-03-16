public class RotateArray {
    public static void rotate(int[] nums, int k) {

        k = k % nums.length;
        reverse(nums, 0, nums.length);
        reverse(nums, 0, k);
        reverse1(nums, k, nums.length - 1);

    }

    public static void reverse(int[] nums, int start, int end) {
        int x = start + end;
        for (int i = start; i <= x / 2; i++) {
            int front = i;
            int back = end + start - i - 1;
            int frontInt = nums[front];
            int backInt = nums[back];
            nums[front] = backInt;
            nums[back] = frontInt;

        }

    }

    public static void reverse1(int[] nums, int start, int end) {
        int x = start + end;
        for (int i = start; i <= x / 2; i++) {
            int front = i;
            int back = end + start - i;
            int frontInt = nums[front];
            int backInt = nums[back];
            nums[front] = backInt;
            nums[back] = frontInt;

        }

    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 3;
        rotate(arr, k);
    }
}
