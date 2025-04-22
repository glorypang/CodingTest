#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;

vector<int> graph[100001];
bool visited[100001];
int result[100001];
int visit_count = 1;

void bfs(int start) {
	queue<int> q;
	q.push(start);
	visited[start] = true;
	result[start] = visit_count++;

	while (!q.empty()) {
		int node = q.front();
		q.pop();

		for (auto next : graph[node]) {
			if (!visited[next]) {
				visited[next] = true;
				result[next] = visit_count++;
				q.push(next);
			}
		}
	}
}

int main() {
	int N, M, R;
	cin >> N >> M >> R;

	for (int i = 0; i < M; i++) {
		int a, b;
		cin >> a >> b;
		graph[a].push_back(b);
		graph[b].push_back(a);
	}

	for (int i = 1; i <= N; i++) {
		sort(graph[i].rbegin(), graph[i].rend());
	}
	bfs(R);
	for (int i = 1; i <= N; i++) {
		cout << result[i] << "\n";
	}

	
	return 0;
}