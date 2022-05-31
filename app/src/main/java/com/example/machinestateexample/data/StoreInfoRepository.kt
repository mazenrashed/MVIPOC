package com.example.machinestateexample.data

import com.example.machinestateexample.PageType

interface StoreInfoRepository {
    val pageType: PageType

    val branchesCount: Int

    val branchTitle: String?
}