package Graph;

import java.util.ArrayList;

public class Graph {
    private int n;
    private ArrayList<Integer>[] graph;                     /* Example: 0 --- 1 <--- 2
                                                                              |      |
                                                                              |      |
                                                                              3 ---> 4
                                                                                         */
    Graph(int n){
        this.n = n;
    }

    void addEdge(){
        graph[0].add(1);
        graph[1].add(0);
        graph[1].add(3);
        graph[2].add(1);
        graph[2].add(4);
        graph[3].add(1);
        graph[3].add(4);
        graph[4].add(2);
    }

    public static void main(String[] args){
        Graph graph = new Graph(5);
        graph.addEdge();
        System.out.println(graph);
    }
}
