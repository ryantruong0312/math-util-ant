/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.tlminh.mathutil.core;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static com.tlminh.mathutil.core.MathUtil.*;

/**
 *
 * @author tlminh
 */

@RunWith(value = Parameterized.class)
public class MathUtilDDTTest {
    
    // 1. Chuẩn bị bộ data là mảng 2 chiều, 2 cột ứng với Expected và n
    //    các dòng ứng với các test case
    
    // mảng object, số thì dùng Wrapper class - class gói các primitive
    // Integer -> int, Long -> long
    @Parameterized.Parameters
    public static Object[][] initData(){
    // int a[] = {5,10,15,20,25}; //liệt kê các phần tử mảng cách nhau dấu phẩy
    // int b[][] = {{1,0}, {1,1}, {2,2}, {6,3}, {24,4}, {120,5}, {720,6}};
    // int c[][] = {{1,0}, 
    //              {1,1},
    //              {2,2},
    //              {6,3},
    //              {24,4},
    //              {120,5},
    //              {720,6}};
        return new Integer[][] {{1,0}, 
                                {1,1},
                                {2,2},
                                {6,3},
                                {24,4},
                                {120,5},
                                {720,6}};
    }
    // Ta sẽ map các cột của mỗi dòng, ví dụ dòng đầu tiên có 2 cột 
    // là 1 0 -> Ta sẽ ánh xạ 1 vào biến expected, 0 vào biến n
    // Tương tự cho các dòng còn lại
    
    @Parameterized.Parameter(value = 0)
    public long expected; // map vào cột 0 của mảng
    
    @Parameterized.Parameter(value = 1)
    public int n; // map vào cột 1 của mảng 
    
    @Test // Kiểm thử các test case với data đc trích ra từ mảng
          // và map vào 2 biến
    public void testFactorialGivenRightArgumentReturnsWell(){
        assertEquals(expected,getFactorial(n));
    }
}


/* Phân tích cách ta viết code cho phần test hàm getFactorial() hôm trc
   Assert.assertEquals(???, MathUtil.getFactorail(???)); 
   lệnh dùng để test hàm/method. Lệnh này lặp đi lặp lại cho các data ta đưa vào
   để ta kiểm tra các tình huống xài hàm/test case
   Lát hồi ta thay data 1 0 thành các data tương ứng khác
   Ví dụ:
    Expected    n!
        1       0  -> có ổn k
        1       1
        2       2
        6       3
        24      4      
        120     5 
        720     6
        ...
        [7][2]

   NẾU TA CÓ ĐC CÁCH NÀO ĐÓ MÀ TÁCH DATA RA RIÊNG 1 CHỖ SAU ĐÓ TỪ TỪ FEED
   DATA NÀY VÀO CÂU LỆNH TEST HÀM Ở TRÊN COI NHƯ CHỈ CẦN 1 LỆNH GỌI TEST HÀM,
   DATA CỨ THẾ TUẦN TỰ ĐẨY VÀO
   KĨ THUẬT ĐẨY/TÁCH DATA RA KHỎI CÁC CÂU LỆNH TEST, SAU ĐÓ NHỒI NÓ CÂU LỆNH
   TEST, GIÚP RÚT GỌN SỐ CÂU LỆNH TEST, GIÚP DỄ DÀNG KIỂM TRA TÍNH THIẾU ĐỦ CỦA
   CÁC TEST CASE
   KĨ THUẬT NÀY GỌI LÀ DDT - DATA DRIVEN TESTING
   Viết code kiểm thử hướng theo tách data
   CÒN GỌI 1 TÊN KHÁC LÀ: KIỂM THỬ THEO KIỂU THAM SỐ HÓA - PARAMETERIZE
   Dấu ??? ở câu lệnh gọi hàm chính là tên biến sẽ dùng để nhận
   data từ tập data đã tách ra - CONVERT DATA THÀNH BIẾN

   Chơi với DDT ta cần
    Bộ data test - tách riêng
    Các tham số ứng với bộ data - chính là các biến dùng trích data ra
    Gọi hàm kiểm thử xài các tham số
*/

// TOÀN BỘ CODE TRONG CLASS NÀY ĐC VIẾT RA DÙNG ĐỂ TEST CODE CHÍNH Ở TRONG 
// BÊN TRONG SRC PACKAGES
// CODE ĐC VIẾT RA DÙNG ĐỂ ĐI TEST CODE KHÁC
// THÌ CODE NÀY ĐC GỌI LÀ TEST SCRIPT
// 1 TEST SCRIPT SẼ CHỨA NHIỀU CODE ĐỂ TEST HÀM CHÍNH
// 1 TEST SCRIPT SẼ CHỨA NHIỀU TEST CASE (CÁC TÌNH HUỐNG XÀI HÀM)
// 1 TEST SCRIPT CÓ THỂ XÀI DDT ĐỂ DỄ BẢO TRÌ CODE TEST
// VIỆC VIẾT CODE CHÍNH CÓ THỂ XÀI TDD