package preRule;

@SuppressWarnings({ "nls", "unused" })
public class TestPrimitiveObjectUseEqualsRule {

	public void testIntegerShouldRefactor() {
		Integer a = Integer.valueOf(1);
		Integer b = Integer.valueOf(2);

		if (a.equals(b)) {
		}

		if (!a.equals(b)) {
		}

		if (!(a.equals(b))) {
		}

		if (!(!a.equals(b))) {
		}

		if (Integer.valueOf(1).equals(Integer.valueOf(2))) {
		}

		if (!Integer.valueOf(1).equals(Integer.valueOf(2))) {
		}

		/* saving comments */
		if (a.equals(b)) {
		}

		if (a.equals(/* saving comments */ b)) {
		}

		if (a.equals(b /* saving comments */)) {
		}

		if (// save comments
		a.equals(b /* saving comments */)) {
		}

		if (a // save comments
				.equals(b // save comments
				)) {
		}
	}

	public void testStringShouldRefactor() {
		String a = "a";
		String b = "b";

		if (a.equals(b)) {
		}

		if (!a.equals(b)) {
		}

		if (!(a.equals(b))) {
		}

		if (!(!a.equals(b))) {
		}

		if ("a".equals("b")) {
		}

		if (!"a".equals("b")) {
		}

		if ("a".equals("b")) {
		}

		if (!"a".equals("b")) {
		}
	}

	public void testOtherPrimitivesShouldRefactor() {
		if (Byte.valueOf("1").equals(Byte.valueOf("2"))) {
		}

		if (Character.valueOf('a').equals(Character.valueOf('b'))) {
		}

		if (Short.valueOf("1").equals(Short.valueOf("2"))) {
		}

		if (Long.valueOf(1).equals(Long.valueOf(2))) {
		}

		if (Float.valueOf(1).equals(Float.valueOf(2))) {
		}

		if (Double.valueOf(1).equals(Double.valueOf(2))) {
		}

		if (Boolean.valueOf(true).equals(Boolean.valueOf(false))) {
		}
	}

	public void testActualPrimitivesShouldNotRefactor() {
		int a = 1;
		int b = 2;
		if (a == b) {
		}

		if (Integer.valueOf(1) == 2) {
		}

		if (1 == Integer.valueOf(2)) {
		}

		if (1f == 2f) {
		}

		if (1l == 2l) {
		}

		if (1d == 2d) {
		}

		if (true == false) {
		}
	}

	public void testOtherInfixShouldNotRefactor() {
		Integer a = Integer.valueOf(1);
		Integer b = Integer.valueOf(2);

		if (a >= b) {
		}

		if (a <= b) {
		}

		if (a < b) {
		}

		if (a > b) {
		}
	}

	public void testCastedExpressionShouldNotRefactor() {
		int c = 0;
		Integer d = Integer.valueOf(1);
		if (((Integer) c).equals(d)) {
		}
		if (d.equals((Integer) c)) {
		}
		if (c == (Integer) d) {
		}
	}
}