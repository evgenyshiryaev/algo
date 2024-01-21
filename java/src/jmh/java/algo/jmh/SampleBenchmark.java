package algo.jmh;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;


// see https://github.com/openjdk/jmh
// see https://github.com/melix/jmh-gradle-plugin
@State(Scope.Benchmark)
public class SampleBenchmark {

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public void sample() {
        int a = 1;
        a = a + 1;
    }

}
