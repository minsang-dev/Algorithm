import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;


class Main{
    static int N;
    public static void main(String[] args) throws IOException{
        // 출력 = 가장 작은 수, 값을 배열에서 제거 --> 큐
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        // 같은 수 -> 단순 비교, 다른 수 -> 절댓값 비교
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) ->
        Math.abs(o1) == Math.abs(o2) ? Integer.compare(o1, o2) : Integer.compare(Math.abs(o1), Math.abs(o2))
        );

        // 한 줄에 정수 하나만 입력된 경우라 st.nextToken이 아닌 br.readLine을 썼음
        for(int i = 0; i < N; i++){
            int x = Integer.parseInt(br.readLine());

            if(x == 0){
                if(!pq.isEmpty()){
                    // 출력
                    System.out.println(pq.poll());
                } else {
                    System.out.println(0);
                }
            }else {
                pq.offer(x);
            }
        }
    }
}