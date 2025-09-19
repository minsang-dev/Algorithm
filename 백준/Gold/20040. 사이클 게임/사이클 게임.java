import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    /*
     * 유니온 파인드 ,,? -> 사이클을 완성하는 순간 게임 종료
     * 부모가 같으면 사이클이 만들어짐
     * 
     * 출력해야할 것 : 사이클이 처음으로 만들어진 차례의 번호
     */
    static int n, m;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(find(a) == find(b)){
                System.out.println(i+1);
                return;
            } else {
                union(a, b);
            }
        }
        System.out.println(0);
    }

    static int find(int a){
        if(a == parent[a]){ // 루트가 자기 자신인 경우
            return a; // 자기 자신 반환
        } else {
            return parent[a] = find(parent[a]);
        }
    }

    static void union(int a, int b){
        a = find(a);
        b = find(b);

        if (a == b) return; // 이미 같은 그룹이면 종료
        
        if(a < b){
            parent[b] = a; // a가 b보다 작은 경우, b의 부모는 a
        } else {
            parent[a] = b;
        }
    }
}