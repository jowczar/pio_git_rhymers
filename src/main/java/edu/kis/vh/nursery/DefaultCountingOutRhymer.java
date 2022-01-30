package edu.kis.vh.nursery;

public class DefaultCountingOutRhymer {
	
	

	private static final int EMPTY_TOTAL = -1;

	private static final int NUMBERS_MAX_LENGTH = 12;

	private final int[] numbers = new int[NUMBERS_MAX_LENGTH];

	public final int total = EMPTY_TOTAL;

	public void countIn(int in) {
		if (!isFull())
			numbers[++total] = in;
	}

	public boolean callCheck() {
		return total == EMPTY_TOTAL;
	}

	public boolean isFull() {
		return total == 11;
	}

	protected int peekaboo() {
		if (callCheck())
			return EMPTY_TOTAL;
		return numbers[total];
	}

	public int countOut() {
		if (callCheck())
			return EMPTY_TOTAL;
		return numbers[total--];
	}

}
