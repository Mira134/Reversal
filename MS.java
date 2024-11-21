import java.io.*;

class MS{
    //Merges two subarrays of arr[]
    //First subarray is [l..m]
    //Second subarray is[m+1..r]

    void merge(int arr[],int l,int m,int r){
        //Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        //Create temp arrays
        int L[] = new int[n1];
        int R[] = new int[n2];

        //Copy data to temp arrays
        for(int i = 0;i < n1;++i){
            L[i] = arr[l + i];
        }
        for(int j = 0;j < n2;++j){
            R[j] = arr[m + 1 + j];
        }
        //Merge temp arrays

        int i = 0, j = 0;
        int k = l;
        while(i < n1 && j < n2){
            if(L[i] <= R[j]){
                arr[k] = L[i];
                i++;
            }
            else{
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        //Copy elements of L[] if any
        while(i < n1){
            arr[k] = L[i];
            i++;
            k++;
        }
        //Copy elements of R[] if any
        while(j < n2){
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    //Main function that sorts arr[l..r] using
    //Merge()
    void sort(int arr[],int l,int r){
        if(l < r){
            int m = l + (r - l) / 2;

            sort(arr,l,m);
            sort(arr,m + 1,r);
            merge(arr,l,m,r);
        }
    }
    static void printArray(int arr[]){
        int n = arr.length;
        for(int i = 0;i < n;++i){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String args[]){
        int arr[] = {89,67,45,23};
        System.out.println("Given array is ");
        printArray(arr);

         MS ob = new MS();
         ob.sort(arr,0,arr.length - 1);

        System.out.println("\n Sorted array is");
        printArray(arr);
    }
}