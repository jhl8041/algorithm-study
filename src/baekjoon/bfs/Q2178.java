package baekjoon.bfs;

import java.util.*;

// 미로탐색
public class Q2178 {

    class Point {
        int r;
        int c;

        public Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};
    int[][] dist;

    private void bfs(int r, int c, int[][] numMap){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(r,c));
        numMap[r][c] = 0;

        while(!q.isEmpty()){
            Point p = q.poll();
            for (int i=0; i<4; i++){
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];

                if (nr < 0 || nr >= numMap.length || nc < 0 || nc >= numMap[0].length) {
                    continue;
                }

                if (numMap[nr][nc] == 0){
                    continue;
                }

                numMap[nr][nc] = 0;
                q.add(new Point(nr,nc));
                dist[nr][nc] = dist[p.r][p.c] + 1;
            }

        }
    }

    public int solution(int n , int m, String[] map){
        dist = new int[map.length][map[0].length()];
        dist[0][0] = 1;
        int[][] numMap = new int[map.length][map[0].length()];

        for (int i=0; i<map.length; i++){
            String row = map[i];
            char[] chArray = row.toCharArray();
            for (int j=0; j<map[0].length(); j++){
                numMap[i][j] = Integer.parseInt(String.valueOf(chArray[j]));
            }
        }

//        for (int i=0; i<numMap.length; i++){
//            System.out.println(Arrays.toString(numMap[i]));
//        }

        bfs(0,0, numMap);

//        System.out.println("=================");
//        for (int i=0; i<numMap.length; i++){
//            System.out.println(Arrays.toString(dist[i]));
//        }

        return dist[n-1][m-1];
    }


    public static void main(String[] args){
        Q2178 T = new Q2178();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        String[] map = new String[n];
        for (int i=0; i<n; i++){
            map[i] = kb.next();
        }

        System.out.println(T.solution(n, m, map));
    }
}
