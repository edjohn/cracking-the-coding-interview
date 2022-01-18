import java.util.ArrayList;
import java.util.Random;

class PillBottle {

    double pillWeight;

    public double getPillWeight() {
        return this.pillWeight;
    }

    public PillBottle(double pillWeight) {
        this.pillWeight = pillWeight;
    }
}

public class HeavyPill {
    static double pillWeight = 1.0;
    static double heavyPillWeight = 1.1;

    /**
      * Given an array of pill bottles such that one has heavier pills than the rest, find
        the heavy pill bottle without using a weighing scale more than once. 

        This can be accomplished by simply taking 1, 2, 3, ... bottleCount pills out of each bottle, 
        weighing them all simultaneously, subtracting the number of pills taken out multiplied by 
        the regular pill weight, and dividing the result by 0.1. Also subtract 1 if zero-indexing.

      * @param bottles An array of pill bottles with one that has heavier pills
      * @param bottleCount The number of pill bottles being used
      * @return The bottle that contains the heavy pills
     */
    public static PillBottle findHeavyPillBottle(PillBottle[] bottles, int bottleCount) {
        double totalWeight = 0;
        int pillsTakenOut = 0;
        for (int i = 1; i <= bottleCount; i++) {
            totalWeight += bottles[i-1].getPillWeight() * i;
            pillsTakenOut += i;
        }
        totalWeight -= pillsTakenOut * pillWeight;
        int heavyPillBottleIndex = (int)(Math.round(totalWeight / 0.1)) - 1;
        System.out.println("Actual heavy pill bottle index is " + heavyPillBottleIndex);
        return bottles[heavyPillBottleIndex];
    }

    public static void main(String[] args) {
        Random random = new Random();
        final int bottleCount = 20; 
        int heavyPillBottleIndex = random.nextInt(10) + 10; 
        System.out.println("Expected heavy pill bottle index is " + heavyPillBottleIndex);
        PillBottle[] bottles = new PillBottle[bottleCount];
        //Create regular bottles
        for (int i = 0; i < bottleCount; i++) {
            double pillWeight = ((double)i == heavyPillBottleIndex) ? HeavyPill.heavyPillWeight : HeavyPill.pillWeight;
            bottles[i] = new PillBottle(pillWeight);
        }
        assert(findHeavyPillBottle(bottles, bottleCount).getPillWeight() == HeavyPill.heavyPillWeight);
    }
}