import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 문제에서 N은 1000이하의 값을 가지지만, 이는 절댓값 기준이기에 2000이 필요하다.
        // 나머지 1은 0자리를 의미한다.
        boolean[] arr = new boolean[2001];

        for(int i = 0; i < N; i++) {
            arr[Integer.parseInt(br.readLine()) + 1000] = true;
        }

        for(int i = 0; i < 2001 ; i++) {
            if(arr[i]) {
                System.out.println(i - 1000);
            }
        }
    }
}