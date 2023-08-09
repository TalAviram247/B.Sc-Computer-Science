class SumArray {

    public static void main(String args[]) {
        // Put your testing here. For example:
        int a[] = { 1, 2, 3, 4 };
        int b[] = { 1, 2, 3, 4, 28, 100};
        System.out.println(sumArr(a));
        System.out.println(sumArr(b));
    }

    // Returns the sum of the elements in the given array.
    public static int sumArr(int arr[]) { 
        // Replace the following statement with your code:
        if (arr.length == 1){
            return arr[0];
        }else{
            return sumArr(arr,arr.length-1) + arr[arr.length-1];
        }
    }
  
    // Returns the sum of the elements in the given array, up to, and including, element n.
    // Assumes that n is nonnegative.
    private static int sumArr(int arr[], int n) {
        // Replace the following statement with your code:
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];

        }
        return sum;
    } 
} 