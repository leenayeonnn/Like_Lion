package bfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BFS1012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= count; i++) {
            boolean[][] board = makeBoard(br);
            int solution = findSolutionWithBfs(board);
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

    private static int findSolutionWithBfs(boolean[][] board) {
        int solution = 0;

        // 모든 칸을 확인해서 배추 있는 곳에서 bfs 호출
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[0].length; x++) {
                if (board[y][x]) {
                    bfs(board, x, y);
                    solution++;
                }
            }
        }

        return solution;
    }

    private static void bfs(boolean[][] board, int x, int y) {
        // 탐색 순서 : 우 -> 좌 -> 하 -> 상
        int[] moveX = {1, -1, 0, 0};
        int[] moveY = {0, 0, 1, -1};

        // 디큐 생성
        Deque<int[]> deque = new ArrayDeque<>();

        // 첫 위치 삽입
        deque.add(new int[]{x, y});
        board[y][x] = false;

        // 큐가 빌 때까지 수행
        while (!deque.isEmpty()) {
            // 큐의 맨 앞에 있는 위치 정보 가져오기
            int[] point = deque.poll();
            x = point[0];
            y = point[1];

            // 인접한 모든 위치에 대해서
            for (int i = 0; i < 4; i++) {
                int newX = x + moveX[i];
                int newY = y + moveY[i];

                if (newX >= 0 && newX < board[0].length && newY >= 0 && newY < board.length) {
                    // 배추가 있으면 삽입
                    if (board[newY][newX]) {
                        deque.add(new int[]{newX, newY});

                        // 방문 처리
                        board[newY][newX] = false;
                    }
                }
            }
        }
    }
}