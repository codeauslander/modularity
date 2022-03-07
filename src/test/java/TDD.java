import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class TDD {

    @Test
    public void sequence(){
        List<Integer> list = Arrays.asList(5,4,3,2,1);
        list.stream().forEach(System.out::println);
        Integer target = 0;
        Integer counter = 0;
        Integer size = list.size();
        Integer current = 0;
        List<List<Integer>> groups = new ArrayList<>();
        while(target <= size){
            while(counter + target <= size){
                List<Integer> group = new ArrayList<>();
                Integer from = 0 + counter;
                Integer to = target + counter;
                while(from <= to && to < size){
                    current = list.get(from);
                    group.add(current);
                    from++;
                }
                if(group.size() > 0) {
                    groups.add(group);
                }
                counter ++;
            }
            counter = 0;
            target ++;
        }

        groups.stream().forEach(System.out::println);

        //check if all list decrease by 1 and count them.
        Integer r = groups.stream().map(x ->{
            if(x.size()==1){
                return 1;
            }
            Integer sum = 0;
            for(Integer index = 0; index < x.size() - 1; index ++){
                sum += x.get(index) - x.get(index + 1) == 1 ? 1 : 0;
            }
            if (sum == x.size() - 1) {
                return 1;
            } else{
                return 0;
            }

        }).reduce(0,Integer::sum);

        System.out.println("result:"+r);
        Assert.assertNull(null);
    }
}
