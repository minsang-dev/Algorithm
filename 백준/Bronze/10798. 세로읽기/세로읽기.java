import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static char[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		arr = new char[5][15];
		
		// 다섯줄 입력
		for(int i = 0; i < 5; i++) {
			String line = br.readLine();
			
			// 길이만큼 -> 글자 쪼개기
			for(int j = 0; j < line.length(); j++) {
				arr[i][j] = line.charAt(j);
//				System.out.println(j);
				
			}
			
		}
		
		// 세로로 읽은 순서대로 글자 출력
		for(int j = 0; j < 15; j++) {
			for(int i = 0; i < 5; i++) {
				// 공백이 아니라면
				if(arr[i][j] != '\0') {
					sb.append(arr[i][j]);
				}
			}
		}
		System.out.println(sb);
		
	}

}
