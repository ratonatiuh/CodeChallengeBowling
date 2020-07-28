# Bowling Code Challenge

The program is about solving the code challenge and is about keeping the bowling score, where we have to perform the following characteristics:

- The program should run from the command-line and take a text file as input
- The program should read the input text file and parse its content, which should have the
results for several players bowling 10 frames each, written according to these guidelines:
a. Each line represents a player and a chance with the subsequent number of pins
knocked down.
b. An 'F' indicates a foul on that chance and no pins knocked down (identical for
scoring to a roll of 0).
c. The rows are tab-separated.

- The program should handle bad input like more than ten throws (i.e., no chance will
produce a negative number of knocked down pins or more than 10, etc), invalid score
value or incorrect format

- The program should output the scoring for the associated game according to these
guidelines:
a. For each player, print their name on a separate line before printing that player's
pinfalls and score.
b. All values are tab-separated.
c. The output should calculate if a player scores a strike ('X'), a spare ('/') and allow
for extra chances in the tenth frame.

Your program should be able to handle all possible cases of a game both including a
game where all rolls are 0, all rolls are fouls (F) and a perfect game, where all rolls are
strikes:

```
Carl 10
Carl 10
Carl 10
Carl 10
Carl 10
Carl 10
Carl 10
Carl 10
Carl 10
Carl 10
Carl 10
Carl 10
```
Other example of file is the next:

```
Jeff 10
John 3
John 7
Jeff 7
Jeff 3
John 6
John 3
Jeff 9
Jeff 0
John 10
Jeff 10
John 8
John 1
Jeff 0
Jeff 8
John 10
Jeff 8
Jeff 2
John 10
Jeff F
Jeff 6
John 9
John 0
Jeff 10
John 7
John 3
Jeff 10
John 4
John 4
Jeff 10
Jeff 8
Jeff 1
John 10
John 9
John 0
```


The program use streams and lambdas of java 8, and divided in clases organize as services and domains.

# System Requirements:

- openJDK 8
- maven 3.0.4

# Test

To make a tests run:

```
$ mvn test
```
# How to

to run the program download the code from github:

```
$ git clone https://github.com/ratonatiuh/codeChallenge.git
```

Run the install phase of the profile code-challenge with the next command:

```
$ mvn clean install -P code-challenge
```

Another way to run the program is go inside the code you need to install maven on your computer, and run the package to make a target directory:

```
$ mvn clean package
```

go to the target folder, paste inside the BowlRecord directory and run the jar:
 
```
$ cp -R BowlRecord target/
$ cd target
$ java -jar CodeChallengeBowling-0.0.1-SNAPSHOT.jar
```

and you can see in the console the result:

```
Frame 	 	1 	 	2 	 	3 	 	4 	 	5 	 	6 	 	7 	 	8 	 	9 	 	10 	 	
Carl
Pinfalls 		 X 		 X 		 X 		 X 		 X 		 X 		 X 		 X 		 X 	X 	X 	X 	
Score 	 	30 	 	60 	 	90 	 	120 	 	150 	 	180 	 	210 	 	240 	 	270 	 	300
Chanchis
Pinfalls 	F 	F 	F 	F 	F 	F 	F 	F 	F 	F 	F 	F 	F 	F 	F 	F 	F 	F 	F 	F 
Score 	 	0 	 	0 	 	0 	 	0 	 	0 	 	0 	 	0 	 	0 	 	0 	 	0

```

if you want to change other file in the code, you can made in the mx.code.challenge..bowling.App change in the line 17 for another text, you can put another file in the BowlRecord directory and change the name.

