#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <limits.h>

#define MAX 100

// Node structure for adjacency list
typedef struct Node {
    int vertex, weight;
    struct Node* next;
} Node;

// Graph structure
Node* graph[MAX];
int dist[MAX], visited[MAX];

// Function to add an edge
void addEdge(int src, int dest, int weight) {
    Node* newNode = (Node*)malloc(sizeof(Node));
    newNode->vertex = dest;
    newNode->weight = weight;
    newNode->next = graph[src];
    graph[src] = newNode;
}

// Dijkstra's Algorithm
void dijkstra(int start, int n) {
    for (int i = 0; i < n; i++) dist[i] = INT_MAX, visited[i] = 0;
    dist[start] = 0;

    for (int i = 0; i < n; i++) {
        int u = -1;
        for (int j = 0; j < n; j++)  // Find the unvisited node with the smallest distance
            if (!visited[j] && (u == -1 || dist[j] < dist[u]))
                u = j;

        visited[u] = 1;

        for (Node* temp = graph[u]; temp; temp = temp->next) { // Relax neighbors
            if (!visited[temp->vertex] && dist[u] + temp->weight < dist[temp->vertex])
                dist[temp->vertex] = dist[u] + temp->weight;
        }
    }

    printf("Vertex\tDistance from Source\n");
    for (int i = 0; i < n; i++) 
        printf("%d\t%d\n", i, dist[i]);
}

// Main function
int main() {
    int n, edges;
    printf("Enter number of vertices and edges: ");
    scanf("%d %d", &n, &edges);

    for (int i = 0; i < n; i++) graph[i] = NULL;

    printf("Enter edges (src dest weight):\n");
    for (int i = 0; i < edges; i++) {
        int src, dest, weight;
        scanf("%d %d %d", &src, &dest, &weight);
        addEdge(src, dest, weight);
    }

    int start;
    printf("Enter starting vertex: ");
    scanf("%d", &start);

    dijkstra(start, n);

    return 0;
}
