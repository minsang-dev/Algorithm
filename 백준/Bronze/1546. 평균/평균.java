import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        double[] scores = new double[N];

        double max = 0;
        
        double sum = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            scores[i] = Double.parseDouble(st.nextToken());

            if(scores[i] > max){
                max = scores[i];
            }
        }

        for(int i = 0; i < N; i++){
            sum += ((scores[i]/ max) * 100);
        }

        System.out.println(sum/N);
    }
}