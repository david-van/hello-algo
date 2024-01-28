/**
 * File: graph_bfs.java
 * Created Time: 2023-02-12
 * Author: Krahets (krahets@163.com)
 */

package mywork.chapter_graph;

import utils.Vertex;

import java.util.*;

public class graph_bfs {
    /* 广度优先遍历 BFS */
    // 使用邻接表来表示图，以便获取指定顶点的所有邻接顶点
    static List<Vertex> graphBFS(GraphAdjList graph, Vertex startVet) {
        //广度优先会找到点的所有边，然后根据边找到关联的点，然后逐层遍历，知道关联的点都被访问一遍
        //又由于相邻点访问后即不再需要访问，所以需要一个set集合进行去重
        List<Vertex> result = new ArrayList<>();
        Set<Vertex> visitSet = new HashSet<>();
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(startVet);
        visitSet.add(startVet);
        result.add(startVet);
        while (!queue.isEmpty()) {
            Vertex vertex = queue.poll();
            List<Vertex> vertexList = graph.adjMap.get(vertex);
            for (Vertex edgeVertex : vertexList) {
                if (visitSet.contains(edgeVertex)) {
                    continue;
                }
                //添加队列，
                queue.add(edgeVertex);
                result.add(edgeVertex);
                visitSet.add(edgeVertex);
            }
        }
        return result;

    }

    public static void main(String[] args) {
        /* 初始化无向图 */
        Vertex[] v = Vertex.valsToVets(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
        Vertex[][] edges = {{v[0], v[1]}, {v[0], v[3]}, {v[1], v[2]}, {v[1], v[4]},
                {v[2], v[5]}, {v[3], v[4]}, {v[3], v[6]}, {v[4], v[5]},
                {v[4], v[7]}, {v[5], v[8]}, {v[6], v[7]}, {v[7], v[8]}};
        GraphAdjList graph = new GraphAdjList(edges);
        System.out.println("\n初始化后，图为");
        graph.print();

        /* 广度优先遍历 BFS */
        List<Vertex> res = graphBFS(graph, v[0]);
        System.out.println("\n广度优先遍历（BFS）顶点序列为");
        System.out.println(Vertex.vetsToVals(res));
    }
}
