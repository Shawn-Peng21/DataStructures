package Graph;

import java.util.ArrayList;

public class DFS {
    static ArrayList<Integer>[] graph;

    static boolean[] visited;

    static void dfs(int node) {

        visited[node] = true;

        System.out.println(node);

        for (int neighbor : graph[node]) {

            if (!visited[neighbor]) {

                dfs(neighbor);

            }

        }

    }

    public static void main(String[] args) {

        int n = 4;

        graph = new ArrayList[n];

        visited = new boolean[n];

        for (int i = 0; i < n; i++) {

            graph[i] = new ArrayList<>();

        }

        graph[0].add(1);

        graph[1].add(0);

        graph[0].add(2);

        graph[2].add(0);

        graph[1].add(3);

        graph[3].add(1);

        dfs(0);

    }
}
