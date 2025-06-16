#include <iostream>
#include <cmath>
#include <vector>
#include <string>
#include <set>
#include <sstream>
#include <algorithm>

int main() {
    std::cin.tie(NULL);
    std::cout.tie(NULL);
    std::ios_base::sync_with_stdio(false);

    int N{ 0 };
    int M{ 0 };
    std::cin >> N >> M;

    std::vector<int> graph(N);
    for (int i = 0; i < N; i++) {
        graph[i] = i + 1;
    }

    do {
        for (int i = 0; i < M; i++) {
            std::cout << graph[i] << " ";
        }
        std::cout << "\n";
        reverse(graph.begin() + M, graph.end());
    } while (next_permutation(graph.begin(), graph.end()));
    return 0;
}