# Animal-Chess
Implemented backend side for the Animal Chess game.  

The game of chess reached Japan from India around one thousand years ago, and over the centuries it developed rather differently in Japan from the rest of the world. The game’s focus switched towards pieces that move only one square at a time, and curious innovations arose, including a more complex system of promotions, and the ability to “drop” a captured piece onto the board with its colour changed. The most popular chess variant in Japan today is known as Shogi, or The Game of Generals; it has gained popularity over the years, and now has a significant number of players outside the country.  
The subject of this practical is Goro-Goro Dobutsu Shogi (or Purring Animal Chess), a small Shogi variant designed by professional Shogi player Madoka Kitao, her aim being to introduce children to Shogi. The game is played on a 5×6 board, and features four different animals which all move in different ways, with similarities to pieces found in chess.

<div align='center'>
<img src="https://user-images.githubusercontent.com/81230042/145485766-6f16e08d-f7dc-4655-b000-717eb9e7a0d4.png" />
	
Picture 1: 	Animal Chess board
</div> 

The two players sit facing each other, with eight pieces each: a lion, two dogs, two cats and three chicks. Players take turns moving a single piece.  
• A chick moves one space forward.  
• A dog moves one space forward, backward, left or right, or diagonally forward (6 directions).  
• A cat moves one space in any diagonal direction, or directly forward (5 directions).  
• A lion moves one space in any direction, either orthogonal or diagonal (8 directions).  
These directions are shown on the playing pieces with red dots.  
A player cannot move a piece onto one of their own pieces, but they may move onto one of their opponent’s pieces, in which case the opponent's piece is captured. The capturing player takes the piece into their hand, and on a future turn, instead of moving a piece, they may drop a captured piece, by placing it onto any empty space on the board as one of their own pieces. A player wins by capturing their opponent’s lion.  
The chick and cat pieces are promotable. If a player moves a chick or a cat into the farthest two rows from them (the two rows closest to their opponent) then it promotes. After promoting, on future turns, it moves like a dog. In a real game, this is shown by flipping the piece over to show the picture on the other side.  

<div align='center'>
<img src="https://user-images.githubusercontent.com/81230042/145486500-9b67a562-0260-4bd8-9a83-85e979ddb465.png" />
	
Picture 2: 	UML diagram
</div> 
