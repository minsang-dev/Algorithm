import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Long n = Long.parseLong(br.readLine());
		
		// 조합
		System.out.println(n*(n-1)*(n-2) / 6);
		System.out.println("3");

	}

}
