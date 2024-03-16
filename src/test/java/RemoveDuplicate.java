public class RemoveDuplicate {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int uniqueIndex = 0; // Pointer to track the position of the next non-duplicate element

        // Iterate through the array
        for (int i = 1; i < nums.length; i++) {
            // If the current element is different from the previous non-duplicate element,
            // move it to the next position in the array
            if (nums[i] != nums[uniqueIndex]) {
                uniqueIndex++;
                nums[uniqueIndex] = nums[i];
            }
        }

        // Return the length of the array up to the position of the last non-duplicate element
        return uniqueIndex + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3, 4, 4, 4, 5};
        int newLength = removeDuplicates(nums);

        System.out.println("Length after removing duplicates: " + newLength);
        System.out.print("Array after removing duplicates: ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
