#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int path[9] = { 0 };
int used[9] = { 0 };

void func(int N, int M, int lev, int start) {

	if (lev == M) {
		for (int i = 0; i < M; i++) {
			printf("%d ", path[i]);
		}
		printf("\n");
		return;
	}

	for (int i = start; i <= N; i++) {
		path[lev] = i;
		func(N, M, lev + 1, i);
		path[lev] = 0;
	}

}

int main() {
	int N, M;
	scanf("%d %d", &N, &M);
	func(N, M, 0, 1);
}