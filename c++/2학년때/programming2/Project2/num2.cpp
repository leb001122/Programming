#include <iostream>
using namespace std;

int getFactorial(int n);

int main()
{
	int input;
	cout << "<factorial 구하기>\n숫자 입력 : ";
	cin >> input;
	cout << input << "! = " << getFactorial(input) << endl;

	return 0;
}

int getFactorial(int num)
{
	int result = 1;
	while (num > 1)
	{
		result *= num;
		num--;
	}
	return result;

	// 무한대 입력에 대해 올바른 결과를 출력할 수 있는 방법?
	// 곱한 결과를 정수 타입 변수에 저장하지 않고 배열에 저장하여 값을 구한다.
	// 예를 들어 49!에서 50 * 49을 구할 때 두 수를 한 배열에 5, 0을 저장하고
	// 48을 또 다른 배열에 4,9을 저장한다.
	// 5 * 4 -> 5 * 9 -> 0 * 4 -> 0 * 9 순서대로 곱하면서 더해갈건데
	// 5 * 4를 결과배열에 앞에서부터 한자리 씩 2, 0을 저장하고
	// 그 다음 5 * 9는 4, 5를 인덱스 1부터 이미 저장된 2,0에 더한다.
	// 그 결과 배열에는 2, 4, 5가 저장될 것이다.
	// 0 * 4 = 0을 인덱스 1부터 배열에 더하고, ( 정확히 말하면 0, 0을 더함)
	// 0 * 9 = 0을 인덱스 2부터 배열에 더한다. ( 마찬가지로 0, 0을 더함)
	// 만약 더하는 과정에서 올림이 발생하면 이전 인덱스의 값을 하나 증가시킨다.
	// 다음의 과정을 모두 거치면 배열에는 2,4,5,0이라는 값이 저장되어 있는데
	// 이 배열과 4,8이 저장된 배ㄴ열을 위의 과정을 거치고 이 과정을 1이 나올때까지 반복한다.
}