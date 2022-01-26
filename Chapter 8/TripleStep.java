import java.util.Arrays;

class TripleStep {
    /**
    A staircase has n steps that can be hopped 1, 2, or 3 steps at a time.
    Find the number of possible ways the staircase can be climbed.

    0 steps: N/A (0 ways)
    1 steps: 1 (1 way)
    2 steps: 1>1, 2 (2 ways)
    3 steps: 1>1>1, 2>1, 1>2, 3 (4 ways)
    4 steps: 1>1>1>1, 2>2, 2>1>1, 1>2>1, 1>1>2, 3>1, 1>3 (7 ways)
    5 steps: 1>1>1>1>1, 2>2>1, 1>2>2, 2>1>2, 2>1>1>1, 1>2>1>1, 1>1>2>1, 1>1>1>2, 3>2, 2>3, 3>1>1, 1>3>1, 1>1>3 (13 ways)
    steps(n) = steps(n-1) + steps(n-2) + steps(n-3).

    @param steps Number of steps in the staircase
    @return Number of ways to climb staircase using 1, 2, or 3 steps
    */
    int solve(int steps) {
        int[] memo = new int[steps+1];
        Arrays.fill(memo, -1);
        return solve(steps, steps, memo);
    }

    int solve(int steps, int stepCount, int[] memo) {
        if ((stepCount < 0 || (steps == 0))) return 0;
        else if (stepCount == 0) return 1;

        if (memo[stepCount] != -1) {
            return memo[stepCount];
        }
        memo[stepCount] = solve(steps, stepCount-3, memo) + solve(steps, stepCount-2, memo) + solve(steps, stepCount-1, memo);
        return memo[stepCount];
    }
}

class Main {
    public static void main(String[] args) {
        TripleStep test = new TripleStep();
        for (int i = 0; i < 10; i++) {
            System.out.println(test.solve(i));
        }
    }
}