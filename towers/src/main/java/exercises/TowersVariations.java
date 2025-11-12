package exercises;

import java.util.Scanner;

/**
 * Exercise 23 — Towers of Hanoi Variation
 * <p>
 * From: Object-Oriented Data Structures Using Java (Ch. 3 Recursion)
 * <p>
 * PROBLEM DESCRIPTION:
 * In this variation of the Towers of Hanoi puzzle, **every move must use the middle peg**.
 * If the pegs are labeled 1, 2, and 3 (left → right),
 * every disk move must either go:
 * 1 → 2,  2 → 1,  2 → 3, or  3 → 2.
 * You can never move directly between pegs 1 and 3.
 * <p>
 * EXAMPLE (for 2 rings):
 * move 1 from 1 → 2
 * move 1 from 2 → 3
 * move 2 from 1 → 2
 * move 1 from 3 → 2
 * move 1 from 2 → 1
 * move 2 from 2 → 3
 * move 1 from 1 → 2
 * move 1 from 2 → 3
 * <p>
 * LEARNING GOALS:
 * - Recognize that additional constraints change the recursive pattern.
 * - Modify the recursion to account for “must pass through middle peg.”
 * - Derive and verify the new move-count growth rate.
 * <p>
 * TASKS:
 * 1. Prompt the user for the number of rings (n).
 * 2. If n < 0 → quit.
 * 3. Otherwise, call a recursive method that
 * a) Prints or counts each move.
 * b) Ensures every move uses the middle peg.
 * 4. Report the total number of moves.
 * <p>
 * Hint: Try expressing this variation in terms of TWO standard-style
 * recursive calls — one to move from start to middle, and another
 * from middle to destination.
 * <p>
 * Base case: n == 0 → no moves.
 */
public class TowersVariations {

    // static counter for number of moves
    private static int count = 0;

    /**
     * Recursive method to solve the Towers of Hanoi variation.
     *
     * @param n    number of disks
     * @param from starting peg label (1, 2, or 3)
     * @param mid  middle peg (must be used for every move)
     * @param to   destination peg label
     */
    public static void solveVariation(int n, int from, int mid, int to) {
        if (n == 0) return;

        if (from == mid || to == mid) {
            // If either source or destination is middle peg, use normal 2-step recursion
            solveVariation(n - 1, from, 6 - from - to, to); // 6 = 1+2+3, gives the "other" peg
            System.out.printf("Move disk %d from %d → %d%n", n, from, to);
            count++;
            solveVariation(n - 1, 6 - from - to, from, to);
        } else {
            // from and to are 1 & 3 → must go through middle peg
            solveVariation(n - 1, from, to, mid);
            System.out.printf("Move disk %d from %d → %d%n", n, from, mid);
            count++;
            solveVariation(n - 1, to, from, mid);
            System.out.printf("Move disk %d from %d → %d%n", n, mid, to);
            count++;
            solveVariation(n - 1, mid, from, to);
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print("Enter number of rings (negative to quit): ");
            int n = in.nextInt();
            if (n < 0) {
                System.out.println("Goodbye!");
                break;
            }

            count = 0; // reset count
            solveVariation(n, 1, 2, 3);
            System.out.printf("Number of moves (variation) = %d%n", count);
        }
        in.close();
    }
}

