import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	static int N;
	static int[] arr;
	// 메모리 초과 ---> arrays.sort
	// 이번엔 list -> collection.sort 로 안통하다니 ..

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());

		arr = new int[N];
		
		for(int i =0 ; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);;
		
		for(int i = 0; i < N; i++) {
			sb.append(arr[i]).append("\n");
		}
		
		System.out.println(sb);
	}

}
