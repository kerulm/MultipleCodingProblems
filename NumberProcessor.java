public class NumberProcessor {
	/**
	*
	* This method returns true if
	*
	*
	*/
	public static boolean isCoprime(int input1, int input2) {
        int dividend; 
        int divisor; // lines 9 - 12: initalizing the variables to use later on
        int quotient; 
        int remainder; 
        if(input1 > input2) {
            dividend = input1; 
            divisor = input2; 	// lines 13 - 19: the dividend has to be bigger than the divisor as per the definition
        } else {
            dividend = input2; 
            divisor = input1;
        }
        quotient = dividend / divisor; 
        remainder = dividend % divisor; 
        if (remainder == 0) {    // check if divisor = 1 as that would be GCD
            if(divisor == 1) {
                return true;
            } else {
                return false; 
            }
        }
        while(remainder != 0) {
            dividend = divisor;   // this algorithm will keep running until remainder doesn't = 0 
            divisor = remainder; 
            quotient = dividend / divisor;  // it will get a final number for divisor
            remainder = dividend % divisor;

        }
        if(divisor == 1) {
            return true; // checks to see if divisor is 1 or not as if its 1 thats the gcd and it means it is coprime
        } else {
            return false; // returns false otherwise
        }
	}

	/**
	*
	* This method returns true if
	*
	*
	*/
	public static boolean isPalindrome(int input) {
        int count = 0;
        String sinput = Integer.toString(input);
        String[] straight = sinput.split(""); // splits it into the string[]
        String[] reverse = new String[straight.length]; // takes the string and puts it into an array
        for(int i = straight.length - 1; i >= 0; i--) {
        reverse[count] = straight[i]; //runs through the array forwards and backwards and checks if = 
        count++; 
        }
        for(int j = 0; j < straight.length; j++) {
            if(reverse[j].equals(straight[j]) == false) {  // checks if the reverse array is the same as forwards array
                return false;
            }
        }
         return true; // if it didnt return false it has to return true here
	}

	/**
	*
	* This method returns true if
	*
	*
	*/
	public static boolean isFibonacciPrime(long input) {
		if(input <= 1) {
			return false; // return false if its prime  because less than 1 is always prime
		}
       for(int i = 2; i < input; i++) {
		   if(input % i == 0) { 
			   return false; // checks to see if prime or compositie if prime than it will return false
		   }
		} 
		long f1 = 1; 
        long f2 = 2; // now that we know that the number has to be prime we check if its in fib or not
        long f3 = f1 + f2; 
		if(input == 2 || input == 1) {
			return true; // these two are always gonna be in the fib series so return true if thats the input
		}
        while(input >= f3) {
			if(input == f3) {
				return true;
			}
			f1 = f3; 
			f3 = f1 + f2; // this algorithm will keep going through and make f3 a number in the fib
			if(input == f3) {
				return true; // if the input = f3 then return true
		}
			f2 = f3;  // go through again and make f3 the next number in fib 
			f3 = f1 + f2;
			if(input == f3) {
				return true; // checks again
		}
        }
		return false;
	}

	/**
	 *
	 * This method returns the number of steps it takes to get to 1
	 * following the collatz game rules starting at the input
	 */

	public static int countCollatzSteps(int input){
		int counter = 0; 
		while(input != 1) { // keeps running until it's 1
			if(input % 2 == 0) {
				input = input / 2; // follow the first rule if its even or not
				counter++;
			} else { // if its not even it has to be odd
				input = input * 3 + 1; // 2nd rule too follow
				counter ++; // count how many steps it took too reach one
			}
		}
		return counter; // returns the counter of how many times it took
	}

	/**
	 *
	 * This method marks off all the spots in the input array
	 * corresponding to composite numbers, leaving only the
	 * prime numbers as true.
	 */
	public static void sieveOfEratosthenes(boolean[] array){
		int max = array.length - 1; // creating a value for the max number that can be prime or composite
		int min = 0;  // lowest value
		int counter = 2; // starting value because 0, 1, have to be prime
		for(min = 0; min <= max; min++) { // this way itll go through every value thats either prime or compositte
			if(min <= 1) {
				array[min] = false; // has to always be false
			}
			if(min == 2) {
				array[min] = true; // 2 wil always be prime
			}
			outer: while(min > counter) { 
				if(min % counter == 0) {
					array[min] = false; // checks each number before min and seeing if it has anything divisible
					break outer; // the moment there is a number thats not just 1 and itself we break from the outer while loop so it doesnt continue
				} else {
					array[min] = true; // if there wasnt a number it must be true
				}
				counter++; 
			}
			counter = 2; // reset the counter so it can each every number
		}
	}

	/**
	 * Converts a Nx3 array to the equivalent rectangular array
	 */
	 public static int[][] list2array(int[][] list) {
	 	int row = 0; // intializing all the variables for now
	 	int col = 0;
	 	int rownew = 0;
	 	int colnew = 0;
	 	int number = 0;
	 	for(int i = 0; i < list.length; i++) {
	 		if(list[i][1] > row) {
	 			row = list[i][1]; // finding max row number
	 		}
	 		if(list[i][2] > col) { // because of the for loop it will keep runnng till col and row = the max value
	 			col = list[i][2]; // findin max col number
	 		}
	 	}
	 	int[][] output = new int[row + 1][col + 1]; // initialzing output with what we know have to be the rectangular shape of the new array
	 	for(int i = 0; i < list.length; i++) {
	 		number = list[i][0];
	 		rownew = list[i][1]; // setting the values from the old list to new array and following the rules given 
	 		colnew = list[i][2];
	 		output[rownew][colnew] = number; // once the right row and col are found we can set it too a place in the new array 
	 	}
	 	return output; 
	}

	/**
	 * Unfolds the array in a spiral order clockwise starting from index 0,0
	 */
	public static int[] spiralUnfolding(int[][] array){
		int counter = 0; 
		int[] ending = new int[array.length * array[0].length];
		int topRow = 0;
		int bottomRow = array.length - 1; // all these values here are boundaries for the row and columns with 4 boundarie 
		int leftCol = 0;  
		int rightCol = array[0].length - 1; 
		int direction = 0;  // this direction will point to what way the array needs to unfold, 0 going right, 1 going down, 2 going left, 3, going up
		while(counter < ending.length) { // too fill up the entire single array
		while(topRow <= bottomRow && leftCol <= rightCol) {
			if(direction == 0) { // too go right
				for(int i = leftCol; i <= rightCol; i++) {
					ending[counter] = array[topRow][i]; // this forloop will go from the top row to the right most column 
					counter++;  // make sure the counter stays upto date
				}
				topRow++; // now that the top row is done we can change our boundary to the next row
			} 
			else if(direction == 1) {
			for(int i = topRow; i <= bottomRow; i++) { // this forloop is for going from top to bottom (going downwards)
				ending[counter] = array[i][rightCol];  // our row will keep changing but our column stays static as its the right most column
				counter++; 
			}
			rightCol--; // done with the right most boundry so we can now change our column boundary
		}
			else if(direction == 2) {
				for(int i = rightCol; i >= leftCol; i--) { // this forloop is for going left to right
					ending[counter] = array[bottomRow][i]; 
					counter++; 
				}
				bottomRow--; 
			}
			else if(direction == 3) {
				for(int i = bottomRow; i >= topRow; i--) { // this forloop is for going bottom to top 
					ending[counter] = array[i][leftCol];
					counter++; 
				}
				leftCol++; 
			}
			direction = (direction + 1) % 4; // this is to find what direction we have too be going and will change every time the loop restarts

		}
	}
		return ending; 
	}

	/**
	 * Even numbers are rotated to the right.
	 * Odd numbers are rotated to the left.
	 */
	public static void arrayRotation(int[] array){
		Integer firstOddNumber = null; 
		Integer oddIndex = null;
		Integer evenIndex = null; // these indicies will start as null and we need to have the indicies and numbers stored 
		Integer oddNumber = 0;
		Integer firstEvenNumber = null; 
		Integer storedEvenNumber = 0; 
		for(int i = 0; i < array.length; i++ ) {
			if(array[i] % 2 == 1) // checks to see if the numeber is odd or not
			{
				if(oddIndex == null) {
					firstOddNumber = array[i]; ; // since we know the number starts off as null we can find the firstOddNumber and store it
					oddIndex = i; // set the Index to wherever we are in the array
				} else { 
					array[oddIndex] = array[i]; // if its not the firstNumber we set the Index we're at to the array
					oddIndex = i;  // change the index we are at
				}
			} 
			else 
			{ 
				if(evenIndex == null) {
					firstEvenNumber = array[i]; //this will change to every first previous even number
					evenIndex = i; // for later when we want to change the last even value with the place of the first evenIndex
				} else { 
					storedEvenNumber = array[i]; // same logic as for odd but we set the stored evenNumber into the array
					array[i] = firstEvenNumber; // then set the first Even number in the arrray at the time too the array
					firstEvenNumber = storedEvenNumber;
				}
			}
		}
		array[oddIndex] = firstOddNumber; // theres a pattern for every possibility where the firstOddNumber at the start of the array will be switched the last OddNumber
		array[evenIndex] = firstEvenNumber; // same with even but the reverse

		//throw new RuntimeException("not implemented!");
	}

	/**
	 * Returns a new array where every sequence of consecutive numbers is
	 * replaced by a single occurrence of the respective number
	 */
	public static int[][] removeConsecutives(int[][] array){
		int counter = 0; 
		int lastNumber = 0; // this will be for the last number in the first matrix 
		int tester = 0; // specifically for the last case where the entire row gets cut
		int colNum = 0; 
		int[][] temp = new int[array.length][]; // this will be the array that stores the values
		for(int i = 0; i < array.length; i++) { 
			if(i == 0) {
				counter = 1; // this beginnin forloop is to find the size of the rows and columns of the jagged array
				tester = 0; 
			} else { 
				lastNumber = array[i - 1][array[i-1].length - 1]; // finds the last number of the first row so we can check later with the first number on the 2nd row
			}
			for(int j = 0; j < array[i].length - 1; j++) { 
				if(tester == 1 && array[i][j] != lastNumber) {
					counter = 1;  // specifically for when the 2nd row is all the same number
					tester = 0; 
				}
				if(tester == 0 && array[i][j] != array[i][j+1]) { // incriminets the counter every time there isnt a consecutive number
					counter++;  // this will be our size of the first array
				}
			}
			if(i > 0 && counter != 0) {
			temp[i] = new int[counter + 1];	 // needs to plus 1 because the size was off by 1
			} else { 
			temp[i] = new int[counter]; 
			}
			counter = 0; // resets counter so it can traverse again 
		}
		lastNumber = 0;  // resets all the numbers so now we can fill the array with the right values
		int j = 0; 
		tester = 0; 
		for(int i = 0; i < array.length; i++) {
			if(i == 0) { 
				temp[i][colNum] = array[i][j]; // inital first case when i has to be 0 in the beginning
			} else { // colNum is too keep track of where we are with the new array 
				lastNumber = array[i - 1][array[i-1].length - 1]; // gets last number of first row
			}
			for(j = 0; j < array[i].length - 1; j++) {
				if(tester == 1 && i != 0 && array[i][j] != lastNumber) {
					temp[i][colNum] = array[i][j]; 
					tester = 0; 
				} 
				if(tester == 0 && array[i][j] != array[i][j + 1]) {
					if(i > 0) { 
						temp[i][colNum] = array[i][j]; // adds the number too the new array that we will return because it cut off the first number in the 2nd loop
					}
					temp[i][colNum + 1] = array[i][j+1]; // same here but for j+1
					colNum++;
				}
			}
			colNum = 0; // resets for each itteration of the loop
		}
		return temp; 
	}

	/**
	 * Modifies a two-dimensional array in-place. Every occurrence of item
	 * is replaced by replacement.
	 */
	public static void replaceItem(int[][] array, int item, int[] replacement){
		int colCounter = 0; 
		int val = 0;
		int[][] temp = new int[array.length][];  // this first for loop is to copy array into a new temp array
		for(int i = 0; i < array.length; i++) {
			temp[i] = new int[array[i].length];
			for(int j = 0; j < array[i].length; j++) { // goes through every value of array and copies into temp
				temp[i][j] = array[i][j]; 
			}
		}

		int counter = 0; 
		int row = array.length;
		int col = array[0].length;
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < array[i].length; j++ ) {
				if(array[i][j] == item) { // checks how many times item occurs through the array
					counter++;
				}
			} 
			if(counter != 0) {
			array[i] = new int[array[i].length + (replacement.length - 1) * counter]; // this formula will give the proper size of the array thats filled with 0s
			}
			counter = 0; // resets counter so it can traverse through the loop again
		}
		for(int i = 0; i < temp.length; i++) { // this next forloop is for us to fill the array we have now which is why we copied it orginally before it was all 0s
			for(int j = 0; j < temp[i].length; j++) {
				if(temp[i][j] == item) { // when it equals the item we will now add in the replacement
					while(val < replacement.length) { // this while loop is gonna add repalcement array
					array[i][colCounter] = replacement[val]; 
					val++; 
					colCounter++;
					} 
				} else { // if it doesnt = item we just keep adding the normal values in
					array[i][colCounter] = temp[i][j]; 
					colCounter++; 
				}
				val = 0; // resets val for us to ittertate through the loop again
			}
			colCounter = 0; 
		}

		
		//throw new RuntimeException("not implemented!");
	}

	/**
	 *
	 * Main method. Is not tested by the tester, create your own tests here!
	 */
	public static void main(String []args){
		
}
}