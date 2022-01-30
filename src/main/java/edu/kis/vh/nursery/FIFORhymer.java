package edu.kis.vh.nursery;

public class FIFORhymer extends DefaultCountingOutRhymer {

	public DefaultCountingOutRhymer defaultRhymer = new DefaultCountingOutRhymer();

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
