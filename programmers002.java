package algorithm;
import java.util.*;



public class programmers002 {



    public static void main(String[] args) {

        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};

        //방문
        // queue
        int answer = 0;
        int[][] visited = new int[505][505];

        visited[0][0] = triangle[0][0];

        for (int y = 0 ; y < triangle.length-1 ; y++) {
            for(int x= 0; x <triangle[y].length; x++) {


                if (visited[y + 1][x] < triangle[y + 1][x] + visited[y][x]) {
                    visited[y+1][x] = triangle[y + 1][x] + visited[y][x];
                }
                if (visited[y + 1][x+1] < triangle[y + 1][x+1] + visited[y][x]) {
                    visited[y+1][x+1] = triangle[y + 1][x+1] + visited[y][x];
                }
            }
        }

        for (int n : visited[triangle.length - 1]) {
            answer = Math.max(answer,n);
        }

        System.out.println("answer = " + answer);
    }//main()


    }

