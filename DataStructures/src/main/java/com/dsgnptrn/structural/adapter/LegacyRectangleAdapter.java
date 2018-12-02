package com.dsgnptrn.structural.adapter;

public class LegacyRectangleAdapter extends Rectangle {

	private LegacyRectangle legacyRectangle;

	public LegacyRectangleAdapter(LegacyRectangle legacyRectangle) {
		this.legacyRectangle = legacyRectangle;
	}

	/*
	 * Remember and be careful that if this overriden implementation gets very complex then it is possible that Adapter pattern 
	 * isn't the best suited one for this situation.
	 */
	@Override
	public int determineSize() {
		// TODO Auto-generated method stub
		return legacyRectangle.determineSize();
	}

}
