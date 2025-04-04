package com.example.daytona

import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.GridLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class TaskPriorityDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireContext())
        val inflater = requireActivity().layoutInflater
        val view = inflater.inflate(R.layout.fragment_task_priority, null)

        builder.setView(view)

        val gridPriority = view.findViewById<GridLayout>(R.id.gridPriority)
        val btnSave = view.findViewById<Button>(R.id.btnSave)
        val btnCancel = view.findViewById<Button>(R.id.btnCancel)

        var selectedPriority = 1

        // Handle button clicks
        for (i in 0 until gridPriority.childCount) {
            val button = gridPriority.getChildAt(i) as Button
            button.setOnClickListener {
                selectedPriority = button.text.toString().toInt()
                it.isSelected = true
            }
        }

        btnCancel.setOnClickListener {
            dismiss()
        }

        btnSave.setOnClickListener {
            Toast.makeText(requireContext(), "Priority: $selectedPriority", Toast.LENGTH_SHORT).show()
            dismiss()
        }

        return builder.create()
    }
}
