import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, B;
	static int minTime;
	static int maxHeight;
	static int[][] map;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		int minH = 257;
		int maxH = -1;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				minH = Math.min(minH, map[i][j]);
				maxH = Math.max(maxH, map[i][j]);
			}
		}
		
		minTime = Integer.MAX_VALUE;
		maxHeight = 0;
		
		for(int target = minH; target <= maxH; target++) {
			simulate(target);
			
		}
		
		System.out.println(minTime + " " + maxHeight);
	}
	
	static void simulate(int target) {
		int time = 0;
		int inven = B;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j<M; j++) {
				int curH = map[i][j];
				
				if(curH > target) {
					int removeCnt = curH - target;
					time += removeCnt * 2;
					inven += removeCnt;
				} else if (curH < target) {
					int addCnt = target - curH;
					time += addCnt * 1;
					inven -= addCnt;
				}
			}
		}
		if(inven < 0) {
			return;
		}
		
		if(time < minTime || time== minTime && target > maxHeight) {
			minTime = time;
			maxHeight = target;
		}
	}

}
