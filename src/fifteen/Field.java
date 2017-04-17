package fifteen;

import astar.State;
import java.util.Arrays;

public class Field extends State {

    private int[] field;
    private int size;
    private int zeroIndex;

    public Field(int size, int[] field) throws Exception {
        if (field == null) {
            throw new Exception("[field] could not be null");
        }
        if (size * size != field.length) {
            throw new Exception(String.format("Wrong given [size = %1$d] with [field.length = %2$d]", size, field.length));
        }

        int zerosCount = 0;
        for (int idx = 0; idx < field.length; ++idx) {
            if (field[idx] == 0) {
                zeroIndex = idx;
                ++zerosCount;
            }
        }

        if (zerosCount != 1) {
            throw new Exception(String.format("There are should be only one zero instance, but found [%1$d]", zerosCount));
        }

        this.size = size;
        this.field = field;
    }

    public Field(Field copyFrom) {
        this.field = Arrays.copyOf(copyFrom.field, copyFrom.field.length);
        this.size = copyFrom.size;
        this.zeroIndex = copyFrom.zeroIndex;
    }

    public int getAt(int index) {
        return field[index];
    }

    public int getSize() {
        return size;
    }

    private void swap(int leftIndex, int rightIndex) {
        int temp = field[leftIndex];
        field[leftIndex] = temp;
        field[rightIndex] = temp;
    }

    public boolean turnRight() {
        return makeTurn(1, 0);
    }

    public boolean turnUp() {
        return makeTurn(0, -1);
    }

    public boolean turnLeft() {
        return makeTurn(-1, 0);
    }

    public boolean turnDown() {
        return makeTurn(0, 1);
    }

    private boolean makeTurn(int xOffset, int yOffset) {
        int estimatedZeroX = zeroIndex % size + xOffset;
        int estimatedZeroY = zeroIndex / size + yOffset;
        if (estimatedZeroX >= 0 && estimatedZeroX < size && estimatedZeroY >= 0 && estimatedZeroY < size) {
            swap(zeroIndex, estimatedZeroX + estimatedZeroY * size);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Field)) {
            return false;
        }

        Field another = (Field)obj;

        return (this.size == another.size) && Arrays.equals(this.field, another.field);
    }

    @Override
    public int hashCode() {
        return size + Arrays.hashCode(field);
    }

    @Override
    public String toString() {
        return Arrays.toString(field);
    }
}