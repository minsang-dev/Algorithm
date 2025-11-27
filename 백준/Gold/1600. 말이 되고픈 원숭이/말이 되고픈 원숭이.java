import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int K, W, H;
	static int[][] board;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static int[] hx = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int[] hy = {1, 2, 2, 1, -1, -2, -2, -1};
	
	static class Point{
		int startX, startY, kMoved, cost;
		
		Point(int startX, int startY, int kMoved, int cost){
			this.startX = startX;
			this.startY = startY;
			this.kMoved = kMoved;
			this.cost = cost;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		K = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		board = new int[H][W];
		
		for(int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < W; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
			System.out.println(bfs(0,0));
	}
	
		static int bfs(int x, int y) {
			boolean visited[][][] = new boolean[H][W][K+1];
			Queue<Point> q = new LinkedList<>();
			q.add(new Point(x, y, 0, 0));
			visited[x][y][0] = true;
			
			while(!q.isEmpty()) {
				Point p = q.poll();
				
				if(p.startX == H-1 && p.startY == W-1) {
					return p.cost;
				}
				
				for(int i = 0; i < 4; i++) {
					int nx = p.startX + dx[i];
					int ny = p.startY + dy[i];
					
					if(nx >= 0 && ny >= 0 && nx < H && ny < W && board[nx][ny] == 0 && !visited[nx][ny][p.kMoved]) {
						visited[nx][ny][p.kMoved] = true;
						q.add(new Point(nx, ny, p.kMoved, p.cost+1));
						
					}
				}
				
				// 말이 이동하는 것
				if(p.kMoved < K) {
					for(int i = 0; i < 8; i++) {
						int nhx = p.startX + hx[i];
						int nhy = p.startY + hy[i];
						
						if(nhx >= 0 && nhy >= 0 && nhx < H && nhy < W && board[nhx][nhy] == 0 && !visited[nhx][nhy][p.kMoved+1]) {
							visited[nhx][nhy][p.kMoved+1] = true;
							q.add(new Point(nhx, nhy, p.kMoved+1, p.cost+1));
						}
					}
				}
			}
			
		return -1;
	}
}
