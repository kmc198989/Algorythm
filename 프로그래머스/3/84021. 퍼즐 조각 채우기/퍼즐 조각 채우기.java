import java.util.*;

public class Solution {
    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};

    public int solution(int[][] game_board, int[][] table) {
        List<List<int[]>> boardSpaces = extractSpaces(game_board, 0);
        List<List<int[]>> tableBlocks = extractSpaces(table, 1);

        List<List<int[]>>[] rotatedBlocks = new List[4];
        rotatedBlocks[0] = tableBlocks;
        for (int i = 1; i < 4; i++) {
            rotatedBlocks[i] = rotateBlocks(rotatedBlocks[i - 1]);
        }

        int totalFilled = 0;
        boolean[] used = new boolean[tableBlocks.size()];

        for (List<int[]> space : boardSpaces) {
            boolean filled = false;
            for (int i = 0; i < 4 && !filled; i++) {
                for (int j = 0; j < tableBlocks.size(); j++) {
                    if (!used[j] && fit(space, rotatedBlocks[i].get(j))) {
                        totalFilled += space.size();
                        used[j] = true;
                        filled = true;
                        break;
                    }
                }
            }
        }

        return totalFilled;
    }

    private List<List<int[]>> extractSpaces(int[][] board, int targetValue) {
        int n = board.length;
        boolean[][] visited = new boolean[n][n];
        List<List<int[]>> spaces = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && board[i][j] == targetValue) {
                    List<int[]> space = bfs(board, visited, i, j, targetValue);
                    spaces.add(space);
                }
            }
        }

        return spaces;
    }

    private List<int[]> bfs(int[][] board, boolean[][] visited, int x, int y, int targetValue) {
        int n = board.length;
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> space = new ArrayList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            space.add(point);

            for (int d = 0; d < 4; d++) {
                int nx = point[0] + dx[d];
                int ny = point[1] + dy[d];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny] && board[nx][ny] == targetValue) {
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }

        return normalize(space);
    }

    private List<int[]> normalize(List<int[]> space) {
        space.sort((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        int minX = space.get(0)[0];
        int minY = space.get(0)[1];

        for (int[] coord : space) {
            coord[0] -= minX;
            coord[1] -= minY;
        }

        return space;
    }

    private List<List<int[]>> rotateBlocks(List<List<int[]>> blocks) {
        List<List<int[]>> rotatedBlocks = new ArrayList<>();
        for (List<int[]> block : blocks) {
            List<int[]> rotatedBlock = new ArrayList<>();
            for (int[] coord : block) {
                rotatedBlock.add(new int[]{coord[1], -coord[0]});
            }
            rotatedBlocks.add(normalize(rotatedBlock));
        }
        return rotatedBlocks;
    }

    private boolean fit(List<int[]> space, List<int[]> block) {
        if (space.size() != block.size()) return false;

        for (int i = 0; i < space.size(); i++) {
            if (space.get(i)[0] != block.get(i)[0] || space.get(i)[1] != block.get(i)[1]) {
                return false;
            }
        }

        return true;
    }
}