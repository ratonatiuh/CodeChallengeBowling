# Bowling Code Challenge



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
$ cd target
$ java -jar CodeChallengeBowling-0.0.1-SNAPSHOT.jar path/of/file.txt
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

if you want to change other file,  only change in the argument of the path and put that path at first argument to run the jar.

# Examples

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
The result to run the jar is the next:

```
Frame           1               2               3               4               5               6               7           8                9               10       
Carl
Pinfalls                 X               X               X               X               X               X               X   X                X      X       X       X 
Score           30              60              90              120             150             180             210         240              270             300
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
```

and the result running the jar is:

```
Frame           1               2               3               4               5               6               7           8                9               10       
Jeff
Pinfalls                 X      7        /      9       0                X      0       8       8        /      F       6    X                X      X       8       1 
Score           20              39              48              66              74              84              90          120              148             167
John
Pinfalls        3        /      6       3                X      8       1                X               X      9       0    /       4       4       X       9       0 
Score           16              25              44              53              82              101             110         124              132             151
```
