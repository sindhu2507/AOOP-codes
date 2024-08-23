package com.Factory;

public class GameState {
	private static GameState instance;
    private int level = 1;
    private String difficulty = "Easy";

    private GameState() {}

    public static GameState getInstance() {
        if (instance == null) {
            instance = new GameState();
        }
        return instance;
    }
    public int getLevel() { return level; }
    public String getDifficulty() { return difficulty; }
    public void nextLevel() { level++; }
    
    
}
