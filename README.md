# Android-Game-Centre
- Open Android GameCenter in Android Studio.
- Run the whole app file.
- Choose your available virtual device.
- Choose Login in application of your virtual device.
- Welcome to GameCenter. First you should sign up an account to play the game, press signup bottom on login activity.
The length of the password you create should be larger than 6 (You'll see "Password is too short" message if you do so).
You cannot use a username that already exists.(You'll see "Username already exists!" message if you do so)
Then Click the sign up button on the left corner.If you sign up successfully, it will take you to login.
- After sign up an account, you should be back to the main menu, then enter your username and corresponding correct password to sign in to the GameCenter.
- Choose the game you would like to play, we have 3 games: Slidingtiles, Simon, Matching Card.

### Game: Slidingtiles
- Choose the difficulty level you want to play. For game Slidingtiles, we have 3 levels: easy, medium and hard. Each level has different number of tiles. Level hard has the most number of tiles.
- After choosing the difficulty level, you can see 5 buttons: Load Saved Game, New Game, Save Game, Scoreboard, Customize Game. Load Saved Game can save the game you saved previously, New game will start a new  game, Save Game can save your current game state so as to continue to play when coming back, Scoreboard will display the score ranking per difficulty levels and per user, Customize Game enables you to upload your own photo.
- If you start a new game, the game will finish until all ids are in increasing order.
- When playing the game, you can enter the number of steps to undo at the bottom.
- Once you finish the game, the current game score will appear. You can see the score ranking by clicking the scoreboard button on the right, there are per-user scoreboard and per difficulty-level scoreboard in Slidingtiles.
- In SlidingTiles, we use number of steps to calculate the score, once you make a move, the step will increase by one. The fewer the step, the higher the score.

### Game: Simon    
- After choosing the game Simon, you will see 4 buttons. 3 buttons for choosing the difficulty level, 1 button for scoreboard.
- To start a game, you need to choose a difficulty level first, there are 3 levels: medium, hard and super hard. Each level has the same number of cards.
- Simon is a game of memory skills, requires player listen to the sound then repeat what they hear in order. At each game, game device plays sounds and show the light (red, green, yellow, blue) which correspond to the sound order. Player has to remember the order of sound and light position. After game device done (Please don't press bottons when game device is on going!), players has to perform what they heard in the order as game device played before. 
- You can undo your choice if you accidentally press the wrong bottom. For example, you need "yellow" and "green" but you press "yellow" and "red".You may press Undo button and press "green".
- You can clear your choice by pressing Clear button if you want to place your answer again.
- After placing your answer, you have to press confirm to check whether it's right. If your answer is too long or too short, you have to clear or undo your answer and place an answer with right "length".
- Once the game is over, you will hear a sad music and will be redirected to the GameOver Page. The current game score will appear and there are 3 buttons below: Menu, New Game and Scoreboard.  Menu: You will be directed to the main menu page, there are 3 games to choose. New Game: Start a new Simon game. Scoreboard: By clicking the scoreboard button, you can see the score ranking, there are per-user scoreboard and per difficulty-level scoreboard in Simon.
- In Simon, we use the total number of games the player played to calculate the score. once you perform a game in correct order, the total number of games will increase by 1. The more the number, the higher the score.

### Game: MatchingCard
-After choosing the game Matching Card(the button is OverWatch Matching Card), you will see 3 buttons for choosing the difficulty.
- To start a game, you need to choose a difficulty level first, there are 3 levels: level1,level2 and level3 Each level represent the different number of the col and row in the game view, they are 2*2, 4*4 and 6*6.
- Matching Card is a game of memory skills, it requires the player to flip each cards and find the two cards with the same pattern. There are only two cards can be shown at the same time.
- If the two cards the player flip have the same pattern, then they will consider to be matched and can not be flipped again.
- If the two cards the player flip don't have the same pattern, then these cards will flip by themselves in a short time. And player need to flip the cards and continues to find the two cards with the same pattern.
- Player can see the times they flip the cards in the button of the screen.
- Once the player let all cards on the screen become matched. The game will be over and the screen will show "winner" and let player go to GameOver page. The current game score will appear and there are 3 buttons below: Menu, New Game and Scoreboard.Menu: You will be directed to the main menu page, there are 3 games to choose. New Game: Start a new Matching Card game. Scoreboard: By clicking the scoreboard button, you can see the score ranking, there are per-user scoreboard and per difficulty-level scoreboard in Matching Card.
- In Matching Card, we use the total number of games the player flip the button to calculate the score. once you perform a flip, the total number of games will increase by 1. The more the number, the higher the score.
- The Matching Card, we do have the auto save function, but it only save the buttons that have already matched.
