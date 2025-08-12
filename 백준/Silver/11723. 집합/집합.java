import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

class Main{
    static int M;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());

        // 특정 값 존재 여부 확인 -> HashSet
        HashSet<Integer> set = new LinkedHashSet<>();

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            int x = 0;

            if(!str.equals("all") && !str.equals("empty")){
                x = Integer.parseInt(st.nextToken());
            }

            switch(str){
                case "add" :
                set.add(x);
                break;

                case "remove" :
                set.remove(x);
                break;

                case "check" :
                bw.write(set.contains(x) ? ("1\n") : ("0\n"));
                break;

                case "toggle" :
                if(set.contains(x)){
                    set.remove(x);
                }else{
                    set.add(x);
                }
                break;

                case "all" :
                set.clear();
                for(int num = 1; num <=20; num++){
                    set.add(num);
                }
                break;

                case "empty" :
                set.clear();
                break;    
            }
        }
        bw.flush();
    }
}