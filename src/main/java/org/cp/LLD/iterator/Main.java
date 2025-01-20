package org.cp.LLD.iterator;

import java.util.Arrays;

public class Main {
    public static void main(String ...args){
        ZigZagIterator<Integer> zigZagIterator = new ZigZagIterator<>(
                Arrays.asList(Arrays.asList(1, 2, 3),
                        Arrays.asList(4, 5, 6))
        );

        while (zigZagIterator.hasNext()){
            Integer value = zigZagIterator.next();
            System.out.print(value);

            if(zigZagIterator.hasNext()){
                System.out.print(", ");
            }
        }

        System.out.println();
        //Custom Iterator
        CustomIterator<Integer> customIterator = new CustomIterator<>(
               Arrays.asList(
                       new BasicIterator<Integer>(Arrays.asList(1, 2, 3)),
                       new BasicIterator<Integer>(Arrays.asList(4, 5, 6)),
                       new StepIterator(1, 6, 1)
                       )
        );

        while(customIterator.hasNext()){
            int value = customIterator.next();
            System.out.print(value);

            if(customIterator.hasNext()){
                System.out.print(", ");
            }
        }

        System.out.println();
        //Cyclic Iterator
        CycleIterator<Integer> cycleIterator = new CycleIterator<>(Arrays.asList(1,2,3), 2);

        while(cycleIterator.hasNext()){
            System.out.print(cycleIterator.next());
            if(cycleIterator.hasNext()){
                System.out.print(", ");
            }
        }
    }
}
