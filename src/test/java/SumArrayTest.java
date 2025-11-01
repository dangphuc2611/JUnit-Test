import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.example.SumArray;

public class SumArrayTest {
  @Test
  void testNormalSum(){
    assertEquals(500500, SumArray.sum());
  }

  @Test
  void testBienTren(){
    assertEquals(1000 * (1000 + 1) / 2, SumArray.sum());
  }

  @Test
  void testGauss(){
    int n = 1000;
    assertEquals(n * (n + 1) / 2, SumArray.sum());
  }

  @Test
  void testOnDinh(){
    int result1 = SumArray.sum();
    int result2 = SumArray.sum();
    assertEquals(result1, result2);
  }

  @Test
  void testChongTran(){
    assertTrue(SumArray.sum() < Long.MAX_VALUE);
  }
}
