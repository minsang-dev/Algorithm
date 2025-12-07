import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int N, k;
//	static int[] arr;
	static ArrayList<Integer> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
//		arr = new int[N];
//		
//		st = new StringTokenizer(br.readLine());
//		for(int i = 0; i < N; i++) {
//			arr[i] = Integer.parseInt(st.nextToken());
//			
//		}
//		
//		Arrays.sort(arr);
//
//		// 잘 정렬되었나 확인
////		System.out.println(Arrays.toString(arr)); 
//		
////		for(int i = N-1; i >= 0; i--) {
////			System.out.print(arr[i] + " ");
////		}
//		
//		System.out.println(arr[N-k]);
//		
//	}
		list = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		
		Collections.sort(list, Collections.reverseOrder());
		
//		for(int i = 0; i < N; i++) {
//			System.out.print(list.get(i) + " ");
//		}
		
//		System.out.println(list);
		
		System.out.println(list.get(k-1));
	}

}
