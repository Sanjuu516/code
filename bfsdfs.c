#include <stdio.h>
#include <stdbool.h>

#define MAX 100 // Maximum number of vertices

// Function prototypes
void BFS(int graph[MAX][MAX], int n, int start);
void DFS(int graph[MAX][MAX], int n, int start, bool visited[]);

// Main function
int main() {
    int n, start;
    int graph[MAX][MAX];

    printf("Enter the number of vertices: ");
    scanf("%d", &n);

    printf("Enter the adjacency matrix:\n");
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            scanf("%d", &graph[i][j]);
        }
    }

    printf("Enter the starting vertex (0-based index): ");
    scanf("%d", &start);

    printf("\nBreadth-First Traversal (BFT):\n");
    BFS(graph, n, start);

    printf("\nDepth-First Traversal (DFT):\n");
    bool visited[MAX] = {false};
    DFS(graph, n, start, visited);

    return 0;
}

// Breadth-First Traversal
void BFS(int graph[MAX][MAX], int n, int start) {
    bool visited[MAX] = {false};
    int queue[MAX], front = 0, rear = 0;

    // Mark the starting node as visited and enqueue it
    visited[start] = true;
    queue[rear++] = start;

    while (front < rear) {
        int current = queue[front++];
        printf("%d ", current);

        // Enqueue all unvisited neighbors
        for (int i = 0; i < n; i++) {
            if (graph[current][i] == 1 && !visited[i]) {
                visited[i] = true;
                queue[rear++] = i;
            }
        }
    }
}

// Depth-First Traversal
void DFS(int graph[MAX][MAX], int n, int start, bool visited[]) {
    visited[start] = true;
    printf("%d ", start);

    // Visit all unvisited neighbors
    for (int i = 0; i < n; i++) {
        if (graph[start][i] == 1 && !visited[i]) {
            DFS(graph, n, i, visited);
        }
    }
}
