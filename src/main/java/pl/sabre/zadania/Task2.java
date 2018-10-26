package pl.sabre.zadania;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

//TODO: You are given an array of integers representing coordinates of obstacles situated on a straight line.
//TODO: Assume that you are jumping from the point with coordinate 0 to the right. You are allowed only to make jumps of the same lenght represented by some integer.
//TODO: Find the minimal length of the jump to avoid all the obstacles.
//TODO: For inputArray = {5, 3, 6, 7, 9} the output should be avoidObstacles(inputArray) = 4
public class Task2 {

    public static void main(String[] args) {
        var inputArrayA = new Integer[]{5, 3, 6, 7, 9};
        var inputArrayB = new Integer[]{1, 2, 3, 5, 6, 7, 8, 9};
        var inputArrayC = new Integer[]{1, 2, 3, 5, 6, 7, 8, 9, 11, 12, 13, 14, 15, 16};
        var inputArrayD = new Integer[]{1, 2, 3, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16, 17};

        System.out.println(String.format("Minimum jump length for input %s is %s", Arrays.toString(inputArrayA),avoidObstacles(inputArrayA)));
        System.out.println(String.format("Minimum jump length for input %s is %s", Arrays.toString(inputArrayB),avoidObstacles(inputArrayB)));
        System.out.println(String.format("Minimum jump length for input %s is %s", Arrays.toString(inputArrayC),avoidObstacles(inputArrayC)));
        System.out.println(String.format("Minimum jump length for input %s is %s", Arrays.toString(inputArrayD),avoidObstacles(inputArrayD)));

    }

    private static int avoidObstacles(Integer... inputArray) {
        long jumpLimit = calculateJumpLimit(inputArray);
        List<Integer> xAxis = List.of(inputArray);
        TreeSet<Integer> possibleJumps = calculatePossibleJumps(xAxis, jumpLimit);
        return calculateMinimalJump(xAxis, possibleJumps, jumpLimit);
    }

    private static long calculateJumpLimit(Integer[] inputArray) {
        return Arrays.stream(inputArray).max(Comparator.comparingInt(i -> i)).orElse(0) + 1;
    }

    private static int calculateMinimalJump(List<Integer> xAxis, TreeSet<Integer> jumpLengths, long jumpLimit) {
        for (Integer jumpLength : jumpLengths) {
            for (int i = 0; i <= jumpLimit; ) {
                i = i + jumpLength;
                if (i > jumpLimit) {
                    return jumpLength;
                } else if (!canJumpTo(i, xAxis)) {
                    break;
                }
            }
        }
        return 0;
    }

    private static TreeSet<Integer> calculatePossibleJumps(List<Integer> xAxis, long jumpLimit) {
        var jumpLengths = new TreeSet<Integer>();
        for (int i = 1; i <= jumpLimit; i++) {
            if (!xAxis.contains(i)) {
                jumpLengths.add(i);
            }
        }
        System.out.println("Possible jumps are :" + jumpLengths);
        return jumpLengths;
    }

    private static boolean canJumpTo(Integer n, List<Integer> xAxis) {
        return !xAxis.contains(n);
    }

}
