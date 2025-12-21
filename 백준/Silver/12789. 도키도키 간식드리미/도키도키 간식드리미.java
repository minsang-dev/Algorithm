import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		// 임시 공간에 저장해 놓을 flag 선언
		boolean[] flag = new boolean[N+1];
		
		// stack과 동일 역할을 하는 deque 사용
		Deque<Integer> s1 = new ArrayDeque<>();
		Deque<Integer> s2 = new ArrayDeque<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int t = Integer.parseInt(st.nextToken());
			s1.addLast(t);
		}
		
		boolean success = true;
		for(int next = 1; next <= N; next++) {
			if(!flag[next]) {
				while(s1.peekFirst() != next) {
					int temp = s1.pollFirst();
					s2.addFirst(temp);
					flag[temp] = true;
				}
				
				s1.pollFirst();
			}
			else {
				if(s2.peekFirst() != next) {
					success = false;
					break;
				}
				
				s2.pollFirst();
			}
		}
		
		if(success) {
			System.out.println("Nice");
		} else {
			System.out.println("Sad");
		}
		

	}

}
