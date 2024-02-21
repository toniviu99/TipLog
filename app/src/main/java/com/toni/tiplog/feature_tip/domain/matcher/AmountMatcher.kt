package com.toni.tiplog.feature_tip.domain.matcher

interface AmountMatcher {
    fun isValid(amount: String): Boolean
}