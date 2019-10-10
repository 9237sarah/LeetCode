public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length <= 1) {
            return new int[] {-1, -1};
        }
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], i);
        }
        for (int i = 0; i < numbers.length; i++) {
            /*
             *  map.get(target - numbers[i]) != i
             *  {3, 2, 4}, 6 ---> {1, 1}
             */
            if (map.containsKey(target - numbers[i]) && map.get(target - numbers[i]) != i) {
                return new int[]{Math.min(map.get(target - numbers[i]), i) + 1, Math.max(map.get(target - numbers[i]), i) + 1};
            }
        }
        return new int[] {-1, -1};
    }
}