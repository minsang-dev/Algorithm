import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		String line;
		int answer = 0;
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 중복 x
		HashSet<String> set = new HashSet<>();
		// list에 담아서 사전 순으로 출력
		List<String> list = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			line = br.readLine();
			set.add(line);
		}
		
		for(int i = 0; i < M; i++) {
			line = br.readLine();
			
			if(set.contains(line)) {
				answer++;
				list.add(line);
			}
		}
		
		System.out.println(answer);
		
		Collections.sort(list);
		for(String s : list) {
			System.out.println(s);
		}
	}

}
