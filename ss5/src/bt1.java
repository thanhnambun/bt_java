

public class bt1 {
    public static void main(String[] args) {
        int [] arr = {10,20,30,5,50};
        int max=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        System.out.printf("max=%d",max);
    }
}
