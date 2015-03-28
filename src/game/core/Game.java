package game.core;

import game.states.IDeferredResourceState;
import game.states.ResourcesState;

import java.io.IOException;
import java.util.ArrayList;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import utils.ResourceManager;

public class Game extends StateBasedGame {

	// CONFIGURATION
	private static final int FRAME_WIDTH = 800;
	private static final int FRAME_HEIGHT = 600;
	private static final int TARGET_FRAME_RATE = 100;
	private static final boolean DEBUG = true;
	private static final boolean FULLSCREEN = false;
	private static final boolean VSYNC = true;

	private ArrayList<BasicGameState> states;

	public Game(String resourcesLocation) {
		super("Game");
		states = new ArrayList<BasicGameState>();
		try {
			ResourceManager.init(resourcesLocation);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initStatesList(GameContainer container) throws SlickException {

		// 0
		ResourcesState rs = new ResourcesState();
		states.add(rs);
		addState(rs);

		// 1
		InGameState igs = new InGameState();
		states.add(igs);
		addState(igs);
	}

	public void initAllStateResources() {
		for (int i = 0; i < states.size(); i++) {
			if (states.get(i) instanceof IDeferredResourceState) {
				((IDeferredResourceState) states.get(i))
						.initDeferredResources();
			}
		}
	}

	public void launch() throws SlickException {
		AppGameContainer container = new AppGameContainer(this);
		// container.setMinimumLogicUpdateInterval(10);
		// container.setMaximumLogicUpdateInterval(10);
		container.setUpdateOnlyWhenVisible(false);
		container.setAlwaysRender(true);

		// Apply Configuration
		container.setDisplayMode(FRAME_WIDTH, FRAME_HEIGHT, FULLSCREEN);
		container.setTargetFrameRate(TARGET_FRAME_RATE);
		container.setVSync(VSYNC);
		container.setShowFPS(DEBUG);
		container.setVerbose(DEBUG);

		// Start the game
		container.start();
	}

}
