package com.carles.carleskotlin.poi.ui

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.carles.carleskotlin.R
import com.carles.carleskotlin.common.ui.inflate
import com.carles.carleskotlin.poi.model.Poi
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_poi_list.*
import kotlin.properties.Delegates

class PoiListAdapter(val onPoiClicked: (Poi) -> Unit) : RecyclerView.Adapter<PoiListAdapter.ViewHolder>() {

    var items: List<Poi> by Delegates.observable(emptyList()) { _, _, _ -> notifyDataSetChanged() }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
            ViewHolder(parent.inflate(R.layout.item_poi_list))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBindView(items.get(position))
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {

        init {
            containerView.setOnClickListener { onPoiClicked(items.get(adapterPosition)) }
        }

        fun onBindView(item: Poi) {
            poilist_item_title_textview.text = item.title
        }
    }
}