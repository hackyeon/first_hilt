package com.hackyeon.first_hilt.api.data.req

class ReqData: BaseReqObject() {
    var startData: String = ""
    var endDate: String = ""
    var timeUnit: String = ""
    var keywordGroups: List<KeywordGroups> = listOf()
    var device: String = ""
    var gender: String = ""
    var ages: List<String> = listOf()


    override val methodName: String
        get() = "v1/datalab/search"
}


class KeywordGroups() {
    var groupName: String = ""
    var keywords: List<String> = listOf()
}