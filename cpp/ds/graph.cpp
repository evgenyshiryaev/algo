#include <iostream>
#include <queue>

using namespace std;

#define frompair(y,x) y*X+x
#define topair(z) x=z%X,y=z/X
#define g(y,x) g[frompair(y,x)]

int _MOVES_HV[4][2] = {{0,1},{0,-1},{1,0},{-1,0}};
int _MOVES_D[4][2] = {{1,1},{-1,-1},{1,-1},{-1,1}};
int _MOVES_ALL[8][2] = {{0,1},{0,-1},{1,0},{-1,0},{1,1},{-1,-1},{1,-1},{-1,1}};


int graph_init() {
	const int N = 50;
	int Y = 3, X = 5;
	int g[N];
	memset(g, 0, sizeof(g));

	g(0, 0) = 10;
	g(2, 3) = 15;
	cout << g(0, 0) << ' ' << g(2, 3) << '\n';

	int x, y;
	topair(11);
	cout << frompair(1, 1) << ' ' << y << ' ' << x << '\n';

	return 0;
}


int graph_bfs() {
	const int N = 50;
	int Y = 3, X = 5;
	int g[N], v[N];
	memset(g, 0, sizeof(g));
	memset(v, -1, sizeof(v));

	deque<int> d;
	int dist = 1;
	int x = 0, y = 0, z = frompair(y, x), x1, y1, z1;
	v[z] = 0;
	d.push_back(z);

	while (!d.empty()) {
		auto dSize = d.size();
		while (dSize--) {
			z = d.front();
			d.pop_front();
			topair(z);
			for (int* move : _MOVES_HV) {
				y1 = y + move[0];
				x1 = x + move[1];
				z1 = frompair(y1, x1);
				if (y1 >= 0 && y1 < Y && x1 >= 0 && x1 < X && v[z1] == -1) {
					v[z1] = dist;
					d.push_back(z1);
				}
			}
		}
		++dist;
	}

	return 0;
}
