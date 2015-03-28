package game;

import game.core.Game;

import org.newdawn.slick.SlickException;

public class LaunchGame {

	public static void main(String[] args) {
		try {
			Game g = new Game("libs/resources.jar");
			g.launch();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

}
