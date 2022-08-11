package GenericLibrary;

import java.util.Random;

/**
 * This class contains all java specific generic methods
 * @author Gokul
 *
 */
public class JavaLibrary
{
    /**
     * This method will generate random number for every execution
     * @return
     */
	public int getRandomNumber()
	{
		Random r=new Random();
		return r.nextInt(1000);
	}
}
