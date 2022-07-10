1107번 리모컨
===

### 문제

수빈이는 TV를 보고 있다. 수빈이는 채널을 돌리려고 했지만, 버튼을 너무 세게 누르는 바람에, 일부 숫자 버튼이 고장났다.

리모컨에는 버튼이 0부터 9까지 숫자, +와 -가 있다. +를 누르면 현재 보고있는 채널에서 +1된 채널로 이동하고, -를 누르면 -1된 채널로 이동한다. 채널 0에서 -를 누른 경우에는 채널이 변하지 않고, 채널은 무한대 만큼 있다.

수빈이가 지금 이동하려고 하는 채널은 N이다. 어떤 버튼이 고장났는지 주어졌을 때, 채널 N으로 이동하기 위해서 버튼을 최소 몇 번 눌러야하는지 구하는 프로그램을 작성하시오. 

수빈이가 지금 보고 있는 채널은 100번이다.

### 입력

첫째 줄에 수빈이가 이동하려고 하는 채널 N (0 ≤ N ≤ 500,000)이 주어진다.  둘째 줄에는 고장난 버튼의 개수 M (0 ≤ M ≤ 10)이 주어진다. 고장난 버튼이 있는 경우에는 셋째 줄에는 고장난 버튼이 주어지며, 같은 버튼이 여러 번 주어지는 경우는 없다.

### 출력

첫째 줄에 채널 N으로 이동하기 위해 버튼을 최소 몇 번 눌러야 하는지를 출력한다.

<br>

문제 링크 : https://www.acmicpc.net/problem/1107

<hr>

### 풀이

가능성 있는 모든 채널을 탐색해보는 방법으로 해결할 수 있다.

문제의 입력은 다음과 같이 받았다.

~~~java
static final int MAX =500000;
static int target;
static boolean[] button;

public static void main(String[] args) throws Exception {
	...
	StringTokenizer st;

	button =new boolean[10];
	Arrays.fill(button, true);

	target =Integer.parseInt(br.readLine());
	if(Integer.parseInt(br.readLine()) !=0) {
		st =new StringTokenizer(br.readLine());
		while(st.hasMoreTokens())
			button[Integer.parseInt(st.nextToken())] =false;
	}
	...
}

~~~

위 코드에서 button이라는 boolean 배열은 고장 난 버튼을 확인하는 용도이다. 고장이면 false가 입력되도록 해줬다. <br>
여기서 주의해 줘야 할점은 고장 난 버튼의 수가 0개일 수 있다는 것이다. <br>

다음 코드는 버튼을 최소한 몇 번 눌러야 되는지 탐색하는 코드이다.

~~~java
int solve() {
	int ret =Math.abs(target-100);		//+,- 버튼으로만 최소인 경우.

	for(int i =0; i <10; i++)			//숫자버튼 누르는 경우.
		if(button[i]) ret =Math.min(ret, pressButton(i) +1);

	return ret;
}

int pressButton(int curChannel) {
	if(curChannel >MAX*10) return MAX;
	if(curChannel ==target) return 0;

	int ret =Math.abs(target-curChannel);

	for(int i =0; i <10; i++)
		if(curChannel !=0 && button[i]) ret =Math.min(ret, pressButton(curChannel*10 +i) +1);
	
	return ret;
}
~~~

고려해야 할 점은 숫자 버튼을 누르는 것뿐만 아니랄 +,-버튼만 눌러서 최소인 경우를 만들 수 있다는 것이다. <br>
그래서 solve() 함수의 시작 부분에 Math.abs(target-100)으로 시작한 것이다. <br>
그다음으로 숫자를 눌러서 최소가 될 수 있는지 확인한다.

pressButton() 함수는 현재 채널에서 +,- 버튼을 누르거나 새로운 숫자 버튼을 누르는 동작을 하는 함수다. <br>
int ret =Math.abs(target-curChannel);은 현재 채널에서 +,-버튼을 눌러서 최소한의 버튼 누름으로 갈 수 있는지 확인하는 부분이다. <br>
그 밑에 Math.min(ret, pressButton(curChannel*10+i) +1);은 숫자 버튼을 최소한으로 눌러서 원하는 채널로 갈 수 있는지 확인하는 부분이다.

함수의 기저 사례에 범위를 많이 벗어나는 경우를 예외 처리해 주었다. <br>
채널의 최대 범위인 500000으로 해주지 않은 이유는 500000보다 큰 숫자에서 -버튼으로 원하는 채널에 갈 수 있기 때문이다.