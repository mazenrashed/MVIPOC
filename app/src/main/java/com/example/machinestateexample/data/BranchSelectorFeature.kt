package com.example.machinestateexample.data

import com.badoo.mvicore.element.Reducer
import com.badoo.mvicore.feature.ReducerFeature
import com.example.machinestateexample.BranchesSelectorState
import com.example.machinestateexample.Event
import com.example.machinestateexample.PageType

class BranchSelectorFeature(storeInfoRepository: StoreInfoRepository) :
    ReducerFeature<Event, BranchesSelectorState, Nothing>(
        initialState = BranchesSelectorState(),
        reducer = ReducerImpl(storeInfoRepository)
    ) {


     class ReducerImpl(private val storeInfoRepository: StoreInfoRepository) : Reducer<BranchesSelectorState, Event> {
        override fun invoke(state: BranchesSelectorState, wish: Event): BranchesSelectorState {
            return if (storeInfoRepository.pageType != PageType.STATIC && storeInfoRepository.branchesCount > 1)
                state.copy(
                    shown = true,
                    text = storeInfoRepository.branchTitle ?: "Default"
                )
            else
                state.copy(shown = false)

        }
    }
}