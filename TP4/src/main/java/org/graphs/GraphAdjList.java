package org.graphs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GraphAdjList {
    private int N; // number of nodes
    private int M; // number of edges
    private ArrayList<Integer>[] adjencyList; // adjacency list representation of the graph

    public GraphAdjList(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;
        N = 0;
        M = 0;
        while ((line = br.readLine()) != null) {
            String[] tokens = line.trim().split("\\s+");
            int u = Integer.parseInt(tokens[0]);
            int v = Integer.parseInt(tokens[1]);
            N = Math.max(N, Math.max(u, v));
            M++;
        }
        br.close();
        adjencyList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adjencyList[i] = new ArrayList<Integer>();
        }
        br = new BufferedReader(new FileReader(filename));
        while ((line = br.readLine()) != null) {
            String[] tokens = line.trim().split("\\s+");
            int u = Integer.parseInt(tokens[0]);
            int v = Integer.parseInt(tokens[1]);
            if (u != 0 && v != 0) {
                adjencyList[u].add(v);
                adjencyList[v].add(u);
            }
        }
        br.close();
    }

    public void addEdge(int u, int v) {
        if (u != 0 && v != 0) {
            adjencyList[u].add(v);
            adjencyList[v].add(u);
            M++;
        }
    }

    public int getN() {
        return N;
    }

    public int getM() {
        return M;
    }

    public ArrayList<Integer>[] getAdjencyList() {
        return adjencyList;
    }

    public void Neighbors(int v) {
        System.out.print("Edge's Neighbors " + v + " : ");
        for (int neighbor : adjencyList[v]) {
            System.out.print(neighbor + " ");
        }
        System.out.println();
    }

    public int Degree(int v) {
        return adjencyList[v].size();
}

    public void structuralProperties() {
        int minimumDegree = Integer.MAX_VALUE;
        int maximumDegree = Integer.MIN_VALUE;
        int sumDegree = 0;
        int isolatedNodes = 0;
        boolean hasLoops = false;

        for (int v = 1; v <= N; v++) {
            int degree = Degree(v);
            if (degree == 0) {
                isolatedNodes++;
            }
            if (degree > maximumDegree) {
                maximumDegree = degree;
            }
            if (degree < minimumDegree) {
                minimumDegree = degree;
            }
            if (adjencyList[v].contains(v)) {
                hasLoops = true;
            }
            sumDegree += degree;
        }

        double averageDegree = sumDegree / (double) N;
        double edgeDensity = 2 * M / (double) (N * (N - 1));// Compute edge-density


        System.out.println("Average degree: " + averageDegree);
        System.out.println("Minimum degree: " + minimumDegree);
        System.out.println("Maximum degree: " + maximumDegree);
        System.out.println("Edge density: " + edgeDensity);

        if (edgeDensity >= 0.5) {
            System.out.println("This graph is dense");
        } else {
            System.out.println("This graph is sparse");
        }

        System.out.println("Number of isolated nodes: " + isolatedNodes);
        System.out.println("Has loops: " + hasLoops);
    }


    public static void printAllNeighbors(GraphAdjList graph, ArrayList<Integer>[] adjList) {
        for (int i = 1; i <= graph.getN(); i++) {
            System.out.print(i + ": ");
            for (int j = 0; j < adjList[i].size(); j++) {
                System.out.print(adjList[i].get(j) + " ");
            }
            System.out.println();
        }
    }
}

