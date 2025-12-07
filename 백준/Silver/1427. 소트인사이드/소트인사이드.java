import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	static int N;
	static ArrayList<Integer> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		list = new ArrayList<>();
		
		while(N>0) {
			
			int tmp = N % 10;
			N /= 10;
			
//			System.out.println(tmp);	
			
			list.add(tmp);
			
		}
		
		
		Collections.sort(list, Collections.reverseOrder());
		
		for(int a : list) {
			sb.append(a);
		}
		
		System.out.println(sb);

	}

}
