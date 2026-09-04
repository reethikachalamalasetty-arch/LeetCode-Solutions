class Solution {

    public int trap(int[] height) {

        // ---------------------------------------------------------
        // STEP 1:
        // Find the size of the array.
        // ---------------------------------------------------------

        int n = height.length;

        /*
         * If there are fewer than 3 bars, water cannot be trapped.
         *
         * Example:
         *
         * [1]
         * [1, 2]
         *
         * There is not enough space between bars to hold water.
         */

        if (n < 3) {
            return 0;
        }


        // ---------------------------------------------------------
        // STEP 2:
        // Create arrays to store the maximum height from
        // the left and from the right.
        // ---------------------------------------------------------

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];


        // ---------------------------------------------------------
        // STEP 3:
        // Calculate leftMax.
        //
        // leftMax[i] means:
        // the tallest bar from index 0 to index i.
        // ---------------------------------------------------------

        leftMax[0] = height[0];

        for (int i = 1; i < n; i++) {

            /*
             * We compare:
             *
             * 1. The current height
             * 2. The maximum height we have already seen
             *
             * The larger one becomes leftMax[i].
             */

            if (height[i] > leftMax[i - 1]) {
                leftMax[i] = height[i];
            } else {
                leftMax[i] = leftMax[i - 1];
            }
        }


        // ---------------------------------------------------------
        // STEP 4:
        // Calculate rightMax.
        //
        // rightMax[i] means:
        // the tallest bar from index i to the last index.
        // ---------------------------------------------------------

        rightMax[n - 1] = height[n - 1];

        for (int i = n - 2; i >= 0; i--) {

            /*
             * Compare the current height with the maximum
             * height found from the right side.
             */

            if (height[i] > rightMax[i + 1]) {
                rightMax[i] = height[i];
            } else {
                rightMax[i] = rightMax[i + 1];
            }
        }


        // ---------------------------------------------------------
        // STEP 5:
        // Calculate the total amount of trapped water.
        // ---------------------------------------------------------

        int totalWater = 0;

        for (int i = 0; i < n; i++) {

            /*
             * Water level is determined by the smaller of:
             *
             * leftMax[i]
             * rightMax[i]
             *
             * Why the smaller one?
             *
             * Because water will overflow from the shorter side.
             */

            int waterLevel;

            if (leftMax[i] < rightMax[i]) {
                waterLevel = leftMax[i];
            } else {
                waterLevel = rightMax[i];
            }


            /*
             * Now subtract the height of the current bar.
             *
             * Example:
             *
             * waterLevel = 4
             * height[i] = 2
             *
             * Water stored = 4 - 2 = 2
             */

            int waterAtCurrentPosition = waterLevel - height[i];


            /*
             * Add the water at this position to the total.
             */

            totalWater = totalWater + waterAtCurrentPosition;
        }


        // ---------------------------------------------------------
        // STEP 6:
        // Return the final answer.
        // ---------------------------------------------------------

        return totalWater;
    }
}
