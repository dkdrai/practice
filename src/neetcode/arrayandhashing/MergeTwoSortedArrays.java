package neetcode.arrayandhashing;

public class MergeTwoSortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int [] mergeArrays(int arr1[], int arr2[]) {
		if(arr1.length ==0 && arr2.length==0) {
			return arr1;
		}
		if(arr1.length==0) {
			return arr2;
		}
		if(arr2.length ==0) {
			return arr1;
		}
		int i =0; 
		int j = 0;
		int mergeArray[] = new int[arr1.length+arr2.length];
		int  k =0;
		while(i<arr1.length && j<arr1.length) {
			if(arr1[i]<arr2[j]) {
				mergeArray[k] = arr1[i];
				i++;
			}else {
				mergeArray[k] = arr2[j];
				j++;
			}
			k++;
		}
		if(i<arr1.length) {
			while(i<arr1.length) {
				mergeArray[k] = arr1[i];
				i++;
				k++;
			}
		}
		if(j<arr2.length) {
			while(i<arr2.length) {
				mergeArray[k] = arr2[j];
				j++;
				k++;
			}
			}
		return arr2;
		
	}

}
