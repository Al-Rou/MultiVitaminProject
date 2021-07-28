public class MultiVitamin {
    public static void main(String[] args)
    {
        Solution s = new Solution();
        //int[] juice = {10, 2, 1, 1}; int[] capacity = {10, 3, 2, 2};
        //int[] juice = {1, 2, 3, 4}; int[] capacity = {3, 6, 4, 4};
        //int[] juice = {2, 3}; int[] capacity = {3, 4};
        int[] juice = {1, 1, 5}; int[] capacity = {6, 5, 8};

        System.out.println(s.solution(juice, capacity));
    }
}
