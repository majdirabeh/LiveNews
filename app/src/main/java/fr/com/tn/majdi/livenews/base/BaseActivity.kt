package fr.com.tn.majdi.livenews.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import fr.com.tn.majdi.livenews.commons.NetworkUtils

/**
 * Created by Majdi RABEH on 03/03/2022.
 * Email : m.rabeh.majdi@gmail.com
 */
internal open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    protected fun onNetworkChange(block: (Boolean) -> Unit) {
        NetworkUtils.getNetworkStatus(this)
            .observe(this, Observer { isConnected ->
                block(isConnected)
            })
    }
}