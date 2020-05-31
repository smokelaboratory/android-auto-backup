package com.smokelaboratory.backuprestore

import android.app.backup.*
import android.os.ParcelFileDescriptor
import android.util.Log
import android.widget.Toast

class CustomBackupAgent : BackupAgentHelper() {
    override fun onFullBackup(data: FullBackupDataOutput?) {
        super.onFullBackup(data)

        Log.e("BACKUP", "onFullBackup")
    }
}