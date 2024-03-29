#include <iostream>
#include <queue>

using namespace std;


int deque_main() {
	deque<int> d;
	d.push_front(2);
	d.push_front(1);
	d.push_back(99);
	d.push_back(100);

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
