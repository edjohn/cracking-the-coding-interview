public class Inserter {
    public int insert(int target, int source, int start, int end) {
        int result = target;
        for (int i = start, j = 0; i <= end; i++, j++) {
            int sourceDigit = getBit(source, j);
            result = updateBit(result, i, sourceDigit == 1);
        }
        return result;
    }

    private int getBit(int num, int i) {
        return ((num & (1 << i)) != 0) ? 1 : 0;
    }

    private int updateBit(int num, int i, boolean bitIs1) {
        int value = bitIs1 ? 1 : 0;
        int mask = ~(1 << i);
        return (num & mask) | (value << i);
    }

    public static void main(String[] args) {
        Inserter inserter = new Inserter();
        assert inserter.insert(1024, 19, 2, 6) == 1100;
        assert inserter.insert(170, 5, 2, 4) == 182;
    }
}

