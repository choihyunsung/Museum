package kr.block.retrofitopenapi.feature.main.networktech.payload.kofic.response

import com.google.gson.annotations.SerializedName

//일별 박스오피스 API 서비스
data class DateBoxOfficeRes(
    @SerializedName("boxOfficeResult")
    var boxOfficeResult: BoxOfficeResult
)
data class BoxOfficeResult(
    @SerializedName("boxofficeType")
    var boxofficeType: String, //박스오피스 종류를 출력합니다.
    @SerializedName("showRange")
    var showRange: String, //박스오피스 조회 일자를 출력합니다.
    @SerializedName("dailyBoxOfficeList")
    var dailyBoxOfficeList: List<DailyBoxOfficeList>
)
data class DailyBoxOfficeList(
    @SerializedName("rnum")
    var rnum: String, //순번을 출력합니다.
    @SerializedName("rank")
    var rank: String, //해당일자의 박스오피스 순위를 출력합니다.
    @SerializedName("rankInten")
    var rankInten: String, //전일대비 순위의 증감분을 출력합니다.
    @SerializedName("rankOldAndNew")
    var rankOldAndNew: String, //랭킹에 신규진입여부를 출력합니다. “OLD” : 기존 , “NEW” : 신규
    @SerializedName("movieCd")
    var movieCd: String, //영화의 대표코드를 출력합니다.
    @SerializedName("movieNm")
    var movieNm: String, //영화명(국문)을 출력합니다.
    @SerializedName("openDt")
    var openDt: String, //영화의 개봉일을 출력합니다.
    @SerializedName("salesAmt")
    var salesAmt: String, //해당일의 매출액을 출력합니다.
    @SerializedName("salesShare")
    var salesShare: String, //해당일자 상영작의 매출총액 대비 해당 영화의 매출비율을 출력합니다.
    @SerializedName("salesInten")
    var salesInten: String, //	전일 대비 매출액 증감분을 출력합니다.
    @SerializedName("salesChange")
    var salesChange: String, //전일 대비 매출액 증감 비율을 출력합니다.
    @SerializedName("salesAcc")
    var salesAcc: String, //	누적매출액을 출력합니다.
    @SerializedName("audiCnt")
    var audiCnt: String, //해당일의 관객수를 출력합니다.
    @SerializedName("audiInten")
    var audiInten: String, //전일 대비 관객수 증감분을 출력합니다.
    @SerializedName("audiChange")
    var audiChange: String, //전일 대비 관객수 증감 비율을 출력합니다.
    @SerializedName("audiAcc")
    var audiAcc: String, //	누적관객수를 출력합니다.
    @SerializedName("scrnCnt")
    var scrnCnt: String, //해당일자에 상영한 스크린수를 출력합니다.
    @SerializedName("showCnt")
    var showCnt: String, //해당일자에 상영된 횟수를 출력합니다.
)


