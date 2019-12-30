package a.suman.mvparchitecture.View

import a.suman.mvparchitecture.Contract.contract
import a.suman.mvparchitecture.Presenter.PresenterClass
import a.suman.mvparchitecture.R
import a.suman.mvparchitecture.Repository.Model.DataTable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.d
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),contract.View{
    var rAdapter=rAdapter(this)
    var presenter= PresenterClass(this@MainActivity)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var recyclerView=findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager=LinearLayoutManager(this)
        recyclerView.adapter=rAdapter
        button.setOnClickListener {
            progressBar.visibility= View.VISIBLE
            var sol=1
            if(editText.text.isEmpty()) {
                Toast.makeText(this, "Searching for default sol 1", Toast.LENGTH_LONG).show()
            }
            else {
                sol= Integer.parseInt(editText.text.toString())
            }

            presenter.transferData(sol, this)

        }

    }

    override fun update(datalist:List<DataTable>, state:String) {

        rAdapter.setdata(datalist)
        this@MainActivity.runOnUiThread{
            progressBar.visibility=View.GONE
            if(state=="Failed"){Toast.makeText(this@MainActivity, "Fetching data from local storage", Toast.LENGTH_LONG).show()}
            else {Toast.makeText(this@MainActivity, "Data loaded from network", Toast.LENGTH_LONG).show()}
            rAdapter.notifyDataSetChanged()}
    }

}
