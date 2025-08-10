import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    static int N;
    static int[][] tree;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        tree = new int[26][2];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int root = (int)st.nextToken().charAt(0) - 'A';
            char leftChar = st.nextToken().charAt(0);
            char rightChar = st.nextToken().charAt(0);

            int left;
            if(leftChar == '.'){
                left = -1;
            } else {
                left = leftChar - 'A';
            }

            int right;
            if(rightChar == '.'){
                right = -1;
            } else {
                right = rightChar - 'A';
            }

            
            tree[root][0] = left;
            tree[root][1] = right;
        }

        preOrder(0);
        System.out.println();

        inOrder(0);
        System.out.println();

        postOrder(0);
        System.out.println();
    }

    public static void preOrder(int c){
        if(c == -1){
            return;
        }
        System.out.print((char)(c+'A'));
        preOrder(tree[c][0]);
        preOrder(tree[c][1]);
    }

    public static void inOrder(int c){
        if(c == -1){
            return;
        }
        inOrder(tree[c][0]);
        System.out.print((char)(c+'A'));
        inOrder(tree[c][1]);
    }

    public static void postOrder(int c){
        if(c == -1){
            return;
        }
        postOrder(tree[c][0]);
        postOrder(tree[c][1]);
        System.out.print((char)(c+'A'));
    }
}