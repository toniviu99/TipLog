package com.toni.tiplog.feature_tip.domain.usecase



class ValidateAmountUseCase {
    operator fun invoke(amount: String): AmountResult {
        if (amount == ""){
            return AmountResult.Invalid("The tip can't be empty")
        }
        if (amount.matches(Regex(".*[-,\\s].*"))) {
            return AmountResult.Invalid("Invalid tip, please enter a valid tip")
        }
        return AmountResult.Valid
//        if(amount.contains("-") || amount.contains(",") || amount.contains(" ")){
//            return AmountResult.Invalid("Invalid tip, please enter a valid tip")
//        }
    }
}

sealed class AmountResult(){
    object Valid: AmountResult()
    data class Invalid(val errorMessage: String) : AmountResult()
}