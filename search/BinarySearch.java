public class BinarySearch{
	public int binarySearch(int[] a, int left, int right, int key){
		int mid = 0;
		while(left <= right){
			mid = left + (right - left) / 2;
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
}
