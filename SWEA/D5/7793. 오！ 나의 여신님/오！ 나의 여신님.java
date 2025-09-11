import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int N, M;
	static char[][] map; // 문자로 받으니까 타입이 int가 아니라 char로 받아야지 민상아. 또 실수하면 가만안둬.
	static int[][] devilTime; // 악마가 도달하는 -
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int minTime;
	
	// Point 클래스 생성 (좌표 표현)
	static class Point{ // 클래스에 static 붙여주기
		int x;
		int y;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	// Node 클래스
	static class Node{
		int x;
		int y;
		int time;
		
		Node(int x, int y, int time){
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			// 배열 초기화 해야지.
			map = new char[N][M];
			visited = new boolean[N][M];
			devilTime = new int[N][M];
			
			// 악마 도달 배열 -1로 초기화
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					devilTime[i][j] = -1;
				}
			}
			
			// 악마의 손아귀가 확산되는 과정 BFS 표현하기 위해 큐 생성 (큐 초기화 일단 시켜)
			Queue<Node> devilSpread = new ArrayDeque<>();
			Point start = null;
			
			for(int i = 0; i < N; i++) {
				String line = br.readLine();

				for(int j = 0; j < M; j++) {
					// 숫자로 변환할 필요 없음 . 문자로 그대로 저장하면 됨.
					map[i][j] = line.charAt(j);
					
					if(map[i][j] == '*') {
						devilSpread.offer(new Node (i, j, 0));
						devilTime[i][j] = 0;
					} else if (map[i][j] == 'S') {
						start = new Point(i, j);
					}
				}
			}
			
			if(start == null) {
				System.out.println("#" + tc + " " + "GAME OVER");
				continue;
			}
			
			devilSpreadTime(devilSpread);
			int result = suyeonMove(start.x, start.y);
			if(result == -1) {
				System.out.println("#" + tc + " " + "GAME OVER");
			} else {
			System.out.println("#" + tc + " " + result);
			}
		}
	}
	
	// 이미 main에서 devilSpread에 offer해줬기 때문에 바로 while문 써서 isEmpty하면 빼주기
	// 악마가 확산되는 메서드
	static void devilSpreadTime(Queue<Node> q) {
		while(!q.isEmpty()) {
			Node cur = q.poll(); // 현재 노드에 뺀 값 넣어주기
			
			for(int d = 0; d < 4; d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];
				
				// 범위체크 + 돌 위치 못가고 + 여신 공간도 아니어야함
				if(isIn(nx, ny) && map[nx][ny] != 'X' && map[nx][ny] != 'D') {
					// 악마가 아직 가지 않은 곳도 체크
					if(devilTime[nx][ny] == -1) {
						devilTime[nx][ny] = cur.time + 1;
						q.offer(new Node(nx, ny, cur.time +1));
						
					}
					
				}
			}
			
		}
	}
	
	static int suyeonMove(int startX, int startY) {
		Queue<Node> q = new ArrayDeque<>();
		q.offer(new Node(startX, startY, 0));
		visited[startX][startY] = true;
			
		while(!q.isEmpty()) {
			Node cur = q.poll();
			
			// 여신에게 도착했을 때 return
			if(map[cur.x][cur.y] == 'D') {
				return cur.time;
			}
			
			// 4방 탐색
			for(int d = 0; d < 4; d++) {
				int nx = cur.x + dx[d];
				int ny = cur.y + dy[d];
				
				// 범위 확인하고, 노드에 추가
				if(isIn(nx, ny) && map[nx][ny] != 'X' && !visited[nx][ny]) {
					// 악마보다 먼저 도착하기
					if(devilTime[nx][ny] == -1 || cur.time +1 < devilTime[nx][ny]) {
						visited[nx][ny] = true;
						q.offer(new Node(nx, ny, cur.time+1));
					}
				}
			}
			
		}
		return -1;
		
	}
	
	// 탐색이 가능한 범위 (&&)
	static boolean isIn (int x, int y){
		return x >= 0 && y >= 0 && x < N && y < M;
	}

}