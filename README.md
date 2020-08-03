# Snake-Game
## 뱀
BAEKJOON ONLINE JUDGE
3190번 문제


#### 문제
[https://www.acmicpc.net/problem/3190](https://www.acmicpc.net/problem/3190)
#### 풀이

`boardSize`는 N by N 보드의 N값이며,  `Snake` 는 뱀을 나타냈으며 뱀의 머리 좌표인 `Point point`,  머리 방향인 `char headDirection`, 이동 방향인 `char moveTo`를 가진다. 머리 방향과 이동 방향에 따라 실제로 움직이는 방향이 결정된다.
함수  `move`를 통해 이동한다.

사과의 위치는 `ArrayList<String> apples`에 *"x좌표 / y좌표"*의 형식으로 저장되며,  회전할 시점은 `ArrayList<Integer> timeOfCurve`에 저장한다.

`HashMap<Integer, Character> direction`은 회전할 시점과 회전 방향을 저장한다.

`int time`을 통해 이동한 횟수를 센다.
`ArrayList<String> snakeBody`를 통해 뱀의 몸통이 위치한 좌표들을 저장한다.

뱀이 자신의 몸 또는 벽에 부딪힐때까지 아래를 반복한다.

1. `time` 값이 `timeOfCurve` 내에  있는 경우, moveTo 값을 direction 내에서 매핑된 방향으로 정한 후 timeOfCurve 내에서 time 값을 삭제한다.
2. move 함수를 통해  이동한 후, 이동 방향을 다시 'H'로 바꿔 초기화 시킨다.
3. 자신의 몸통 또는 벽과 충돌난 경우,  반복문을 탈출한다.
4. 이동한 위치에 사과가 있는 경우 사과를 `ArrayList<String> apples`에서 삭제한 후, `snakeBody`에 뱀의 머리 좌표를 추가한다.
5. 이동한 위치에 사과가 없는 경우, `snakeBody`에서 뱀의 머리 좌표를 추가한 후, 뱀의 꼬리 좌표를 삭제한다.

