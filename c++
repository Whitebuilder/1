#include <iostream>
#include <vector>
#include <utility>
using namespace std;
pair<vector<int>, int> processArray(vector<int> A) {
int n = A.size();
if (n == 0) return {A, 0};
int maxPos = 0, minPos = 0;
for (int i = 1; i < n; i++) {
if (A[i] > A[maxPos]) maxPos = i;
if (A[i] < A[minPos]) minPos = i;
}
swap(A[maxPos], A[minPos]);
int temp = maxPos;
maxPos = minPos;
minPos = temp;
int left = min(maxPos, minPos);
int right = max(maxPos, minPos);
int product = 1;
bool hasPositive = false;
for (int i = left + 1; i < right; i++) {
if (A[i] > 0) {
product *= A[i];
hasPositive = true;
}
}
if (!hasPositive) product = 0;
return {A, product};
}
int main() {
vector<int> A = {3, -2, 5, 1, -4, 6};
auto result = processArray(A);
cout << "Изменённый массив: ";
for (int val : result.first) {
cout << val << " ";
}
cout << "\nПроизведение положительных: " << result.second << endl;
return 0;
}
