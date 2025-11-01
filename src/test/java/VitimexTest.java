import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class VitimexTest {
    public static void main(String[] args) throws InterruptedException {
        // 🧠 Khai báo đường dẫn ChromeDriver (đổi theo máy bạn)
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // =============================
        // 🔹 Bước 1: Mở trang chủ
        driver.get("https://vitimex.com.vn/");
        Thread.sleep(2000);

        // 🔹 Bước 2: Nhấn vào "Đăng ký"
        driver.findElement(By.xpath("//a[contains(text(),'Đăng ký')]")).click();
        Thread.sleep(2000);

        // 🔹 Bước 3: Điền thông tin đăng ký
        driver.findElement(By.id("lastName")).sendKeys("Nguyen");
        driver.findElement(By.id("firstName")).sendKeys("Phuc");
        driver.findElement(By.id("email")).sendKeys("phuctest" + System.currentTimeMillis() + "@gmail.com");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.id("confirmPassword")).sendKeys("123456");

        // 🔹 Bước 4: Chọn giới tính (nếu có)
        try {
            WebElement genderSelect = driver.findElement(By.id("gender"));
            new Select(genderSelect).selectByVisibleText("Nam");
        } catch (Exception e) {
            // Không có giới tính cũng không sao
        }

        // 🔹 Bước 5: Nhấn nút “Đăng ký”
        driver.findElement(By.xpath("//button[contains(text(),'Đăng ký')]")).click();
        Thread.sleep(3000);

        // =============================
        // 🔹 Bước 6: Quay lại trang đăng nhập
        driver.get("https://vitimex.com.vn/account/login");
        Thread.sleep(2000);

        // 🔹 Bước 7: Nhập email & mật khẩu
        String email = "phuctest@gmail.com"; // thay bằng email vừa đăng ký ở trên
        driver.findElement(By.id("CustomerEmail")).sendKeys(email);
        driver.findElement(By.id("CustomerPassword")).sendKeys("123456");

        // 🔹 Bước 8: Nhấn “Đăng nhập”
        driver.findElement(By.xpath("//button[contains(text(),'Đăng nhập')]")).click();
        Thread.sleep(3000);

        // 🔹 Bước 9: Kiểm tra đăng nhập thành công
        if (driver.getPageSource().contains("Tài khoản của tôi")) {
            System.out.println("✅ Đăng nhập thành công!");
        } else {
            System.out.println("❌ Đăng nhập thất bại!");
        }

        driver.quit();
    }
}
