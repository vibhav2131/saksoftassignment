package in.sacksoft.project.exception;

public class SacksoftException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	static void validate(Integer id) throws SacksoftException {
		if (id < 100) {
			throw new SacksoftException();
		} else {
			System.out.println("finding age successfully");
		}
	}

}
