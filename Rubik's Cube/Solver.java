import java.util.*;

import static java.lang.System.exit;

public class Solver {

    static final String moves[] = new String[] { "Turn Facet#1 Clockwise", "Turn Facet#1 Counterclockwise", "Turn Facet#2 Clockwise", "Turn Facet#2 Counterclockwise","Turn Facet#3 Clockwise", "Turn Facet#3 Counterclockwise", "Turn Facet#4 Clockwise", "Turn Facet#4 Counterclockwise", "Turn Facet#5 Clockwise", "Turn Facet#5 Counterclockwise", "Turn Facet#6 Clockwise", "Turn Facet#6 Counterclockwise" };

    static int calculateHeuristic(byte[] arr){
        //Calculates heuristic for this state
        int color = 0;
        int diffCount = 1;
        int twoCount, threeCount, fourCount;
        twoCount = threeCount = fourCount = 0;
        int sum = 0;
        for (int i = 1; i < arr.length; i++) {
            if (i % 4 == 1) {
                if(diffCount == 2)
                    twoCount++;
                else if(diffCount == 3)
                    threeCount++;
                else if(diffCount == 4)
                    fourCount++;

                diffCount = 1;
                color = arr[i];
                continue;
            }
            if (arr[i] != color) {
                diffCount++;
            }
        }
        sum = (4 * fourCount) + (2 * threeCount) + twoCount;
        return sum;
    }

    static boolean checkSolved(byte[] state) {
        int color = 0;
        for (int i = 1; i < state.length; i++) {
            if (i % 4 == 1) {
                color = state[i];
            }
            if (state[i] != color) {
                return false;
            }
        }
        return true;
    }

    static List<String> traceSteps(State state, Map<State, State> graph) {
        List<String> steps = new ArrayList<>();
        while (state != null) {
            steps.add(moves[state.lastMove]);
            state = graph.get(state);
        }
        steps.remove(steps.size() - 1);
        Collections.reverse(steps);
        return steps;
    }

    static List<String> solveAStar(State state) {
        int producedCount = 1;
        int expandedCount = 0;
        Map<State, State> visited = new HashMap<>();
        //Priority queue ordered by heuristic
        state.f = state.g + state.heuristic;
        PriorityQueue<State> q = new PriorityQueue<State>(Comparator.comparing(State::getF));
        q.add(state);
        visited.put(state, null);


        while (!q.isEmpty()) {
            State curr = q.poll();
            expandedCount++;

            if (checkSolved(curr.colors)) {
                System.out.println("Nodes produced: " + producedCount);
                System.out.println("Nodes expanded: " + expandedCount);
                System.out.println("Depth is: " + traceSteps(curr, visited).size());
                for(int i = 1; i < curr.colors.length; i++)
                    System.out.print((char)curr.colors[i]);
                System.out.println();
                return traceSteps(curr, visited);
            }

            for (State neighbour : curr.neighbourList()) {
                if (!visited.containsKey(neighbour)) {
                    producedCount++;
                    visited.put(neighbour, curr);
                    neighbour.f = neighbour.g + calculateHeuristic(neighbour.colors);
                    q.add(neighbour);
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter 4 numbers corresponding to the colors given below. Do this for all 6 faces pressing return/enter after every 4 numbers.");
        System.out.println("orange-1");
        System.out.println("green-2");
        System.out.println("white-3");
        System.out.println("blue-4");
        System.out.println("red-5");
        System.out.println("yellow-6");

        byte[] cube = new byte[25];
        int index = 1;
        for(int i = 0; i < 6; i++) {
            String input = in.next();
            if(input.length() > 4) {
                System.out.println("Error: Too many colors in face");
                exit(1);
            }
            for(int j = 0; j < 4; j++) {
                cube[index] = (byte)input.charAt(j);
                index++;
            }
        }

        int h = calculateHeuristic(cube);
        State init = new State(cube, 0, 0, h);
        List<String> solution = solveAStar(init);

        System.out.println("Solution:\n" + solution);

    }
}
