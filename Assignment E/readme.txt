This is our (=Benedikt Bastin, Jonas Cremer, Martin Schmidt) solution to Programming Assignment E.

We chose an elitist (Lambda+Mu)-approach with single-parent inheritance and mutation via small permutations in the route taken (Swaps for maximizing the path, cycles for minimizing).

MainScript handles the general program logic, reading in the file (The file with the data points should be in the same folder as the terminal while running the program) taking user input (population size P, Offspring size Lambda and Survival rate Mu=P-Lambda, amount of steps taken and output file).

GeomSpace handles the point space with all coordinates for debugging and a distance-matrix that in the construction step to have fast lookups.
TSPDoubleVisitTour handles individuals of our population, i.e. permutations of the array [0,0,1,1,2,2,...,populationSize-1,populationSize-1], with eliminateTrivialStops() guaranteeing that all individuals fulfill the conditions of the second part of the assignment.

EvoTSPDoubleVisit is an abstract class that handles a general evolutionary algorithm for this problem with abstract methods for different approaches to inheritance, recombination, mutation and an abstract fitness function. AssignmentPartOne and AssignmentPartTwo are implementations of this abstract class according to the assignment sheet.

plotscript.gplot (gnuplot) plots the data output by the program into a single pdf. Change the variable 'path' to the file where the output data lies.

maxgraph.pdf and mingraph.pdf are outputs of plotscript.gplot with data from the maximizing- and minimizing-tasks respectively. Both data are derived from population size 100, with offspring 30 (survivors 70) and 1000 evolutionary steps taken.
