package Generic_Utility;

import java.util.Random;

public class Java_Utility {
	/**
	 * This method is used to generate random number and suffix it to product name to avoid duplicates
	 * @return
	 * @author Dharini C S
	 */
	public int getRandomNumber() {
		Random ran = new Random();
		int randomNumber = ran.nextInt(1000);
		return randomNumber;
		
	}
}
