package edu.kis.vh.nursery;

import org.junit.Assert;
import org.junit.Test;

public class RhymersJUnitTest {
	private final int EMPTY_STACK_VALUE = -1;
	private final int STACK_CAPACITY = 12;

	@Test
	public void testGetTotal() {
		DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
		
		int emptyTotal = rhymer.getTotal();
		Assert.assertEquals("Expected getTotal to return total - equal to -1 if rhymer is empty", emptyTotal, EMPTY_STACK_VALUE);
		
		rhymer.countIn(5);
		int totalAfterFirstCall = rhymer.getTotal();
		Assert.assertEquals("Expected getTotal to return total - equal to 0 after first call", totalAfterFirstCall, 0);
		
		rhymer.countIn(5);
		rhymer.countIn(5);
		rhymer.countIn(5);
		int totalAfterFourthCall = rhymer.getTotal();
		Assert.assertEquals("Expected getTotal to return total - equal to 3 after fourth call", totalAfterFourthCall, 3);		
		
		rhymer.countOut();
		int totalAfterCountingOut = rhymer.getTotal();
		Assert.assertEquals("Expected getTotal to return total - equal to 2 after one count out", totalAfterCountingOut, 2);	

		rhymer.countOut();
		rhymer.countOut();
		rhymer.countOut();
		rhymer.countOut();
		rhymer.countOut();
		rhymer.countOut();
		int totalAfterTooManyCountOuts = rhymer.getTotal();
		Assert.assertEquals("Expected getTotal to return total - equal to -1 after stack is emptied (total should never go below -1)", totalAfterTooManyCountOuts, EMPTY_STACK_VALUE);	
	}
	
	@Test
	public void testCountIn() {
		DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
		
		int testValue = 4;
		rhymer.countIn(testValue);

		int result = rhymer.peekaboo();
		Assert.assertEquals("Expected countIn to place on top value "  + testValue + "; found " + result + " instead", testValue, result);
	}

	@Test
	public void testCallCheck() {
		DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
		
		boolean result = rhymer.callCheck();
		Assert.assertTrue("Expected callcheck to return true if rhymer is empty", result);

		rhymer.countIn(888);

		result = rhymer.callCheck();
		Assert.assertFalse("Expected callcheck to return false if rhymer has already count in something", result);
	}

	@Test
	public void testIsFull() {
		DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
		for (int i = 0; i < STACK_CAPACITY; i++) {
			boolean result = rhymer.isFull();
			Assert.assertFalse("Expected isFull to return false as long as ryhmer is not full", result);
			rhymer.countIn(888);
		}

		boolean result = rhymer.isFull();
		Assert.assertTrue("Expected isFull to return true if rhymer is full", result);
	}

	@Test
	public void testPeekaboo() {
		DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();

		int result = rhymer.peekaboo();
		Assert.assertEquals("Expected peekaboo to return empty stack value if rhymer is empty", EMPTY_STACK_VALUE, result);

		int testValue = 4;
		rhymer.countIn(testValue);

		result = rhymer.peekaboo();
		Assert.assertEquals("Expected peekabo to return last (top) value", testValue, result);
		result = rhymer.peekaboo();
		Assert.assertEquals("Expected peekabo to return last (top) value again", testValue, result);
	}

	@Test
	public void testCountOut() {
		DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();

		int result = rhymer.countOut();
		Assert.assertEquals("Expected countOut to return empty stack value if rhymer is empty", EMPTY_STACK_VALUE, result);

		int testValue = 4;
		rhymer.countIn(testValue);

		result = rhymer.countOut();
		Assert.assertEquals("Expected countOut to pop last (top) value", testValue, result);
		result = rhymer.countOut();
		Assert.assertEquals("Expected countOut to return empty stack value if rhymer is empty after popping last value", EMPTY_STACK_VALUE, result);
	}

	@Test
	public void testFIFORhymerCountOut() {
		FIFORhymer rhymer = new FIFORhymer();
		
		rhymer.countIn(5);
		rhymer.countIn(8);
		rhymer.countIn(10);
		
		int peek = rhymer.peekaboo();
		Assert.assertEquals("Expected default countIn to properly stack values, with last one (10) on top", peek, 10);
		
		int result = rhymer.countOut();
		Assert.assertEquals("Expected overriden countOut to return first value (5)", result, 5);
		
		int topValue = rhymer.peekaboo();
		Assert.assertEquals("Expected overriden countOut to leave values in proper order (10 is still on top)", topValue, 10);
	}

	@Test
	public void testHanoiRhymerReportRejected() {
		HanoiRhymer rhymer = new HanoiRhymer();

		rhymer.countIn(6);
		
		int rejected = rhymer.reportRejected();
		Assert.assertEquals("Expected reportRejected to return totalRejected value, defaulting to 0", rejected, 0);
		
		rhymer.countIn(7);
		rejected = rhymer.reportRejected();
		Assert.assertEquals("Expected reportRejected to return totalRejected value", rejected, 1);
	}

	@Test
	public void testHanoiRhymerCountIn() {
		HanoiRhymer rhymer = new HanoiRhymer();

		rhymer.countIn(6);
		
		int rejected = rhymer.reportRejected();
		Assert.assertEquals("Expected countIn to accept any first value", rejected, 0);
		
		rhymer.countIn(7);
		rejected = rhymer.reportRejected();
		Assert.assertEquals("Expected countIn to reject values larger than last value", rejected, 1);

		rhymer.countIn(5);
		rejected = rhymer.reportRejected();
		Assert.assertEquals("Expected countIn to accept values smaller than last value", rejected, 1);
		
		rhymer.countIn(5);
		rejected = rhymer.reportRejected();
		Assert.assertEquals("Expected countIn to accept values equal to last value", rejected, 1);
	}

}
