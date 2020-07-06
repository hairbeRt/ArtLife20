# Compilation
  
Compilation can be done by entering the `src` folder and executing the following command:

    javac *.java

# Execution

The execution can be started by issuing the following command:

    java MainScript

The program then will prompt for the grid file.
After a correct file has been entered, it will ask for the number of stepts it should simulate.

The output will be in the file ```PA-F-robot.path``` within the working directory.

# Visualisation

The output can be visualised using gnuplot and the following command:

    plot 'PA-F-robot.path' using 1:2 with points
