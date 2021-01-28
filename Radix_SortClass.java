/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btec.fpt.edu.vn.radixsort2;

/**
 *
 * @author Group2.
 */
import java.util.*;
import java.io.*;

public class Radix_SortClass {
    public static void main(String[] args) {
        int arr [] = {40, 25, 206, 65, 457, 4, 81, 74, 58, 6};
        int n = arr.length;  
        
        radixsort(arr, n);
        print(arr, n);
    }
    // lấy phần tử tối đa trong mảng
    static int getMaxElementInArray(int arr [], int n){
        int max = arr[0];
        for(int i = 1; i < n; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }
    // Một hàm để thực hiện sắp xếp đếm arr [] theo
    // khai báo position : khai báo số có nghĩa nhỏ nhất
    static void count(int arr[], int n, int position){
       int output[] = new int [n]; // mảng đầu ra
       int i ;
       int count[] = new int [10];
       Arrays.fill(count, 0);
       
       // Lưu trữ số lần xuất hiện được đếm []
       for(i = 0; i < n; i++)
           count[(arr[i] / position) % 10]++;
        
       
        // Thay đổi số lượng [i] để số lượng [i] hiện chứa
        // vị trí thực tế của chữ số này trong đầu ra []
        for(i = 1; i < 10; i ++)
            count[i] += count[i-1]; // cộng và gán giá trị
        
        //xây dựng các mảng đầu ra
        for(i = n-1; i >= 0; i--){
            output[count[(arr[i] / position) % 10] - 1] = arr[i]; 
            count[(arr[i] / position) % 10]--; 
        } 
        // Sao chép mảng đầu ra vào arr [], để arr [] bây giờ
        // chứa các số được sắp xếp theo chữ số hiện tại
        for( i =0; i < n; i++){
            arr[i] = output[i];
        }
    }
    //Hàm chính sắp xếp arr [] có kích thước n bằng cách sử dụng
    // Sắp xếp theo Radix
    static void radixsort(int arr[], int n){
        //Tìm số lớn nhất biết số chữ số
        int max = getMaxElementInArray(arr, n);
        //Thực hiện sắp xếp đếm cho mọi chữ số. Lưu ý rằng
        // thay vì chuyển số chữ số, position được chuyển.
        for(int position = 1; max / position > 0; position *=10)
            count(arr, n, position); 
    }  
    static void print(int arr[], int n){
        for(int i =0; i< n; i++)
           System.out.print(arr[i] + ",");
    }
}
