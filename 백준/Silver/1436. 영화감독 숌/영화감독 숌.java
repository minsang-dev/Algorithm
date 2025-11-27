import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		int number = 666; // 첫번째 숫자
		int cnt = 1;
		
		while(cnt != N) { // cnt가 N이 될때까지 반복
			number++;
			
			// 숫자를 문자열로 변경 => String.valueOf()
			if(String.valueOf(number).contains("666")) {
				cnt++;
			}
		}
		System.out.println(number);
	}

}
