import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String S = br.readLine();
		
//		char[] arr = new char[26];
		int[] arr = new int[26];
		
		Arrays.fill(arr,-1);
		
		for(int i = 0; i < S.length(); i++) {
			
			S.charAt(i);
			
			if(arr[S.charAt(i) - 'a'] == -1) {
				// b문자 그대로-> a를 뺴주고 -> arr의 인덱스 순서 -> 숫자  -> arr[1] == -1 ?
				arr[S.charAt(i) - 'a'] = i;
			}
			
			
		}
		
		for(int i = 0 ; i < arr.length; i++) {
			System.out.print(arr[i] + " ");

		}
		
	}

}
