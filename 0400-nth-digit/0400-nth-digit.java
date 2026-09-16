class Solution {
    public int findNthDigit(int n) {

        // Use long to avoid overflow.
        // Example:
        // 9-digit block contains 900000000 numbers.
        // 900000000 * 9 exceeds int range.
        long N = n;

        // start = first number of current block
        // len   = digits in each number of current block
        // count = how many numbers are present in current block
        //
        // Initially:
        // 1-digit numbers => 1 to 9
        long start = 1;
        long len = 1;
        long count = 9;

        // Remove complete blocks until nth digit falls inside a block.
        //
        // Example n = 250
        //
        // 1-digit block:
        // total digits = 9 * 1 = 9
        // n = 250 - 9 = 241
        //
        // 2-digit block:
        // total digits = 90 * 2 = 180
        // n = 241 - 180 = 61
        //
        // Now n = 61 lies inside the 3-digit block.
        while (N > len * count) {
            N -= len * count;

            // Move to next block.
            len++;
            count *= 10;
            start *= 10;
        }

        // We are now inside the correct block.
        //
        // Formula for the n lie in which number like 16th digit is lying inside 13 number
        // number = start + (N - 1) / len
        //
        // Example:
        // N = 61, len = 3, start = 100
        //
        // number = 100 + (61 - 1) / 3
        //        = 100 + 20
        //        = 120
        //
        // So the required digit lies in number 120.
        long number = start + (N - 1) / len;

        // Convert number to string so that we can access its digits.
        String num = String.valueOf(number);

        // Find index of required digit inside the number.
        //
        // Formula for digit like 16th digit is at index 0 of 13 that is 1
        // index = (N - 1) % len
        //
        // Example:
        // N = 61, len = 3
        //
        // index = (61 - 1) % 3
        //       = 0
        //
        // In "120":
        // index 0 -> '1'
        // index 1 -> '2'
        // index 2 -> '0'
        //
        // Therefore answer = 1.
        return num.charAt((int) ((N - 1) % len)) - '0';
    }
}