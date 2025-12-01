import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());

		// 1. 배열을 통째로 받아서 배열의 합을 구하는 방식
		// 2. 문자열로 받아서, 쪼개서 하나씩 더해주는 방식
		
		// 1번 방식
		String line = br.readLine(); // 문자열 한 줄 입력받기 12345
				
		// 출력값을 뽑아내기 위한 처리
//		char[] arr = line.toCharArray(); // 한줄로 입력받은 문자열을 쪼개기
//		
////		System.out.println(Arrays.toString(arr));
//		// 출력값 : [7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
//		
//		int sum = 0;
//		
//		for(char a : arr) {
//			
////			System.out.print(a + " ");
//			
//			sum += a - '0';
//			
//		}
//				
//		System.out.println(sum);
		
		
		// 2번 방식
		int sum = 0;
		
		for(int i = 0; i < line.length(); i++) {
			
			sum += line.charAt(i) - '0';
		}
		
		System.out.println(sum);
		
	}

}
