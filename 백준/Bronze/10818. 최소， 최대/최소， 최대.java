import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());

		for(int i = 0; i < N; i++) {

			arr[i] = Integer.parseInt(st.nextToken());
			
		}
		
		int max = arr[0];
		int min = arr[0];
		
		for(int i = 0; i < arr.length; i++) {
			
			if(arr[i] < min) {
				min = arr[i];
			}
			
			if(arr[i] > max) {
				max = arr[i];
			}
		}
		System.out.println(min + " " + max);
	}

}
