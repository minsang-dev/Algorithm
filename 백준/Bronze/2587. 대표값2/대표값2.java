import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	static ArrayList<Integer> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		list = new ArrayList<>();
		
		int sum = 0;
		
		for(int i = 0; i < 5; i++) {
			list.add(Integer.parseInt(br.readLine()));
			
			sum += list.get(i);
		}
		
		int avg = sum / 5;
		
		Collections.sort(list);
		
		System.out.println(avg);
		System.out.println(list.get(2));
		
	}
	
}