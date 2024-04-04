//Date: 4/2/2024
//Programmer: Geoffrey Grossthal
//Algorithm: "two-pointer" or "Floyd's Tortoise and Hare"

/*
Description:
The Tortoise and Hare algorithm, also known as Floyd's Cycle Detection algorithm, is a popular 
algorithm used to detect cycles in a linked list or find the starting point of a loop in a cyclic 
linked list. It's named after the fable of "The Tortoise and the Hare," where a tortoise and a 
hare engage in a race. The algorithm works by using two pointers, often referred to as the 
"tortoise" and the "hare," which move through the linked list at different speeds. The tortoise 
moves forward one node at a time, while the hare moves forward two nodes at a time.

Space and time complexity:
The "tortoise" pointer moves one step at a time, so it takes O(n) time to reach the cycle.
Once both pointers are inside the cycle, the "hare" pointer moves twice as fast as the "tortoise" 
pointer. Therefore, the time taken for the "hare" pointer to catch up to the "tortoise" pointer is 
proportional to the number of nodes in the cycle, which is O(k).
Overall, the time complexity is O(n + k).

The space complexity of the algorithm is O(1), meaning it uses constant extra space regardless of the size of the linked lis
*/

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class TortoiseAndHare {

    //Function returns true if there is a cycle, 
    //Utilizes the "two-pointer" or "Floyd's Tortoise and Hare" algorithm 
    //Time complexity of O(n) and a space complexity of O(1)
    public boolean hasCycle(ListNode head) {
            
        //If empty or next is null there is no cycle
        if (head == null || head.next == null)
            return false;

        ListNode fast = head.next;

        //If head and fast pointers meet, cycle is present
        while (head != fast) {
            //Reached the end of the list no cycle
            if (fast == null || fast.next == null)
                return false;
            head = head.next;
            fast = fast.next.next;
        }

        //Loop terminated cycle was present
        return true;
    }
}