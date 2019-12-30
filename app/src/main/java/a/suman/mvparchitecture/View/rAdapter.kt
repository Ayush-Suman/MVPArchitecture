package a.suman.mvparchitecture.View

import a.suman.mvparchitecture.Contract.contract
import a.suman.mvparchitecture.R
import a.suman.mvparchitecture.Repository.Model.DataTable
import android.content.Context
import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class rAdapter(var context: Context):RecyclerView.Adapter<rAdapter.rViewHolder>(){
    var data:List<DataTable> =emptyList()
    override fun getItemCount(): Int {
        return data.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): rViewHolder {
        return rViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recyclerview, parent, false))
    }



    override fun onBindViewHolder(holder: rViewHolder, position: Int) {
        Glide.with(context).load(data[position].img_src).into(holder.imageView)
        holder.textView2.text=data[position].earth_date
    }

    fun setdata(datalist: List<DataTable>) {
        data =datalist
        d("a", data[0].earth_date)
        notifyDataSetChanged()
    }

    inner class rViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var imageView=itemView.findViewById<ImageView>(R.id.imageView)
        var textView2=itemView.findViewById<TextView>(R.id.textView2)
    }
}