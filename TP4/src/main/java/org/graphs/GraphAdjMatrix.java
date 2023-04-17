package org.graphs;

import java.io.*;

public class GraphAdjMatrix {
    private int N;
    private int M;
    private boolean[][] adjacencyMatrix;

    public GraphAdjMatrix(int N){
        this.N = 0;
        this.M = 0;
        adjacencyMatrix = new boolean[N][N];
    }
    public GraphAdjMatrix(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;
        while((line = br.readLine()) != null){
            String[]parts = line.trim().split("\\s+");
            int u = Integer.parseInt(parts[0]);
            int v = Integer.parseInt(parts[1]);
            N = Math.max(N, Math.max(u,v));
            M++;
        }
        br.close();
        adjacencyMatrix = new boolean[N + 1][ N + 1];
        br = new BufferedReader(new FileReader(filename));
        while ((line = br.readLine()) != null){
            String[]parts = line.trim().split("\\s+");
            int u = Integer.parseInt(parts[0]);
            int v = Integer.parseInt(parts[1]);
            if (u != 0 && v != 0){
                addEdge(u,v);
            }
        }
        br.close();
    }

    public void addEdge(int u, int v ){
        if (u != 0 && v != 0){
            adjacencyMatrix[u][v] = true;
            adjacencyMatrix[v][u] = true;
            M++;
        }
    }

    public int getN() {
        return N;
    }

    public int getM() {
        return M;
    }

    public boolean[][] getAdjacencyMatrix() {
        return adjacencyMatrix;
    }

    public int getDistance(int u, int v) {
        int distance = -1;
        if (u > 0 && u <= N && v > 0 && v <=N){
            int[][]product = new int[N + 1][N + 1];
            for (int i = 1; i < N; i++){
                for (int j = 1; j <= N; j++){
                    for (int k = 1; k <= N; k++){
                        product[i][j] +=(adjacencyMatrix[i][k] ? 1 : 0) * (adjacencyMatrix[k][j] ? 1 : 0);
                    }
                }
            }
            distance = product[u][v];
        }
        return distance;
    }
}
