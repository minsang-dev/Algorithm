import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static int maxSum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		arr = new int[9][9];
		// 최댓값 초기화
		maxSum = Integer.MIN_VALUE;
		// 행 시작 위치 x, y => (1, 1)부터
		int x = 1;
		int y = 1;
		
		for(int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// arr[i][j] > 최댓값이면
		// 최댓값 갱신
		// 인덱스 1번부터 시작
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(arr[i][j] > maxSum) {
					maxSum = arr[i][j];
					x = i+1;
					y = j+1;
				}
			}
		}
		
		System.out.println(maxSum);
		System.out.println(x + " " + y);
	}

}
