import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class State {
    //refers to facet number and direction(clockwise/anticlockwise)
    static final int F1C = 0;
    static final int F1AC = 1;
    static final int F2C = 2;
    static final int F2AC = 3;
    static final int F3C = 4;
    static final int F3AC = 5;
    static final int F4C = 6;
    static final int F4AC = 7;
    static final int F5C = 8;
    static final int F5AC = 9;
    static final int F6C = 10;
    static final int F6AC = 11;

    int lastMove;
    byte[] colors;
    int g;
    int heuristic;
    int f;

    State(byte[] arr, int move, int g, int h) {
        this.colors = arr;
        this.lastMove = move;
        this.g = g;
        this.heuristic = h;
    }

    public int getF(){
        return this.f;
    }
    
    

    List<State> neighbourList() {
        List<State> neighbours = new ArrayList<>();
        for (int move = 0; move < 12; move++) {
            byte[] colorsRot = rotate(move, colors);
            int g = this.g + 1;
            neighbours.add(new State(colorsRot, move, g, 0 ));
        }
        return neighbours;
    }

    static byte[] rotate(int move, byte[] colors) {
        byte[] colorsRot = Arrays.copyOf(colors, colors.length);
        switch (move) {
            case F1C:
                rotateF1C(colorsRot, colors);
                break;
            case F1AC:
                rotateF1AC(colorsRot, colors);
                break;
            case F2C:
                rotateF2C(colorsRot, colors);
                break;
            case F2AC:
                rotateF2AC(colorsRot, colors);
                break;
            case F3C:
                rotateF3C(colorsRot, colors);
                break;
            case F3AC:
                rotateF3AC(colorsRot, colors);
                break;
            case F4C:
                rotateF4C(colorsRot, colors);
                break;
            case F4AC:
                rotateF4AC(colorsRot, colors);
                break;
            case F5C:
                rotateF5C(colorsRot, colors);
                break;
            case F5AC:
                rotateF5AC(colorsRot, colors);
                break;
            case F6C:
                rotateF6C(colorsRot, colors);
                break;
            case F6AC:
                rotateF6AC(colorsRot, colors);
                break;
        }
        return colorsRot;
    }

    static void rotateF1C(byte[] colorsRot, byte[] colors) {
        colorsRot[1] = colors[3];
        colorsRot[2] = colors[1];
        colorsRot[3] = colors[4];
        colorsRot[4] = colors[2];

        colorsRot[9] = colors[13];
        colorsRot[10] = colors[14];

        colorsRot[13] = colors[24];
        colorsRot[14] = colors[23];

        colorsRot[24] = colors[5];
        colorsRot[23] = colors[6];

        colorsRot[5] = colors[9];
        colorsRot[6] = colors[10];

    }

    static void rotateF1AC(byte[] colorsRot, byte[] colors) {
        colorsRot[1] = colors[2];
        colorsRot[2] = colors[4];
        colorsRot[4] = colors[3];
        colorsRot[3] = colors[1];

        colorsRot[9] = colors[5];
        colorsRot[10] = colors[6];

        colorsRot[13] = colors[9];
        colorsRot[14] = colors[10];

        colorsRot[24] = colors[13];
        colorsRot[23] = colors[14];

        colorsRot[5] = colors[24];
        colorsRot[6] = colors[23];
    }

    static void rotateF2C(byte[] colorsRot, byte[] colors) {
        colorsRot[5] = colors[7];
        colorsRot[6] = colors[5];
        colorsRot[8] = colors[6];
        colorsRot[7] = colors[8];

        colorsRot[11] = colors[3];
        colorsRot[9] = colors[1];

        colorsRot[3] = colors[23];
        colorsRot[1] = colors[21];

        colorsRot[23] = colors[17];
        colorsRot[21] = colors[19];

        colorsRot[17] = colors[9];
        colorsRot[19] = colors[11];
    }

    static void rotateF2AC(byte[] colorsRot, byte[] colors) {
        colorsRot[5] = colors[6];
        colorsRot[6] = colors[8];
        colorsRot[8] = colors[7];
        colorsRot[7] = colors[5];

        colorsRot[1] = colors[9];
        colorsRot[3] = colors[11];

        colorsRot[9] = colors[17];
        colorsRot[11] = colors[19];

        colorsRot[17] = colors[21];
        colorsRot[19] = colors[23];

        colorsRot[21] = colors[1];
        colorsRot[23] = colors[3];
    }

    static void rotateF3C(byte[] colorsRot, byte[] colors) {
        colorsRot[10] = colors[9];
        colorsRot[9] = colors[11];
        colorsRot[11] = colors[12];
        colorsRot[12] = colors[10];

        colorsRot[3] = colors[8];
        colorsRot[4] = colors[6];

        colorsRot[6] = colors[17];
        colorsRot[8] = colors[18];

        colorsRot[18] = colors[13];
        colorsRot[17] = colors[15];

        colorsRot[13] = colors[3];
        colorsRot[15] = colors[4];
    }

    static void rotateF3AC(byte[] colorsRot, byte[] colors) {
        colorsRot[9] = colors[10];
        colorsRot[11] = colors[9];
        colorsRot[12] = colors[11];
        colorsRot[10] = colors[12];

        colorsRot[8] = colors[3];
        colorsRot[6] = colors[4];

        colorsRot[17] = colors[6];
        colorsRot[18] = colors[8];

        colorsRot[13] = colors[18];
        colorsRot[15] = colors[17];

        colorsRot[3] = colors[13];
        colorsRot[4] = colors[15];
    }


    static void rotateF4C(byte[] colorsRot, byte[] colors) {
        colorsRot[13] = colors[15];
        colorsRot[14] = colors[13];
        colorsRot[15] = colors[16];
        colorsRot[16] = colors[14];

        colorsRot[2] = colors[10];
        colorsRot[4] = colors[12];

        colorsRot[10] = colors[18];
        colorsRot[12] = colors[20];

        colorsRot[18] = colors[22];
        colorsRot[20] = colors[24];

        colorsRot[22] = colors[2];
        colorsRot[24] = colors[4];
    }

    static void rotateF4AC(byte[] colorsRot, byte[] colors) {
        colorsRot[16] = colors[15];
        colorsRot[15] = colors[13];
        colorsRot[13] = colors[14];
        colorsRot[14] = colors[16];

        colorsRot[2] = colors[22];
        colorsRot[4] = colors[24];

        colorsRot[22] = colors[18];
        colorsRot[24] = colors[20];

        colorsRot[18] = colors[10];
        colorsRot[20] = colors[12];

        colorsRot[10] = colors[2];
        colorsRot[12] = colors[4];

    }

    static void rotateF5C(byte[] colorsRot, byte[] colors) {
        colorsRot[17] = colors[19];
        colorsRot[18] = colors[17];
        colorsRot[19] = colors[20];
        colorsRot[20] = colors[18];

        colorsRot[11] = colors[7];
        colorsRot[12] = colors[8];

        colorsRot[7] = colors[22];
        colorsRot[8] = colors[21];

        colorsRot[22] = colors[15];
        colorsRot[21] = colors[16];

        colorsRot[15] = colors[11];
        colorsRot[16] = colors[12];
    }

    static void rotateF5AC(byte[] colorsRot, byte[] colors) {
        colorsRot[17] = colors[18];
        colorsRot[18] = colors[20];
        colorsRot[19] = colors[17];
        colorsRot[20] = colors[19];

        colorsRot[11] = colors[15];
        colorsRot[12] = colors[16];

        colorsRot[15] = colors[22];
        colorsRot[16] = colors[21];

        colorsRot[22] = colors[7];
        colorsRot[21] = colors[8];

        colorsRot[7] = colors[11];
        colorsRot[8] = colors[12];
    }

    static void rotateF6C(byte[] colorsRot, byte[] colors) {
        colorsRot[21] = colors[23];
        colorsRot[22] = colors[21];
        colorsRot[23] = colors[24];
        colorsRot[24] = colors[22];

        colorsRot[19] = colors[5];
        colorsRot[20] = colors[7];

        colorsRot[5] = colors[2];
        colorsRot[7] = colors[1];

        colorsRot[2] = colors[15];
        colorsRot[1] = colors[13];

        colorsRot[15] = colors[19];
        colorsRot[13] = colors[20];
    }

    static void rotateF6AC(byte[] colorsRot, byte[] colors) {
        colorsRot[21] = colors[22];
        colorsRot[22] = colors[24];
        colorsRot[23] = colors[21];
        colorsRot[24] = colors[23];

        colorsRot[19] = colors[15];
        colorsRot[20] = colors[13];

        colorsRot[15] = colors[2];
        colorsRot[13] = colors[1];

        colorsRot[2] = colors[5];
        colorsRot[1] = colors[7];

        colorsRot[5] = colors[19];
        colorsRot[7] = colors[20];
    }





    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        State colorsState = (State) obj;
        return Arrays.equals(colors, colorsState.colors);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(colors);
    }

}
