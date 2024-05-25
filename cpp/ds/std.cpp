#include <iostream>
#include <map>
#include <queue>
#include <unordered_map>
#include <unordered_set>

using namespace std;


int deque_main() {
	deque<int> d;
	d.push_front(2), d.push_front(1), d.push_back(99), d.push_back(100);

	while (!d.empty()) {
		cout << d.front() << ' ';
		d.pop_front();
	}
	cout << '\n';

	return 0;
}

int priority_queue_main() {
	int data[5] = {5, 9, 1, 4, 5};

	priority_queue<int> qMax; // max on top
	for (int n : data) qMax.push(n);
	while (!qMax.empty()) {
		cout << qMax.top() << " ";
		qMax.pop();
	}
	cout << '\n';

	priority_queue<int, vector<int>, greater<int>> qMin; // min on top
	for (int n : data) qMin.push(n);
	while (!qMin.empty()) {
		cout << qMin.top() << " ";
		qMin.pop();
	}
	cout << '\n';

	return 0;
}

int unordered_map_main() {
	unordered_map<int, int> m;
	m[0] = 10, m[2] = 5;
	cout << m.count(0) << ' ' << m.count(1) << '\n';
	for (const auto& e : m) cout << e.first << ' ' << e.second << ' ';
	cout << '\n';
	m.erase(0);
	for (const auto& e : m) cout << e.first << ' ' << e.second << ' ';
	cout << '\n';

	return 0;
}

int unordered_set_main() {
	unordered_set<int> s {0, 3, 9, 3, 5};
	s.insert(0), s.insert(4);
	cout << s.count(0) << ' ' << s.count(1) << '\n';
	for (int e : s) cout << e << ' ';
	cout << '\n';
	s.erase(0);
	for (int e : s) cout << e << ' ';
	cout << '\n';

	return 0;
}
