package odd_number_exception;

public class ValidateInteger{
	int input;

	public ValidateInteger(int input){
		this.input = input;
	}

	void validate() throws OddNumberException{
		if(input % 2 == 1){
			throw new OddNumberException();
		} else {
			System.out.println("Integer not Odd");
		}
	}
}
