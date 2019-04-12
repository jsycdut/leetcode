int recursion_binary_search(const int arr[], int start, int end, int key){
	if(start > end){
		return -1;
	}

	int mid = start + (end -start) / 2j;

	if(arr[mid] > key){
		loop_binary_search(arr, start, end - 1, key);
	}

	if(arr[mid] < key){
		loop_binary_search(arr, start + 1, end, key);
	}

	return mid;
}

int loop_binary_search(const int arr[], int start, int end, int key){
	int  mid = 0;

	while(start <= end){
		mid = start + (end - start) / 2;
		if(arr[mid] > key){
			end = mid -1;
		}else if(arr[mid] < key){
			start = mid + 1;
		}else{
			return mid;
		}
	}

	return -1;
}
