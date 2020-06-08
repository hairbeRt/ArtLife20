Our solution to PA-C.

As usual, just javac all files and run MainScript.

The assignment said that user input is not necessary, but we thought its easier for you to test our code,
so we implemented simple IO. Input is case-sensitive and all commands are CAPSLOCK!

You can choose one of the four listed examples by first entering "EXAMPLE" and then choosing the L-System.

You can also define your own L-System via "CUSTOM" and enter all components by hand, separated by space.
Finish one block of definitions with a semicolon ";" (must also be separated by space from the last definition!).
The program then prints each production step (starting with the axiom as production step 0) into separate lines.

Some example runs if things go wrong:

-------------------------------
Choose example ("EXAMPLE") or define your own L-System ("CUSTOM"): CUSTOM
Define variable symbols (except ";"), separated by space, finish with ";" (for example: A B ;): A B ;
Define constant symbols (except ";"), separated by space, finish with ";" (for example: C D ;): C ;
Set the axiom string: ACA
Add production rules (format: F->T), separated by space, finish with ";" (for example: A->AB B->BB ;): A->AB B->C ;
Enter amount of time steps to print: 10
ACA
ABCAB
ABCCABC
ABCCCABCC
ABCCCCABCCC
ABCCCCCABCCCC
ABCCCCCCABCCCCC
ABCCCCCCCABCCCCCC
ABCCCCCCCCABCCCCCCC
ABCCCCCCCCCABCCCCCCCC
ABCCCCCCCCCCABCCCCCCCCC
-------------------------------

-------------------------------
Choose example ("EXAMPLE") or define your own L-System ("CUSTOM"): CUSTOM
Define variable symbols (except ";"), separated by space, finish with ";" (for example: A B ;): A B ;
Define constant symbols (except ";"), separated by space, finish with ";" (for example: C D ;): C ;
Set the axiom string: A
Add production rules (format: F->T), separated by space, finish with ";" (for example: A->AB B->BB ;): A->ABC B->BAB ;
Enter amount of time steps to print: 5
A
ABC
ABCBABC
ABCBABCBABABCBABC
ABCBABCBABABCBABCBABABCBABABCBABCBABABCBABC
ABCBABCBABABCBABCBABABCBABABCBABCBABABCBABCBABABCBABABCBABCBABABCBABABCBABCBABABCBABCBABABCBABABCBABCBABABCBABC
-------------------------------

-------------------------------
Choose example ("EXAMPLE") or define your own L-System ("CUSTOM"): EXAMPLE
Choose an L-System between PARENT_CHILD_POPULATION, KOCH_SNOWFLAKE, DRAGON_CURVE, CANTOR_DUST: CANTOR_DUST
Amount of steps to print: 6
A
ABA
ABABBBABA
ABABBBABABBBBBBBBBABABBBABA
ABABBBABABBBBBBBBBABABBBABABBBBBBBBBBBBBBBBBBBBBBBBBBBABABBBABABBBBBBBBBABABBBABA
ABABBBABABBBBBBBBBABABBBABABBBBBBBBBBBBBBBBBBBBBBBBBBBABABBBABABBBBBBBBBABABBBABABBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBABABBBABABBBBBBBBBABABBBABABBBBBBBBBBBBBBBBBBBBBBBBBBBABABBBABABBBBBBBBBABABBBABA
ABABBBABABBBBBBBBBABABBBABABBBBBBBBBBBBBBBBBBBBBBBBBBBABABBBABABBBBBBBBBABABBBABABBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBABABBBABABBBBBBBBBABABBBABABBBBBBBBBBBBBBBBBBBBBBBBBBBABABBBABABBBBBBBBBABABBBABABBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBABABBBABABBBBBBBBBABABBBABABBBBBBBBBBBBBBBBBBBBBBBBBBBABABBBABABBBBBBBBBABABBBABABBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBABABBBABABBBBBBBBBABABBBABABBBBBBBBBBBBBBBBBBBBBBBBBBBABABBBABABBBBBBBBBABABBBABA
-------------------------------

-------------------------------
Choose example ("EXAMPLE") or define your own L-System ("CUSTOM"): EXAMPLE
Choose an L-System between PARENT_CHILD_POPULATION, KOCH_SNOWFLAKE, DRAGON_CURVE, CANTOR_DUST: PARENT_CHILD_POPULATION
Amount of steps to print: 8
C
A
CA
ACA
CAACA
ACACAACA
CAACAACACAACA
ACACAACACAACAACACAACA
CAACAACACAACAACACAACACAACAACACAACA
-------------------------------