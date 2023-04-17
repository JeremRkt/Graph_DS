package org.graphs;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.graphs.GraphAdjList.printAllNeighbors;

public class Main {

    public static void main(String[]args) throws IOException {
        new Main();
    }
    public Main() throws IOException {
        //2.1 Adjacency list representation of an undirected graph
//        firstPart();
        // Second part of 2.1 - Choose input of the graph
//        secondPart();
//        verifyNeighbor("src/main/resources/graph.txt");

        //2.2 - Adjacency matrix representation of an undirected graph
        thirdPart();

        //3 - Bigger Graph
        //biggerGraph1();
        //biggerGraph2();
    }

    private static void calculateDistanceBtweenNode(String filename) {
        try {
            GraphAdjMatrix graph = new GraphAdjMatrix(filename);
            System.out.println("Order: " + graph.getN());
            System.out.println("Size: " + graph.getM());
            System.out.println("Adjacency Matrix: ");
            boolean[][] adjacencyMatrix = graph.getAdjacencyMatrix();
            for (int i = 1; i <= graph.getN(); i++) {
                for (int j = 1; j <= graph.getN(); j++) {
                    System.out.print((adjacencyMatrix[i][j] ? 1 : 0) + " ");
                }
                System.out.println();
            }
            System.out.println("Distance between 1 and 4: " + graph.getDistance(1, 4));
            System.out.println("Distance between 3 and 5: " + graph.getDistance(3, 5));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void verifyNeighbor(String filename) throws IOException {
        GraphAdjList graph = new GraphAdjList(filename);

        int node = 4;// Modify by the node you want to verify
        System.out.print("Neighbors of node " + node + ": ");
        for (int neighbor : graph.getAdjencyList()[node]) {
            System.out.print(neighbor + " ");
        }
        System.out.println();
        graph.Neighbors(node);
    }

    public void firstPart() throws IOException {
        GraphAdjList graph = new GraphAdjList("src/main/resources/graph.txt");
        System.out.println("Order: " + graph.getN());
        System.out.println("Size: " + graph.getM());
        System.out.println("Adjacency List: ");
        ArrayList<Integer>[] adjList = graph.getAdjencyList();

        printAllNeighbors(graph, adjList);

        graph.structuralProperties();
    }

    public void secondPart(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Number of vertices ?");
        int numberOfVectices = scanner.nextInt();
        scanner = new Scanner(System.in);
        System.out.print("Number of Edges ?");
        int numberOfEdges = scanner.nextInt();

        List<List<Integer>>adjencyList = new ArrayList<>();
        for (int i = 0 ; i <= numberOfVectices ; i ++){
            adjencyList.add( new ArrayList<>());
        }

        System.out.println("Enter edges in the format : u v");
        for (int i = 1; i <= numberOfEdges; i++){
            System.out.print("Edge " + i + "? ");
            int u = scanner.nextInt();
            int v = scanner.nextInt();

            adjencyList.get(u - 1).add(v);
        }
        System.out.println(" Adjency List representation of the graph :" );
        for (int i = 0; i < numberOfVectices; i ++){
            System.out.print((i + 1) + ": ");
            for (int j : adjencyList.get(i)){
                System.out.print(j + " ");
            }
            System.out.println("\n");
        }
    }
    public void thirdPart(){
        try {
            GraphAdjMatrix graph = new GraphAdjMatrix("src/main/resources/graph.txt");
            System.out.println(graph.getDistance(0,4));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        calculateDistanceBtweenNode("src/main/resources/graph.txt");
    }
    public void biggerGraph1() throws IOException {
        GraphAdjList graph = new GraphAdjList("src/main/resources/Wiki-Vote.txt");
        System.out.println("Order: " + graph.getN());
        System.out.println("Size: " + graph.getM());
        System.out.println("Adjacency List: ");
        ArrayList<Integer>[] adjList = graph.getAdjencyList();

        printAllNeighbors(graph, adjList);

        graph.structuralProperties();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Number of vertices ?");
        int numberOfVectices = scanner.nextInt();
        scanner = new Scanner(System.in);
        System.out.print("Number of Edges ?");
        int numberOfEdges = scanner.nextInt();

        List<List<Integer>>adjencyList = new ArrayList<>();
        for (int i = 0 ; i <= numberOfVectices ; i ++){
            adjencyList.add( new ArrayList<>());
        }

        System.out.println("Enter edges in the format : u v");
        for (int i = 1; i <= numberOfEdges; i++){
            System.out.print("Edge " + i + "? ");
            int u = scanner.nextInt();
            int v = scanner.nextInt();

            adjencyList.get(u - 1).add(v);
        }
        System.out.println(" Adjency List representation of the graph :" );
        for (int i = 0; i < numberOfVectices; i ++){
            System.out.print((i + 1) + ": ");
            for (int j : adjencyList.get(i)){
                System.out.print(j + " ");
            }
            System.out.println("\n");
        }
        verifyNeighbor("src/main/resources/Wiki-Vote.txt");

        try {
            GraphAdjMatrix graph1 = new GraphAdjMatrix("src/main/resources/Wiki-Vote.txt");
            System.out.println(graph1.getDistance(0,4));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        calculateDistanceBtweenNode("src/main/resources/Wiki-Vote.txt");
    }

    public void biggerGraph2() throws IOException {
        GraphAdjList graph = new GraphAdjList("src/main/resources/facebook_combined.txt");
        System.out.println("Order: " + graph.getN());
        System.out.println("Size: " + graph.getM());
        System.out.println("Adjacency List: ");
        ArrayList<Integer>[] adjList = graph.getAdjencyList();

        printAllNeighbors(graph, adjList);

        graph.structuralProperties();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Number of vertices ?");
        int numberOfVectices = scanner.nextInt();
        scanner = new Scanner(System.in);
        System.out.print("Number of Edges ?");
        int numberOfEdges = scanner.nextInt();

        List<List<Integer>>adjencyList = new ArrayList<>();
        for (int i = 0 ; i <= numberOfVectices ; i ++){
            adjencyList.add( new ArrayList<>());
        }

        System.out.println("Enter edges in the format : u v");
        for (int i = 1; i <= numberOfEdges; i++){
            System.out.print("Edge " + i + "? ");
            int u = scanner.nextInt();
            int v = scanner.nextInt();

            adjencyList.get(u - 1).add(v);
        }
        System.out.println(" Adjency List representation of the graph :" );
        for (int i = 0; i < numberOfVectices; i ++){
            System.out.print((i + 1) + ": ");
            for (int j : adjencyList.get(i)){
                System.out.print(j + " ");
            }
            System.out.println("\n");
        }
        verifyNeighbor("src/main/resources/facebook_combined.txt");

        try {
            GraphAdjMatrix graph1 = new GraphAdjMatrix("src/main/resources/facebook_combined.txt");
            System.out.println(graph1.getDistance(0,4));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        calculateDistanceBtweenNode("src/main/resources/facebook_combined.txt");
    }

}