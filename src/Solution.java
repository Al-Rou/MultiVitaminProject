import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public int solution(int[] juice, int[] capacity)
    {
        int difference = 0;
        int counter = 0;
        int maxFlavour = 0;
        for(int i = 0; i < juice.length; i++)
        {
            //Each time, the list is created and filled out with array's elements in the array's order
            List<Integer> list = new ArrayList<>();
            for(int k = 0; k < juice.length; k++)
            {
                list.add(juice[k]);
            }
            difference = capacity[i]-juice[i];
            //The chosen glass is replaced with its empty capacity
            list.add(i, difference);
            //The list is sorted
            Collections.sort(list);
            //The appropriate index is chosen
            int index = list.indexOf(difference);
            //In case there are repetitive values equal to the difference, the highest index is taken
            if((index+1) < list.size()) {
                while ((list.get(index) == list.get(index + 1)) && ((index + 1) < list.size())) {
                    index++;
                    if(index+1 == list.size())
                    {
                        break;
                    }
                }
            }
            //Maximum flavour happens when juice with least amount is added to the chosen glass.
            //That's why sorting of the list really matters!
            for(int j = 0; j < index; j++)
            {
                if(difference-list.get(j) >= 0)
                {
                    //Every time that a flavour is successfully added, counter increments by one and
                    //a new difference is set
                    counter++;
                    difference -= list.get(j);
                }
            }
            //If counter is bigger than maxFlavour, a new value for maxFlavour should be set,
            //otherwise counter has to be forgotten!
            if(counter > maxFlavour)
            {
                maxFlavour = counter;
            }
            counter = 0;
        }
        //Calculated maxFlavour needs to be incremented by one which is the flavour of the chosen glass
        return maxFlavour+1;
    }
}
