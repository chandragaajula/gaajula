import java.math.BigDecimal;
import java.math.RoundingMode;

public class BrainBench<B> {
	B b;

	public <B> void printMe(B b) {
		System.out.println(b.getClass().getName());
	}

	public static void main(String args[]) {
//		BrainBench<BrainBench> b = new BrainBench<BrainBench>();
//		b.printMe("Hello, World");
		
//		RoundingMode mode = RoundingMode.CEILING;
//		BigDecimal big1 = new BigDecimal(-11);
//		BigDecimal big2 = new BigDecimal(2);
//		System.out.println(big1.divide(big2, mode));

		




int x = -1; x = x << 16;
System.out.println(x);
	}

}
