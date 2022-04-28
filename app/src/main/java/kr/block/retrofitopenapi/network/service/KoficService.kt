package kr.block.retrofitopenapi.network.service

import kr.block.retrofitopenapi.feature.main.networktech.payload.kofic.response.DateBoxOfficeRes
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface KoficService {
    @GET("boxoffice/searchDailyBoxOfficeList.json")
    fun dateBoxOffice( //일별 박스 오피스
        @Query("key") key: String, //필수 인증키
        @Query("targetDt") targetDt: String, //필수 조회 날짜 yyyymmdd형식
        @Query("itemPerPage") itemPerPage: String? = null, //0 : 주간, 1 : 주말 2 : 주중
        @Query("multiMovieYn") multiMovieYn: String? = null, //개수 Max : 10
        @Query("repNationCd") repNationCd: String? = null, //K : 한국영화 N : 외국영화
        @Query("wideAreaCd") wideAreaCd: String? = null // 상영지역별로 조회할 수 있으며, 지역코드는 공통코드 조회 서비스에서 “0105000000” 로서 조회된 지역코드입니다. (default : 전체)
    ): Call<DateBoxOfficeRes>
}
