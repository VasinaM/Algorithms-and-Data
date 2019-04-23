import java.util.LinkedList;

public class BreadthFirstPaths {
    private boolean[] marked;
    private  int[] edgeTo; //откуда идем
    private  int[] distTo;  //шаг
    private int source;
    private  int inf = Integer.MAX_VALUE;

    public BreadthFirstPaths(Graph g, int source) {  //int source - с какой вершины будем начинать
        if (source < 0) {
            throw new IllegalArgumentException();
        }
        if (source >= g.vertexCount()) {
            throw new IndexOutOfBoundsException();
        }
        this.source = source;
        edgeTo = new int[g.vertexCount()];
        marked = new boolean[g.vertexCount()];
        distTo = new int[g.vertexCount()];
        for (int i = 0; i < g.vertexCount(); i++) {
            distTo[i] = inf;
        }
        bfs(g);
    }

    private void bfs(Graph g) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(source);  //добавляем в очередь вершину source
        marked[source] = true; //в массиве marked отмечаем ее как посещенную
        distTo[source] = 0;    //расстояние от исходной вершины

        while (!queue.isEmpty()) {
            int vertex = queue.removeFirst();
            for ( int w:
                 g.adjList(vertex)) {
                if (!marked[w]) {
                    marked[w] = true;
                    edgeTo[w] = vertex;
                    distTo[w] = distTo[vertex] +1;
                    queue.addLast(w);
                }
            }
        }
    }

    public boolean hasPathTo(int dist){
        if (dist < 0){
            throw new IllegalArgumentException();
        }
        if (dist >= marked.length) {
            throw new IndexOutOfBoundsException();
        }
        return marked[dist];
    }

    public LinkedList<Integer> pathTo(int dist) { //стек
        if (!hasPathTo(dist)) {
            return null;
        }
        LinkedList<Integer> stack = new LinkedList<>();

        int vertex = dist;
        while (vertex != source) {
            stack.push(vertex);
            vertex = edgeTo[vertex];
        }
        return stack;
    }

    public int distTo(int dist) {
        if (dist < 0){
            throw new IllegalArgumentException();
        }
        if (dist >= marked.length) {
            throw new IndexOutOfBoundsException();
        }
        return distTo[dist];
    }
}
