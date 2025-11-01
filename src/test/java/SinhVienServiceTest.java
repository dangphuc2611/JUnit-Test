import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.example.SinhVien;
import com.example.SinhVienService;

public class SinhVienServiceTest {
    SinhVienService service = new SinhVienService();
    SinhVien sv = new SinhVien("SV01", "Quỳnh Trang", 20, 8.0f, 3, "Marketing");

    // ✅ Test 1: Sửa điểm hợp lệ (phân vùng tương đương)
    @Test
    void testSuaDiem_HopLe() {
        boolean result = service.suaDiem(sv, 9.5f);
        assertTrue(result);
        assertEquals(9.5f, sv.getDiemTrungBinh());
    }

    // ✅ Test 2: Điểm dưới biên (newDiem < 0)
    @Test
    void testSuaDiem_ThapHonBien() {
        boolean result = service.suaDiem(sv, -1f);
        assertFalse(result);
    }

    // ✅ Test 3: Điểm trên biên (newDiem > 10)
    @Test
    void testSuaDiem_CaoHonBien() {
        boolean result = service.suaDiem(sv, 10.5f);
        assertFalse(result);
    }

    // ✅ Test 4: Điểm tại biên (0 và 10)
    @Test
    void testSuaDiem_TaiBien() {
        assertTrue(service.suaDiem(sv, 0f));
        assertTrue(service.suaDiem(sv, 10f));
    }

    // ✅ Test 5: Sinh viên null
    @Test
    void testSuaDiem_SinhVienNull() {
        assertFalse(service.suaDiem(null, 8f));
    }

    // ✅ Test 6: Validate dữ liệu hợp lệ
    @Test
    void testValidate_HopLe() {
        assertTrue(service.validate(sv));
    }

    // ✅ Test 7: Validate dữ liệu trống
    @Test
    void testValidate_ThieuThongTin() {
        SinhVien sv2 = new SinhVien("", "", 20, 7f, 2, "");
        assertFalse(service.validate(sv2));
    }
}
