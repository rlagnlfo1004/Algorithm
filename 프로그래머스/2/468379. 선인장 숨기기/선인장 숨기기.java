import java.util.Arrays;

class Solution {
    public int[] solution(int m, int n, int h, int w, int[][] drops) {
        
        // 1. 시간 맵(Time Map) 생성
        // 2차원 격자를 1차원 배열로 평탄화하여 메모리 및 속도 최적화 (인덱스: r * n + c)
        int[] timeMap = new int[m * n];
        
        // 비가 내리지 않는 구역은 무한대(안전 지대)로 간주합니다.
        Arrays.fill(timeMap, Integer.MAX_VALUE);
        
        // 빗방울이 떨어지는 시간을 기록합니다. (1번째 비부터 시작)
        for (int i = 0; i < drops.length; i++) {
            int r = drops[i][0];
            int c = drops[i][1];
            timeMap[r * n + c] = i + 1; 
        }
        
        // 2. 가로 방향(Row 단위) 1차원 슬라이딩 윈도우
        // 각 행(Row)별로 크기가 w인 윈도우의 최솟값을 저장할 임시 배열
        int cols = n - w + 1; // 가로 윈도우 적용 후 열의 개수
        int[] rowMin = new int[m * cols];
        
        int[] deque = new int[n]; // 속도를 위해 배열로 직접 구현한 단조 덱
        
        for (int i = 0; i < m; i++) {
            int head = 0, tail = 0; // 덱 포인터 초기화
            
            for (int j = 0; j < n; j++) {
                int val = timeMap[i * n + j];
                
                // [덱 Front] 윈도우 범위를 벗어난 오래된 인덱스 제거
                if (head < tail && deque[head] < j - w + 1) {
                    head++;
                }
                
                // [덱 Back] 단조 오름차순 유지: 새로 들어올 값보다 크거나 같은 값 제거
                while (head < tail && timeMap[i * n + deque[tail - 1]] >= val) {
                    tail--;
                }
                
                // 현재 인덱스 삽입
                deque[tail++] = j;
                
                // 윈도우가 가득 찬 시점부터 임시 배열에 최솟값 기록
                if (j >= w - 1) {
                    rowMin[i * cols + (j - w + 1)] = timeMap[i * n + deque[head]];
                }
            }
        }
        
        // 3. 세로 방향(Col 단위) 1차원 슬라이딩 윈도우 및 최종 좌표 갱신
        int maxTime = -1;
        int bestR = -1;
        int bestC = -1;
        
        int[] dequeH = new int[m]; // 세로 탐색용 단조 덱
        
        for (int j = 0; j < cols; j++) {
            int head = 0, tail = 0;
            
            for (int i = 0; i < m; i++) {
                int val = rowMin[i * cols + j];
                
                if (head < tail && dequeH[head] < i - h + 1) {
                    head++;
                }
                
                while (head < tail && rowMin[dequeH[tail - 1] * cols + j] >= val) {
                    tail--;
                }
                
                dequeH[tail++] = i;
                
                if (i >= h - 1) {
                    int currentMin = rowMin[dequeH[head] * cols + j];
                    int currentR = i - h + 1;
                    int currentC = j;
                    
                    // 최댓값 갱신 로직 (가장 늦게 비를 맞는 곳)
                    if (currentMin > maxTime) {
                        maxTime = currentMin;
                        bestR = currentR;
                        bestC = currentC;
                    } 
                    // 시간이 동일한 후보군이 여러 개일 경우 조건 처리
                    else if (currentMin == maxTime) {
                        // 1순위: 가장 위쪽 행 (r이 더 작은 것)
                        // 2순위: 가장 왼쪽 열 (c가 더 작은 것)
                        if (currentR < bestR || (currentR == bestR && currentC < bestC)) {
                            bestR = currentR;
                            bestC = currentC;
                        }
                    }
                }
            }
        }
        
        return new int[]{bestR, bestC};
    }
}