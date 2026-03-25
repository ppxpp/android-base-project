package cn.edu.sziit.android.debugdemo

import android.util.Log

object DebugLab {
    @JvmStatic
    fun runDemo() {
        val prices = intArrayOf(100, 80, 50)
        val discountRate = 0.8
        val finalTotal = calculateTotal(prices, discountRate)
        Log.d("DebugDemo", "Final total = $finalTotal")
    }

    private fun calculateTotal(prices: IntArray, discountRate: Double): Int {
        var sum = 0
        for (price in prices) {
            val discounted = applyDiscount(price, discountRate)
            sum += discounted
        }
        return addShipping(sum)
    }

    private fun applyDiscount(price: Int, discountRate: Double): Int {
        return (price * discountRate).toInt()
    }

    private fun addShipping(amount: Int): Int {
        val shipping = 12
        return amount + shipping
    }
}