#  MCON 264 — Recursion Assignment: Towers of Hanoi × 3


##  Overview

In this lab, you implemented three recursive versions of the Towers of Hanoi problem and (optionally) one iterative version.  
Each part reinforces a key concept of recursion — base case, recursive case, and growth pattern — and illustrates how recursion can be refactored or replaced by iteration.

---

## Part 1 — Classic Towers of Hanoi (`TowersOfHanoi.java`)

### 1. Base Case
_Describe the base condition that stops recursion (for example, what happens when `n == 0`?)._

> ✎ Your answer here
when n==0 it means that there are no more disks on the peg so nothing else needs to be moved so it means that everything is in place. 
### 2. Recursive Case
_Explain the sequence of recursive calls and what each represents._

> ✎ Your answer here
solve(n-1, from, to, aux, moves); this takes the next disk and moves from its current peg to the middle peg B
>     solve(n-1, aux, from, to, moves); this takes the disk that is on the middle peg and moves it to the  peg C

### 3. Sample Trace (for n = 3)

| Move # | From |  To  |
|:------:|:----:|:----:|
|   1    |  A   |  C   |
|   2    |  A   |  B   |
|   3    |  C   |  B   |
|   4    |  A   |  C   |
    5       B       A
    6       B       C
    7       A       C
_Total moves = 2ⁿ − 1 = 7 (for n = 3)_

---

## Part 2 — Counting Moves (`TowersExercise21.java`)

### 1. Approach
_How did you modify the standard recursion to count rather than print moves?_

>  Your answer here
I added a variable to be incrimented every take we entered the else statement and moved a disk
### 2. Verification of Formula
_Complete the table and verify that count = 2ⁿ − 1._

| n | Expected (2ⁿ − 1) | Program Output | Matches? (Y/N) |
|:--:|:--:|:--------------:|:--------------:|
| 1 | 1 |       1        |       Y        |
| 2 | 3 |       3        |       Y        |
| 3 | 7 |       7        |       Y        |
| 4 | 15 |       15       |       Y        |
| 5 | 31 |       31       |       Y        |
    6   63      63                  Y
    7   127     127                 Y
### 3. Reflection
_What changes when you replace printed moves with a counter? What are the pros and cons?_

> ✎ Your answer here
a pro is that you can see how many times you moved but you cant see clearly all the moves taking place
---

## Part 3 — Hanoi Variation (`TowersVariations.java`)

### 1. New Rule
_Every move must pass through the middle peg. How does this alter the recursion?_

> ✎ Your answer here
because now there is an added task that must be done every time the recusrion  is called
### 2. Observed Move Counts

| n | Expected ≈ 3ⁿ − 1 | Program Output | Matches? (Y/N) |
|:--:|:--:|:--------------:|:--------------:|
| 1 | 2 |       2        |       y        |
| 2 | 8 |       8        |       y        |
| 3 | 26 |       26       |       y        |
| 4 | 80 |       80       |       y        |

### 3. Analysis
_Why does this variation grow faster than the standard version? How do additional move constraints affect complexity?_

> ✎ Your answer here
Because each move now requires two sub-moves through the middle peg, the total number of operations grows.
> Adding more restrictions increases the exponential growth rate and thus the time complexity---

## Comparative Analysis

### 1. Growth Patterns

| Version | Approx. Formula | Growth Type |
|:--|:--|:--|
| Standard | 2ⁿ − 1 | Exponential |
| Variation | 3ⁿ − 1 | Exponential (faster) |
| Iterative (Optional) | 2ⁿ − 1 | Same as recursive but loop based |

### 2. Stack Depth and Memory
_Estimate the maximum recursion depth before StackOverflowError and discuss how stack size (–Xss flag) affects this._

> ✎ Your answer here
the maximum recursion depth is however big the stack is. the bigger the stack size the more depth it can hole before it throws a stack overflow. 
---


I wrote this code myslef:
TowersExercise21 but chatGPT told me that i did my count++ wrong because i orginally did 1 after each statement but really only needed one

I wrote this code myself:
TowersOfHanoi

ChatGPT helped me with this code: solveVariation

I undertsand all the concepts but I am still very confused on all the meaning and how the code runs. 
## Part 4 — Beyond Recursion (Extra Credit)

### Iterative / Explicit-Stack Version (`TowersIterative.java`)

1. How does your iterative version simulate recursion?
2. How did you track pending calls or frames?
3. Which version (r vs iterative) is clearer? Why?

> ✎ Your answer here

---

## Discussion &amp; Reflection

1. What three questions can you use to verify a recursive solution works?
2. How do the base case and recursive case cooperate to guarantee termination?
3. What is the trade-off between elegance and efficiency in recursion?

> ✎ Your answers here

---

## References (APA or MLA format)

- Dale, N., Joyce, D., &amp; Weems, C. (2016). *Object-Oriented Data Structures Using Java* (Ch. 3 Recursion). Jones &amp; Bartlett.
- Additional videos or websites you consulted (YouTube CS50 Recursion, GeeksForGeeks Hanoi, etc.)

---

 **Submission Checklist**

- [ ] `TowersOfHanoi.java` — implemented and tested
- [ ] `TowersExercise21.java` — counts moves correctly
- [ ] `TowersVariations.java` — middle-peg constraint implemented
- [ ] (Extra Credit) `TowersIterative.java` — loop or explicit stack solution
- [ ] All JUnit tests pass (green on GitHub Actions)
- [ ] This `ANSWERS.md` file completed and committed to repo  
