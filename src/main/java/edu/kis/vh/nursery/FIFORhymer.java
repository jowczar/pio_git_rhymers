package edu.kis.vh.nursery;

public class FIFORhymer extends defaultCountingOutRhymer {

	public defaultCountingOutRhymer defaultRhymer = new defaultCountingOutRhymer();

	@Override
	public int countOut() {
		while (!callCheck())

			defaultRhymer.countIn(super.countOut());

		int ret = defaultRhymer.countOut();

		while (!defaultRhymer.callCheck())

			countIn(defaultRhymer.countOut());

		return ret;
	}
}
