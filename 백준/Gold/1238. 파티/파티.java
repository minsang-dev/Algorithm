import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int X;
	static ArrayList<Node>[] graph;
	static ArrayList<Node>[] reverseGraph;
	static int INF = Integer.MAX_VALUE;
	static int[] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		reverseGraph = new ArrayList[N+1];
		
		for(int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<>();
			reverseGraph[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			
			graph[start].add(new Node(end, time));
			reverseGraph[end].add(new Node(start, time));
		}
		
		int[] distFromX = dij1(X);
		int[] distToX = dij2(X);
				
		int maxDist = 0;
		for(int i = 0; i <= N; i++) {
			if(i == X) continue;
			
			if(distFromX[i] != INF && distToX[i] != INF) { // 갈 수 있을때만 계산하기
			
			maxDist = Math.max(maxDist, distFromX[i] + distToX[i]);
			}
		}
		
		System.out.println(maxDist);
	}
	
	static int[] dij1(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.time - o2.time);
		
		dist = new int[N+1];
		Arrays.fill(dist, INF);
		dist[start] = 0;
		
		pq.offer(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(cur.time > dist[cur.to]) continue;
			
			for(Node next : graph[cur.to]) {
				
				int newTime =  dist[cur.to] + next.time;
				
				if(newTime < dist[next.to]) {
					dist[next.to] = newTime;
					pq.add(new Node(next.to, newTime));

				}
				
			}
		}
		return dist;
	}
	
	static int[] dij2(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.time - o2.time);
		
		dist = new int[N+1];
		Arrays.fill(dist, INF);
		dist[start] = 0;
		
		pq.offer(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(cur.time > dist[cur.to]) continue;
			
			for(Node next : reverseGraph[cur.to]) {
				
				int newTime =  dist[cur.to] + next.time;
				
				if(newTime < dist[next.to]) {
					dist[next.to] = newTime;
					pq.add(new Node(next.to, newTime));

				}
				
			}
		}
		return dist;
	}

	static class Node{
		int to;
		int time;
		
		public Node(int to, int time) {
			super();
			this.to = to;
			this.time = time;
		}
	}
}

