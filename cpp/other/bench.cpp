#include <chrono>

using namespace std::chrono;

void bench() {
	auto start = system_clock::now();
	// TODO
	auto end = system_clock::now();
	duration<double> elapsed_seconds = end - start;
	elapsed_seconds.count();
}
