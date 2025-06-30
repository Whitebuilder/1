import java.util.ArrayList;
import java.util.Collections;
class Result {
ArrayList<Integer> array;
int product;
Result(ArrayList<Integer> array, int product) {
this.array = array;
this.product = product;
}
}
public class Main {
public static Result processArray(ArrayList<Integer> A) {
if (A.size() == 0) return new Result(A, 0);
int maxIdx = A.indexOf(Collections.max(A));
int minIdx = A.indexOf(Collections.min(A));
// Swap элементов
int temp = A.get(maxIdx);
A.set(maxIdx, A.get(minIdx));
A.set(minIdx, temp);
// Обновляем индексы после обмена
int tempIdx = maxIdx;
maxIdx = minIdx;
minIdx = tempIdx;
int left = Math.min(minIdx, maxIdx);
int right = Math.max(minIdx, maxIdx);
int product = 1;
boolean found = false;
for (int i = left + 1; i < right; i++) {
if (A.get(i) > 0) {
product *= A.get(i);
found = true;
}
}
if (!found) product = 0;
return new Result(A, product);
}
public static void main(String[] args) {
ArrayList<Integer> A = new ArrayList<>();
A.add(3); A.add(-2); A.add(5); A.add(1); A.add(-4); A.add(6);
Result result = processArray(A);
System.out.print("Изменённый массив: ");
for (int val : result.array) {
System.out.print(val + " ");
}
System.out.println("\nПроизведение положительных: " + result.product);
}
} 
