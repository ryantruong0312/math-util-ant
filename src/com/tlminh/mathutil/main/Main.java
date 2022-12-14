/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tlminh.mathutil.main;

import com.tlminh.mathutil.core.MathUtil;

/**
 *
 * @author tlminh
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("This statement comes from the main() method");
        tryTDDFirst();
        //testFactorialGivenWrongArgumentThrowsException();
        
    }
    
    public static void testFactorialGivenWrongArgumentThrowsException(){
        // Test case #3: Đưa data cà chớn, n âm, hoặc n quá lớn
        //               Hàm đc thiết kế ném về ngoại lệ!!
        // Thấy ngoại lệ xuất hiện như kì vọng -> test passed -> màu xanh
        System.out.println("Hope to see the Exception| Illegal Argument Exception");
        MathUtil.getFactorial(-5);
    }
    
    // hàm này để dùng thử kĩ thuật viết code kiểu TDD
    // gọi thử/dùng thử hàm chính bên core/bên MathUtil 
    // xem nó sai đúng ra sao, ở ngay mức khởi đầu viết hàm
    public static void tryTDDFirst(){
        // Test case #1 (tình huống kiểm thử hàm số 1/xài thử hàm lần 1):
        // - Input: n = 1;
        // - Gọi hàm getFactorial(1)
        // - Hy vọng hàm trả về 1, vì 1! = 1
        long expected = 1;
        long actual = MathUtil.getFactorial(1);
        // so sánh expected vs. actual xem giống nhau ko?
        // giống -> hàm đúng với case đang test
        // sai -> bug rồi!! với case đang test
        System.out.println("Test 1! | status: " +
                                "Expected: " + expected +
                                " | Actual: " + actual);
        
        
        // Test case #2 (tình huống kiểm thử hàm số 2/xài thử hàm lần 2):
        // - Input: n = 2;
        // - Gọi hàm getFactorial(2)
        // - Hy vọng hàm trả về 2, vì 2! = 2
        System.out.println("Test 2! | status: " +
                                "Expected: " + 2 +
                                " | Actual: " + MathUtil.getFactorial(2));
    }
    
}


// TEST CASE LÀ GÌ ?
// Là 1 tình huống xài app/kiểm thử app/kiểm thử tính năng/màn hình
// chức năng/xử lý của app
// Test case là tình huống kiểm thử app/chức năng mà khi đó
// ta phải 
// - đưa vào data giả/mẫu/test,
// - đưa ra giá trị kì vọng ta mong chờ app trả ra
// sau đó chờ hàm/tính năng xử lý xong trả kết quả!!
// và ta nhìn vào kết quả và ta so sánh với kì vọng trước đó!!
// để kết luận hàm ổn/tính năng ổn, TEST CASE PASSED
//                                  TEST CASE FAILED