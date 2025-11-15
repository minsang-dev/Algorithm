import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int S = Integer.parseInt(br.readLine());

        if(S >= 90 && S <= 100){
            System.out.println("A");
        } else if ( S >= 80 && S <= 89){
            System.out.println("B");
        } else if ( S >= 70 && S <=  79){
            System.out.println("C");
        } else if ( S >= 60 && S <= 69){
            System.out.println("D");
        } else {
            System.out.println("F");
        }

    }
}