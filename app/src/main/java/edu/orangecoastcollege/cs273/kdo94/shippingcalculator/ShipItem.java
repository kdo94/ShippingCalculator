package edu.orangecoastcollege.cs273.kdo94.shippingcalculator;

/**
 * Created by kevin_000 on 9/14/2016.
 */

public class ShipItem {
    /**
     * Weight of package being shipped
     */
    private double mPackageWeight;
    /**
     * Cost if the package weighs more htan 16 ounces
     */
    private double mAddedCost;
    /**
     * Total cost of shipment, including base cost and added cost
     */
    private double mTotalShippingCost;
    /**
     * Cost of a shipment if package weighs <= 16
     */
    private double BASE_COST = 3.0;
    /**
     * Cost for every 4 ounces over 16
     */
    private double ADDED_COST = 0.5;
    /**
     * How much the package needs to weigh more for added cost
     */
    private int BASE_WEIGHT = 16;

    /**
     * Creates a new shipItem that may change weight, and the costs will
     * adjust accordingly. A package may change weight.
     */
    public ShipItem() {
        mPackageWeight = 0.0;
    }

    /**
     * Creates a new shipItem with the given weight.
     * The weight of the package should be in ounces.
     *
     * @param  mPackageWeight the weight of the package in ounces
     */
    public ShipItem(double mPackageWeight) {
        this.mPackageWeight = mPackageWeight;
    }

    /**
     * Gets the added cost of the item being shipped.
     * The added cost is $0.50 for every 4 pounds rounded up
     *
     * @return the added cost of the package
     */
    public double getAddedCost() {
        return mAddedCost;
    }

    /**
     * Gets the weight of the package
     *
     * @return the weight of the package
     */
    public double getPackageWeight() {
        return mPackageWeight;
    }


    /**
     * Changes the weight of the package.
     * After changed the weight of the package the added
     * cost and total shipping cost will change accordingly.
     *
     * @param mPackageWeight This is the weight of the package
     *                       Should be in ounces.
     */
    public void setPackageWeight(double mPackageWeight) {
        this.mPackageWeight = mPackageWeight;
        recalculateAmount();
    }


    /**
     * Gets the final shipping cost of the package being sent.
     *
     * @return The total shipping cost of the package which includes
     *          the base cost and added cost
     */
    public double getTotalShippingCost() {
        return mTotalShippingCost;
    }


    /**
     * When the weight of the package is changed, the mAddedCost and
     * mTotalShippingCost will update afterwards.
     * The mAddedCost increases $0.50 for every four pounds over 16 ounces.
     */
    private void recalculateAmount(){
        if(mPackageWeight <= BASE_WEIGHT){
            mTotalShippingCost = BASE_COST;
            mAddedCost = 0.0;
        }
        else
        {
            mAddedCost = Math.ceil((mPackageWeight - BASE_WEIGHT) / 4.0) * ADDED_COST;
            mTotalShippingCost = BASE_COST + mAddedCost;
        }
    }

    /**
     * Gets the base cost of ShipItem
     *
     * @return the base cost of the package
     */
    public double getBaseCost()
    {
        return BASE_COST;
    }
}
