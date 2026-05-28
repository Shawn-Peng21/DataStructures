package Graph;

import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

public class BFS {
    static void bfs(ArrayList<Integer>[] graph, int start) {

        boolean[] visited = new boolean[graph.length];

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);

        visited[start] = true;

        while (!queue.isEmpty()) {

            int node = queue.poll();

            System.out.println(node);

            for (int neighbor : graph[node]) {

                if (!visited[neighbor]) {

                    visited[neighbor] = true;

                    queue.offer(neighbor);

                }

            }

        }

    }
}
