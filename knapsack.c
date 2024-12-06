#include <stdio.h>

#define MAX_ITEMS 100
#define MAX_CAPACITY 1000

// Function to solve the 0/1 Knapsack problem
int knapsack(int weights[], int values[], int n, int capacity) {
    int dp[MAX_ITEMS + 1][MAX_CAPACITY + 1];

    // Fill the DP table
    for (int i = 0; i <= n; i++) {
        for (int w = 0; w <= capacity; w++) {
            if (i == 0 || w == 0) {
                dp[i][w] = 0; // Base case
            } else if (weights[i - 1] <= w) {
                dp[i][w] = (values[i - 1] + dp[i - 1][w - weights[i - 1]] > dp[i - 1][w])
                           ? values[i - 1] + dp[i - 1][w - weights[i - 1]]
                           : dp[i - 1][w];
            } else {
                dp[i][w] = dp[i - 1][w];
            }
        }
    }

    return dp[n][capacity];
}

int main() {
    int n, capacity;
    int weights[MAX_ITEMS], values[MAX_ITEMS];

    printf("Enter the number of items: ");
    scanf("%d", &n);

    printf("Enter the weights and values of each item:\n");
    for (int i = 0; i < n; i++) {
        scanf("%d %d", &weights[i], &values[i]);
    }

    printf("Enter the capacity of the knapsack: ");
    scanf("%d", &capacity);

    int maxProfit = knapsack(weights, values, n, capacity);
    printf("Maximum profit: %d\n", maxProfit);

    return 0;
}
