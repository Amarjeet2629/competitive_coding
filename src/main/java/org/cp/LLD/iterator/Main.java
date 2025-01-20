package org.cp.LLD.iterator;

import java.util.Arrays;
import java.util.List;

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

        System.out.println();

        PeekableIterator<Integer> peekableIterator = new PeekableIterator<>(Arrays.asList(1, 2, 3));
        while(peekableIterator.hasNext()){
            System.out.print(peekableIterator.peek());
            peekableIterator.next();

            if(peekableIterator.hasNext()){
                System.out.print(", ");
            }
        }

        System.out.println();

        FilterableIterator<Integer> evenIterator = new FilterableIterator<>(Arrays.asList(1, 2, 3, 4, 5, 6), (x) -> x % 2 == 0);
        while(evenIterator.hasNext()){
            System.out.print(evenIterator.next());
            if(evenIterator.hasNext()){
                System.out.print(", ");
            }
        }

        System.out.println();

        FilterableIterator<Integer> oddIterator = new FilterableIterator<>(Arrays.asList(1, 2, 3, 4, 5, 6), (x) -> x % 2 != 0);
        while(oddIterator.hasNext()){
            System.out.print(oddIterator.next());
            if(oddIterator.hasNext()){
                System.out.print(", ");
            }
        }

        System.out.println();

        ChunkedIterator<Integer> chunkedIterator = new ChunkedIterator<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8), 3);

        while (chunkedIterator.hasNext()){
            List<Integer> values = chunkedIterator.next();
            for(int i = 0; i < values.size(); i++){
                System.out.print(values.get(i));

                if(i != values.size() - 1){
                    System.out.print(", ");
                }
            }

            System.out.print(" | ");
        }
    }
}
