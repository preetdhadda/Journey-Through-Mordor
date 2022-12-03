package com.group21.app.Screen;

import javax.swing.*;
import java.awt.*;

import com.group21.app.Entity.Enemy;
import com.group21.app.Entity.Character;

/**
 * This class builds the UI for the game. It creates windows for the game,
 * win, and lose screens.
 */
public class UI {

    static UI singletonInstance;
    private UI(){}
    public static String gameState = "";

    TitlePanel titlePanel;
    RulePanel rulepanel;
    ScreenPanel screenPanel;
    public WinPanel winpanel;
    public LosePanel losepanel;

    /**
     * Uses the singleton design pattern to ensure only one instance of UI is created
     * @return UI
     * @author Jimmy
     */
    public static UI getInstance(){
        if (singletonInstance == null){
            singletonInstance = new UI();
        }
        return singletonInstance;
    }

    /**
     * This constructor creates a JFrame for the title screen.
     * <p>
     * Instantiates TitlePanel and adds them to a Container to
     * display it in the JFrame. Includes the following settings:
     * <p>
     *     - stop the game when user exits the window
     * <p>
     *     - don't allow user to resize the window
     * <p>
     *     - open window in middle of user's screen
     *
     * @see TitlePanel
     * @author Jimmy
     */
    public void makeTitleWindow(){
        JFrame window = new JFrame("Journey Through Mordor");
        // create window with JFrame
        // when the user exits the window, stop the game
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // don't allow the user to resize the window
        window.setResizable(false);

        // instantiate TitlePanel
        titlePanel = new TitlePanel();

        Container gameContainer = window.getContentPane();
        gameContainer.setLayout(new BoxLayout(gameContainer, BoxLayout.Y_AXIS));
        gameContainer.add(titlePanel);
        window.pack();

        // more window settings
        window.setLocationRelativeTo(null); // open window in middle of user's device
        window.setVisible(true); // display window
    }

    /**
     * This constructor creates a JFrame for the rules screen.
     * <p>
     * Instantiates RulePanel and adds them to a Container to
     * display it in the JFrame. Includes the following settings:
     * <p>
     *     - stop the game when user exits the window
     * <p>
     *     - don't allow user to resize the window
     * <p>
     *     - open window in middle of user's screen
     *
     * @see RulePanel
     * @author Jimmy
     */
    public void makeRuleWindow() {
        // create window with JFrame
        JFrame window = new JFrame("Journey Through Mordor");
        // when the user exits the window, stop the game
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // don't allow the user to resize the window
        window.setResizable(false);
        
        // instantiate rule panel
        rulepanel = new RulePanel();

        // create container for panels
        Container gameContainer = window.getContentPane();
        gameContainer.setLayout(new BoxLayout(gameContainer, BoxLayout.Y_AXIS));

        gameContainer.add(rulepanel);
        window.addKeyListener(rulepanel);
        window.pack(); // makes window fit preferred size of screen

        // more window settings
        window.setLocationRelativeTo(null); // open window in middle of user's device
        window.setVisible(true); // display window
    }

    // Game Panel
    JFrame gameWindow = new JFrame("Journey Through Mordor");

    /**
     * This constructor creates a JFrame for the game.
     * <p>
     * Instantiates ScreenPanel and MenuPanel and adds them to a Container to
     * display them both in the JFrame. Includes the following settings:
     * <p>
     *     - stop the game when user exits the window
     * <p>
     *     - don't allow user to resize the window
     * <p>
     *     - add screen and menu panels to window in a BoxLayout (to have one on top of the other)
     * <p>
     *     - open window in middle of user's screen
     *
     * @see ScreenPanel
     * @see MenuPanel
     * @author Preet
     */
    public void makeGameWindow() {
        gameWindow = new JFrame("Journey Through Mordor");

        // window settings
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow.setResizable(false);

        // instantiate screen and menu panels
        ScreenPanel.deleteInstance();
        screenPanel = ScreenPanel.getInstance();
        Character.score = 0;
        Enemy.playerFound = false;
        MenuPanel menuPanel = new MenuPanel(screenPanel);

        // instantiate container and add panels
        Container gameContainer = gameWindow.getContentPane();
        gameContainer.setLayout(new BoxLayout(gameContainer, BoxLayout.Y_AXIS));
        gameContainer.add(screenPanel);
        gameWindow.addKeyListener(screenPanel);
        gameContainer.add(menuPanel);
        gameWindow.pack(); // makes window fit preferred size of screen
        
        // more window settings
        gameWindow.setLocationRelativeTo(null);
        gameWindow.setVisible(true);
    }

    /**
     * Deletes the instance of game Window when the player won or lost
     * 
     * @see ScreenPanel
     * @author Jimmy
     */
    public void disposeGameWindow(){
        gameWindow.dispose();
    }

    /**
     * This constructor creates a JFrame for the winning screen.
     * <p>
     * Instantiates WinPanel and adds them to a Container to
     * display it in the JFrame. Includes the following settings:
     * <p>
     *     - stop the game when user exits the window
     * <p>
     *     - don't allow user to resize the window
     * <p>
     *     - open window in middle of user's screen
     *
     * @see WinPanel
     * @author Jimmy
     */
    public void makeWinWindow(){
        // create window with JFrame
        JFrame window = new JFrame("Journey Through Mordor");
        // when the user exits the window, stop the game
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // don't allow the user to resize the window
        window.setResizable(false);
        
        // instantiate win panel
        winpanel = new WinPanel();
    
        // create container for panels
        Container gameContainer = window.getContentPane();
        gameContainer.setLayout(new BoxLayout(gameContainer, BoxLayout.Y_AXIS));
    
        gameContainer.add(winpanel);
        window.pack(); // makes window fit preferred size of screen
    
        // more window settings
        window.setLocationRelativeTo(null); // open window in middle of user's device
        window.setVisible(true); // display window
    }

    /**
     * This constructor creates a JFrame for the losing screen.
     * <p>
     * Instantiates LosePanel and adds them to a Container to
     * display it in the JFrame. Includes the following settings:
     * <p>
     *     - stop the game when user exits the window
     * <p>
     *     - don't allow user to resize the window
     * <p>
     *     - open window in middle of user's screen
     *
     * @see LosePanel
     * @author Jimmy
     */
    public void makeLoseWindow(String state){
        // create window with JFrame
        JFrame window = new JFrame("Journey Through Mordor");
        // when the user exits the window, stop the game
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // don't allow the user to resize the window
        window.setResizable(false);
        
        // instantiate lose panel
        losepanel = new LosePanel(state);
    
        // create container for panels
        Container gameContainer = window.getContentPane();
        gameContainer.setLayout(new BoxLayout(gameContainer, BoxLayout.Y_AXIS));
    
        gameContainer.add(losepanel);
        window.pack(); // makes window fit preferred size of screen
    
        // more window settings
        window.setLocationRelativeTo(null); // open window in middle of user's device
        window.setVisible(true); // display window
    }
    /**
     * This method instantiates the win panel, deletes the game window,
     * and resets the game variables for a new game when the user
     * wins the game from collecting all the rewards
     * 
     * @see ScreenPanel
     * @see Enemy
     * @see detectCollision
     * @author Jimmy
     */
    public void makeWinRewardsWindow(){
        Character.deleteInstance();
        makeWinWindow();
        disposeGameWindow();
        ScreenPanel.deleteInstance();
        Enemy.playerFound = true;
    }

    /**
     * This method instantiates the lose window and deletes the instances
     * of gamewindow and screen panel when the user loses because
     * they did not collect all the rewards before reaching the 
     * end goal
     * 
     * @see Screenpanel 
     * @see detectCollision
     * @author Jimmy
     */
    public void makeLoseRewardsWindow(){
        Character.deleteInstance();
        makeLoseWindow("rewards");
        disposeGameWindow();
        ScreenPanel.deleteInstance();
    }

    /**
     * This method instantiates the lose window and disposes the 
     * game window when the user's score drops below 0
     * 
     * @see detectCollision
     * @author Jimmy 
     */
    public void makeLoseScoreWindow(){
        Character.deleteInstance();
        makeLoseWindow("score");
        disposeGameWindow();
    }
}
