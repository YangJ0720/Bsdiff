package yangj.bsdiff

import android.os.Bundle
import android.os.Environment
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

/**
 * @author YangJ
 */
class MainActivity : AppCompatActivity() {

    private lateinit var mCachePath: String

    private lateinit var mApkOldPath: String

    private lateinit var mApkNewPath: String

    private lateinit var mPatchPath: String

    private lateinit var mApkInstallPath: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()
        initView()
    }

    private fun initData() {
        mCachePath = Environment.getExternalStorageDirectory().absolutePath
        val v1 = "app_v1.0.apk"
        val v2 = "app_v2.0.apk"
        mApkOldPath = "$mCachePath/bsdiff/$v1"
        mApkNewPath = "$mCachePath/bsdiff/$v2"
        //
        mPatchPath = "$mCachePath/bsdiff/patch.patch"
        mApkInstallPath = "$mCachePath/bsdiff/app_new.apk"
    }

    private fun initView() {
        textView.text = getVersionName()
        btnDiff.setOnClickListener{
            println("diff -> start")
            Bsdiff.onBsdiff(mApkOldPath, mApkNewPath, mPatchPath)
            println("diff -> stop")
        }
        btnPatch.setOnClickListener {
            println("patch -> start")
            Bspatch.onBspatch(mApkOldPath, mApkInstallPath, mPatchPath)
            println("patch -> stop")
        }
    }

    private fun getVersionName(): String? {
        val info = packageManager.getPackageInfo(packageName, 0)
        return info.versionName
    }

    /**
     * 获取本地安装的apk文件
     */
    private fun getLocalApkPath(): String {
        val info = packageManager.getApplicationInfo(packageName, 0)
        return info.sourceDir
    }
}
