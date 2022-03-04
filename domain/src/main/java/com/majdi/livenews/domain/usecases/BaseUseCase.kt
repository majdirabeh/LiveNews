package com.majdi.livenews.domain.usecases
/**
 * Created by Majdi RABEH on 28/02/2022.
 * Email m.rabeh.majdi@gmail.com
 */
interface BaseUseCase <in Parameter, out Result> {
    suspend operator fun invoke(params: Parameter): Result
}