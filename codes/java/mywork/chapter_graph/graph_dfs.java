/**
 * File: graph_dfs.java
 * Created Time: 2023-02-12
 * Author: Krahets (krahets@163.com)
 */

package mywork.chapter_graph;

import utils.Vertex;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class graph_dfs {
    /* 深度优先遍历 DFS 辅助函数 */
    static void dfs(GraphAdjList graph, Set<Vertex> visited, List<Vertex> res, Vertex vet) {
        List<Vertex> vertexList = graph.adjMap.get(vet);
        //当不存在对应的边的时候，说明为非联通图，但是当前均为联通图，故此不需要判断
//        if (null == vertexList) {
//            return;
//        }
        res.add(vet);
        visited.add(vet);
        for (Vertex vertex : vertexList) {
            if (visited.contains(vertex)) {
                continue;
            }
            dfs(graph, visited, res, vertex);
        }
    }

    /* 深度优先遍历 DFS */
    // 使用邻接表来表示图，以便获取指定顶点的所有邻接顶点
    static List<Vertex> graphDFS(GraphAdjList graph, Vertex startVet) {
        //dfs 简单理解为沿着边一直走到尾，直至没有，然后返回上个顶点，访问其它的边，
        // 直至所有的被访问结束
        List<Vertex> result = new ArrayList<>();
        Set<Vertex> set = new HashSet<>();
        dfs(graph, set, result, startVet);
        return result;
    }

    public static void main(String[] args) {
        /* 初始化无向图 */
        Vertex[] v = Vertex.valsToVets(new int[]{0, 1, 2, 3, 4, 5, 6});
        Vertex[][] edges = {{v[0], v[1]}, {v[0], v[3]}, {v[1], v[2]},
                {v[2], v[5]}, {v[4], v[5]}, {v[5], v[6]}};
        GraphAdjList graph = new GraphAdjList(edges);
        System.out.println("\n初始化后，图为");
        graph.print();

        /* 深度优先遍历 DFS */
        List<Vertex> res = graphDFS(graph, v[0]);
        System.out.println("\n深度优先遍历（DFS）顶点序列为");
        System.out.println(Vertex.vetsToVals(res));
    }
}
