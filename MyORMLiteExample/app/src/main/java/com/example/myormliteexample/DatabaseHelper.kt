package com.example.myormliteexample

import android.database.sqlite.SQLiteDatabase
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper
import com.j256.ormlite.support.ConnectionSource
import com.j256.ormlite.table.TableUtils

// helps manage the creation and upgrade of the database
object DatabaseHelper: OrmLiteSqliteOpenHelper(App.instance, "bank.db", null, 1) {

    // creates the database
    override fun onCreate(database: SQLiteDatabase?, connectionSource: ConnectionSource?) {
        TableUtils.createTableIfNotExists(connectionSource, Person::class.java)
    }

    // upgrades the database
    override fun onUpgrade(database: SQLiteDatabase?, connectionSource: ConnectionSource?, oldVersion: Int, newVersion: Int) {
        TableUtils.dropTable<Person, Any>(connectionSource, Person::class.java, true)
        onCreate(database, connectionSource)
    }
}