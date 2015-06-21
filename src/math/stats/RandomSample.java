package math.stats;

import math.exceptions.MException;
import java.util.Random;
import math.stats.Constants.Constant;

public class RandomSample {

    private boolean replacement;
    private Constant sampleType;
    private int size;
    private int[] values;
    private int onValue = 0;
    private Integer[] populationValues;
    private int[] stratumIndex;

    public void setSampleType(Constant sampleType) {
        this.sampleType = sampleType;
    }

    /**
     * Creates a new RandomSample.
     *
     * @param type Random sample type
     * @param size Size
     * @param populationValues The entire population
     * @param replacement Whether or not replacement is used during stratification
     * @throws MException Mathematical exception if a configuration cannot be used
     */
    public RandomSample(Constant type, int size, Integer[] populationValues, boolean replacement) throws MException {
        if (type == Constant.RANDOM_SAMPLE_SIMPLE) {// || type == TYPE_STRATIFIED
            if (size < populationValues.length) {
                this.sampleType = type;
                this.size = size;
                this.populationValues = populationValues;
                values = new int[size];
                this.stratumIndex = null;
                this.replacement = replacement;
            } else {
                throw new MException("Sample size is greater than population size.");
            }

        } else {
            throw new MException("Did not give a proper sample type.");
        }

        generateSample();
    }

    /**
     * Creates a new RandomSample, with stratified-sample parameter. Unfinished.
     *
     * @param type Random sample type
     * @param size Size
     * @param populationValues The entire population
     * @param stratumIndex The values to set as strata. Order: [strataLevel, numberOfValuesInStrata, strataLevel + 1, numberOfValuesInStrata2].
     * @param replacement Whether or not replacement is used during stratification
     * @throws MException Mathematical error while calculating random sample
     */
    public RandomSample(Constant type, int size, Integer[] populationValues, int[] stratumIndex, boolean replacement) throws MException {
        int temp = 0;
        if (type == Constant.RANDOM_SAMPLE_SIMPLE) {// || type == TYPE_STRATIFIED
            if (size < populationValues.length) {
                if (stratumIndex.length % 2 == 0) {
                    for (int mC = 0; mC < stratumIndex.length; mC++) {
                        temp += (mC % 2 == 1 ? stratumIndex[mC] : 0);
                    }
                    if (temp <= populationValues.length) {
                        this.sampleType = type;
                        this.stratumIndex = stratumIndex;
                        this.size = size;
                        this.populationValues = populationValues;
                        values = new int[size];
                        this.replacement = replacement;
                    } else {
                        throw new MException("Number of stratum values are greater that number of population values.");
                    }
                } else {
                    throw new MException("Improper stratum index.");
                }
            } else {
                throw new MException("Sample size greater than population size.");
            }
        } else {
            throw new MException("Did not give a proper sample type.");
        }

        generateSample();
    }

    /**
     * Gets the size of the random sample.
     *
     * @return The size of the sample as an <code>int</code>.
     */
    public int getSize() {
        return size;
    }

    /**
     * Gets the type of sample.
     * <br><br>WARNING: Only use in comparison to other <code>Constant</code> objects.
     *
     * @return The type of sample as a <code>Constant</code>.
     */
    public Constant getSampleType() {
        return sampleType;
    }

    /**
     * Gets whether or not the normal approximation can be used.
     * <br><br>Inherent checking will be implemented later.
     *
     * @return True if the sample can be used with the normal approximation.
     */
    public boolean getNormalApproximation() {
        return size >= 30;
    }

    private void generateSample() throws MException {
        switch (sampleType) {
            case RANDOM_SAMPLE_SIMPLE:
                if (replacement) {
                    for (int x = 0; x < size; x++) {
                        values[onValue] = new Random().nextInt(populationValues.length);
                        onValue++;
                    }
                } else {

                }
                break;
//            case TYPE_STRATIFIED:
//                if (stratumIndex != null) {
//                    for (int x = 0; x < stratumIndex.length; x += 2) {
//                        if (x % 2 == 0) {//stratum level
//
//                        } else if (x % 2 == 1) {//stratum number
//                            if (replacement) {
//                                for (int sC = 0; sC < stratumIndex[x]; sC++) {
//                                    values[onValue] = new Random().nextInt(populationValues.length);
//                                    onValue++;
//                                }
//                            } else {
//                                for (int sC = 0; sC < stratumIndex[x]; sC++) {
//                                    values[onValue] = new Random().nextInt(populationValues.length);
//                                    populationValues[x] = null;
//                                    onValue++;
//                                }
//                            }
//                        }
//                    }
//                } else {
//                    throw new MException("StratumIndex is null.", stratumIndex);
//                }
//                break;
            default:
                throw new MException("Sample type error. Try using the constants in the RandomSample class.");
        }
    }

    /**
     * Prints all the sample values to the console.
     *
     * @return An <code>int[]</code> of the sample values.
     */
    public int[] printSampleValues() {
        for (int x = 0; x < values.length; x++) {
            System.out.println("Value " + x + ": " + values[x]);
        }

        return values;
    }

    /**
     * Returns the sample values as an <code>int[]</code>.
     *
     * @return Sample values
     */
    public int[] getSampleValues() {
        return values;
    }

    /**
     * Returns the maximum value of the sample.
     *
     * @return The maximum value of the sample as an <code>int</code>.
     */
    public int getMaxValue() {
        int prev = 0;
        for (int i : values) {
            if (i > prev) {
                prev = i;
            }
        }

        return prev;
    }

    /**
     * Returns the minimum value of the sample.
     *
     * @return The minimum value of the sample as an <code>int</code>.
     */
    public int getMinValue() {
        int prev = getMaxValue();
        for (int i : values) {
            if (i < prev) {
                prev = i;
            }
        }

        return prev;
    }
}
