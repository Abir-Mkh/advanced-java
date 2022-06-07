package gui;

@FunctionalInterface
public interface UserFormListner {

	void formSubmitted(String username, String password);

}
