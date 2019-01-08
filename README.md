# BANDIT TRAIL

  ##  Team Memebers
- Ahmed Marzook
- Max Francis
- Benjamin Kearns
- Kwame Mintah

Project Summary: A text based adventure game based in the Wild West similar to that of Oregon Trail

## User Stories
>As a user,
So that I understand the story,
I can read what is currently happening.


>As a user
So that I can play the game
I am able to interact with the game

>As a user,
So that my decision impact the game,
I’m given different scenarios as I play the game

>As a user,
So that I know how much money I have,
I want to be able to check my bank balance.

>As a user,
So that I can prepare for my journey,
I want to be able to spend money at a shop.

>As a user,
So that I know how healthy I am,
I can check my health.

Notes:

Money at the start if the game (Very basic use)

Score System based on the decision

Objects: Money, Health, Weapons, Notoriety, Inventory

MVP: there is one town, the player can either rob someone or rob a bank, it goes well and they gain some gold.

### Starting stats

HP: 100

Gold: 50

Weapons: N/A

Ammunition: N/A

Notoriety: 0%

Script

### Shop

Item Price

1.  Revolver 20G
    
2.  Rifle 40G
    
3.  Crowbar 10G
    
4.  Mask 5G
    
5.  Revolver Ammo 10G
    
6.  Rifle Ammo 15G
    
7.  Horse 45G
    
8.  Clothes 10G
    
9.  Boat 200G
    
## Town 1

You have just been released from jail, with just 50 gold to your name you head into town, what would you like to do?

1.  Go to the shop (go to shop screen)
    
2.  Go to another town
    
3.  Attempt to rob someone
    
4.  Attempt to rob a bank

### Option 2

How would you like to get to the town?
1.  Catch a wagon (10G)
    
2.  Ride a horse (horse required)
    
3.  Don’t leave town (go to previous screen)

### Option 3

As you walk along the street you see a wealthy looking old lady and decide to rob her.

Options
1.  Continue to rob her
    
2.  Leave
    
Outcomes

1.  You have successfully robbed her (mask was used), you have gained 30G.
    
2.  You have successfully robbed her but she remembers your face, you have gained 30G (If the sheriff sees you, he will chase you)
    
3.  The old lady hits you with her bag and runs away, you are unconscious for 3 hours, you lose 10HP.

### Option 4

You have walked into the local bank, with your best weapon at your waist.

1.  You walk to the counter and demand money, you slyly show your weapon to the cashier.
    
2.  You aim your gun in the air and tell everyone to get down
    
Outcomes

0. If you attempt to rob the bank in the same clothes that you have robbed someone in you are instantly arrested and it is game over.

1.1. The cashier gives you all the money in her till and you leave quietly (You gain 45G)

1.2. The cashier shouts gun and takes cover, an officer in the bank hears and shoots you in the arm, you run out of the bank. (You lose 30HP)

2.1. Everyone does as told, you get a cashier to open the vault for you and narrowly escape with the money. (You gain 90G)

2.2. Everyone in the bank panics, an office tackles you to the ground and punches you in the face, you yeet him off you and run away. (You lose 30HP)

## Town 2

You have arrived in a new town.

1.  Go to the shop (go to shop screen)
    
2.  Go to another town
    
3.  Attempt to rob someone
    
4.  Attempt to rob a bank
    
### Option 3

You see a man across the street who is tying his shoes, you decide to rob him, when you get to him he stands up and you see he is much more muscular than you previously thought.

Options

3.  Continue to rob him
    
4.  Leave
    
Outcomes

1.  You have successfully robbed him (mask was used), you have gained 40G.
    
2.  You have successfully robbed him but he remembers your face, you have gained 40G (If the sheriff sees you, he will chase you)
    
3.  The man beats you up, leaving you very wounded and unconscious for a day, when you wake up you are in the town hospital. (You lose 25G and 35HP)
