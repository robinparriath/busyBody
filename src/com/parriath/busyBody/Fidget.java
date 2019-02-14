package com.parriath.busyBody;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.util.Random;

/**
 * @author      Robin Parriath robinparriath@gmail.com
 * @version     0.1.1
 * @since       0.1
 */
public class Fidget {

	/**
	 * Randomly move the cursor within 5 square pixels each 0 to 10 seconds 
	 * <p>
	 * Move the cursor<ul>
	 * 
	 * 	<li>5 pixels left or right, covering a 5 square pixel area</li>
	 *  <li>Any interval between 0 and 10 seconds</li>
	 *  </ul>
	 * </p>
	 * The idea behind this is to keep the screen active.
	 * Keeps my screen active while I wait for my jobs to complete.
	 * 
	 * Kill this by killing the task in the terminal
	 * or look for a javaw.exe task in the Task manager, running this class.
	 * 
	 * This will kill your accuracy in any game or frustrate you 
	 * if you forget that it was running.
	 * 
	 * @param args : Standard console stuff. Any arguments will be ignored.
	 * @throws AWTException : needed by java.awt.Robot class
	 * @throws InterruptedException : needed by java.lang.Thread
	 */
	public static void main(String[] args) throws AWTException, InterruptedException {
		Robot robot = new Robot();
		Point point = new Point();
		Random random = new Random();
		int x, y, xSign, ySign, time;
		
		while(true)
		{
			x = random.nextInt(6);					//random number between 0 and 5
			y = random.nextInt(6);					//random number between 0 and 5
			xSign = (random.nextInt(2)==0)?-1:1;	//randomly either -1 or 1
			ySign = (random.nextInt(2)==0)?-1:1;	//randomly either -1 or 1
			time = random.nextInt(10001);			//random time between 0 and 10 seconds
			
			point = MouseInfo.getPointerInfo().getLocation();			//get current position of cursor
			robot.mouseMove(point.x + x * xSign, point.y + y * ySign);	//move it within a 5 pixel square 
			Thread.sleep(time);										 	//random interval(0 - 10 seconds)
		}
		
	}

}
