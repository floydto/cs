# week 4 exercises

[[week1]]
[[week2]]
[[week3]]
[[week4]]
[[week5]]
[[week6]]
[[week7]] 

There are two parts to this exercise:

Write an algorithm which takes an array of n integers as input and output the maximum element of the list.
Analyse its time complexity and express it using asymptotic notations.>
When you've finished, be prepared to share both your algorithm and notations with your group on the discussion board for their feedback. You'll also be asked to read through other people's solutions and provide some feedback.

| Line | Max(A)               | Cost | Worst Time | Best Time | Note                                                          |
| ---- | -------------------- | ---- | ---------- | --------- | ------------------------------------------------------------- |
| 1    | MaxInt = A[1]        | c1   | 1          | 1         | //   the first index of array starts with 1, not 0 as in java |
| 2    | index = 2            | c2   | 1          | 1         |                                                               |
| 3    | while index ≤ n      | c3   | n          | n         | // condition is checked n-times                               |
| 4    | if MaxInt < A[index] | c4   | n-1        | n-1       | // the line does not run for   index  = n+1                   |
| 5    | MaxInt = A[index]    | c5   | n-1        | 0         | // in best case, line 4 is   always FALSE                     |
| 6    | index = index+1      | c6   | n-1        | n-1       |                                                               |
| 7    | return MaxInt        | c7   | 1          | 1         |                                                               |

