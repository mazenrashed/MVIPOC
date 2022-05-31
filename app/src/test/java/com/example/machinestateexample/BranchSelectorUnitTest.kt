package com.example.machinestateexample

import com.example.machinestateexample.data.BranchSelectorFeature
import com.example.machinestateexample.data.StoreInfoRepository
import io.reactivex.Observable
import org.junit.Assert
import org.junit.Test


class BranchSelectorUnitTest {

    @Test
    fun `One branch in collection page`() {
        val storeInfoRepository = object : StoreInfoRepository {
            override val pageType: PageType
                get() = PageType.COLLECTION
            override val branchesCount: Int
                get() = 1
            override val branchTitle: String?
                get() = "Default text"
        }
        val feature = BranchSelectorFeature(storeInfoRepository)
        feature.accept(Event.OnNavigateToHomeScreen)
        Assert.assertFalse(Observable.wrap(feature).blockingFirst().shown)
    }

    @Test
    fun `One branch in static page`() {
        val storeInfoRepository = object : StoreInfoRepository {
            override val pageType: PageType
                get() = PageType.STATIC
            override val branchesCount: Int
                get() = 1
            override val branchTitle: String?
                get() = "Default text"
        }
        val feature = BranchSelectorFeature(storeInfoRepository)
        feature.accept(Event.OnNavigateToHomeScreen)
        Assert.assertFalse(Observable.wrap(feature).blockingFirst().shown)
    }

    @Test
    fun `Multi branches in collection page`() {
        val storeInfoRepository = object : StoreInfoRepository {
            override val pageType: PageType
                get() = PageType.COLLECTION
            override val branchesCount: Int
                get() = 3
            override val branchTitle: String?
                get() = "Default text"
        }
        val feature = BranchSelectorFeature(storeInfoRepository)
        feature.accept(Event.OnNavigateToHomeScreen)
        val result = Observable.wrap(feature).blockingFirst().shown
        assert(result)
    }

    @Test
    fun `Multi branches in static page`() {
        val storeInfoRepository = object : StoreInfoRepository {
            override val pageType: PageType
                get() = PageType.STATIC
            override val branchesCount: Int
                get() = 3
            override val branchTitle: String?
                get() = "Default text"
        }
        val feature = BranchSelectorFeature(storeInfoRepository)
        feature.accept(Event.OnNavigateToHomeScreen)
        val result = Observable.wrap(feature).blockingFirst().shown
        assert(!result)
    }
}