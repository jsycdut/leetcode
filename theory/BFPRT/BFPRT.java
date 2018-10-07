public class BFPRT{
	
	public void swap(int[] a, int i, int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public void sort(int[] a, int left, int right){
		for(int i = 1; i < a.length; i++){
			for(int j = i; j > 0; j-- ){
				if(a[j] < a[j - 1]){
					swap(a, j, j - 1);
				}
			}
		}
	}

	public int partition(int[]a, int left, int right, int pivotIndex){
		int pivotValue = a[pivotIndex];
		swap(a, left, pivotIndex);
		while(left < right){
			while(left < right && a[right] >= pivotValue){
				right--;
			}
			if(left < right){
				a[left++] = a[right];
			}
			while(left < right && a[left] <= pivotValue){
				left++;
			}
			if(left < right){
				a[right--] = a[left]; 
			}
		}
		a[left] = pivotValue;
		return left;
	}

	public int search(int[]a, int left, int right, int k){
		if(a == null || k < 0 || left > right){
			return -1;
		}	
		final int GROUP_SIZE = 5;
		if(a.length <= GROUP_SIZE){
			sort(a, left, right);
			return left + k - 1;
		}
		int length = a.length;
		int groups = length % GROUP_SIZE == 0 ? length / GROUP_SIZE : length / GROUP_SIZE + 1;
		for(int i = 0; i < groups; i++){
			int subLeft = GROUP_SIZE * i;
			int subRight = subLeft + GROUP_SIZE - 1;
			if(subRight > right){
				subRight = right;
			}
			sort(a, subLeft, subRight);
			int medianIndex = subLeft + ((subRight - subLeft) >> 1); 
			swap(a, i, medianIndex);
		}
		int pivotIndex = left + ((groups - 1) >> 1);
		search(a, left, left + groups - 1, ((groups + 1) >> 1));
		int ans = partition(a, left, left + groups -1, pivotIndex);
		int iMax = ans - left + 1;
		if(iMax > k){
			search(a, left, iMax - 1, k);
		}else if(iMax < k){
			search(a, iMax + 1, right, k - iMax);
		}else{
			return ans;
		}
	}	
}
