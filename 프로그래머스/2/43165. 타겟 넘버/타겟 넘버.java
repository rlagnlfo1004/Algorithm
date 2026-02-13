class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        answer = dfs(numbers, 0, 0, target);
        return answer;
    }
    
    int dfs(int[] numbers, int n, int sum, int target) {
        if(n == numbers.length) {
            if(sum == target) return 1;
            else return 0;
        } else {
            return dfs(numbers, n + 1, sum + numbers[n], target) 
                + dfs(numbers, n + 1, sum - numbers[n], target);
        }
    }
}