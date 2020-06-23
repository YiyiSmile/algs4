package miscellaneous.maze_solver;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author Tom
 * @Date 2020/6/23 16:45
 * @Version 1.0
 * @Description
 */
public class Test {

    @org.junit.Test
    public void test() {
        IntFunction<Integer[]> intFunction = new IntFunction<Integer[]>() {

            @Override
            public Integer[] apply(int value) {
                return new Integer[4];
            }
        };
        Integer[] integers = Stream.of(1, 2, 3, 4, 5).toArray(Integer[]::new);
        System.out.println(Arrays.toString(integers));
    }

}
