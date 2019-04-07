import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author : mengmuzi
 * create at:  2019-04-08  00:46
 * @description: 优先级队列寻找第K大的元素
 */
public class PriorityQueueFindKthLargest {

    public int findKthLargest(int[] nums ,int k){
        k = nums.length - k + 1;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        //是个大根堆
        for(int val : nums){
            priorityQueue.add(val);
            if(priorityQueue.size() > k){
                priorityQueue.poll();
            }
        }
        return priorityQueue.peek();
    }

}
