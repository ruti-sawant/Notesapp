package com.example.notes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class NotesAdapter(private val context: Context, private val listener:INotesAdapter): RecyclerView.Adapter<NotesAdapter.NoteViewHolder>() {
    private val allNotes=ArrayList<Note>()
    class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val textView:TextView=itemView.findViewById(R.id.text)
        val deleteButton: ImageView =itemView.findViewById(R.id.deleteButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val viewHolder=NoteViewHolder(LayoutInflater.from(context).inflate(R.layout.item_note,parent,false))
        viewHolder.deleteButton.setOnClickListener {
            listener.onClick(allNotes[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNote=allNotes[position]
        holder.textView.text=currentNote.text
    }

    override fun getItemCount(): Int {
        return allNotes.size
    }
    fun updateList(list:List<Note>){
        allNotes.clear()
        allNotes.addAll(list)
        notifyDataSetChanged()
    }
}
interface INotesAdapter{
     fun onClick(note:Note)
}