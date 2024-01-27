#include <iostream>

using namespace std;

void _print_array(int** a, int Y, int X) {
	for (int y = 0; y < Y; ++y) {
		int* row = a[y];
		for (int x = 0; x < X; ++x) cout << a[y][x] << ' ';
		cout << '\n';
	}
}

void _print_2d_array(int* a, int Y, int X) {
	int i = 0;
	for (int y = 0; y < Y; ++y) {
		for (int x = 0; x < X; ++x) cout << a[i++] << ' ';
		cout << '\n';
	}
}

void _print_2d_array(char* a, int Y, int X) {
	int i = 0;
	for (int y = 0; y < Y; ++y) {
		for (int x = 0; x < X; ++x) cout << a[i++];
		cout << '\n';
	}
}
