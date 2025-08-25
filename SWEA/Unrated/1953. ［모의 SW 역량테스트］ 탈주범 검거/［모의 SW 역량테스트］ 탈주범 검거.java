import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int N, M; // 세로, 가로
	static int[][] map;
	static int R, C; // 맨홀 세로, 맨홀 가로
	static int L; // 소요된 시간 
	static boolean[][] visited;
	// 상 하 좌 우 순으로 (0,1,2,3)
	// 반대방향 -> (1, 0, 3, 2)
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0 , -1, 1};
	static int[] opposite = {1, 0, 3, 2};
	static int[][] type = {
							{0,0}, // 0 없음
							{0,1,2,3}, // 1
							{0,1}, // 2
							{2,3}, // 3
							{0,3}, // 4
							{1,3}, // 5
							{1,2}, // 6
							{0,2} // 7
						};
	
	/*
	 * 구하고자 하는 것 : 탈주범이 있을 수 있는 위치의 개수
	 * 시뮬레이션 + bfs
	 */
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			visited = new boolean[N][M];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				
				for(int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());			
				}
			}
			
			// 맨홀 뚜껑 위치 (세로 위치, 가로 위치)
			int result = bfs(R,C);
			System.out.println("#" + tc + " " + result);
		}
	}
	
	// bfs 방식
	static int bfs(int x, int y) {
		Queue<Node> q = new ArrayDeque<>();
		q.offer(new Node(x, y, 1));
		visited[x][y] = true;
		
		int cnt = 1;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			if(cur.time == L) { // 탈출 소요 시간이 같을 때 넘어감
				continue;
			}
			
			// 현재 구조물
			int type = map[cur.x][cur.y];
			int[] directions = getDir(type);
			
			for(int dir : directions) {
				int nx = cur.x + dx[dir];
				int ny = cur.y + dy[dir];
				
				// 맵 밖(범위) 벗어난 경우 넘어감 ~
				if(nx < 0 || nx >= N || ny < 0 || ny >= M) {
					continue;
				}
				
				// 이미 방문했거나 터널이 없는 경우 넘어감 ~
				if(visited[nx][ny] || map[nx][ny] == 0) {
					continue;
				}
				
				// 다음 구조물 선언
				int nextType = map[nx][ny];
				int[] nextDirections = getDir(nextType);
				
				// 연결되어있는지 확인
				boolean connected = false;
				for(int nextDir : nextDirections) {
					// 다음 위치에서는 반대 방향으로 들어오기 때문에 -> (상 하)(좌 우) -> (하 상)(좌 우)
					if(nextDir == opposite[dir]) {
						// 방문처리
						connected = true;
						break;
					}
				}
				
				// 이동 가능한 경우
				if(connected) {
					// 방문 처리
					visited[nx][ny] = true;
					q.offer(new Node(nx, ny, cur.time +1));
					cnt++;
				}
			}
		}
		return cnt;
	}
		
		// 터널 타입 switch문
		static int[] getDir(int type) {
			switch(type) {
			case 1 : return new int[] {0,1,2,3};
			case 2 : return new int[] {0,1};
			case 3 : return new int[] {2,3};
			case 4 : return new int[] {0,3};
			case 5 : return new int[] {1,3};
			case 6 : return new int[] {1,2};
			case 7 : return new int[] {0,2};
			default : return new int[] {};
	}

}
	// Node 클래스 만들기 (x,y,걸린 시간)
	static class Node {
		int x;
		int y;
		int time;
		
		Node(int x, int y, int time){
			this.x = x;
			this.y = y;
			this.time = time;
		}
		
	}
}
