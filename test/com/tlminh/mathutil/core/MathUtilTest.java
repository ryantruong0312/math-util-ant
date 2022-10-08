package com.tlminh.mathutil.core;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author tlminh
 */
public class MathUtilTest {
    
    // Ta đi test ngoại lệ, tức là so sánh/đo lường ngoại lệ có xuất hiện
    // hay k khi ta đưa data cà chớn, n < 0 || n > 20
    // thay vì so sánh expected value vs. actual value
    // LÚC NÀY TA SẼ ĐI SO SÁNH/ ƯỚC LƯỢNG XEM NGOẠI LỆ CÓ XUẤT HIỆN 
    // NHƯ KÌ VỌNG HAY KO, NẾU CÓ XH NHƯ KÌ VỌNG -> HÀM THIẾT KẾ NGON
    // NẾU NGOẠI LỆ NHƯ KÌ VỌNG, THÌ MÀU XANH
    @Test(expected = IllegalArgumentException.class)
    public void testFactorialGivenWrongArgumentThrowsException(){
        // Test case #7: Đưa data cà chớn, n âm, hoặc n quá lớn
        //               Hàm đc thiết kế ném về ngoại lệ!!
        // Thấy ngoại lệ xuất hiện như kì vọng -> test passed -> màu xanh
        System.out.println("Hope to see the Exception| Illegal Argument Exception");
        MathUtil.getFactorial(-5);
    }
    
    @Test
    public void testFactorialGivenRightArgumentReturnsWell2(){       
        // Test case #4: n = 3, hi vọng hàm trả về 6
        Assert.assertEquals(6, MathUtil.getFactorial(3));
        
        // Test case #5: n = 4, hi vọng hàm trả về 24
        Assert.assertEquals(24, MathUtil.getFactorial(4));
        
        // Test case #6: n = 5, hi vọng hàm trả về 120
        Assert.assertEquals(120, MathUtil.getFactorial(5));
    }
    
    
    @Test 
    // Coding convention
    // Tên hàm kiểm thử/tên hàm của test script
    // phải nói lên ý nghĩa của việc kiểm thử
    // tình huống này ta muốn test hàm getFactorial()
    // với tham số tử tế n = 0..20 !!!
    public void testFactorialGivenRightArgumentReturnsWell(){
        // Test case #1: n = 0, hi vọng hàm trả về 1
        //                      thực tế hàm trả về mấy, ai biết???
        long expected = 1;
        long actual = MathUtil.getFactorial(0);
        // so sánh expected vs. actual, máy tự so sánh, ko cần sout
        Assert.assertEquals(expected, actual);
        
        // Test case #2: n = 1, hi vọng hàm trả về 1
        Assert.assertEquals(1, MathUtil.getFactorial(1));
        
        // Test case #3: n = 2, hi vọng hàm trả về 1
        Assert.assertEquals(2, MathUtil.getFactorial(2));
    }
    
    // @Test ra lệnh cho thư viện JUnit mình đã add/import
    // tự động generate ra hàm public static void main()
    // biến hàm tryJUnitComparison() thành hàm main()
    // và gửi main() này cho JVM chạy - Java Virtual Machine
    // @Test ~~~ main()
    // Ko @Test thì class ko có main(), lấy gì mà chạy - no runnable method
    
    
    @Test
    public void tryJUnitComparison(){
        // hàm này thử nghiệm việc so sánh expected vs. actual
        // coi sai đúng ra màu thế nào!!
        // ta đang xài hàm của thư viện JUnit nhưng k xài bừa bãi
        // mà phải viết theo quy tắc định trước
        // quy tắc định trước nằm ở @ - annotation
        
        Assert.assertEquals(100, 100);
    }
}

// CLASS NÀY DEV SẼ VIẾT NHỮNG CÂU LỆNH DÙNG ĐỂ TEST HÀM
// CỦA CODE CHÍNH, TEST CÁC HÀM CỦA CLASS MathUtil
// Trog class này sẽ có những lời gọi hàm getFactorial()
// có những lệnh so sánh giữa EXPECTED vs ACTUAL
// giống như đã làm test ở bên Main
// nhưng khác chỗ, SAI -> màu đỏ, ĐÚNG -> màu xanh
// mắt không cần nhìn các dòng output từ hàm System.out cho mất sức
// mắt h chỉ nhìn 2 màu xanh đỏ
// Muốn có đc điều này ta sẽ dùng thêm các UNIT TESTING FRAMEWORK
// Ví dụ: JUnit,TestNG (Java)
//        xUnit,MSTest,NUnit (C#)
//        PHPUnit (PHP)
//        ...

// VIỆC VIẾT CODE ĐỂ TEST CODE GỌI LÀ UNIT TESTING
// ĐOẠN CODE TRONG CLASS NÀY DÙNG JUnit/UNIT TESTING METHOD
// ĐỂ KIỂM THỬ HÀM CỦA CODE CHÍNH
// ĐOẠN CODE KIỂM THỬ NÀY ĐƯỢC GỌI LÀ TEST SCRIPT
// Code dùng để test code (chính) đc gọi là TEST SCRIPT
// Test Script là các đoạn code được viết ra để test code chính (DAO
// DTO, Controller, API...)
// Muốn test thì cần phải phác thảo các TEST CASE
// Test Script sẽ sử dụng các Test Case
// Ví dụ: Viết code để test hàm getFactorial() với các case
// n = -5, 0, 1 ...


// QUY TẮC XANH ĐỎ:
// MÀU XANH KHI TẤT CẢ CÁC TEST CASE PHẢI CÙNG LÀ XANH, tức là
// EXPECTED == ACTUAL cho tất cả các case/tình huống test

// MÀU ĐỎ KHI CHỈ CẦN 1 TRONG NHỮNG TEST CASE, tức là
// chỉ cần 1 cái EXPECTED != ACTUAL, KẾT LUẬN MẠNH TAY HÀM SAI

// Ý nghĩa của quy tắc: Nếu đã test, nếu đã liệt kê các test case
// thì chúng phải đúng hết, chỉ cần 1 hàm sai -> hàm ko ổn định
// về việc return => hàm sai
// ĐÚNG ĐÚNG HẾT, SAI CHỈ CẦN 1 THẰNG

// EXPECTED == ACTUAL -> Case đúng, TEST CASE PASSED
// EXPECTED != ACTUAL -> CASE FAILED
    // NẾU EXPECTED LÀ CHÍNH XÁC, HÀM ĐÃ XỬ LÝ SAI -> BUG
    // CŨNG CÓ KHI EXPECTED/CÁI TA KÌ VỌNG BỊ SAI!!! LỖI DO 
    // DÂN QC TÍNH TOÁN BẰNG TAY BỊ SAI!!