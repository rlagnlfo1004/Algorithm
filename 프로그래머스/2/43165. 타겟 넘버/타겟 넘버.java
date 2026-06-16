class Solution {
    int answer = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(0, 0, numbers, target);
        return answer;
    }
    
    private void dfs(int sum, int index, int[] numbers, int target) {
        if(index == numbers.length) {
            if (sum == target) answer++;
            return;
        }
        
        dfs(sum + numbers[index], index + 1, numbers, target);
        dfs(sum - numbers[index], index + 1, numbers, target);
    }
}