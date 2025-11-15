import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int Y = Integer.parseInt(br.readLine());

        if(Y % 4 == 0){
            if(Y % 400 == 0){
                System.out.println("1");
            } else if(Y % 100 == 0){
                System.out.println("0");
            } else {
                System.out.println("1");
            }
            
        } else {
            System.out.println("0");
        }
    }
}