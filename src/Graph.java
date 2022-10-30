import java.util.*;
class Graph {
    private int V;
    private ArrayList<Integer> adj[];
    private int m = 2;
    public HashMap<Integer, Integer> ras = new HashMap<>();

    Graph(int v) {
        V = v;
        adj = new ArrayList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new ArrayList();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }


    void BFS(int s) {

        boolean visited[] = new boolean[V];

        ArrayList<Integer> queue = new ArrayList();

        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            s = queue.get(0);
            queue.remove(0);
            System.out.print(s + " ");

            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                    ras.put(1, 0);
                    ras.put(m, n);
                    m++;
                }
            }
        }
    }
}



