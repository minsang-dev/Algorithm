import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	// 시뮬레이션 + bfs
	static int R, C;
	static int[][] map;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		
		for(int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int time = 0;
		int remainCheese = 0;
		
		while(true) {
			int cheeseCnt = countCheese();
			if(cheeseCnt == 0) {
				break;
			}
				
				remainCheese = cheeseCnt;
				
				bfs(0, 0);
				
				melting();
				
				time++;
			}
			
			System.out.println(time);
			System.out.println(remainCheese);
		}
			
	private static void melting() {
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i][j] == 2) {
					map[i][j] = 0; // 치즈를 공기로
				}
			}
		}
	}

	private static int countCheese() {
		int cnt = 0;
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i][j] == 1) {
					cnt++;
				}
			}
		}
		return cnt;
	}

	static void bfs(int curX, int curY) {
		visited = new boolean[R][C];
		
		Queue<Node> q = new ArrayDeque<>();
		q.offer(new Node(curX, curY));
		visited[curX][curY] = true;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			for(int d = 0; d < 4; d++) {
				
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];
				
				if(isIn(nx, ny) && !visited[nx][ny]) {
					if(map[nx][ny] == 0) { // 공기일때
						visited[nx][ny] = true;
						q.offer(new Node(nx, ny));
					} else if (map[nx][ny] == 1) { // 치즈일때
						map[nx][ny] = 2; // 녹을 예정
					}
					
					
				}
			}
		}
	}
	
	static boolean isIn(int x, int y) {
		return x >= 0 && y >= 0 && R > x && C > y;
	}
	
	static class Node{
		int x;
		int y;
		
		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}