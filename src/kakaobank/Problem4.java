package kakaobank;

import java.util.Arrays;

public class Problem4 {

    static int BminR, BminC, BmaxR, BmaxC;
    static int WminR, WminC, WmaxR, WmaxC;

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    private static void dfs(String searchType, int r, int c, int maxR, int maxC, String[] param, int[][] visited){
        if (r < 0 || r >= maxR || c < 0 || c >= maxC){
            return;
        }

        if (param[r].charAt(c) == (searchType.equals("black")? '.' : 'X')){
            return;
        }

        if (visited[r][c] == 1){
            return;
        }

        visited[r][c] = 1;

        if (searchType.equals("black")){
            BminR = Math.min(BminR, r);
            BminC = Math.min(BminC, c);
            BmaxR = Math.max(BmaxR, r);
            BmaxC = Math.max(BmaxC, c);
        } else {
            WminR = Math.min(WminR, r);
            WminC = Math.min(WminC, c);
            WmaxR = Math.max(WmaxR, r);
            WmaxC = Math.max(WmaxC, c);
        }

        for (int i=0; i<4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];

            dfs(searchType, nr, nc, maxR, maxC, param, visited);
        }
    }



    public static void main(String[] args){
//        String[][] params = {
//                {".....",".XXX.",".X.X.",".XXX.","....."},
//                {"XXXXX","XXXXX","XXX.X","XXX.X","XXXXX"},
//                {"XXXXX","X...X","X.X.X","X...X","XXXXX"},
//                {"....X",".....","XXX..","X.X..","XXX.."},
//                {".......","XXX.XXX","X.X.X.X","XXX.XXX","......."},
//                {"XXXXX","XX.XX","X...X","XX.XX","XXXXX"}
//        };

//        String[][] params = {
//                {"...X..","XXXXX.",".X..X.",".X..XX",".X..X.",".XXXX.","..X..."},
//                {"XX.X","XXXX","X..X","X..X","XXXX"},
//                {"XXXXX","X.X.X","X.X.X","XXXXX"},
//                {"XXXX","X.XX","X..X","XXXX"},
//                {"XXXXXXX","X.....X","X.XXX.X","X.X.X.X","X.XXX.X","X.....X","XXXXXXX"}
//        };

        String[][] params = {{"XXX","X.X","XXX","X.X","XXX"},
                {"....","XX..","XX..","...."},
                {"XXXX","XXXX","XXXX","XXXX"}};



        boolean[] answer = new boolean[params.length];

        Loop1 :
        for (int i=0; i<params.length; i++){

            // 맵 하나씩 꺼내기
            String[] param = params[i];
            int mapNum = i+1;

            // TODO: 출력 제거
            System.out.println("----------------------------------------");
            System.out.println("[Processing Map " + mapNum + "]");
            System.out.println();

            // 검정섬, 하얀섬 min, max xy 초기화
            BminR = BminC = WminR = WminC = Integer.MAX_VALUE;
            BmaxR = BmaxC = WmaxR = WmaxC = 0;

            // row, column 길이 초기화
            int R = param.length;
            int C = param[0].length();

            // 방문 배열
            int[][] visitedBlack = new int[R][C];

            // 검정섬 갯수
            int blackIslandCnt = 0;


            // 1. '검정섬' 카운트 & '검정섬' min, max xy 찾기
            for (int r=0; r<R; r++){
                for (int c=0; c<C; c++){

                    if (param[r].charAt(c) == 'X' && visitedBlack[r][c] == 0) {
                        blackIslandCnt++;
                        // TODO: 출력 제거
                        System.out.println(blackIslandCnt + " Black Island found!! (r: " + r + ", c: " + c + ")");
                        if (blackIslandCnt > 1) {
                            System.out.println("NOT GOOD: More than one black island found");
                            System.out.println();
                            answer[i] = false;
                            continue Loop1;
                        }
                        dfs("black", r, c, R, C, param, visitedBlack);

                        // TODO: 출력 제거
                        for (int[] v : visitedBlack) {
                            System.out.println(Arrays.toString(v));
                        }
                        System.out.println();
                    }

                }
            }

            // 하얀섬 방문 배열 (검정섬 내부)
            int[][] visitedWhite = new int[BmaxR+1][BmaxC+1];

            // 하얀섬 카운트 (검정섬 내부)
            int whiteIslandCnt = 0;

            // 2. '검정섬' 직사각형 확인 & '하얀섬' 카운트 & '하얀섬' min, max xy 찾기
            for (int r=BminR; r<=BmaxR; r++){
                for (int c=BminC; c<=BmaxC; c++){

                    // Max 경계에서 하얀색이 발견된다면 return false
                    if (r == BminR || r == BmaxR || c == BminC || c == BmaxC){
                        if (param[r].charAt(c) == '.'){
                            System.out.println("NOT GOOD: Black Island is not square!");
                            System.out.println();
                            answer[i] = false;
                            continue Loop1;
                        }
                    }

                    if (param[r].charAt(c) == '.' && visitedWhite[r][c] == 0) {
                        whiteIslandCnt++;
                        // TODO: 출력 제거
                        System.out.println(whiteIslandCnt + " White Island found!! (r: " + r + ", c: " + c + ")");
                        if (whiteIslandCnt > 1) {
                            System.out.println("NOT GOOD: More than one white island found!");
                            System.out.println();
                            answer[i] = false;
                            continue Loop1;
                        }
                        dfs("white", r, c, BmaxR+1, BmaxC+1, param, visitedWhite);

                        // TODO: 출력 제거
                        for (int[] v : visitedWhite) {
                            System.out.println(Arrays.toString(v));
                        }
                        System.out.println();
                    }

                }
            }

            // 무조건 내부에 하얀섬이 하나라도 있어야함
            if (whiteIslandCnt == 0){
                answer[i] = false;
                System.out.println("NOT GOOD: no white island found!");
                System.out.println();
                continue Loop1;
            }

            // 3. '하얀섬' 직사각형 확인
            for (int r=WminR; r<=WmaxR; r++){
                for (int c=WminC; c<=WmaxC; c++){

                    // Max 경계에서 '검정색'이 발견된다면 return false
                    if (r == WminR || r == WmaxR || c == WminC || c == WmaxC){
                        if (param[r].charAt(c) == 'X'){
                            System.out.println("NOT GOOD: White island inside is not square!");
                            System.out.println();
                            answer[i] = false;
                            continue Loop1;
                        }
                    }
                }
            }

            answer[i] = true;
        }

        System.out.println(Arrays.toString(answer));

    }

}
