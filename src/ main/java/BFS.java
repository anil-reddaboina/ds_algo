import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    static class Graph{
        int vertices;
        LinkedList<Integer>[] adjList;

        Graph(int vertices){
            this.vertices = vertices;
            adjList = new LinkedList[vertices];
            for (int i = 0; i <vertices ; i++) {
                adjList[i] = new LinkedList<>();
            }
        }
        public void addEdge(int source, int destination){
            adjList[source].addFirst(destination);
        }

        public void BFS(int startVertex) {
            boolean[] visited = new boolean[vertices];
            Queue<Integer> s = new LinkedList<>();

            s.add(startVertex);
            while (!s.isEmpty()) {
                int n = s.remove();
                System.out.print(" " + n);
                visited[n] = true;
                for (int i = 0; i <adjList[n].size() ; i++) {
                    int neighbor = adjList[n].get(i);
                    if(!visited[neighbor]){
                        s.add(neighbor);
                        visited[neighbor] = true;
                    }
                }
            }
        }
    }
    public static void main(String args[]) {
        Graph g = new Graph(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(3, 4);
        g.addEdge(2, 3);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(4, 5);
        g.BFS(0);
    }
}
