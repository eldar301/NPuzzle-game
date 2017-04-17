package fifteen;

import astar.State;
import java.util.Arrays;

//TODO
//makeTurn move to object-oriented-method
public class Field extends State {

    private int[] field;
    private int size;
    private int zeroIndex;

    public Field(int size, int[] field) throws Exception {
        if (field == null) {
            throw new Exception("State could not be null");
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

    public static Field turnRight(Field parent) {
        return makeTurn(parent, 1, 0);
    }

    public static Field turnUp(Field parent) {
        return makeTurn(parent, 0, -1);
    }

    public static Field turnLeft(Field parent) {
        return makeTurn(parent, -1, 0);
    }

    public static Field turnDown(Field parent) {
        return makeTurn(parent, 0, 1);
    }

    private static Field makeTurn(Field parent, int xOffset, int yOffset) {
        int size = parent.size;
        int estimatedZeroX = parent.zeroIndex % size + xOffset;
        int estimatedZeroY = parent.zeroIndex / size + yOffset;
        if (estimatedZeroX >= 0 && estimatedZeroX < size && estimatedZeroY >= 0 && estimatedZeroY < size) {
            Field result = new Field(parent);
            result.swap(result.zeroIndex, estimatedZeroX + estimatedZeroY * size);
            return result;
        } else {
            return null;
        }
    }
}