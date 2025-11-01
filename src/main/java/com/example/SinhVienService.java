package com.example;

public class SinhVienService {

    // ✅ Hàm sửa điểm trung bình
    public boolean suaDiem(SinhVien sv, float newDiem) {
        if (sv == null) return false;
        if (newDiem < 0 || newDiem > 10) {
            return false; // Điểm không hợp lệ
        }
        sv.setDiemTrungBinh(newDiem);
        return true;
    }

    // ✅ Hàm kiểm tra dữ liệu có hợp lệ không
    public boolean validate(SinhVien sv) {
        if (sv == null) return false;
        if (sv.getMaSV() == null || sv.getMaSV().isEmpty()) return false;
        if (sv.getTen() == null || sv.getTen().isEmpty()) return false;
        if (sv.getChuyenNganh() == null || sv.getChuyenNganh().isEmpty()) return false;
        return true;
    }
}
