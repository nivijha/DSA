package Sort;

public class MergeSort {
    public static void mergeSort(int arr[], int si, int ei){
        if( si >= ei){
            return;
        }
        int mid = si + (ei-si)/2;
        mergeSort(arr, si, mid);//leftarray
        mergeSort(arr, mid+1, ei);//rightarray
        merge(arr, si, mid, ei);
    }

    //merge method to merge the sorted parts
    public static void merge(int arr[], int si, int mid, int ei){
        int temp[]= new int[ei-si+1];
        int i = si;//iterator for left part array
        int j = mid+1;//iterator for right part array
        int k = 0;//iterator for temp array

        while(i <=mid && j<=ei){
            if(arr[i]>arr[j]){
                temp[k]=arr[j];
                j++;
            }
            else{
                temp[k]=arr[i];
                i++;
            }
            k++;
        }

        //leftover elements in left part
        while(i<=mid){
            temp[k++]=arr[i++];
        }
        //leftover elements in right part
        while(j<=ei){
            temp[k++]=arr[j++];
        }
        //copy temp to original arr
        for(k=0, i=si; k<temp.length; k++, i++){
            arr[i]=temp[k];
        }
    }

    public static void printArr(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int arr[]={6,3,9,5,2,8};
        mergeSort(arr, 0, arr.length-1);
        printArr(arr);
    }
}
