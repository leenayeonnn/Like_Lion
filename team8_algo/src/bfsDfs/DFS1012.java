package bfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DFS1012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= count; i++) {
            boolean[][] board = makeBoard(br);
            int solution = findSolutionWithDfs(board);
            sb.append(solution).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static boolean[][] makeBoard(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int col = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());

        boolean[][] board = new boolean[row][col];

        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            board[y][x] = true;
        }

        return board;
    }

    private static int findSolutionWithDfs(boolean[][] board) {
        int solution = 0;

        // 모든 칸을 확인해서 배추 있는 곳에서 dfs 호출
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[0].length; x++) {
                if (board[y][x]) {
                    dfs(board, x, y);
                    solution++;
                }
            }
        }

        return solution;
    }

    private static void dfs(boolean[][] board, int x, int y) {
        // 탐색 순서 : 우 -> 좌 -> 하 -> 상
        int[] moveX = {1, -1, 0, 0};
        int[] moveY = {0, 0, 1, -1};

        // 방문 배열을 만들지 않고
        // false로 값을 바꿔 방문 처리
        board[y][x] = false;

        for (int i = 0; i < 4; i++) {
            // 확인할 표인트 지정
            int newX = x + moveX[i];
            int newY = y + moveY[i];

            // 유효한 board 범위의 포인트 일시
            if (newX >= 0 && newX < board[0].length && newY >= 0 && newY < board.length) {
                // 해당 포인트에 배추가 있는가
                if (board[newY][newX]) {
                    // 있으면 dfs 호출
                    dfs(board, newX, newY);
                }
            }
        }
    }
}