#include <iostream>
#include <queue>
#include <set>
#include <unordered_map>
#include <unordered_set>
#include <vector>

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

	// max on top
	priority_queue<int> qMax;
	for (int n : data) qMax.push(n);
	while (!qMax.empty()) {
		cout << qMax.top() << " ";
		qMax.pop();
	}
	cout << '\n';

	// min on top
	priority_queue<int, vector<int>, greater<int>> qMin;
	for (int n : data) qMin.push(n);
	while (!qMin.empty()) {
		cout << qMin.top() << " ";
		qMin.pop();
	}
	cout << '\n';

	// custom struct
	struct node {
		int a, b;
		bool operator<(const node& other) const {
			return a < other.a;
		}
	};
	priority_queue<node> qNode;
	for (int n : data) qNode.push(node{n, -n});
	while (!qNode.empty()) {
		cout << qNode.top().a << ',' << qNode.top().b << " ";
		qNode.pop();
	}
	cout << '\n';

	return 0;
}

int set_main() {
	set<int> s { 0, 3, 9, 3, 5 };
	s.insert(0), s.insert(4);
	for (int e : s) cout << e << ' ';
	cout << '\n';
	cout << "min=" << *s.begin() << " max=" << *s.rbegin();

	return 0;
}

int unordered_map_main() {
	unordered_map<int, int> m;
	m[0] = 10, m[2] = 5;
	cout << m.count(0) << ' ' << m.count(1) << '\n';
	cout << 0 << '=' << (m.find(0) == m.end() ? -1 : m.find(0)->second) << '\n';
	cout << 0 << '=' << (m.find(1) == m.end() ? -1 : m.find(1)->second) << '\n';
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

int vector_main() {
	vector<int> v { 4, 19, 8 };
	v.push_back(-69);
	for (int e : v) cout << e << ' ';
	cout << '\n';
	sort(v.begin(), v.end());
	for (int e : v) cout << e << ' ';
	cout << '\n';

	return 0;
}
