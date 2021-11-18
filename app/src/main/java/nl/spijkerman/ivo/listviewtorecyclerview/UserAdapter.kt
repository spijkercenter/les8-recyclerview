package nl.spijkerman.ivo.listviewtorecyclerview

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class UserAdapter(
    private val layoutInflater: LayoutInflater
) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    class UserViewHolder(
        private val containerView: View
    ) : RecyclerView.ViewHolder(containerView) {
        private val nameView = containerView.findViewById<TextView>(R.id.userItem_name_textView)
        private val cityView = containerView.findViewById<TextView>(R.id.userItem_city_textView)
        private val photoView = containerView.findViewById<ImageView>(R.id.userItem_photo_imageView)

        @SuppressLint("SetTextI18n")
        fun bindData(user: UserModel) {
            nameView.text = user.title + " " + user.firstName + " " + user.lastName
            cityView.text = user.city
            photoView

            containerView.setOnClickListener {
                val intent = Intent(containerView.context, UserDetailActivity::class.java)
                intent.putExtra("name", nameView.text)
                containerView.context.startActivity(intent)
            }
        }
    }

    private val userData = mutableListOf<UserModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = layoutInflater.inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bindData(userData[position])
    }

    override fun getItemCount() = userData.size

    fun setData(userData: List<UserModel>) {
        this.userData.clear()
        this.userData.addAll(userData)
        notifyDataSetChanged()
    }
}