import multiprocessing
import search



# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.


def ForcedTest(initia):
    j = search.make_hardCoded_StagePuzzle(initia)
    print('Using', j.initial, 'as our initial state, we have the following information when running astar_search using max of Misplaced and Manhattan Heurestic')
    search.AstarRunningData(j,j.h2)


def main():
    #search.testALLRandom()
    #search.testMaxofMisplacedManhattan()
    ForcedTest((4, 0, 7, 8, 1, 3, 2, 5, 9, 6))
    


main()

#testMaxofMisplacedManhattan()



