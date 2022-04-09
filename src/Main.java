import java.text.ParseException;
import java.util.*;

public class Main {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    private static void dfs(int r, int c, int[][] board){
        if (r==6 && c==6){
            System.out.println("I arrived!");
            return;
        } else {
            for (int i=0;i<4;i++){
                int nr = r + dr[i];
                int nc = c + dc[i];

                // 범위 벗어나는것 체크
                if(nr < 0 || nr >= board.length || nc < 0 || nc > board[0].length){
                    continue;
                }

                // visited 체크
                if(board[nr][nc] == 1){
                    continue;
                }

                board[nr][nc] = 1;
                dfs(nr, nc, board);

                // 탐색이 끝나면 다시 visited 된 곳을 풀어준다
                board[nr][nc] = 0;
            }
        }
    }

    public static void main(String[] args) throws ParseException {

        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(3);
        ts.add(1);
        ts.add(5);
        ts.add(4);

        System.out.println(ts.first());
        System.out.println(ts.last());

        Map<String, String> t = new HashMap<>();

    }


}



