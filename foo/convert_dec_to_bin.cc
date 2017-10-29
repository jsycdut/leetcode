#include <iostream>
#include <stack>
using namespace std;

int main()
{
	int input;
	int radix;
	stack<int> my_stack;
	cout << "please enter the target number: " << endl;
	cin >> input;
	if(input < INT_MIN || input > INT_MAX)
	{
		cout << "input exceed, gonna exit."<<endl;
		return 0;
	}
	cout << "please enter the radix you want: "<< endl;
	cin >> radix;
	while(input)
	{
		int n = input % radix;
		my_stack.push(n);
		input = input / radix;
	}

	cout << "your result is: "<< endl;
	while(!my_stack.empty())
	{
		cout << my_stack.top(); 
		my_stack.pop();
	}
	cout << endl;
	return 0;
}
