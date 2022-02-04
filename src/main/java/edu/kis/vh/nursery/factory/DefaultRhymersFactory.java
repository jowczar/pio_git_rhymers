package edu.kis.vh.nursery.factory;

import edu.kis.vh.nursery.DefaultCountingOutRhymer;
import edu.kis.vh.nursery.FIFORhymer;
import edu.kis.vh.nursery.HanoiRhymer;
import edu.kis.vh.nursery.factory.RhymersFactory;

/**
 * @author justynaowczarek
 *
 * DefaultRhymersFactory is a factory that creates new rhymers
 * of specific category, based on method used
 */
public class DefaultRhymersFactory implements RhymersFactory {

	/**
	 * getStandardRhymers returns new object of class DefaultCountingOutRhymer
	 */
	@Override
	public DefaultCountingOutRhymer getStandardRhymer() {
		return new DefaultCountingOutRhymer();
	}

	/**
	 * getFalseRhymer returns new object of class DefaultCountingOutRhymer
	 */
	@Override
	public DefaultCountingOutRhymer getFalseRhymer() {
		return new DefaultCountingOutRhymer();
	}

	/**
	 * getFIFORhymer returns new object of class FIFORhymer
	 */
	@Override
	public DefaultCountingOutRhymer getFIFORhymer() {
		return new FIFORhymer();
	}

	/**
	 * getHanoiRhymer returns new object of class HanoiRhymer
	 */
	@Override
	public DefaultCountingOutRhymer getHanoiRhymer() {
		return new HanoiRhymer();
	}

}
