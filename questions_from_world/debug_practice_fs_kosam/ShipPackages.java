/*Question 3: Port Shipping
Topic: Binary search · Hidden bugs: 2
A port has packages on a conveyor belt, in a fixed order. Every day the ship loads packages
 from the belt in that same order and sails once the next package would go over the ship's
  weight capacity. All packages must be shipped within d days, and the ship has the same 
  capacity every day. A package can never be split. Find the least ship capacity that works.
   The program binary searches on the capacity.*/
public class ShipPackages {
    static int daysNeeded(int[] w, int cap) {
        int days = 1, load = 0;
        for (int x : w) {
            if (load + x > cap) {
                days++;
                load = 0;
            }
            load += x;
        }
        return days;
    }

    static int minCapacity(int[] w, int d) {
        int low = Integer.MIN_VALUE, high = 0;
        for (int x : w) {
            low = Math.max(low,x);
            high += x;
        }
        int res = -1;
        while (low  <= high) {
            int mid = low + (high - low) / 2;
            if (daysNeeded(w, mid) <= d) {
                res = mid;
                high = mid-1; // inka takkava 
            } else {
                low = mid + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] w1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("Shipment 1: " + minCapacity(w1, 5));

        int[] w2 = {5, 1, 1};
        System.out.println("Shipment 2: " + minCapacity(w2, 3));
    }
}
/*Expected output
Shipment 1: 15
Shipment 2: 5
Actual output
Shipment 1: 17
Shipment 2: 5 */