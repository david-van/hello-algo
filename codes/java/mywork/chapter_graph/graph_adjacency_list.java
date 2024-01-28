/**
 * File: graph_adjacency_list.java
 * Created Time: 2023-01-26
 * Author: Krahets (krahets@163.com)
 */

package mywork.chapter_graph;

import utils.Vertex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 基于邻接表实现的无向图类 */
class GraphAdjList {
    // 邻接表，key：顶点，value：该顶点的所有邻接顶点
    Map<Vertex, List<Vertex>> adjMap;

    /* 构造方法 */
    public GraphAdjList(Vertex[][] edges) {
        this.adjMap = new HashMap<>();
        for (Vertex[] edge : edges) {
            Vertex vertex1 = edge[0];
            Vertex vertex2 = edge[1];
            //先增加顶点，然后再增加边
            addVertex(vertex1);
            addVertex(vertex2);
            addEdge(vertex1, vertex2);
        }
    }

    /* 获取顶点数量 */
    public int size() {
        return adjMap.size();
    }

    /* 添加边 */
    public void addEdge(Vertex vet1, Vertex vet2) {
        //添加边，先找到对应的链表，然后添加即可
        List<Vertex> list1 = adjMap.get(vet1);
        List<Vertex> list2 = adjMap.get(vet2);
        if (null == list1 || null == list2) {
            throw new RuntimeException("存在不存在的顶点");
        }
        list1.add(vet2);
        list2.add(vet1);
    }

    /* 删除边 */
    public void removeEdge(Vertex vet1, Vertex vet2) {
        List<Vertex> list1 = adjMap.get(vet1);
        List<Vertex> list2 = adjMap.get(vet2);
        if (null == list1 || null == list2) {
            throw new RuntimeException("存在不存在的顶点");
        }
        list1.remove(vet2);
        list2.remove(vet1);
    }

    /* 添加顶点 */
    public void addVertex(Vertex vet) {
        //如果已经存在了，应该怎么处理？按照存在则不进行处理的原则来
        if (adjMap.containsKey(vet)) {
            return;
        }
        adjMap.put(vet, new ArrayList<>());
    }

    /* 删除顶点 */
    public void removeVertex(Vertex vet) {
        //删除对应的链表，然后循环处理其余的链表，如果存在边，则移除
        List<Vertex> remove = adjMap.remove(vet);
        if (null == remove) {
            return;
        }
        for (List<Vertex> list : adjMap.values()) {
            list.remove(vet);
        }
    }

    /* 打印邻接表 */
    public void print() {
        System.out.println("邻接表 =");
        for (Map.Entry<Vertex, List<Vertex>> pair : adjMap.entrySet()) {
            List<Integer> tmp = new ArrayList<>();
            for (Vertex vertex : pair.getValue())
                tmp.add(vertex.val);
            System.out.println(pair.getKey().val + ": " + tmp + ",");
        }
    }
}

public class graph_adjacency_list {
    public static void main(String[] args) {
        /* 初始化无向图 */
        Vertex[] v = Vertex.valsToVets(new int[]{1, 3, 2, 5, 4});
        Vertex[][] edges = {{v[0], v[1]}, {v[0], v[3]}, {v[1], v[2]},
                {v[2], v[3]}, {v[2], v[4]}, {v[3], v[4]}};
        GraphAdjList graph = new GraphAdjList(edges);
        System.out.println("\n初始化后，图为");
        graph.print();

        /* 添加边 */
        // 顶点 1, 2 即 v[0], v[2]
        graph.addEdge(v[0], v[2]);
        System.out.println("\n添加边 1-2 后，图为");
        graph.print();

        /* 删除边 */
        // 顶点 1, 3 即 v[0], v[1]
        graph.removeEdge(v[0], v[1]);
        System.out.println("\n删除边 1-3 后，图为");
        graph.print();

        /* 添加顶点 */
        Vertex v5 = new Vertex(6);
        graph.addVertex(v5);
        System.out.println("\n添加顶点 6 后，图为");
        graph.print();

        /* 删除顶点 */
        // 顶点 3 即 v[1]
        graph.removeVertex(v[1]);
        System.out.println("\n删除顶点 3 后，图为");
        graph.print();
    }
}
