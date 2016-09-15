package edu.orangecoastcollege.cs273.kdo94.shippingcalculator;

/**
 * Created by kevin_000 on 9/14/2016.
 */

public class ShipItem {
    private double mPackageWeight;
    private double mAddedCost;
    private double mTotalShippingCost;
    private double BASE_COST = 3.0;
    private double ADDED_COST = 0.5;
    private int BASE_WEIGHT = 16;

    public ShipItem() {
        mAddedCost = 0.0;
        mPackageWeight = 0.0;
        mTotalShippingCost = 0.0;
    }

    public ShipItem(double mPackageWeight, double mAddedCost, double mTotalShippingCost) {
        this.mPackageWeight = mPackageWeight;
        this.mAddedCost = mAddedCost;
        this.mTotalShippingCost = mTotalShippingCost;
    }

    public double getAddedCost() {
        return mAddedCost;
    }

    public void setAddedCost(double mAddedCost) {
        this.mAddedCost = mAddedCost;
    }

    public double getPackageWeight() {
        return mPackageWeight;
    }

    public void setPackageWeight(double mPackageWeight) {
        this.mPackageWeight = mPackageWeight;
        recalculateAmount();
    }

    public double getTotalShippingCost() {
        return mTotalShippingCost;
    }

    public void setTotalShippingCost(double mTotalShippingCost) {
        this.mTotalShippingCost = mTotalShippingCost;
    }

    private void recalculateAmount(){
        if(mPackageWeight <= 16){
            mTotalShippingCost = BASE_COST;
            mAddedCost = 0.0;
        }
        else
        {
            mAddedCost = Math.ceil((mPackageWeight - BASE_WEIGHT) / 4.0) * ADDED_COST;
            mTotalShippingCost = BASE_COST + mAddedCost;
        }
    }

    public double getBaseCost()
    {
        return BASE_COST;
    }
}
