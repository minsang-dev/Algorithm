import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{
    static int T;
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0};
    static char[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
            char[] arr = br.readLine().toCharArray();

            int dir = 0;
            int x = 0, y = 0;
            int minX = 0, maxX = 0, minY = 0, maxY = 0;

            for(char c : arr){
                if(c == 'F'){
                    x += dx[dir];
                    y += dy[dir];
                } else if (c == 'B'){
                    x -= dx[dir];
                    y -= dy[dir];
                } else if (c == 'L'){
                    dir = (dir + 3) % 4;
                } else if (c == 'R'){
                    dir = (dir + 1) % 4;
                }

                minX = Math.min(minX, x);
                maxX = Math.max(maxX, x);
                minY = Math.min(minY, y);
                maxY = Math.max(maxY, y);
            }

            int area = (maxX - minX) * (maxY - minY);
            System.out.println(area);
        }
    }

}