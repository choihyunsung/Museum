package kr.block.retrofitopenapi.feature.main.networktech.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kr.block.retrofitopenapi.BuildConfig
import kr.block.retrofitopenapi.R
import kr.block.retrofitopenapi.databinding.ActivityNetworkApiViewerBinding
import kr.block.retrofitopenapi.feature.common.activity.BaseActivity
import kr.block.retrofitopenapi.feature.main.networktech.fragment.NetworkTechnologyFragment
import kr.block.retrofitopenapi.feature.main.networktech.fragment.NetworkTechnologyFragment.*
import kr.block.retrofitopenapi.feature.main.networktech.payload.kofic.response.DateBoxOfficeRes
import kr.block.retrofitopenapi.network.RetrofitCommunication
import kr.block.retrofitopenapi.network.service.KoficService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NetworkApiViewerActivity :
    BaseActivity<ActivityNetworkApiViewerBinding>(R.layout.activity_network_api_viewer) {

    companion object {
        const val API_TYPE_KEY =
            "kr.block.retrofitopenapi.feature.main.networktech.activity.NetworkApiViewerActivity.API_TYPE_KEY"

        fun createActivity(context: Context, apiType: RestApiType) {
            val intent = Intent(context, NetworkApiViewerActivity::class.java).also {
                it.putExtra(API_TYPE_KEY, apiType)
            }
            context.startActivity(intent)
        }
    }

    private val apiType: RestApiType by lazy {
        intent.getSerializableExtra(
            API_TYPE_KEY
        ) as RestApiType
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        with(mBinder) {
            mBinder.title.leftBtn.setOnClickListener { finish() }
            apiType = this@NetworkApiViewerActivity.apiType
            context = this@NetworkApiViewerActivity
            //FIXME HSCHOE TESTLINE Del
            showProgressDialog()
            RetrofitCommunication.getInstance(BuildConfig.BASE_URL_KOFIC)
                .create(KoficService::class.java)
                .dateBoxOffice(BuildConfig.KEY_KOFIC, "20210110")
                .enqueue(object : Callback<DateBoxOfficeRes> {
                    override fun onResponse(
                        call: Call<DateBoxOfficeRes>,
                        response: Response<DateBoxOfficeRes>
                    ) {
                        if (response.isSuccessful) {
                            dismissProgressDialog()
                            runOnUiThread {
                                Toast.makeText(
                                    this@NetworkApiViewerActivity,
                                    "res : ${response.body().toString()}",
                                    Toast.LENGTH_LONG
                                ).show()
                            }

                        } else {
                            onFailure(call, Exception("ErrorCode : ${response.code()}"))
                        }
                    }

                    override fun onFailure(call: Call<DateBoxOfficeRes>, t: Throwable) {
                        dismissProgressDialog()
                    }

                })
            //FIXME HSCHOE TESTLINE Del
        }
    }
}