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
            List<Integer> list1 = new ArrayList<>();
            for(int k = 0; k < juice.length; k++)
            {
                list1.add(juice[k]);
            }
            difference = capacity[i]-juice[i];
            list1.add(i, difference);
            Collections.sort(list1);
            int index = list1.indexOf(difference);
            if((index+1) < list1.size()) {
                while ((list1.get(index) == list1.get(index + 1)) && ((index + 1) < list1.size())) {
                    index++;
                    if(index+1 == list1.size())
                    {
                        break;
                    }
                }
            }
            for(int j = 0; j < index; j++)
            {
                if(difference-list1.get(j) >= 0)
                {
                    counter++;
                    difference -= list1.get(j);
                }
            }
            if(counter > maxFlavour)
            {
                maxFlavour = counter;
            }
            counter = 0;
        }
        return maxFlavour+1;
    }
}
