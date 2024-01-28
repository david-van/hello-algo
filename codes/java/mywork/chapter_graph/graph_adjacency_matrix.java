/**
 * File: graph_adjacency_matrix.java
 * Created Time: 2023-01-26
 * Author: Krahets (krahets@163.com)
 */

package mywork.chapter_graph;

import javafx.util.Pair;
import utils.PrintUtil;

import java.util.ArrayList;
import java.util.List;

/* 基于邻接矩阵实现的无向图类 */
class GraphAdjMat {
    List<Integer> vertices; // 顶点列表，元素代表“顶点值”，索引代表“顶点索引”
    // 邻接矩阵，行列索引对应“顶点索引”
    // 先行，再列
    List<List<Integer>> adjMat;

    /* 构造方法 */
    public GraphAdjMat(int[] vertices, Pair<Integer, Integer>[] edges) {
        this.vertices = new ArrayList<>();
        adjMat = new ArrayList<>();
        //先初始化元素，再初始化邻接矩阵
        //邻接矩阵的初始化可以对元素添加为顶点来处理
        for (int vertex : vertices) {
            addVertex(vertex);
        }
        //添加边
        for (int i = 0; i < edges.length; i++) {
            for (Pair<Integer, Integer> pair : edges) {
                Integer key = pair.getKey();
                Integer value = pair.getValue();
                addEdge(key, value);
            }
        }
    }

    /* 获取顶点数量 */
    public int size() {
        return vertices.size();
    }

    /* 添加顶点 */
    public void addVertex(int val) {
        //增加顶点，1：元素添加，处理表的关系
        int index = vertices.size();
        vertices.add(val);
        List<Integer> rowList = new ArrayList<>();
        for (int i = 0; i < index; i++) {
            //该行添加的元素数量和之前行一直，
            // 改行要添加的最后一个列，由下面的添加列元素的循环进行添加
            rowList.add(0);
        }
        adjMat.add(rowList);
        //再添加一列
        for (List<Integer> list : adjMat) {
            list.add(0);
        }
    }

    /* 删除顶点 */
    public void removeVertex(int index) {
        //先删除点，再删除邻接矩阵
        vertices.remove(index);
        //先删除该行，再循环每一行，删除该列对应的元素
        adjMat.remove(index);
        for (List<Integer> list : adjMat) {
            list.remove(index);
        }
    }

    /* 添加边 */
    // 参数 i, j 对应 vertices 元素索引
    public void addEdge(int i, int j) {
//        边的操作，只需要动二维数组即可
        //定位到对应的元素，将其值设置为1即可
        Integer oldValue = adjMat.get(i).get(j);
        adjMat.get(i).set(j, 1);
        adjMat.get(j).set(i, 1);
    }

    /* 删除边 */
    // 参数 i, j 对应 vertices 元素索引
    public void removeEdge(int i, int j) {
        adjMat.get(i).set(j, 0);
        adjMat.get(j).set(i, 0);
    }

    /* 打印邻接矩阵 */
    public void print() {
        System.out.print("顶点列表 = ");
        System.out.println(vertices);
        System.out.println("邻接矩阵 =");
        PrintUtil.printMatrix(adjMat);
    }
}

public class graph_adjacency_matrix {
    public static void main(String[] args) {
        /* 初始化无向图 */
        // 请注意，edges 元素代表顶点索引，即对应 vertices 元素索引
        int[] vertices = {1, 3, 2, 5, 4};
        int[][] edges = {{0, 1}, {0, 3}, {1, 2}, {2, 3}, {2, 4}, {3, 4}};
        Pair<Integer, Integer>[] edgesPair = new Pair[edges.length];
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            Pair<Integer, Integer> pair = new Pair<>(edge[0], edge[1]);
            edgesPair[i] = pair;
        }
        GraphAdjMat graph = new GraphAdjMat(vertices, edgesPair);
        System.out.println("\n初始化后，图为");
        graph.print();

        /* 添加边 */
        // 顶点 1, 2 的索引分别为 0, 2
        graph.addEdge(0, 2);
        System.out.println("\n添加边 1-2 后，图为");
        graph.print();

        /* 删除边 */
        // 顶点 1, 3 的索引分别为 0, 1
        graph.removeEdge(0, 1);
        System.out.println("\n删除边 1-3 后，图为");
        graph.print();

        /* 添加顶点 */
        graph.addVertex(6);
        System.out.println("\n添加顶点 6 后，图为");
        graph.print();

        /* 删除顶点 */
        // 顶点 3 的索引为 1
        graph.removeVertex(1);
        System.out.println("\n删除顶点 3 后，图为");
        graph.print();
    }
}
