package org.com.yu.zhao;

import org.junit.Test;
import org.com.yu.zhao.HelloAnt;
import junit.framework.TestCase;

public class HelloAntTest extends TestCase{
	
	
	@Test
	public void test(){
		HelloAnt ha = new HelloAnt();
		assertEquals("1+3=4?", 4, ha.add(1, 3));
	}
}
