import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());

        int z = b % 10;
        int x = (b/10) % 10;
        int y = (b/10) / 10 % 10;

        System.out.println(z * a);
        System.out.println(x * a);
        System.out.println(y * a);
        System.out.println(a*b);

    }
}