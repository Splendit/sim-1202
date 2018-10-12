package preRule;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@SuppressWarnings("nls")
public class OptionalIfPresentRule {

	private final String value2 = "";

	{
		Optional<String> input = Optional.empty();
		if (input.isPresent()) {
			String value = input.get();
			System.out.println(value);
		}
	}

	public void default_comment(Optional<String> input) {
		if (input.isPresent()) {
			String value = input.get(); // comment after value initialization
			System.out.println(value);
		}
	}

	public void default_comment1(Optional<String> input) {
		if (input.isPresent()) { // comment after isPresent
			String value = input.get();
			System.out.println(value);
		}
	}

	public void default_comment2(Optional<String> input) {
		// comment above isPresent
		if (input.isPresent()) {
			String value = input.get();
			System.out.println(value);
		}
	}

	public void default_comment3(Optional<String> input) {
		// comment unconnected

		if (input.isPresent()) {
			String value = input.get();
			System.out.println(value);
		}
	}

	public void default_comment4(Optional<String> input) {
		if (input.isPresent()) {
			// comment under isPresent
			String value = input.get();
			System.out.println(value);
		}
	}

	public void default_comment5(Optional<String> input) {
		if (input.isPresent()) {
			String value = input.get();
			// comment under value initialization
			System.out.println(value);
		}
	}

	public void default_comment6(Optional<String> input) {
		if (input.isPresent()) {
			String value = input.get();
			System.out.println(value);
			// comment at the end of isPresent block
		}
	}

	public void singleIfBlockBody_shouldTransform(Optional<String> input) {
		// comment before isPresent
		if (input.isPresent()) { // comment after isPresent
			// comment under isPresent
			String value = input.get();
			// comment under value initialization
			if (true) {
				// comment inside inner if
				System.out.println(value);
			}
			// comment at the end of isPresent block
		}
	}

	public void singleIfBlockBody_savingComments_shouldTransform(Optional<String> input) {
		// leading comment
		if /* 1 */ ( /* 2 */input /* 3 */. /* 4 */isPresent/* 5 */(/* 6 */)/* 7 */)/* 8 */ {/* 9.1 */
			/* 9.2 */
			String /* 10 */ value /* 11 */ = /* 12 */ input/* 13 */./* 14 */get/* 15 */(/* 16 */)/* 17 */;/* 18 */
			/* 19 */
			if /* 20 */ ( /* 21 */ true /* 22 */) /* 23 */ { /* 24 */
				/* 25 */
				System/* 26 */.out./* 27 */println(value);/* 28 */
				/* 29 */
			} /* 30 */

			/* 31 */
		} /* 32 */
		/* 33 */
	}

	public void defaultUseCase_savingComments_shouldTransform(Optional<String> input) {
		/*
		 * Comment 25 is still being lost...
		 */

		/* 1 */
		if /* 2 */ (/* 3 */input/* 4 */./* 5 */isPresent(/* 6 */)/* 7 */)/* 8 */ {/* 9 */
			/* 10 */
			String /* 11 */ value /* 12 */ = /* 13 */ input/* 14 */./* 15 */get/* 16 */ (/* 17 */)/* 18 */;/* 19 */
			/* 20 */
			System.out.println(/* 21 */value/* 22 */);/* 23 */
			/* 24 */
		} /* 25 */
		/* 26 */
	}

	public void nestedOptionalIsPresent_shouldTransform(Optional<String> input) {
		if (input.isPresent()) {
			String value = input.get();
			System.out.println(value);
			if (input.isPresent()) {
				String value2 = input.get();
				System.out.println(value2);
			}
		}
	}

	public void singleIfStatementBody_shouldTransform(Optional<String> input) {
		if (input.isPresent()) {
			if (true) {
				String value = input.get();
				System.out.println(value);
			}
		}
	}

	public void multipleInitialiyers_shouldTransform(Optional<String> input) {
		if (input.isPresent()) {
			// comment under isPresent
			String value = input.get();
			String second = "";
			System.out.println(value);
			System.out.println(second);
		}
	}

	public void getExpressionNotPresent_shouldNotTransform(Optional<String> input) {
		if (input.isPresent()) {
			String value = "";
			System.out.println(value);
		}
	}

	public void getWithArgument_shouldNotTransform(Optional<String> input, List<String> users) {
		if (input.isPresent()) {
			String value = users.get(0);
			System.out.println(value);
		}
	}

	public void getWithNullExpression_shouldNotTransform(Optional<String> input) {
		if (input.isPresent()) {
			// comment under isPresent
			String value = "";
			get();
			System.out.println(value);
		}
	}

	public void throwingCheckedException_shouldNotTransform(Optional<String> input) throws Exception {
		// comment before isPresent
		if (input.isPresent()) {
			String value = input.get();
			System.out.println(value);
			throwSomething();
		}
	}

	public void defaultUseCase_shouldTransform(Optional<String> input) {
		if (input.isPresent()) {
			String value = input.get();
			System.out.println(value);
		}
	}

	public void multipleBodyStatements_shouldTransform(Optional<String> input) {
		if (input.isPresent()) {
			String value = input.get();
			System.out.println(value);
			System.out.println("Print another value");
		}
	}

	public void missingDeclarationFragment_shouldTransform(Optional<String> input) {
		if (input.isPresent()) {
			System.out.println(input.get());
		}
	}

	public void singleBodyStatement_shouldTransform(Optional<String> input) {
		if (input.isPresent()) {
			System.out.println(input.get());
		}
		System.out.println("I'm out!");
	}

	public void multipleGet_shouldTransform(Optional<String> input) {
		if (input.isPresent()) {
			String value = input.get();
			String value2 = input.get();
			System.out.println(value);
			System.out.println(value2);
			if (!value.isEmpty() && !value2.isEmpty()) {
				System.out.println(value + value2);
			}
		}
	}

	public void multipleGetConflictingNames_shouldTransform(Optional<String> input, int i) {
		if (input.isPresent()) {
			if (i == 0) {
				String value = input.get();
				System.out.println(value);
			} else {
				String value = input.get();
				System.out.println(value + i);
			}
		}
	}

	public void multipleOptionals_shouldTransform(Optional<String> input) {
		Optional<String> user = Optional.ofNullable("user-name");
		if (input.isPresent()) {
			String value = input.get();
			// this is a field access - should not be renamed
			System.out.println(value2);
			// this is a local declaration - should be removed
			String value2 = input.get();
			String value3 = user.get();
			System.out.println(value);
			System.out.println(value2);
			if (!value.isEmpty() && !value2.isEmpty()) {
				System.out.println(value + value2 + ":" + value3);
			}
		}
	}

	public void avoidExternalNameConflicts_shouldTransform() {
		String value = "I could crash with the lambda parameter";
		Optional<String> user = Optional.ofNullable(value);
		if (user.isPresent()) {
			System.out.println(user.get());
		}
	}

	public void avoidInternalNameConflicts_shouldTransform() {
		Optional<String> user = Optional.ofNullable("John Snow");
		if (user.isPresent()) {
			String value = "I could crash with the lambda parameter";
			System.out.println(value + ":" + user.get());
		}
	}

	public void avoidShadowingFields_shouldTransform() {
		Optional<String> user = Optional.ofNullable("John Snow");
		if (user.isPresent()) {
			System.out.println(value2 + ":" + user.get());
			String value2 = user.get();
			System.out.println(value2);
		}
	}

	public void fakeOptional_shouldNotTransform(IoNonSonoOpzionale input) {
		if (input.isPresent()) {
			String value = input.get();
			System.out.println(value);
		}
	}

	public void multipleConditions_shouldNotTransform(Optional<String> input) {
		boolean beTrue = true;
		if (input.isPresent() && beTrue) {
			String value = input.get();
			System.out.println(value);
		}
	}

	public void nonEffectivelyFinalVariables_shouldNotTransform(Optional<String> input) {
		int i = 0;
		i++;
		if (input.isPresent()) {
			String value = input.get();
			System.out.println(value + i);
		}
	}

	public void elseStatement_shouldNotTransform(Optional<String> input) {
		if (input.isPresent()) {
			String value = input.get();
			System.out.println(value);
		} else {
			// do nothing
		}
	}

	public void returnStatementInBody_shouldNotTransform(Optional<String> input) {
		if (input.isPresent()) {
			String value = input.get();
			System.out.println(value);
			return;
		}

		// Something here should not be done if the value is present
		System.out.println("The value is not present");
	}

	public void breakStatementInBody_shouldNotTransform(List<String> users) {
		for (String user : users) {
			Optional<String> name = findUserName(user);
			if (name.isPresent()) {
				String value = name.get();
				System.out.println(value);
				break;
			}
		}
	}

	public void continueStatementInBody_shouldNotTransform(List<String> users) {
		for (String user : users) {
			Optional<String> name = findUserName(user);
			if (name.isPresent()) {
				String value = name.get();
				System.out.println(value);
				continue;
			}
		}
	}

	public void throwStatementInBody_shouldNotTransform(List<String> users) {
		for (String user : users) {
			Optional<String> name = findUserName(user);
			if (name.isPresent()) {
				String value = name.get();
				System.out.println(value);
				if (value.isEmpty()) {
					throw new NoSuchElementException();
				} else {
					System.out.println(value);
				}
			}
		}
	}

	public void clashingWithPropertyOnQualifiedName_shouldTransform(Optional<String> input) {
		final IoNonSonoOpzionale user = new IoNonSonoOpzionale();
		if (input.isPresent()) {
			String value = input.get();
			user.value.length();
			System.out.println(value);
		}
	}

	public void discardedSingleOptionalGet_shouldNotTransform() {
		Optional<String> input = findUserName("");
		if (input.isPresent()) {
			input.get();
			String myVar = "somewar";
		}
	}

	public void discardedOptionalGet_shouldTransform() {
		Optional<String> input = findUserName("");
		if (input.isPresent()) {
			input.get();
			String myVar = input.get();
			findUserName(myVar);
		}
	}

	public void unusedAssignmentWithOptionalGet_shouldTransform() {
		Optional<String> input = findUserName("");
		if (input.isPresent()) {
			String myVar = input.get();
		}
	}

	public void internalNonFinalVariables_shouldTransform() {
		Optional<String> input = findUserName("");
		if (input.isPresent()) {
			for (int i = 0; i < 15; i++) {
				if (true) {
					System.out.println("Test");
				} else {
					String value = input.get();
					System.out.println("Test");
				}
			}
		}
	}

	private Optional<String> findUserName(String user) {
		return Optional.empty();
	}

	private void throwSomething() throws FileNotFoundException {

	}

	private void get() {

	}

	class IoNonSonoOpzionale {
		final public String value = "";

		public boolean isPresent() {
			return false;
		}

		public String get() {
			return "";
		}

		public void clashingWithFieldAccess_shouldTransform(Optional<String> input) {
			if (input.isPresent()) {
				String value = input.get();
				this.value.length();
				System.out.println(value);
			}
		}
	}

}