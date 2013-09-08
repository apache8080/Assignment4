/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 */

import acm.graphics.*;

public class HangmanCanvas extends GCanvas {
	public static String u;
/** Resets the display so that only the scaffold appears */
	public void reset() {
		/* You fill this in */
		GLine hang = new GLine(0, 0, getWidth(), getHeight());
		hang.setStartPoint(50, 50);
		hang.setEndPoint(50, SCAFFOLD_HEIGHT);
		add(hang);
		GLine scaff = new GLine(0,0, getWidth(), getHeight());
		scaff.setStartPoint(50, 50);
		scaff.setEndPoint(200, 50);
		add(scaff);
		GLine rope = new GLine (0,0, getWidth(), getHeight());
		rope.setStartPoint(200, 50);
		rope.setEndPoint(200, 50+ROPE_LENGTH);
		add(rope);
	}

/**
 * Updates the word on the screen to correspond to the current
 * state of the game.  The argument string shows what letters have
 * been guessed so far; unguessed letters are indicated by hyphens.
 */
	public void displayWord(String word) {
		/* You fill this in */
		
		
	}

/**
 * Updates the display to correspond to an incorrect guess by the
 * user.  Calling this method causes the next body part to appear
 * on the scaffold and adds the letter to the list of incorrect
 * guesses that appears at the bottom of the window.
 */
	public void noteIncorrectGuess(char letter) {
		/* You fill this in */
		
	}
	public void head(){
		GOval head = new GOval(200-HEAD_RADIUS, 50+ROPE_LENGTH, HEAD_RADIUS*2, HEAD_RADIUS*2);
		add(head);
	}
	public void body(){
		GLine body = new GLine(0, 0, getWidth(), getHeight());
		body.setStartPoint(200, HEAD_RADIUS*2+50+ROPE_LENGTH);
		body.setEndPoint(200, HEAD_RADIUS*2+BODY_LENGTH);
		add(body);
		GLine hip = new GLine(0, 0, getWidth(), getHeight());
		hip.setStartPoint(200 - HEAD_RADIUS, HEAD_RADIUS*2+BODY_LENGTH);
		hip.setEndPoint(200+HEAD_RADIUS, HEAD_RADIUS*2+BODY_LENGTH);
		add(hip);
	}
	public void arm1(){
		GLine arm1u = new GLine(0, 0, getWidth(), getHeight());
		arm1u.setStartPoint(200, 50+ROPE_LENGTH+HEAD_RADIUS*2+ARM_OFFSET_FROM_HEAD);
		arm1u.setEndPoint(200 + UPPER_ARM_LENGTH, 50+ROPE_LENGTH+HEAD_RADIUS*2+ARM_OFFSET_FROM_HEAD);
		add(arm1u);
		GLine arm1l = new GLine(0, 0, getWidth(), getHeight());
		arm1l.setStartPoint(200 + UPPER_ARM_LENGTH, 50+HEAD_RADIUS*2+ARM_OFFSET_FROM_HEAD);
		arm1l.setEndPoint(200 + UPPER_ARM_LENGTH, 50+LOWER_ARM_LENGTH+HEAD_RADIUS*2);
		add(arm1l);
	}
	public void arm2(){
		GLine arm2u = new GLine(0, 0, getWidth(), getHeight());
		arm2u.setStartPoint(200, 50+HEAD_RADIUS*2+ARM_OFFSET_FROM_HEAD+ROPE_LENGTH);
		arm2u.setEndPoint(200-UPPER_ARM_LENGTH, 50+HEAD_RADIUS*2+ARM_OFFSET_FROM_HEAD+ROPE_LENGTH);
		add(arm2u);
		GLine arm2l = new GLine(0, 0, getWidth(), getHeight());
		arm2l.setStartPoint(200 - UPPER_ARM_LENGTH, 50+HEAD_RADIUS*2+ARM_OFFSET_FROM_HEAD);
		arm2l.setEndPoint(200 - UPPER_ARM_LENGTH, 50+LOWER_ARM_LENGTH+HEAD_RADIUS*2);
		add(arm2l);
	}
	public void leg1(){
		GLine leg1 = new GLine(0, 0, getWidth(), getHeight());
		leg1.setStartPoint(200+HEAD_RADIUS, HEAD_RADIUS*2+BODY_LENGTH);
		leg1.setEndPoint(200+HEAD_RADIUS, LEG_LENGTH+BODY_LENGTH+HEAD_RADIUS*2);
		add(leg1);
	}
	public void leg2(){
		GLine leg2 = new GLine(0, 0, getWidth(), getHeight());
		leg2.setStartPoint(200-HEAD_RADIUS, HEAD_RADIUS*2+BODY_LENGTH);
		leg2.setEndPoint(200-HEAD_RADIUS, LEG_LENGTH+BODY_LENGTH+HEAD_RADIUS*2);
		add(leg2);
	}
	public void foot1(){
		GLine foot1 = new GLine(0, 0, getWidth(), getHeight());
		foot1.setStartPoint(200-HEAD_RADIUS, LEG_LENGTH+BODY_LENGTH+HEAD_RADIUS*2);
		foot1.setEndPoint(200-HEAD_RADIUS- FOOT_LENGTH, LEG_LENGTH+BODY_LENGTH+HEAD_RADIUS*2);
		add(foot1);
	}
	public void foot2(){
		GLine foot2 = new GLine(0, 0, getWidth(), getHeight());
		foot2.setStartPoint(200+HEAD_RADIUS, LEG_LENGTH+BODY_LENGTH+HEAD_RADIUS*2);
		foot2.setEndPoint(200+HEAD_RADIUS+ FOOT_LENGTH, LEG_LENGTH+BODY_LENGTH+HEAD_RADIUS*2);
		add(foot2);
	
	}

/* Constants for the simple version of the picture (in pixels) */
	private static final int SCAFFOLD_HEIGHT = 360;
	private static final int BEAM_LENGTH = 144;
	private static final int ROPE_LENGTH = 18;
	private static final int HEAD_RADIUS = 36;
	private static final int BODY_LENGTH = 144;
	private static final int ARM_OFFSET_FROM_HEAD = 28;
	private static final int UPPER_ARM_LENGTH = 72;
	private static final int LOWER_ARM_LENGTH = 44;
	private static final int HIP_WIDTH = 36;
	private static final int LEG_LENGTH = 108;
	private static final int FOOT_LENGTH = 28;

}
