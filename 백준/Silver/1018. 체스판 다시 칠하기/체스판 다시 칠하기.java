import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
	static int N, M;
	static char[][] board;
	// 다시 칠해야하는 정사각형 개수의 최솟값

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new char[N][M];
		
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			for(int j = 0; j < M; j++) {
				board[i][j] = line.charAt(j);
			}
		}
		
		// 최솟값
		int answer = Integer.MAX_VALUE;
		
		for(int i = 0; i <= N - 8; i++) {
			for(int j = 0; j <= M - 8; j++) {
				answer = Math.min(answer, count(i, j));
			}
		}
		
		System.out.println(answer);
	}
	
	static int count(int x, int y) {
		int rePaintB = 0;
		int rePaintW = 0;
		
		for(int i = x; i < x + 8; i++) {
			for(int j = y; j < y + 8; j++) {
				
				// 짝수 칸이면 시작색과 같은 색
				if((i + j) % 2 == 0) {
					if(board[i][j] != 'B') {
						rePaintB++;
				}
					if(board[i][j] != 'W') {
						rePaintW++;
					}
				} else {
					if(board[i][j] != 'W') {
						rePaintB++;
					}
					if(board[i][j] != 'B') {
						rePaintW++;
					}
				}
			}
		}
		return Math.min(rePaintB, rePaintW);
	}

}
