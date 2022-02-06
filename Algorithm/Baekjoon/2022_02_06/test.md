[DP 개념 바로가기](https://velog.io/@gandi0330/Python-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%8F%99%EC%A0%81%EA%B3%84%ED%9A%8D%EB%B2%95-Dynamic-Programming)

> 문제

다음 소스는 N번째 피보나치 수를 구하는 C++ 함수이다.
```python
int fibonacci(int n) {
    if (n == 0) {
        printf("0");
        return 0;
        
    } else if (n == 1) {
        printf("1");
        return 1;
        
    } else {
        return fibonacci(n‐1) + fibonacci(n‐2);
    }
}
```

fibonacci(3)을 호출하면 다음과 같은 일이 일어난다.

- fibonacci(3)은 fibonacci(2)와 fibonacci(1) (첫 번째 호출)을 호출한다.
- fibonacci(2)는 fibonacci(1) (두 번째 호출)과 fibonacci(0)을 호출한다.
- 두 번째 호출한 fibonacci(1)은 1을 출력하고 1을 리턴한다.
- fibonacci(0)은 0을 출력하고, 0을 리턴한다.
- fibonacci(2)는 fibonacci(1)과 fibonacci(0)의 결과를 얻고, 1을 리턴한다.
- 첫 번째 호출한 fibonacci(1)은 1을 출력하고, 1을 리턴한다.
- fibonacci(3)은 fibonacci(2)와 fibonacci(1)의 결과를 얻고, 2를 리턴한다.

1은 2번 출력되고, 0은 1번 출력된다. N이 주어졌을 때, fibonacci(N)을 호출했을 때, 0과 1이 각각 몇 번 출력되는지 구하는 프로그램을 작성하시오.

<br>
<br>

> 입력

첫째 줄에 테스트 케이스의 개수 T가 주어진다.

각 테스트 케이스는 한 줄로 이루어져 있고, N이 주어진다. N은 40보다 작거나 같은 자연수 또는 0이다.

<br>
<br>

> 출력

각 테스트 케이스마다 0이 출력되는 횟수와 1이 출력되는 횟수를 공백으로 구분해서 출력한다.

<br>
<br>

> 접근 방식


먼저 fibonacci를 5 정도 까지 계산하고 fibonacci(0)과 fibonacci(1)이 얼마나 호출되는지 계산해보자

|  | cnt_0 | cnt_1 |
|:----------:|:----------:|:----------:|
| fibonacci(0) | 1 | 0 |
| fibonacci(1) | 0 | 1 |
| fibonacci(2) | 1 | 1 |
| fibonacci(3) | 1 | 2 |
| fibonacci(4) | 2 | 3 |
| fibonacci(5) | 3 | 5 |

fibonacci(5)는 fibonacci(4)와 fibonacci(3)을 호출하므로 결국 각각의 cnt_0과 cnt_1을 더해주면 된다 (fibonacci(4) + fibonacci(3) -> [1+2 , 2+3] => [3,5])


dp테이블을 2차원 리스트로 만들어 주고 0과 1만 [1,0] , [0,1] 로 정의해준 후 나머지는 반복문을 통해 bottom-up 방식을 사용하면 해결할 수 있다.

<br>
<br>

>코드

```python
import sys
n = int(sys.stdin.readline())

for _ in range(n):

    num = int(sys.stdin.readline())

    d = [[0, 0]] * 41 # dp table (입력값이 0부터 40까지라 41개를 만들어줘야한다)

    d[0] = [1, 0]
    d[1] = [0, 1]

    for i in range(2, num+1) : #fibonacchi(2) 부터 fibonacchi(num)까지 올라가며 계산한다
        d[i] = [d[i-1][0] + d[i-2][0] , d[i-1][1] + d[i-2][1]]

    print(d[num][0], d[num][1])


```

