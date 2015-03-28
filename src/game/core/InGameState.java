package game.core;

import game.states.IDeferredResourceState;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class InGameState extends BasicGameState implements
		IDeferredResourceState {

	public static final int ID = 1;

	@Override
	public void init(GameContainer container, StateBasedGame sbGame)
			throws SlickException {
	}

	@Override
	public void initDeferredResources() {
	}

	@Override
	public void render(GameContainer container, StateBasedGame sbGame,
			Graphics g) throws SlickException {
	}

	@Override
	public void update(GameContainer container, StateBasedGame sbGame, int delta)
			throws SlickException {
	}

	@Override
	public int getID() {
		return ID;
	}

}