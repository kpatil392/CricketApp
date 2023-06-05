package com.cricket.test.ui.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.cricket.test.aaautils.PlayerInfo
import com.cricket.test.databinding.ActivityMainBinding
import com.cricket.test.model.CricketResp
import com.cricket.test.ui.viewmodel.MatchViewModel
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import org.json.JSONException
import org.json.JSONObject


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val matchViewModel: MatchViewModel by viewModels()
    lateinit var strTeamA:String
    lateinit var strTeamB:String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setView()
        getdata()
    }

    private fun setView() {

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvTeama.setOnClickListener {
            //Toast.makeText(this@MainActivity,strTeamA,Toast.LENGTH_LONG).show()
            startActivity(Intent(this@MainActivity, MatchDetailActivity::class.java).putExtra("Team",strTeamA))
        }
        binding.tvTeamb.setOnClickListener {
            //Toast.makeText(this@MainActivity,strTeamB,Toast.LENGTH_LONG).show()
            startActivity(Intent(this@MainActivity, MatchDetailActivity::class.java).putExtra("Team",strTeamB))
        }
    }


    fun getdata() {
        matchViewModel.mCricketDataStr.observe(this) {
            Log.i("DAtaKK---", it.string().toString())
            val hashMap=(getPlayer(getData(it.string().toString(), "Teams")))
            hashMap.forEach {
                val keyByIndex0 = hashMap.keys.elementAt(0) // Get key.
                val valueOfElement0 = hashMap.getValue(keyByIndex0) // Get Value.
                val keyByIndex1 = hashMap.keys.elementAt(1) // Get key by index.
                val valueOfElement1 = hashMap.getValue(keyByIndex1) // Get value.

                val nf1 = JSONObject(valueOfElement0).getString("Name_Full")
                val ns1 = JSONObject(valueOfElement0).getString("Name_Short")
                val nf2 = JSONObject(valueOfElement1).getString("Name_Full")
                val ns2 = JSONObject(valueOfElement1).getString("Name_Short")

                binding.tvTeama.setText("${nf1} (${ns1})")
                binding.tvTeamb.setText("${nf2} (${ns2})")
                strTeamA=valueOfElement0
                strTeamB=valueOfElement1


            }
            try {
                val obj: CricketResp = Gson().fromJson(it.string().toString(), CricketResp::class.java)
                // binding.tvVanue.setText(obj.Matchdetail.Venue.Name)

                Log.i("DAta---", obj.Matchdetail.Venue.Name)
            }catch (e:Exception){
                Log.i("DAta---", e.localizedMessage)

            }


        }

    }


    private fun getData(str: String, ss: String): String {
        val obj = JSONObject(str)
        val keys: Iterator<*> = obj.keys()
        while (keys.hasNext()) {
            val key = keys.next() as String
            if (key.equals(ss)) {
                val value: String = obj.getString(key) //This is where the error comes
                return value
                break
                //  setInner(value)
            }
        }
        return ""

    }

    private fun getPlayer(str: String): HashMap<String, String> {
        val hmap: HashMap<String, String> = HashMap()
        val obj = JSONObject(str)
        val keys: Iterator<*> = obj.keys()
        while (keys.hasNext()) {
            val key = keys.next() as String
            val value: String = obj.getString(key) //This is where the error comes
            //  Log.i("Kundan  Inner Data---", key + "--" + value);
            val str = getData(value, "Players")
            Log.i("Kiru777 Json Data Inner---", str)
            hmap.put(key,value)
        }
        return hmap
    }



}