package game.states;

import game.core.Game;
import game.core.InGameState;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import utils.ResourceManager;
import utils.Timer;

public class ResourcesState extends BasicGameState {

	public static final int ID = 0;

	private static final int WAIT_TIME_BEFORE_NEXT_RESOURCE_LOAD = 100;

	private Timer waitTimer;
	private boolean complete;

	public ResourcesState() {
		waitTimer = new Timer(WAIT_TIME_BEFORE_NEXT_RESOURCE_LOAD);
	}

	@Override
	public void init(GameContainer container, StateBasedGame sbGame)
			throws SlickException {

	}

	@Override
	public void render(GameContainer container, StateBasedGame sbGame,
			Graphics g) throws SlickException {
		g.drawString("Loading ... " + ResourceManager.getAdvancement() + "%",
				container.getWidth() / 2 - 80, container.getHeight() / 2 - 60);
	}

	@Override
	public void update(GameContainer container, StateBasedGame sbGame, int delta)
			throws SlickException {
		if (complete) {
			sbGame.enterState(InGameState.ID, new FadeOutTransition(),
					new FadeInTransition());
		} else {
			waitTimer.update(delta);
			if (waitTimer.isTimeComplete()) {
				ResourceManager.loadNextResource();
				if (ResourceManager.isLoadComplete()) {
					((Game) sbGame).initAllStateResources();
					complete = true;
				}
				waitTimer.resetTime();
			}
		}

	}

	@Override
	public int getID() {
		return ID;
	}

}
