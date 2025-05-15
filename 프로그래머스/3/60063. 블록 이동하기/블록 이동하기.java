import java.util.*;

class Solution {
    
    public int solution(int[][] board) {
        return bfs(board);
    }
    
    private int bfs(int[][] board) {
        int boardSize = board.length;
        Queue<Robot> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[boardSize][boardSize][2];

        int[] dRow = {0, 0, 1, -1};
        int[] dCol = {1, -1, 0, 0};

        queue.add(new Robot(new Position(0, 0), new Position(0, 1), 0, 0));

        while (!queue.isEmpty()) {
            Robot current = queue.poll();

            if (isOutOfBounds(current.pos1, boardSize) || isOutOfBounds(current.pos2, boardSize)) continue;
            if (board[current.pos1.row][current.pos1.col] == 1 || board[current.pos2.row][current.pos2.col] == 1) continue;
            if (visited[current.pos1.row][current.pos1.col][current.orientation] &&
                visited[current.pos2.row][current.pos2.col][current.orientation]) continue;

            if ((current.pos1.row == boardSize - 1 && current.pos1.col == boardSize - 1) ||
                (current.pos2.row == boardSize - 1 && current.pos2.col == boardSize - 1)) {
                return current.time;
            }

            visited[current.pos1.row][current.pos1.col][current.orientation] = true;
            visited[current.pos2.row][current.pos2.col][current.orientation] = true;

            // 네 방향 이동
            for (int i = 0; i < 4; i++) {
                int newRow1 = current.pos1.row + dRow[i];
                int newCol1 = current.pos1.col + dCol[i];
                int newRow2 = current.pos2.row + dRow[i];
                int newCol2 = current.pos2.col + dCol[i];
                queue.add(new Robot(new Position(newRow1, newCol1), new Position(newRow2, newCol2), current.time + 1, current.orientation));
            }

            // 회전 시도
            if (current.orientation == 1) { // 수직 -> 수평
                if (current.pos1.col - 1 >= 0 &&
                    board[current.pos1.row][current.pos1.col - 1] == 0 &&
                    board[current.pos2.row][current.pos2.col - 1] == 0) {

                    queue.add(new Robot(new Position(current.pos1.row, current.pos1.col), new Position(current.pos1.row, current.pos2.col - 1), current.time + 1, 0));
                    queue.add(new Robot(new Position(current.pos2.row, current.pos1.col - 1), new Position(current.pos2.row, current.pos2.col), current.time + 1, 0));
                }

                if (current.pos1.col + 1 < boardSize &&
                    board[current.pos1.row][current.pos1.col + 1] == 0 &&
                    board[current.pos2.row][current.pos2.col + 1] == 0) {

                    queue.add(new Robot(new Position(current.pos1.row, current.pos1.col), new Position(current.pos1.row, current.pos2.col + 1), current.time + 1, 0));
                    queue.add(new Robot(new Position(current.pos2.row, current.pos1.col + 1), new Position(current.pos2.row, current.pos2.col), current.time + 1, 0));
                }
            } else { // 수평 -> 수직
                if (current.pos1.row - 1 >= 0 &&
                    board[current.pos1.row - 1][current.pos1.col] == 0 &&
                    board[current.pos2.row - 1][current.pos2.col] == 0) {

                    queue.add(new Robot(new Position(current.pos1.row - 1, current.pos2.col), new Position(current.pos2.row, current.pos2.col), current.time + 1, 1));
                    queue.add(new Robot(new Position(current.pos1.row, current.pos1.col), new Position(current.pos2.row - 1, current.pos1.col), current.time + 1, 1));
                }

                if (current.pos1.row + 1 < boardSize &&
                    board[current.pos1.row + 1][current.pos1.col] == 0 &&
                    board[current.pos2.row + 1][current.pos2.col] == 0) {

                    queue.add(new Robot(new Position(current.pos1.row + 1, current.pos2.col), new Position(current.pos2.row, current.pos2.col), current.time + 1, 1));
                    queue.add(new Robot(new Position(current.pos1.row, current.pos1.col), new Position(current.pos2.row + 1, current.pos1.col), current.time + 1, 1));
                }
            }
        }

        return 0;
    }

    private boolean isOutOfBounds(Position pos, int size) {
        return pos.row < 0 || pos.col < 0 || pos.row >= size || pos.col >= size;
    }

    class Robot {
        Position pos1;
        Position pos2;
        int time;
        int orientation; // 0: horizontal, 1: vertical

        Robot(Position pos1, Position pos2, int time, int orientation) {
            this.pos1 = pos1;
            this.pos2 = pos2;
            this.time = time;
            this.orientation = orientation;
        }
    }

    class Position {
        int row, col;

        Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
