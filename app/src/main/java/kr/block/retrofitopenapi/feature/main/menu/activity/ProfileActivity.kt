package kr.block.retrofitopenapi.feature.main.menu.activity

import android.app.Application
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.ImageDecoder
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kr.block.retrofitopenapi.R
import kr.block.retrofitopenapi.databinding.ActivityProfileBinding
import kr.block.retrofitopenapi.feature.common.activity.BaseActivity
import kr.block.retrofitopenapi.feature.main.menu.data.IdentityData

class ProfileActivity : BaseActivity<ActivityProfileBinding>(R.layout.activity_profile) {

    init {
        backKeyGuard = false
    }

    private lateinit var viewModel: IdentityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(
            this,
            IdentityViewModelFactory(application)
        )[IdentityViewModel::class.java]
        with(mBinder) {
            title.leftBtn.setOnClickListener(this@ProfileActivity::onBack)
            this.activity = this@ProfileActivity
            this.viewModel = this@ProfileActivity.viewModel
            viewModel!!.identityData.observe(this@ProfileActivity) {
                identityData = it
                poto.setImageBitmap(it.potoResource)
                name.text = getString(R.string.name_label) + ":" + it.name
                email.text = getString(R.string.email_label) + ":" + it.email
            }
        }
        viewModel.getIdentityInfo()
    }

    private fun onBack(view: View?) {
        finish()
    }


    class IdentityViewModel(application: Application) : AndroidViewModel(application) {
        var identityData: MutableLiveData<IdentityData> =
            MutableLiveData(
                IdentityData(
                    "Name",
                    BitmapFactory.decodeResource(application.resources, R.drawable.tree1),
                    "id@email.com"
                )
            )

        fun getIdentityInfo() {
            //FIXME 이건 더미 파일 나중에 RoomDB로 다시 구현.
        }

        fun onGallery(resultContracts: ActivityResultLauncher<Intent>) {
            val intent = Intent(Intent.ACTION_PICK).also {
                it.type = MediaStore.Images.Media.CONTENT_TYPE
                it.data = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            }
            resultContracts.launch(intent)
        }

        fun setPoto(bitmap: Bitmap) {
            identityData.value!!.potoResource = bitmap
            identityData.value = identityData.value
        }
    }

    class IdentityViewModelFactory(private val application: Application) :
        ViewModelProvider.AndroidViewModelFactory(
            application
        ) {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return if (modelClass == IdentityViewModel::class.java) {
                IdentityViewModel(application) as T
            } else {
                super.create(modelClass)
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.P)
    val galleryResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult())
    {
        when (it.resultCode) {
            RESULT_OK -> {
                it.data ?: return@registerForActivityResult
                val uri = it.data!!.data as Uri
                viewModel.setPoto(
                    ImageDecoder.decodeBitmap(
                        ImageDecoder.createSource(
                            contentResolver,
                            uri
                        )
                    )
                )

            }
            RESULT_CANCELED -> {
                Toast.makeText(this, "사진을 불러오지 못함", Toast.LENGTH_LONG).show()
            }
        }
    }
}