import Leetcode.Easy200.L23;

import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode Amazon OA Demolition of Robot
 *
 * https://leetcode.com/discuss/interview-question/1257344/amazon-oa-demolition-of-robot
 */
public class 客户OA {

    public static int bfs(int[][] grid) {
        //bfs, 路径存在path 频繁操作：1. 加到结尾  2. 删除头部  所以使用 linkedlist
        Queue<int[]> path = new LinkedList<>();
        //todo 极度注意direction 不能搞错 不然超长时间debug
        int[][] directions = new int[][] {{0,1}, {1,0}, {0,-1}, {-1, 0}};
        boolean[][] visisted = new boolean[grid.length][grid[0].length];
        //删除头部 https://www.geeksforgeeks.org/linkedlist-remove-method-in-java/

        path.add(new int[]{0,0});
        visisted[0][0] = true;

        int minCost = Integer.MAX_VALUE;

        while (!path.isEmpty()) {
            int[] cur = path.remove();

            for (int[] direct : directions) {
                int nextX = cur[0] + direct[0];
                int nextY = cur[1] + direct[1];

                //boundary of the 迷宫check
                if (nextX < 0 || nextY < 0 || nextX >= grid.length || nextY >= grid[0].length)
                    continue;

                //arrive destination
                if (grid[nextX][nextY] == 9) {
                   // minCost = Math.min(minCost, grid[nextX][nextY]); 原本别人的解答 不懂为什么不对
                    return grid[cur[0]][cur[1]];//todo 下面别人指出他的错误 改了就对了 //注意 cost + 1 是建立在原来grid 上 而能走的grid 是 1 ！！！ 1 +1 = 2
                    //todo 所以事实上 应该是 grid[cur[0]][cur[1]] + 1 - 1  ！！！！   第一个加 1 是指到下一步 剪1 是去掉原来的grid的1
                }


                if (!visisted[nextX][nextY] && grid[nextX][nextY] != 0) {
                    visisted[nextX][nextY] = true;
                    grid[nextX][nextY] = grid[cur[0]][cur[1]] + 1;
                    path.add(new int[]{nextX, nextY});
                }
            }
        }

        return -1;//can not find such path to reach destination
    }

    public static void main(String[] args) {
        /**
         * 构建 3 * 3 迷宫
         *
         * 凡事 1 的都不能走
         *
         * 0 的可以走
         *
         * 目的地 9
         *
         * 找最短路径
         */
        int[][] grid  = new int[3][3];
        for (int i = 0; i < grid.length; i++) {
            grid[i][0] = 1;
        }



        grid[2][1] = 1;
        grid[2][2] = 1;

        grid[0][2] = 9;
        grid[1][2] = 1;

        System.out.println(bfs(grid)); //expect 6  but get -1
    }

    //todo approach two DFS 版本


}
