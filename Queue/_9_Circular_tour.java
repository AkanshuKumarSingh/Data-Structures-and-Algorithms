package Queue;

public class _9_Circular_tour {

	// mine
	static int tour(int petrol[], int distance[]) {
		int rem = 0, st = -1, total = 0;
		for (int i = 9; i < distance.length; i++) {
			System.out.println("index: " + i + " ,start: " + st + " , rem: " + rem + " , total: " + total);
			if (petrol[i] >= distance[i]) {
				if (st == -1) {
					st = i;
				}
				rem += (petrol[i] - distance[i]);
			} else {
				if (st == -1) {

				} else {
					rem += (petrol[i] - distance[i]);
					if (rem < 0) {
						rem = 0;
						st = -1;
					} else {

					}
				}
			}
			total += (petrol[i] - distance[i]);
		}
		if (total < 0)
			return -1;
		return st;
	}

	// gfg
    static class petrolPump
    {
        int petrol;
        int distance;
         
        // constructor
        public petrolPump(int petrol, int distance) 
        {
            this.petrol = petrol;
            this.distance = distance;
        }
    }
	static int printTour(petrolPump arr[], int n) {
		int start = 0;
		int end = 1;
		int curr_petrol = arr[start].petrol - arr[start].distance;

		// If current amount of petrol in truck becomes less than 0, then
		// remove the starting petrol pump from tour
		while (end != start || curr_petrol < 0) {

			// If current amount of petrol in truck becomes less than 0, then
			// remove the starting petrol pump from tour
			while (curr_petrol < 0 && start != end) {
				// Remove starting petrol pump. Change start
				curr_petrol -= arr[start].petrol - arr[start].distance;
				start = (start + 1) % n;

				// If 0 is being considered as start again, then there is no
				// possible solution
				if (start == 0)
					return -1;
			}
			// Add a petrol pump to current tour
			curr_petrol += arr[end].petrol - arr[end].distance;

			end = (end + 1) % n;
		}

		// Return starting point
		return start;
	}

	public static void main(String args[]) {
		int[] Petrol = { 67, 22, 61, 64, 12, 83, 87, 86, 31, 86, 84, 91, 77, 15, 21, 17, 26, 93, 40, 29, 91, 26, 61, 37,
				44, 19, 29, 38, 22, 83, 56, 11, 26 };
		int[] Distance = { 89, 71, 16, 54, 38, 23, 9, 51, 84, 98, 58, 27, 28, 72, 70, 50, 52, 29, 11, 99, 40, 11, 89,
				78, 94, 77, 91, 53, 100, 88, 32, 100, 78 };
		System.out.println(tour(Petrol, Distance));
	}

}
