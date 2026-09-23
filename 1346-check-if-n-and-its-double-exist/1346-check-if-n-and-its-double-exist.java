class Solution {
    public boolean checkIfExist(int[] arr) {
        // return solution1(arr);
        // return solution2(arr);
        return solution3(arr);
    }

    public boolean solution3(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(arr[i] * 2) || (arr[i] % 2 == 0 && set.contains(arr[i] / 2)))
                return true;
            set.add(arr[i]);
        }
        return false;
    }

    public boolean solution2(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            int target = arr[i] * 2;
            int idx = binarySearch(arr, target);
            if (idx == -1)
                continue;
            if (idx != i)
                return true;
            if ((idx - 1 >= 0 && arr[idx - 1] == target) ||
                    (idx + 1 < arr.length && arr[idx + 1] == target))
                return true;
        }
        return false;
    }

    private int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target)
                return mid;
            if (arr[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    public boolean solution1(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == j)
                    continue;
                if (arr[i] == 2 * arr[j])
                    return true;
            }
        }
        return false;
    }
}