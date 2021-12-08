# week 4

big-o = give upper bound, which means to find the time complexity upper bound = worst case. <br>
big omega Ω = lower bound.<br>
big theta θ = upper bound and lower bound.<br>

θ(1) = upper & lower bound of time complexity of linear search, best case T(n)=a,<br>
θ(n) = worst case T(n)= an<br>
which means, ≤O(n), ≥Ω(1)<br>

O Ω θ

| Big-o   | informal name |
| ------- | ------------- |
| O(1)    | constant      |
| O(lgn)  | logarithmic   |
| O(n)    | linear        |
| O(nlgn) | nlogn         |
| O(n^2)  | quadratic     |
| O(n^3)  | cubic         |
| O(2^n)  | exponential   |

<br/>
<br/>

<center><b>The table shows the seven important functions with growth rate in ascending order</b></center>
<br/>

| n       | 33n        | 46nlog n  | 13n2      | 3.4n3     | 2n         |
| ------- | ---------- | --------- | --------- | --------- | ---------- |
| 1       | .00033 sec | .0015 sec | .0013 sec | .0034 sec | .001 sec   |
| 100     | .003 sec   | .03 sec   | .13 sec   | 3.4 sec   | 4x1014 sec |
| 1000    | .033 sec   | .45 sec   | 13 sec    | 0.94 hrs  | centuries  |
| 10,000  | 0.33 sec   | 6.1 sec   | 22 min    | 39 days   |            |
| 100,000 | 3.3 sec    | 1.3 min   | 1.5 days  | 108 years |            |

<br/>
if pop the empty stack= stack underflow<br/>
S.top exceeds n = stack overflow<br/>
example as follow shown the O(1) time:
<br/>
<br/>

```
STACK-EMPTY(S)
if S.top == 0 ;
    return TRUE;
else return FALSE;
```

<br/>

```
PUSH(S,x)
S.top = S.top + 1
S[S.top] = x
```

<br/>

```
POP(S)
if STACK-EMPTY(S)
    error "underflow"
else S.top = S.top - 1
    return S[S.top+1]
```

<br/>

successor = n-1 <br>
predecessor= n+1 <br>
Q.head = queue's head <br>
Q.tail = queue's tail, to be precisely, tail + 1 <br>
Q[1..8]:

```
| 1  |  2 |  3  |  4  |  5  |  6  |  7  |  8  |  9  |
|head|    |     |     |     |     |     |     | tail|
```

<br>
ENQUEUE = add <br>
DEQUEUE = remove <br>
When Q.head = Q.tail = queue empty, dequeue an element = underflow<br>
<br>

```
ENQUEUE(Q,x)
Q[Q.tail] = x
if Q.tail == Q.length
    Q.tail = 1 //tail end, start from 1
else Q.tail = Q.tail + 1
```

```
DEQUEUE(Q)
x = Q[Q.head]
if Q.head == Q.length
    Q.head = 1 // head already end, start from 1
else Q.head = Q.head + 1
return x
```

<br>
