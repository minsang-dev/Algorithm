import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static int[] dist;
	static int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		dist = new int[100001];

		System.out.println(dij());
	}
    
	static int dij() {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.time - o2.time);
		Arrays.fill(dist, INF); // 초기화 시켜주기

		pq.offer(new Node(N, 0));
		dist[N] = 0;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			int nPos = cur.pos;
			int nTime = cur.time;
			
			if(nTime > dist[nPos]) {
				continue;
			}
			
			if(nPos == K) {
				return nTime;
			}
			
			// 1) X-1초 후
			if(nPos-1 >= 0 && dist[nPos-1] > nTime +1) {
				dist[nPos-1] = nTime+1;
				pq.offer(new Node(nPos-1, nTime+1));
			}
			
			// 2) X+1초 후 (** 여기서 중요한 것은 상한 범위로 설정해주기)
			if(nPos+1 <= 100000 && dist[nPos+1] > nTime +1) {
				dist[nPos+1] = nTime+1;
				pq.offer(new Node(nPos+1, nTime+1));				
			}
			
			// 3) 0초 후 (** 여기서 중요한 것은 상한 범위로 설정해주기)
			if(nPos*2 <= 100000 && dist[nPos*2] > nTime) {
				dist[nPos*2] = nTime;
				pq.offer(new Node(nPos*2, nTime));
			}
		}
		return -1;
	}
	
	static class Node{
		int pos;
		int time;
		
		public Node(int pos, int time) {
			super();
			this.pos = pos;
			this.time = time;
		}
	}

}
