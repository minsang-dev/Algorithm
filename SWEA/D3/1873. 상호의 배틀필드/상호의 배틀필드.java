import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

class Solution {
    static int T;
    static int H, W;
    static char[][] map;
    static int x, y, dir; // 전차의 위치(x,y,방향)
    // 사방탐색 (동 남 서 북 순으로)
    static int[]dx = {-1, 1, 0, 0};
    static int[]dy = {0, 0, -1, 1};
    static char[] dirs = {'^', 'v', '<', '>'};
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        
        // 게임 맵의 크기 (H x W) 입력받기
        for(int tc=1; tc <= T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            // 변수 초기화 (for문 안에서.)
            map = new char[H][W];

            // 게임 맵의 구성 요소 조건문 달아주기
            for(int i= 0; i < H; i++){
                String str = br.readLine();
                
                for(int j = 0 ; j < W; j++){
                    map[i][j] = str.charAt(j);

                        if(map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>'){
                            // 시작 위치 지정
                            x = i;
                            y = j;
                        }
                    }
                }
                
                // 사용자로부터 문자 입력 받기
                int inPut = Integer.parseInt(br.readLine());
                String str = br.readLine();
                
                // 사용자가 넣을 입력 개수에 따라 정수가 주어짐
                for(int i = 0; i < inPut; i++){
                    char command = str.charAt(i);

                    // 문자 동작 케이스 분류
                    switch (command) {
                        case 'S':
                            shoot();
                            break;
                        case 'U':
                                go(0);
                                break;
                        case 'D':
                                go(1);
                                break;
                        case 'L':
                                go(2);
                                break;
                        case 'R':
                                go(3);
                                break;
            }

        }
        System.out.print("#" + tc + " ");
        for(int i = 0; i < H; i++) {
            for(int j = 0; j < W; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}
    // dir 메서드 추출 (dir 배열 순서에 따라 return 값)
    static int getDir(){
        if(map[x][y] == '^'){
            return 0;
        }
        else if(map[x][y] == 'v'){
            return 1;
        }
        else if(map[x][y] == '<'){
            return 2;
        }
        else if(map[x][y] == '>'){
            return 3;
        }

        // 그렇지 않은 경우 -1로 반환
        return -1;
    }

    // shoot 메서드 추출
    static void shoot(){
        // 현재 전차 위치와 방향
        int r = x;
        int c = y;
        int dir = getDir();

        while (true) {
            r += dx[dir];
            c += dy[dir];

            // 게임 맵 범위 선정
            if(r < 0 || r >=H || c < 0 || c >=W){
                break;
            }

            // 벽돌벽 만나면 (*) -> 파괴(.)
            if(map[r][c] == '*'){
                map[r][c] = '.';
                break;
            }

            // 강철벽 만나면 (#) -> 아무일도 X
            else if(map[r][c] == '#'){
                break;
            }
        }
    }

    // go 메서드 추출
    static void go(int dir){
        map[x][y] = dirs[dir];

        // 이동하려는 위치
        int r = x + dx[dir];
        int c = y + dy[dir];

        // 맵 범위 & 평지일 경우
        if(r >= 0 && r < H && c >=0 && c < W && map[r][c] =='.'){

            // 현재 위치를 평지로-
            map[x][y] = '.';

            // 전차 위치와 방향 -> 갱신
            x = r;
            y = c;
            map[x][y] = dirs[dir];

        }
    }
}