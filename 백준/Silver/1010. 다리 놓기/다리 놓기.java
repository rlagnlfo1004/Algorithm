import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=0;t<T;t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int result = 1;
			for(int i=1;i<=N;i++) {
				result = result * (M-i+1) / i;
			}
			System.out.println(result);
		}
		
	}
}