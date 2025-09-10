/**
 *
 * @author Hachi Ndu
 */
package coe318.lab3;
public class Counter {
    int i;
    int n;
    Counter left;
    
    
    //Instance variables here
    public Counter(int modulus, Counter left) {
        this.i = modulus;
        this.left = left;
        n = 0;
    }


    /**
     * @return the modulus
     */
    public int getModulus() {
        return this.i;
    }

    /**
     * Returns the Counter to the left attached to this
     * Counter.  Returns null if there is no Counter
     * to the left.
     * @return the left
     */
    public Counter getLeft() {
        
        return this.left;
    }

    /**
     * @return the digit
     */
    public int getDigit() {
        return n;
    }

    /**
     * @param digit the digit to set
     */
    public void setDigit(int digit) {
        this.n = digit;
    }

    /**
     * Increment this counter.  If it rolls over,
     * its left Counter is also incremented if it
     * exists.
     */
    public void increment() {
        n++;
        if (n == i){
            n = 0;
            if (this.left != null){
                this.left.n++;
            }
        }
    }

    /** Return the count of this Counter combined
     * with any Counter to its left.
     *
     * @return the count
     */
    public int getCount() {
        if(this.left != null){
            return(n + i*left.n);
        }
        else{
            return(n);
        }
    }

    /** Returns a String representation of the Counter's
     * total count (including its left neighbour).
     * @return the String representation
     */
    @Override
    public String toString() {
        //DO NOT MODIFY THIS CODE
        return "" + getCount();
    }

}
