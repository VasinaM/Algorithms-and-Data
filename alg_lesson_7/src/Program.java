public class Program {
    public static void main(String[] args) {
        Graph graph = new Graph(10);
        graph.addEdge(0, 5);
        graph.addEdge(5, 6);
        graph.addEdge(6, 9);
        graph.addEdge(8, 9);
        graph.addEdge(7, 8);
        graph.addEdge(0, 7);
        graph.addEdge(7, 4);
        graph.addEdge(1, 0);
        graph.addEdge(0, 4);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);

        BreadthFirstPaths bfs = new BreadthFirstPaths(graph, 0);
        System.out.println(bfs.hasPathTo(9)); //есть ли вершина
        System.out.println(bfs.pathTo(9));  //что бы добраться до 3 надо пройти 2, 3
        System.out.println(bfs.distTo(9));   //растояние кратчайшее 2 (2 шага)


    }

}
