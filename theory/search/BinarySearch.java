public class BinarySearch{
	public int loopBinarySearch(int[] a, int left, int right, int key){
		int mid = 0;
		while(left <= right){
			mid = (left + right) >>> 1;
			if(a[mid] > key){
				right = mid - 1;
			}else if(a[mid] < key){
				left = mid + 1;
			}else{
				return mid;
			}
		}
		return -1;
	}

	public int recursionBinarySearch(int[]a, int left, int right, int key){
        if (left > right) return -1;

		int mid = left + (right - left) / 2;
		if(a[mid] > key){
			return recursionBinarySearch(a, left, right -1 , key);
		}
		if(a[mid] < key){
			return recursionBinarySearch(a, left + 1, right, key);
		}
		return mid;
	}
}
