import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    static int N;
    static int[][] paper;
    static int whiteCount = 0;
    static int blueCount = 0;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());

        paper = new int[N][N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++){

                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divideAndConquer(0, 0, N);

        System.out.println(whiteCount);
        System.out.println(blueCount);
    }

    static void divideAndConquer(int x, int y, int size){
        if(isSameColor(x, y, size)){
            if(paper[x][y] == 0){
                whiteCount++;
            } else {
                blueCount++;
            }
            return;
        }

        int halfSize = size / 2;

        divideAndConquer(x, y, halfSize);
        divideAndConquer(x, y + halfSize, halfSize);
        divideAndConquer(x + halfSize, y, halfSize);
        divideAndConquer(x + halfSize, y + halfSize, halfSize);
    }

    static boolean isSameColor(int x, int y, int size){
        int color = paper[x][y];

        for(int i = x; i < x + size; i++){
            for(int j = y; j < y + size; j++){
                if(paper[i][j] != color){
                    return false;
                }
            }
            
        }
        return true;
    }
}