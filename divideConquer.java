1. count inversion
利用merge sort的思路，先把array分成两个，然后recursion分别算出两个array的count记为a,b，然后再把它们放一起，算最终结果a+b+c
c的具体计算方法就是把两个array放到一起，然后像要sort一样，把第二个array中的值放过来的时候就check一下第一个array中剩余的比这个值大的值的个数
public static int count(int[] A){
	if(A == null || A.length <= 1){
		return 0;
	}
	return count(A, 0, A.length - 1);
}
private static int count(int[] A, int start, int end){
	if(A == null || A.length <= 1){
		return 0;
	}
	if(start >= end){
		return 0;
	}
	int x = count(A, start, (start + end)/2);
	int y = count(A, (start + end)/2 + 1, end);
	int z = countSplit(A, start, (start + end)/2, (start + end)/2 + 1, end);
	return x + y + z;
}
private static int countSplit(int[] A, int startB, int endB, int startC, int endC){
	if(A == null || A.length <=1){
		return 0;
	}
	if(startB > endB || startC > endC){
		return 0;
	}
	int b = startB;
	int c = startC;
	int result = 0;
	while(b <= endB && c <= endC){
		if(A[b] < A[c]){
			b++;
		}
		else{
			c++;
			result += (endB - b + 1);
		}
	}
	return result;
}