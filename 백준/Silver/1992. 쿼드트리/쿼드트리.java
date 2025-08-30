import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    static int N;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for(int i = 0; i < N; i++){
            String line = br.readLine();

            for(int j = 0; j < N; j++){
                map[i][j] = line.charAt(j) - '0';
            }
        }

        divideAndConquer(0, 0, N);
        System.out.println();
    }

    static void divideAndConquer(int x, int y, int size){
        if(isSameValue(x, y, size)){
            System.out.print(map[x][y]);
            return;
        }

        int halfSize = size / 2;

        System.out.print("(");
        divideAndConquer(x, y, halfSize);
        divideAndConquer(x, y + halfSize, halfSize);
        divideAndConquer(x + halfSize, y, halfSize);
        divideAndConquer(x + halfSize, y + halfSize, halfSize);
        System.out.print(")");
    }

    static boolean isSameValue(int x, int y, int size) {
        int value = map[x][y];

        for(int i = x; i < x + size; i++){
            for(int j = y; j < y + size; j++){
                if(map[i][j] != value){
                    return false;
                }
            }
        }

        return true;
    }
}